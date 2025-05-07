<template>
  <Layout>
    <!-- 页面顶部区域 - 更现代的英雄区设计 -->

    <div class="hero-section">
      <div class="hero-overlay"></div>
      <div class="hero-content">
        <div class="container">
          <h1 class="hero-title">客户案例</h1>
          <p class="hero-description">探索我们精心打造的照明与招牌解决方案</p>
          <div class="hero-cta">
            <button class="hero-btn primary">浏览案例</button>
            <button class="hero-btn secondary">联系我们</button>
          </div>
        </div>
      </div>
      <div class="hero-wave">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 100">
          <path fill="#f8fafc" fill-opacity="1" d="M0,64L80,53.3C160,43,320,21,480,16C640,11,800,21,960,42.7C1120,64,1280,96,1360,112L1440,128L1440,320L1360,320C1280,320,1120,320,960,320C800,320,640,320,480,320C320,320,160,320,80,320L0,320Z"></path>
        </svg>
      </div>
    </div>

    <!-- 案例展示区域 - 更干净的布局与更好的视觉层次 -->
    <div class="showcase-section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">携手共创 <span class="highlight">点亮每一个精彩瞬间</span></h2>
          <div class="section-description">
            <p>我们专注于广告装饰发光字及招牌的设计与制作，致力于为客户打造独特、亮眼的品牌形象。</p>
            <p>以下是我们与合作伙伴共同完成的一些经典案例，展示了我们在这一领域的专业实力和创意设计。</p>
          </div>
        </div>

        <!-- 案例分类标签 - 更现代的选项卡设计 -->
        <div class="case-tabs">
          <div class="tabs-container">
            <div
                v-for="(tab, index) in tabList"
                :key="index"
                @click="changeTab(index)"
                class="tab-item"
                :class="{'active': tabIndex === index}"
            >
              <div class="tab-icon">
                <svg v-if="tab.id === 1" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                  <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"></polygon>
                </svg>
                <svg v-else-if="tab.id === 2" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                  <rect x="2" y="7" width="20" height="14" rx="2" ry="2"></rect>
                  <path d="M16 21V5a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v16"></path>
                </svg>
                <svg v-else-if="tab.id === 3" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                  <rect x="2" y="7" width="20" height="14" rx="2" ry="2"></rect>
                  <path d="M16 21V5a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v16"></path>
                </svg>
                <svg v-else-if="tab.id === 4" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                  <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                  <circle cx="9" cy="7" r="4"></circle>
                  <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                  <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                </svg>
                <svg v-else-if="tab.id === 5" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                  <rect x="4" y="2" width="16" height="20" rx="2" ry="2"></rect>
                  <line x1="9" y1="22" x2="9" y2="2"></line>
                  <line x1="16" y1="4" x2="16" y2="4"></line>
                  <line x1="16" y1="8" x2="16" y2="8"></line>
                  <line x1="16" y1="12" x2="16" y2="12"></line>
                </svg>
                <svg v-else-if="tab.id === 6" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                  <path d="M22 10v6M2 10l10-5 10 5-10 5z"></path>
                  <path d="M6 12v5c0 2 2 3 6 3s6-1 6-3v-5"></path>
                </svg>
              </div>
              <span class="tab-text">{{ tab.name }}</span>
            </div>
          </div>
        </div>

        <!-- 案例图片展示区 - 更吸引人的网格布局 -->
        <transition name="fade" mode="out-in">
          <div class="gallery-container" :key="tabIndex">
            <div v-if="loading" class="loading-container">
              <div class="loading-spinner"></div>
              <span>加载中...</span>
            </div>

            <div v-else-if="list.length === 0" class="empty-state">
              <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round">
                <rect x="3" y="3" width="18" height="18" rx="2" ry="2"></rect>
                <circle cx="8.5" cy="8.5" r="1.5"></circle>
                <polyline points="21 15 16 10 5 21"></polyline>
              </svg>
              <p>暂无案例图片</p>
              <button class="empty-state-btn" @click="changeTab(0)">查看主要案例</button>
            </div>

            <div v-else class="gallery-grid">
              <div
                  v-for="(image, index) in list"
                  :key="index"
                  class="gallery-item"
                  @click="openLightbox(index)"
              >
                <div class="image-wrapper">
                  <img :src="image" :alt="`${getCurrentTabName()}案例 ${index + 1}`">
                  <div class="image-overlay">
                    <div class="overlay-content">
                      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                        <circle cx="11" cy="11" r="8"></circle>
                        <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
                        <line x1="11" y1="8" x2="11" y2="14"></line>
                        <line x1="8" y1="11" x2="14" y2="11"></line>
                      </svg>
                      <span>查看详情</span>
                    </div>
                  </div>
                </div>
                <div class="gallery-item-info">
                  <h3 class="gallery-item-title">{{ getCurrentTabName() }} {{ index + 1 }}</h3>
                  <span class="gallery-item-tag">{{ tabList[tabIndex].name }}</span>
                </div>
              </div>
            </div>
          </div>
        </transition>

        <!-- 更现代的分页器 (可选) -->
        <div v-if="list.length > 0" class="pagination">
          <button class="pagination-btn" :disabled="true">
            <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <polyline points="15 18 9 12 15 6"></polyline>
            </svg>
            上一页
          </button>
          <span class="pagination-info">第 1 页，共 {{ Math.ceil(list.length / 8) }} 页</span>
          <button class="pagination-btn" :disabled="list.length <= 8">
            下一页
            <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <polyline points="9 18 15 12 9 6"></polyline>
            </svg>
          </button>
        </div>

        <!-- 图片预览弹窗 - 更现代的灯箱设计 -->
        <div class="lightbox" v-if="lightboxVisible" @click="closeLightbox">
          <div class="lightbox-content" @click.stop>
            <button class="lightbox-close" @click="closeLightbox">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <line x1="18" y1="6" x2="6" y2="18"></line>
                <line x1="6" y1="6" x2="18" y2="18"></line>
              </svg>
            </button>
            <button class="lightbox-nav prev" v-if="list.length > 1" @click.stop="navigateLightbox(-1)">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <polyline points="15 18 9 12 15 6"></polyline>
              </svg>
            </button>
            <button class="lightbox-nav next" v-if="list.length > 1" @click.stop="navigateLightbox(1)">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <polyline points="9 18 15 12 9 6"></polyline>
              </svg>
            </button>
            <div class="lightbox-image-container">
              <img :src="list[currentLightboxIndex]" :alt="`${getCurrentTabName()}案例 ${currentLightboxIndex + 1}`">
            </div>
            <div class="lightbox-caption">
              <span class="lightbox-counter">{{ currentLightboxIndex + 1 }} / {{ list.length }}</span>
              <span class="lightbox-title">{{ getCurrentTabName() }} - 案例 {{ currentLightboxIndex + 1 }}</span>
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
  name: "ExampleView",
  components: { Layout },
  data() {
    return {
      tabIndex: 0,
      tabList: [
        { id: 1, name: '主要案例', icon: 'star' },
        { id: 2, name: '政府案例', icon: 'landmark' },
        { id: 3, name: '商业办公案例', icon: 'briefcase' },
        { id: 4, name: '公共服务案例', icon: 'users' },
        { id: 5, name: '房地产案例', icon: 'building' },
        { id: 6, name: '教育案例', icon: 'book' },
      ],
      list: [],
      loading: true,
      lightboxVisible: false,
      currentLightboxIndex: 0
    }
  },
  mounted() {
    document.title = '客户案例 - 广告装饰发光字及招牌设计制作';
    this.findExampleByExampleType(0);
  },
  methods: {
    changeTab(index) {
      if (this.tabIndex === index) return;
      this.tabIndex = index;
      this.loading = true;
      this.findExampleByExampleType(index);

      // 滚动到案例区域
      const galleryContainer = document.querySelector('.gallery-container');
      if (galleryContainer) {
        setTimeout(() => {
          galleryContainer.scrollIntoView({ behavior: 'smooth', block: 'start' });
        }, 100);
      }
    },

    findExampleByExampleType(exampleType) {
      this.getRequest(`/findExampleByExampleType/${exampleType}`).then(resp => {
        this.loading = false;
        if (resp && resp.data && resp.data.data) {
          const temp = resp.data.data;
          const list = [];
          for (let i = 1; i < 17; i++) {
            if (temp['image' + i] != null) {
              list.push(temp['image' + i]);
            }
          }
          this.list = list;
        } else {
          this.list = [];
        }
      }).catch(() => {
        this.loading = false;
        this.list = [];
      });
    },

    getCurrentTabName() {
      return this.tabList[this.tabIndex].name;
    },

    openLightbox(index) {
      this.currentLightboxIndex = index;
      this.lightboxVisible = true;
      document.body.classList.add('no-scroll');
    },

    closeLightbox() {
      this.lightboxVisible = false;
      document.body.classList.remove('no-scroll');
    },

    navigateLightbox(direction) {
      const newIndex = this.currentLightboxIndex + direction;
      if (newIndex >= 0 && newIndex < this.list.length) {
        this.currentLightboxIndex = newIndex;
      } else if (newIndex < 0) {
        this.currentLightboxIndex = this.list.length - 1;
      } else {
        this.currentLightboxIndex = 0;
      }
    }
  }
}
</script>

