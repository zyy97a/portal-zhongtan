<template>
  <Layout>
    <!-- Hero section with overlay -->
<!--    <div class="hero-section">
      <div class="hero-overlay"></div>
      <div class="hero-content">
        <h1 class="hero-title">公司动态</h1>
        <p class="hero-description">了解我们最新的公司动态、行业资讯和技术分享</p>
      </div>
    </div>

    &lt;!&ndash; Breadcrumb &ndash;&gt;
    <div class="breadcrumb-container">
      <div class="container">
        <ol class="breadcrumb">
          <li><router-link to="/">首页</router-link></li>
          <li class="active">公司动态</li>
        </ol>
      </div>
    </div>-->

    <!-- Hero section with full-width background -->
    <div class="hero-section">
      <div class="hero-overlay"></div>
      <div class="hero-content">
        <div class="container">
          <h1 class="hero-title">公司动态</h1>
          <div class="title-separator"></div>
          <p class="hero-description">了解我们最新的公司动态、行业资讯和技术分享</p>
          <div class="hero-cta">
            <a href="#news" class="btn-explore">探索更多</a>
          </div>
        </div>
      </div>
    </div>

    <!-- News section -->
    <div class="news-section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">最近新闻</h2>
          <div class="title-underline"></div>
          <p class="section-description">
            广告标识制作的工艺范围较广，只要是具有表现力、具有装饰性能的工艺手段，几乎都能被标牌工艺所采纳。据标识圈了解，铜牌蚀刻诚然有过它历史的辉煌，或者说现在仍有沿用，但时下已不是主流；而采用科技含量高的加工手段，才是提高广告标识品味的发展方向。
          </p>
        </div>

        <!-- News grid -->
        <div class="news-container">
          <div v-if="loading" class="loading-container">
            <div class="loader"></div>
            <p>加载中...</p>
          </div>

          <div v-else-if="articles.records && articles.records.length === 0" class="empty-state">
            <p>暂无新闻内容</p>
          </div>

          <div v-else class="news-grid">
            <div class="news-card" v-for="(article, index) in articles.records" :key="index">
              <div class="news-image">
                <img :src="article.cover" :alt="article.title" />
                <div class="news-date">{{ formatDate(article.createTime) }}</div>
              </div>
              <div class="news-content">
                <h3 class="news-title">
                  <a :href="article.contentHtml || '#'" target="_blank" rel="noopener noreferrer">{{ article.title }}</a>
                </h3>
                <p class="news-excerpt">{{ article.introduction }}</p>
                <a :href="article.contentHtml || '#'" target="_blank" rel="noopener noreferrer" class="read-more">
                  查看更多 <i class="arrow-icon">→</i>
                </a>
              </div>
            </div>
          </div>

          <!-- Pagination -->
          <div class="pagination-container" v-if="articles.records && articles.records.length > 0">
            <ul class="pagination">
              <li
                  :class="pageIndex === 1 ? 'disabled' : ''"
                  @click="pageIndex > 1 && changeIndex(pageIndex - 1)"
              >
                <a href="#" @click.prevent>&laquo;</a>
              </li>

              <li
                  v-for="p in getPaginationArray()"
                  :key="p"
                  :class="pageIndex === p ? 'active' : ''"
                  @click="changeIndex(p)"
              >
                <a href="#" @click.prevent>{{ p }}</a>
              </li>

              <li
                  :class="pageIndex === articles.pages ? 'disabled' : ''"
                  @click="pageIndex < articles.pages && changeIndex(pageIndex + 1)"
              >
                <a href="#" @click.prevent>&raquo;</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </Layout>
</template>

<script>
import Layout from "@/components/common/Layout";

