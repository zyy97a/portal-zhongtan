<template>
  <Layout>
    <!-- Hero section with overlay -->
<!--    <div class="hero-section">
      <div class="hero-overlay"></div>
      <div class="hero-content">
        <h1 class="hero-title">您可靠的招牌专家</h1>
        <p class="hero-description">钟潭熟悉每种制作材料和制作工艺，擅长叠加使用放大您的品牌优势。钟潭坚持定制化原则，倾听您的需求，在任何时候都能给你提供专业的招牌和金属制品的意见和帮助，创建符合您期望要求的品牌标志。</p>
      </div>
    </div>

    &lt;!&ndash; Breadcrumb &ndash;&gt;
    <div class="breadcrumb-container">
      <div class="container">
        <ol class="breadcrumb">
          <li><router-link to="/">首页</router-link></li>
          <li class="active">产品中心</li>
        </ol>
      </div>
    </div>-->

    <!-- Enhanced Hero section with full-width background -->
    <div class="hero-section">
      <div class="hero-overlay"></div>
      <div class="hero-content">
        <div class="container">
          <h1 class="hero-title">您可靠的招牌专家</h1>
          <div class="title-separator"></div>
          <p class="hero-description">钟潭熟悉每种制作材料和制作工艺，擅长叠加使用放大您的品牌优势。钟潭坚持定制化原则，倾听您的需求，在任何时候都能给你提供专业的招牌和金属制品的意见和帮助，创建符合您期望要求的品牌标志。</p>
          <div class="hero-cta">
            <a href="#product-section" class="btn-explore">浏览产品</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Product section -->
    <div class="product-section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">产品介绍</h2>
          <div class="title-underline"></div>
          <p class="section-description">
            我们是一家专业从事广告招牌设计与制作的工厂，提供多元化的产品和服务，满足客户的各种需求。以下是我们的主要产品介绍
          </p>
        </div>

        <!-- Tabs section -->
        <div class="tabs-container">
          <div class="tabs-nav-wrapper">
            <ul class="tabs-nav">
              <li
                  v-for="(tab, index) in tabList"
                  :key="index"
                  @click.prevent="changeTab(index, tab.typeId)"
                  :class="tabIndex === index ? 'active' : ''"
              >
                <a href="#">{{ tab.typeName }}</a>
              </li>
            </ul>
          </div>

          <!-- Product grid -->
          <div class="tabs-content">
            <div class="product-grid">
              <div
                  class="product-card"
                  v-for="(goods, index) in goodsList"
                  :key="index"
                  @click="handleDetails(goods.typeDetaisId)"
              >
                <div class="product-image">
                  <img :src="goods.imageUrl1" :alt="goods.title">
                </div>
                <div class="product-info">
                  <h3 class="product-title">{{ goods.title }}</h3>
                  <div class="view-details">查看详情 <i class="fa fa-arrow-right"></i></div>
                </div>
              </div>
            </div>

            <!-- Empty state when no products -->
            <div class="empty-state" v-if="goodsList.length === 0">
              <p>暂无产品信息</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </Layout>
</template>

<script>
import Layout from "@/components/common/Layout";