<style scoped>
/* 全局样式 */
.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 15px;
}

/* 页面顶部英雄区域 - 更有吸引力的设计 */
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

.hero-section {
  position: relative;
  height: 400px;
  width: 100%;
  background-image: url('../assets/images/footer.jpg');
  background-size: cover;
  background-position: center;
  color: #fff;
  margin-bottom: 0;
  display: flex;
  align-items: center;
  overflow: hidden;
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


/*.hero-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-image: url("data:image/svg+xml,%3Csvg width='60' height='60' viewBox='0 0 60 60' xmlns='http://www.w3.org/2000/svg'%3E%3Cg fill='none' fill-rule='evenodd'%3E%3Cg fill='%23ffffff' fill-opacity='0.05'%3E%3Cpath d='M36 34v-4h-2v4h-4v2h4v4h2v-4h4v-2h-4zm0-30V0h-2v4h-4v2h4v4h2V6h4V4h-4zM6 34v-4H4v4H0v2h4v4h2v-4h4v-2H6zM6 4V0H4v4H0v2h4v4h2V6h4V4H6z'/%3E%3C/g%3E%3C/g%3E%3C/svg%3E");
  opacity: 0.2;
}*/

.hero-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: linear-gradient(135deg, rgba(45, 71, 141, 0.9) 0%, rgba(32, 54, 114, 0.8) 100%);
  background-image: linear-gradient(135deg, rgba(45, 71, 141, 0.9) 0%, rgba(32, 54, 114, 0.8) 100%), url("data:image/svg+xml,%3Csvg width='60' height='60' viewBox='0 0 60 60' xmlns='http://www.w3.org/2000/svg'%3E%3Cg fill='none' fill-rule='evenodd'%3E%3Cg fill='%23ffffff' fill-opacity='0.05'%3E%3Cpath d='M36 34v-4h-2v4h-4v2h4v4h2v-4h4v-2h-4zm0-30V0h-2v4h-4v2h4v4h2V6h4V4h-4zM6 34v-4H4v4H0v2h4v4h2v-4h4v-2H6zM6 4V0H4v4H0v2h4v4h2V6h4V4H6z'/%3E%3C/g%3E%3C/g%3E%3C/svg%3E");
}