export default {
  name: "NewsView",
  components: { Layout },
  data() {
    return {
      articles: {},
      pageIndex: 1,
      loading: false
    };
  },
  mounted() {
    this.getArticle(1);
  },
  methods: {
    getArticle(pageIndex) {
      this.loading = true;
      this.getRequest(`/findArticles/${pageIndex}`)
          .then(resp => {
            if (resp && resp.data && resp.data.data) {
              this.articles = resp.data.data;
            }
          })
          .catch(error => {
            console.error("获取新闻列表失败:", error);
          })
          .finally(() => {
            this.loading = false;
          });
    },
    changeIndex(p) {
      if (p < 1) {
        this.pageIndex = 1;
      } else if (p > this.articles.pages) {
        this.pageIndex = this.articles.pages;
      } else {
        this.pageIndex = p;
        this.getArticle(p);
        // Scroll to top of news section
        const newsSection = document.querySelector('.news-section');
        if (newsSection) {
          newsSection.scrollIntoView({ behavior: 'smooth' });
        }
      }
    },
    formatDate(dateString) {
      if (!dateString) return '';

      try {
        const date = new Date(dateString);
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const day = String(date.getDate()).padStart(2, '0');

        return `${year}-${month}-${day}`;
      } catch (e) {
        // If date parsing fails, return the original string
        return dateString;
      }
    },
    getPaginationArray() {
      const totalPages = this.articles.pages || 1;
      const currentPage = this.pageIndex;

      // For small number of pages, show all
      if (totalPages <= 5) {
        return Array.from({ length: totalPages }, (_, i) => i + 1);
      }

      // For larger number of pages, show window around current page
      let startPage = Math.max(currentPage - 2, 1);
      let endPage = Math.min(startPage + 4, totalPages);

      // Adjust window if needed
      if (endPage - startPage < 4) {
        startPage = Math.max(endPage - 4, 1);
      }

      return Array.from({ length: endPage - startPage + 1 }, (_, i) => startPage + i);
    }
  }
};
</script>

<style scoped>
/* Global styles */
.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 15px;
}

/* Hero section */
/*.hero-section {
  position: relative;
  height: 300px;
  background-image: url('/Users/zyysyx/Documents/zyyjava/portal-zhongtan1/portal-ui/src/assets/images/footer.jpg');
  background-size: cover;
  background-position: center;
  color: #fff;
  margin-bottom: 20px;
}*/

/*新加*/

.hero-section {
  position: relative;
  height: 400px; /* Increased height for more impact */
  width: 100%;
  background-image: url('../assets/images/footer.jpg');
  background-size: cover;
  background-position: center center;
  background-repeat: no-repeat;
  background-attachment: fixed; /* Creates a parallax effect */
  color: #fff;
  margin-bottom: 0; /* Remove bottom margin */
  overflow: hidden;
}

.hero-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(90deg, rgba(0, 0, 0, 0.7), rgba(44, 62, 80, 0.65)); /* Darker, more dramatic overlay */
}

.hero-content {
  position: relative;
  z-index: 2;
  height: 100%;
  display: flex;
  align-items: center;
  text-align: center;
}

.hero-content .container {
  width: 100%;
  max-width: 1000px; /* Wider content area */
  padding: 0 20px;
}

.hero-title {
  font-size: 48px; /* Larger title */
  font-weight: 800; /* Bolder weight */
  margin-bottom: 20px;
  color: #fff;
  text-shadow: 0 2px 10px rgba(0, 0, 0, 0.3); /* Text shadow for better readability */
  animation: fadeInDown 1s ease-out; /* Subtle animation */
}

.title-separator {
  height: 3px;
  width: 80px;
  background-color: #f39c12;
  margin: 0 auto 25px;
  animation: scaleIn 1.2s ease-out;
}

.hero-description {
  font-size: 20px;
  line-height: 1.6;
  margin: 0 auto 30px;
  max-width: 700px;
  opacity: 0.9;
  animation: fadeInUp 1s ease-out 0.3s;
  animation-fill-mode: both;
}

.hero-cta {
  margin-top: 30px;
  animation: fadeIn 1.5s ease-out 0.6s;
  animation-fill-mode: both;
}