export default {
  name: "ProductView",
  components: { Layout },
  data() {
    return {
      tabList: [],
      tabIndex: 0,
      goodsList: [],
      loading: false
    };
  },
  mounted() {
    this.getTabList();
  },
  methods: {
    getTabList() {
      this.loading = true;
      this.getRequest("/findAllType")
          .then(resp => {
            if (resp && resp.data && resp.data.data) {
              this.tabList = resp.data.data;
              if (this.tabList.length > 0) {
                this.getGoodsList(this.tabList[0].typeId);
              }
            }
          })
          .catch(error => {
            console.error("获取产品类型失败:", error);
          })
          .finally(() => {
            this.loading = false;
          });
    },
    changeTab(index, typeId) {
      this.tabIndex = index;
      this.getGoodsList(typeId);
    },
    getGoodsList(typeId) {
      this.loading = true;
      this.goodsList = []; // Clear current list while loading
      this.getRequest(`/findTypeDetailsByTypeId/${typeId}`)
          .then(resp => {
            if (resp && resp.data && resp.data.data) {
              this.goodsList = resp.data.data;
            }
          })
          .catch(error => {
            console.error("获取产品列表失败:", error);
          })
          .finally(() => {
            this.loading = false;
          });
    },
    handleDetails(productId) {
      this.$router.push({ path: `/product/productId/${productId}` });
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

/*
.hero-title {
  font-size: 32px;
  font-weight: 700;
  margin-bottom: 15px;
  color: #fff;
}
*/

/*.hero-description {
  font-size: 16px;
  line-height: 1.5;
  margin: 0;
}*/


/*新加*/
.hero-section {
  position: relative;
  height: 450px; /* Increased height for better showcase */
  width: 100%;
  background-image: url('../assets/images/product/abouthostorybg.jpg');
  background-size: cover;
  background-position: center center;
  background-repeat: no-repeat;
  background-attachment: fixed; /* Parallax effect */
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
  background: linear-gradient(90deg, rgba(0, 0, 0, 0.65), rgba(0, 48, 87, 0.7)); /* More professional color scheme */
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
  font-size: 44px; /* Larger title */
  font-weight: 800; /* Bolder weight */
  margin-bottom: 20px;
  color: #fff;
  text-shadow: 0 2px 10px rgba(0, 0, 0, 0.3); /* Text shadow for better readability */
  animation: fadeInDown 1s ease-out; /* Subtle animation */
  letter-spacing: 1px; /* Slight letter spacing for elegance */
}

.title-separator {
  height: 3px;
  width: 80px;
  background-color: #f39c12;
  margin: 0 auto 25px;
  animation: scaleIn 1.2s ease-out;
}

.hero-description {
  font-size: 18px;
  line-height: 1.8;
  margin: 0 auto 30px;
  max-width: 800px;
  opacity: 0.95;
  animation: fadeInUp 1s ease-out 0.3s;
  animation-fill-mode: both;
  text-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
}

.hero-cta {
  margin-top: 35px;
  animation: fadeIn 1.5s ease-out 0.6s;
  animation-fill-mode: both;
}

.btn-explore {
  display: inline-block;
  background-color: #f39c12;
  color: white;
  font-size: 16px;
  font-weight: 600;
  padding: 12px 32px;
  border-radius: 30px;
  text-decoration: none;
  box-shadow: 0 4px 15px rgba(243, 156, 18, 0.4);
  transition: all 0.3s ease;
  text-transform: uppercase;
  letter-spacing: 1px;
}

.btn-explore:hover {
  background-color: #e67e22;
  transform: translateY(-2px);
  box-shadow: 0 6px 20px rgba(243, 156, 18, 0.6);
}

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
.product-section {
  padding: 40px 0 60px;
}

.section-header {
  text-align: center;
  margin-bottom: 40px;
}

.section-title {
  font-size: 28px;
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

/* Tabs */
.tabs-container {
  margin-top: 30px;
}

.tabs-nav-wrapper {
  overflow-x: auto;
  margin-bottom: 30px;
}

.tabs-nav {
  display: flex;
  list-style: none;
  padding: 0;
  margin: 0;
  border-bottom: 1px solid #eee;
  min-width: max-content;
}

.tabs-nav li {
  margin-right: 5px;
}

.tabs-nav li a {
  display: block;
  padding: 12px 20px;
  color: #666;
  text-decoration: none;
  font-size: 16px;
  border-radius: 4px 4px 0 0;
  transition: all 0.3s ease;
}

.tabs-nav li:hover a {
  color: #f39c12;
}

.tabs-nav li.active a {
  color: #f39c12;
  border-bottom: 3px solid #f39c12;
  font-weight: 600;
}

/* Product grid */
.product-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 25px;
}

.product-card {
  background-color: #fff;
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.05);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  cursor: pointer;
}

.product-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
}

.product-image {
  width: 100%;
  height: 220px;
  overflow: hidden;
}

.product-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.5s ease;
}

.product-card:hover .product-image img {
  transform: scale(1.05);
}

.product-info {
  padding: 15px;
  border-top: 1px solid #eee;
}

.product-title {
  font-size: 16px;
  margin: 0 0 10px;
  color: #333;
  font-weight: 600;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.view-details {
  color: #f39c12;
  font-size: 14px;
  font-weight: 500;
  display: flex;
  align-items: center;
  opacity: 0;
  transition: opacity 0.3s ease;
}

.product-card:hover .view-details {
  opacity: 1;
}

.view-details i {
  margin-left: 5px;
}

.empty-state {
  text-align: center;
  padding: 40px 0;
  color: #999;
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
  .product-grid {
    grid-template-columns: repeat(2, 1fr);
  }

  /*新加*/
  .hero-section {
    height: 400px;
    background-attachment: scroll; /* Disable parallax on mobile */
  }

  .hero-title {
    font-size: 38px;
  }

  .hero-description {
    font-size: 16px;
    line-height: 1.6;
  }

/*  .hero-section {
    height: 250px;
  }*/

  .hero-content {
    padding: 60px 20px;
  }

/*  .hero-title {
    font-size: 28px;
  }*/
}

@media (max-width: 767px) {

  .section-title {
    font-size: 24px;
  }

  /*新加*/
  .hero-section {
    height: 350px;
  }

  .hero-title {
    font-size: 30px;
    margin-bottom: 15px;
  }

  .title-separator {
    margin-bottom: 15px;
  }

  .hero-description {
    font-size: 15px;
    line-height: 1.5;
  }

  .btn-explore {
    padding: 10px 25px;
    font-size: 14px;
  }

/*  .hero-section {
    height: 200px;
  }*/

  .hero-content {
    padding: 40px 15px;
  }

/*  .hero-title {
    font-size: 24px;
  }*/

/*  .hero-description {
    font-size: 14px;
  }*/

  .tabs-nav li a {
    padding: 10px 15px;
    font-size: 14px;
  }
}

@media (max-width: 575px) {
  .product-grid {
    grid-template-columns: 1fr;
    gap: 20px;
  }

  .product-image {
    height: 180px;
  }

  .section-header {
    margin-bottom: 25px;
  }

  .product-section {
    padding: 30px 0;
  }

  .view-details {
    opacity: 1;
  }

  /*新加*/
  .hero-section {
    height: 300px;
  }

  .hero-title {
    font-size: 24px;
    margin-bottom: 10px;
  }

  .title-separator {
    margin-bottom: 12px;
    width: 60px;
  }

  .hero-description {
    font-size: 14px;
    line-height: 1.5;
    margin-bottom: 20px;
  }

  .hero-cta {
    margin-top: 20px;
  }

  .btn-explore {
    padding: 8px 20px;
    font-size: 12px;
  }

/*  .hero-section {
    height: 180px;
  }*/

  .hero-content {
    padding: 30px 15px;
  }

/*  .hero-title {
    font-size: 20px;
    margin-bottom: 10px;
  }*/
}
</style>