/*新加*/
.hero-content {
  position: relative;
  z-index: 2;
  width: 100%;
  text-align: center;
  padding: 0 20px;
}

.hero-title {
  font-size: 52px;
  font-weight: 800;
  margin: 0 0 15px;
  letter-spacing: 1px;
  text-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
  animation: fadeInDown 0.8s ease-out;
}

.hero-description {
  font-size: 20px;
  max-width: 600px;
  margin: 0 auto 30px;
  opacity: 0.95;
  font-weight: 300;
  letter-spacing: 0.5px;
  text-shadow: 0 1px 4px rgba(0, 0, 0, 0.2);
  animation: fadeInUp 0.8s ease-out 0.2s both;
}
.hero-cta {
  display: flex;
  justify-content: center;
  gap: 16px;
  animation: fadeIn 1s ease-out 0.4s both;
}

.hero-btn {
  padding: 12px 24px;
  font-size: 16px;
  font-weight: 600;
  border-radius: 8px;
  transition: all 0.3s ease;
  cursor: pointer;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  border: none;
  text-transform: uppercase;
  letter-spacing: 1px;
}

.hero-btn.primary {
  background: linear-gradient(90deg, #f59e0b, #fbbf24);
  color: #fff;
  box-shadow: 0 4px 14px rgba(245, 158, 11, 0.4);
}

.hero-btn.primary:hover {
  transform: translateY(-3px);
  box-shadow: 0 6px 20px rgba(245, 158, 11, 0.5);
}

.hero-btn.secondary {
  background: rgba(255, 255, 255, 0.15);
  backdrop-filter: blur(10px);
  color: #fff;
  border: 1px solid rgba(255, 255, 255, 0.3);
}

.hero-btn.secondary:hover {
  background: rgba(255, 255, 255, 0.25);
  transform: translateY(-3px);
}

.hero-wave {
  position: absolute;
  bottom: -1px;
  left: 0;
  width: 100%;
  z-index: 3;
  line-height: 0;
}

.hero-wave svg {
  display: block;
  width: 100%;
  height: 50px;
}

 .page-hero::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  height: 6px;
  background: linear-gradient(90deg, #f59e0b, #fbbf24);
}

.page-hero-title {
  font-size: 42px;
  font-weight: 800;
  margin: 0 0 15px;
  letter-spacing: 1px;
  text-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  position: relative;
}


/* 案例展示区域 - 更干净优雅的布局 */
.showcase-section {
  padding: 80px 0;
  background-color: #f8fafc;
}

.section-header {
  text-align: center;
  margin-bottom: 60px;
}

.section-title {
  font-size: 36px;
  font-weight: 800;
  margin: 0 0 20px;
  color: #0f172a;
  position: relative;
  display: inline-block;
}

.section-title .highlight {
  color: #f59e0b;
  position: relative;
}

.section-title::after {
  content: '';
  display: block;
  width: 80px;
  height: 4px;
  background: linear-gradient(90deg, #f59e0b, #fbbf24);
  margin: 15px auto 0;
  border-radius: 2px;
}

.section-description {
  max-width: 800px;
  margin: 0 auto;
  color: #64748b;
  line-height: 1.7;
  font-size: 16px;
}

.section-description p {
  margin: 12px 0;
}

/* 案例分类标签 - 更现代的设计 */
.case-tabs {
  margin-bottom: 50px;
}

.tabs-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 15px;
}

.tab-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 16px 20px;
  border-radius: 12px;
  background-color: #fff;
  border: 1px solid #e2e8f0;
  cursor: pointer;
  transition: all 0.3s ease;
  min-width: 120px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.03);
}