.btn-explore {
  display: inline-block;
  background-color: #f39c12;
  color: white;
  font-size: 16px;
  font-weight: 600;
  padding: 12px 30px;
  border-radius: 30px;
  text-decoration: none;
  box-shadow: 0 4px 15px rgba(243, 156, 18, 0.4);
  transition: all 0.3s ease;
}

.btn-explore:hover {
  background-color: #e67e22;
  transform: translateY(-2px);
  box-shadow: 0 6px 20px rgba(243, 156, 18, 0.6);
}

/*.hero-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(90deg, rgba(52, 152, 219, 0.2), rgba(44, 62, 80, 0.7));
}*/

/*.hero-content {
  position: relative;
  z-index: 2;
  padding: 80px 20px;
  text-align: center;
  max-width: 800px;
  margin: 0 auto;
}*/

.hero-title {
  font-size: 36px;
  font-weight: 700;
  margin-bottom: 15px;
  color: #fff;
}

/*.hero-description {
  font-size: 18px;
  line-height: 1.5;
  margin: 0;
}*/

/* Breadcrumb */
.breadcrumb-container {
  background-color: #f5f5f5;
  padding: 10px 0;
  margin-bottom: 30px;
}

.breadcrumb {
  display: flex;
  list-style: none;
  padding: 0;
  margin: 0;
}

.breadcrumb li {
  margin-right: 10px;
  font-size: 14px;
}

.breadcrumb li:after {
  content: '/';
  margin-left: 10px;
  color: #999;
}

.breadcrumb li:last-child:after {
  display: none;
}

.breadcrumb a {
  color: #666;
  text-decoration: none;
}

.breadcrumb .active {
  color: #333;
  font-weight: 600;
}

/* Section styles */
.news-section {
  padding: 40px 0 60px;
}

.section-header {
  text-align: center;
  margin-bottom: 40px;
}

.section-title {
  font-size: 32px;
  font-weight: 700;
  margin-bottom: 15px;
  color: #333;
}

.title-underline {
  height: 3px;
  width: 60px;
  background-color: #f39c12;
  margin: 0 auto 20px;
}

.section-description {
  max-width: 800px;
  margin: 0 auto;
  color: #666;
  line-height: 1.6;
}

/* News grid */
.news-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 30px;
  margin-bottom: 40px;
}

.news-card {
  background-color: #fff;
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.05);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.news-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
}

.news-image {
  position: relative;
  height: 200px;
  overflow: hidden;
}

.news-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.5s ease;
}

.news-card:hover .news-image img {
  transform: scale(1.05);
}

.news-date {
  position: absolute;
  top: 15px;
  right: 15px;
  background-color: rgba(243, 156, 18, 0.9);
  color: #fff;
  padding: 5px 10px;
  border-radius: 4px;
  font-size: 12px;
  font-weight: 600;
  z-index: 1;
}

.news-content {
  padding: 20px;
}

.news-title {
  font-size: 18px;
  margin: 0 0 15px;
  line-height: 1.4;
}

.news-title a {
  color: #333;
  text-decoration: none;
  transition: color 0.3s ease;
}

.news-title a:hover {
  color: #f39c12;
}

.news-excerpt {
  font-size: 14px;
  color: #666;
  margin-bottom: 20px;
  line-height: 1.6;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
  overflow: hidden;
  text-overflow: ellipsis;
}

.read-more {
  display: inline-flex;
  align-items: center;
  color: #f39c12;
  font-size: 14px;
  font-weight: 600;
  text-decoration: none;
  transition: all 0.3s ease;
}

.read-more:hover {
  color: #e67e22;
}

.arrow-icon {
  margin-left: 5px;
  transition: transform 0.3s ease;
}

.read-more:hover .arrow-icon {
  transform: translateX(3px);
}

/* Pagination */
.pagination-container {
  margin-top: 40px;
  display: flex;
  justify-content: center;
}

.pagination {
  display: flex;
  list-style: none;
  padding: 0;
  margin: 0;
  box-shadow: 0 2px 10px rgba(0,0,0,0.08);
  border-radius: 30px;
  overflow: hidden;
}