.tab-item:hover {
  transform: translateY(-3px);
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.08);
  border-color: #cbd5e1;
}

.tab-item.active {
  background: linear-gradient(135deg, #2e4985 0%, #3d5788 100%);
  color: #fff;
  border-color: transparent;
  box-shadow: 0 8px 16px rgba(15, 23, 42, 0.25);
}

.tab-icon {
  margin-bottom: 12px;
  color: #f59e0b;
  display: flex;
  justify-content: center;
}

.tab-icon svg {
  stroke: #f59e0b;
  transition: all 0.3s ease;
}

.tab-item.active .tab-icon svg {
  stroke: #fbbf24;
}

.tab-text {
  font-size: 15px;
  font-weight: 500;
}

/* 案例图片展示区 - 更有吸引力的网格布局 */
.gallery-container {
  min-height: 300px;
  position: relative;
}

.gallery-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 25px;
}

.gallery-item {
  background-color: #fff;
  border-radius: 12px;
  overflow: hidden;
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.06);
  cursor: pointer;
  transition: transform 0.3s, box-shadow 0.3s;
  border: 1px solid rgba(226, 232, 240, 0.8);
}

.gallery-item:hover {
  transform: translateY(-6px);
  box-shadow: 0 14px 24px rgba(0, 0, 0, 0.12);
}

.image-wrapper {
  position: relative;
  padding-top: 75%; /* 4:3 比例 */
  overflow: hidden;
}

.image-wrapper img {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.5s ease;
}

.gallery-item:hover .image-wrapper img {
  transform: scale(1.08);
}

.image-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(15, 23, 42, 0.7);
  display: flex;
  align-items: center;
  justify-content: center;
  opacity: 0;
  transition: opacity 0.3s;
}

.gallery-item:hover .image-overlay {
  opacity: 1;
}

.overlay-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  transform: translateY(20px);
  transition: transform 0.3s ease;
}

.gallery-item:hover .overlay-content {
  transform: translateY(0);
}

.overlay-content svg {
  stroke: #fff;
  margin-bottom: 8px;
}

.overlay-content span {
  color: #fff;
  font-size: 14px;
  font-weight: 500;
}

.gallery-item-info {
  padding: 16px;
}

.gallery-item-title {
  font-size: 16px;
  font-weight: 600;
  color: #2d478d;
  margin: 0 0 6px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.gallery-item-tag {
  display: inline-block;
  font-size: 12px;
  padding: 4px 8px;
  background-color: #f1f5f9;
  color: #64748b;
  border-radius: 4px;
  font-weight: 500;
}

/* 分页器 */
.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 40px;
  gap: 16px;
}

.pagination-btn {
  display: flex;
  align-items: center;
  gap: 8px;
  padding: 10px 16px;
  background-color: #fff;
  border: 1px solid #e2e8f0;
  border-radius: 8px;
  color: #556da2;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s ease;
}

.pagination-btn:not(:disabled):hover {
  background-color: #f8fafc;
  border-color: #cbd5e1;
  transform: translateY(-2px);
}

.pagination-btn:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}

.pagination-info {
  color: #64748b;
  font-size: 14px;
}

/* 加载状态 - 更精致的加载动画 */
.loading-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 300px;
  color: #64748b;
}

.loading-spinner {
  width: 40px;
  height: 40px;
  border: 3px solid rgba(245, 158, 11, 0.2);
  border-radius: 50%;
  border-top-color: #f59e0b;
  animation: spin 1s linear infinite;
  margin-bottom: 15px;
}

@keyframes spin {
  to { transform: rotate(360deg); }
}

/* 空状态 - 更友好的空状态提示 */
.empty-state {
  text-align: center;
  padding: 60px 0;
  color: #64748b;
  background-color: #fff;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.03);
}

.empty-state svg {
  stroke: #94a3b8;
  margin-bottom: 15px;
}

.empty-state p {
  font-size: 16px;
  margin-bottom: 20px;
}

.empty-state-btn {
  background: linear-gradient(90deg, #f59e0b, #fbbf24);
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 8px;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s ease;
  box-shadow: 0 4px 8px rgba(245, 158, 11, 0.25);
}

.empty-state-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 12px rgba(245, 158, 11, 0.35);
}

/* 图片预览弹窗 - 更现代的灯箱设计 */
.lightbox {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(100, 130, 196, 0.95);
  z-index: 9999;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
  backdrop-filter: blur(8px);
}

.lightbox-content {
  position: relative;
  max-width: 90%;
  max-height: 90%;
}

.lightbox-close {
  position: absolute;
  top: -40px;
  right: -10px;
  background: none;
  border: none;
  color: white;
  font-size: 30px;
  cursor: pointer;
  z-index: 10;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: rgba(15, 23, 42, 0.5);
  transition: all 0.2s ease;
}

.lightbox-close:hover {
  background-color: rgba(245, 158, 11, 0.8);
  transform: rotate(90deg);
}

.lightbox-image-container {
  max-height: 80vh;
  display: flex;
  align-items: center;
  justify-content: center;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.3);
  border-radius: 6px;
  overflow: hidden;
  background-color: #54676b;
}

.lightbox-image-container img {
  max-width: 100%;
  max-height: 80vh;
  object-fit: contain;
}

.lightbox-nav {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  background: rgba(15, 23, 42, 0.5);
  color: white;
  border: none;
  width: 44px;
  height: 44px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: all 0.3s ease;
  backdrop-filter: blur(4px);
}

.lightbox-nav:hover {
  background-color: rgba(245, 158, 11, 0.8);
  width: 48px;
  height: 48px;
}

.lightbox-nav.prev {
  left: -60px;
}

.lightbox-nav.next {
  right: -60px;
}