.pagination li {
  margin: 0;
}

.pagination li a {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 45px;
  height: 45px;
  background-color: #fff;
  color: #555;
  text-decoration: none;
  font-size: 14px;
  font-weight: 500;
  transition: all 0.3s ease;
  border-right: 1px solid #f0f0f0;
}

.pagination li:last-child a {
  border-right: none;
}

.pagination li:not(.disabled):not(.active) a:hover {
  background-color: #f8f8f8;
  color: #333;
}

.pagination li.active a {
  background-color: #3498db;
  color: #fff;
  box-shadow: 0 5px 15px rgba(52, 152, 219, 0.3);
  position: relative;
  z-index: 1;
}

.pagination li.disabled a {
  color: #ccc;
  cursor: not-allowed;
  background-color: #fafafa;
}

/* Loading state */
.loading-container {
  text-align: center;
  padding: 60px 0;
}

.loader {
  display: inline-block;
  width: 40px;
  height: 40px;
  border: 3px solid rgba(243, 156, 18, 0.3);
  border-radius: 50%;
  border-top-color: #f39c12;
  animation: spin 1s ease-in-out infinite;
  margin-bottom: 15px;
}

@keyframes spin {
  to { transform: rotate(360deg); }
}

/* Empty state */
.empty-state {
  text-align: center;
  padding: 60px 0;
  color: #999;
  font-size: 16px;
}

/*新加*/
/* Animation keyframes */
@keyframes fadeInDown {
  from {
    opacity: 0;
    transform: translateY(-30px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes fadeInUp {
  from {
    opacity: 0;
    transform: translateY(30px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes scaleIn {
  from {
    transform: scaleX(0);
  }
  to {
    transform: scaleX(1);
  }
}

@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}



/* Responsive styles */
@media (max-width: 991px) {


  .news-grid {
    grid-template-columns: repeat(2, 1fr);
  }

  .hero-section {
    height: 350px;
    background-attachment: scroll; /* Disable parallax on mobile for better performance */
  }

  .hero-title {
    font-size: 40px;
  }

/*  .hero-section {
    height: 250px;
  }*/

  .hero-content {
    padding: 60px 20px;
  }

/*  .hero-title {
    font-size: 32px;
  }*/

  .section-title {
    font-size: 28px;
  }
}

@media (max-width: 767px) {


  .section-title {
    font-size: 24px;
  }

  /*新加*/
  .hero-section {
    height: 300px;
  }

  .hero-title {
    font-size: 32px;
  }

  .hero-description {
    font-size: 16px;
  }

  .btn-explore {
    padding: 10px 25px;
    font-size: 14px;
  }

/*
  .hero-section {
    height: 200px;
  }*/

  .hero-content {
    padding: 40px 15px;
  }

  /*
  .hero-title {
    font-size: 28px;
  }
  */

/*  .hero-description {
    font-size: 16px;
  }*/

  .news-image {
    height: 180px;
  }

  .pagination li a {
    width: 40px;
    height: 40px;
  }
}

@media (max-width: 575px) {
  .news-grid {
    grid-template-columns: 1fr;
    gap: 25px;
  }

  /*新加*/
  .hero-section {
    height: 250px;
  }

  .hero-title {
    font-size: 28px;
    margin-bottom: 10px;
  }

  .title-separator {
    margin-bottom: 15px;
  }

  .hero-description {
    font-size: 14px;
    margin-bottom: 20px;
  }

  .hero-cta {
    margin-top: 20px;
  }

  /*
  .hero-section {
    height: 180px;
  }
  */

  .hero-content {
    padding: 30px 15px;
  }

/*  .hero-title {
    font-size: 24px;
    margin-bottom: 10px;
  }*/

/*  .hero-description {
    font-size: 14px;
  }*/

  .news-section {
    padding: 30px 0;
  }

  .pagination li a {
    width: 35px;
    height: 35px;
  }
}
</style>