.lightbox-caption {
  color: white;
  text-align: center;
  margin-top: 20px;
  font-size: 14px;
  display: flex;
  justify-content: space-between;
  background-color: rgba(15, 23, 42, 0.5);
  padding: 10px 15px;
  border-radius: 8px;
  backdrop-filter: blur(4px);
}

.lightbox-counter {
  font-weight: 500;
  color: #f59e0b;
}

.lightbox-title {
  font-weight: 500;
}

/* 动画效果 */
.fade-enter-active, .fade-leave-active {
  transition: opacity 0.4s ease, transform 0.4s ease;
}

.fade-enter, .fade-leave-to {
  opacity: 0;
  transform: translateY(10px);
}

/*新加*/
@keyframes fadeInDown {
  from {
    opacity: 0;
    transform: translateY(-20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes fadeInUp {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
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


/* 响应式适配 */
@media (max-width: 992px) {
  .page-hero {
    padding: 60px 0 40px;
  }

  /*新加*/
  .hero-section {
    height: 350px;
  }

  .hero-title {
    font-size: 42px;
  }

  .hero-description {
    font-size: 18px;
  }

/*  .hero-section {
    height: 250px;
  }*/

  .section-title {
    font-size: 30px;
  }

  .showcase-section {
    padding: 60px 0;
  }

  .tab-item {
    min-width: 110px;
    padding: 14px 16px;
  }

  .gallery-grid {
    grid-template-columns: repeat(auto-fill, minmax(260px, 1fr));
    gap: 20px;
  }
}



@media (max-width: 768px) {

  /*新加*/
  .hero-section {
    height: 300px;
  }

  .hero-title {
    font-size: 36px;
  }

  .hero-description {
    font-size: 16px;
    max-width: 450px;
  }

  .hero-btn {
    padding: 10px 20px;
    font-size: 14px;
  }
/*  .hero-section {
    height: 200px;
  }*/

  .section-title {
    font-size: 26px;
  }

  .section-description {
    font-size: 15px;
  }

  .tabs-container {
    flex-wrap: wrap;
    gap: 10px;
  }

  .tab-item {
    padding: 12px 16px;
    min-width: 110px;
    flex: 0 0 calc(33.33% - 10px);
    margin-bottom: 10px;
  }

  .tab-icon svg {
    width: 20px;
    height: 20px;
  }

  .tab-text {
    font-size: 13px;
  }

  .gallery-grid {
    grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
    gap: 15px;
  }

  .lightbox-nav.prev {
    left: -45px;
  }

  .lightbox-nav.next {
    right: -45px;
  }

  .gallery-item-title {
    font-size: 15px;
  }
}

@media (max-width: 576px) {
  /*新加*/
  .hero-section {
    height: 280px;
  }

  .hero-title {
    font-size: 30px;
  }

  .hero-description {
    font-size: 15px;
    margin-bottom: 20px;
  }

  .hero-cta {
    flex-direction: column;
    gap: 10px;
    max-width: 200px;
    margin: 0 auto;
  }

  .hero-btn {
    width: 100%;
  }

/*
  .hero-section {
    height: 180px;
  }*/
  .section-title {
    font-size: 24px;
  }

  .section-description {
    font-size: 14px;
  }

  .showcase-section {
    padding: 40px 0;
  }

  .tab-item {
    flex: 0 0 calc(50% - 10px);
    padding: 10px 12px;
  }

  .tab-icon {
    margin-bottom: 8px;
  }

  .gallery-grid {
    grid-template-columns: repeat(auto-fill, minmax(165px, 1fr));
    gap: 12px;
  }

  .gallery-item-info {
    padding: 12px;
  }

  .gallery-item-title {
    font-size: 14px;
    margin-bottom: 4px;
  }

  .gallery-item-tag {
    font-size: 11px;
    padding: 3px 6px;
  }

  .lightbox-nav {
    width: 36px;
    height: 36px;
  }

  .lightbox-nav.prev {
    left: -25px;
  }

  .lightbox-nav.next {
    right: -25px;
  }

  .section-header {
    margin-bottom: 30px;
  }

  .case-tabs {
    margin-bottom: 25px;
  }

  .pagination {
    margin-top: 30px;
    flex-direction: column;
    gap: 10px;
  }

  .pagination-btn {
    width: 100%;
    justify-content: center;
  }
}
</style>