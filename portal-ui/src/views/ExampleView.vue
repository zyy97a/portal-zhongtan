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
                  <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
                  <circle cx="12" cy="7" r="4"></circle>
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

            <div v-else-if="caseData[tabIndex].cases.length === 0" class="empty-state">
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
                  v-for="(caseItem, index) in caseData[tabIndex].cases"
                  :key="index"
                  class="gallery-item"
                  @click="openDetailModal(caseItem)"
              >
                <div class="image-wrapper">
                  <img :src="caseItem.thumbImg" :alt="caseItem.title">
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
                  <h3 class="gallery-item-title">{{ caseItem.title }}</h3>
                  <span class="gallery-item-tag">{{ tabList[tabIndex].name }}</span>
                </div>
              </div>
            </div>
          </div>
        </transition>

        <!-- 更现代的分页器 (可选) -->
        <div v-if="caseData[tabIndex].cases.length > 0" class="pagination">
          <button class="pagination-btn" :disabled="currentPage <= 1" @click="changePage(currentPage - 1)">
            <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <polyline points="15 18 9 12 15 6"></polyline>
            </svg>
            上一页
          </button>
          <span class="pagination-info">第 {{ currentPage }} 页，共 {{ Math.ceil(caseData[tabIndex].cases.length / itemsPerPage) }} 页</span>
          <button class="pagination-btn" :disabled="currentPage >= Math.ceil(caseData[tabIndex].cases.length / itemsPerPage)" @click="changePage(currentPage + 1)">
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
            <button class="lightbox-nav prev" v-if="lightboxImages.length > 1" @click.stop="navigateLightbox(-1)">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <polyline points="15 18 9 12 15 6"></polyline>
              </svg>
            </button>
            <button class="lightbox-nav next" v-if="lightboxImages.length > 1" @click.stop="navigateLightbox(1)">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <polyline points="9 18 15 12 9 6"></polyline>
              </svg>
            </button>
            <div class="lightbox-image-container">
              <img :src="lightboxImages[currentLightboxIndex]" :alt="lightboxTitle">
            </div>
            <div class="lightbox-caption">
              <span class="lightbox-counter">{{ currentLightboxIndex + 1 }} / {{ lightboxImages.length }}</span>
              <span class="lightbox-title">{{ lightboxTitle }}</span>
            </div>
          </div>
        </div>

        <!-- 案例详情弹窗 -->
        <div class="case-detail-modal" v-if="detailModalVisible" @click="closeDetailModal">
          <div class="case-modal-content" @click.stop>
            <button class="modal-close" @click="closeDetailModal">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <line x1="18" y1="6" x2="6" y2="18"></line>
                <line x1="6" y1="6" x2="18" y2="18"></line>
              </svg>
            </button>

            <div class="case-modal-body">
              <div class="case-modal-gallery">
                <div class="featured-image">
                  <img :src="currentCase.images && currentCase.images.length ? currentCase.images[currentImageIndex] : currentCase.thumbImg" :alt="currentCase.title">
                  <div class="image-controls" v-if="currentCase.images && currentCase.images.length > 1">
                    <button class="image-nav prev" @click="changeImage(-1)">
                      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                        <polyline points="15 18 9 12 15 6"></polyline>
                      </svg>
                    </button>
                    <button class="image-nav next" @click="changeImage(1)">
                      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                        <polyline points="9 18 15 12 9 6"></polyline>
                      </svg>
                    </button>
                  </div>
                </div>

                <div class="image-thumbnails" v-if="currentCase.images && currentCase.images.length > 1">
                  <div
                      v-for="(image, index) in currentCase.images"
                      :key="index"
                      class="thumbnail"
                      :class="{'active': index === currentImageIndex}"
                      @click="currentImageIndex = index"
                  >
                    <img :src="image" :alt="`${currentCase.title} - 缩略图 ${index + 1}`">
                  </div>
                </div>
              </div>

              <div class="case-modal-details">
                <h2 class="case-title">{{ currentCase.title }}</h2>

                <div class="case-meta">
                  <div class="meta-item">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                      <path d="M21 10c0 7-9 13-9 13s-9-6-9-13a9 9 0 0 1 18 0z"></path>
                      <circle cx="12" cy="10" r="3"></circle>
                    </svg>
                    <span>{{ currentCase.location || '未知位置' }}</span>
                  </div>

                  <div class="meta-item">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                      <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                      <circle cx="9" cy="7" r="4"></circle>
                      <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                      <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                    </svg>
                    <span>{{ currentCase.client || '未知客户' }}</span>
                  </div>

                  <div class="meta-item">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                      <rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect>
                      <line x1="16" y1="2" x2="16" y2="6"></line>
                      <line x1="8" y1="2" x2="8" y2="6"></line>
                      <line x1="3" y1="10" x2="21" y2="10"></line>
                    </svg>
                    <span>{{ currentCase.completionTime || '未知完成时间' }}</span>
                  </div>

                  <div class="meta-item">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                      <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"></polygon>
                    </svg>
                    <span>{{ tabList[tabIndex].name }}</span>
                  </div>
                </div>

                <div class="case-description">
                  <h3>项目概述</h3>
                  <p>{{ currentCase.description || '暂无项目描述' }}</p>
                </div>

                <div class="case-footer">
                  <button class="view-all-btn" @click="viewAllImages" v-if="currentCase.images && currentCase.images.length > 0">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                      <rect x="3" y="3" width="18" height="18" rx="2" ry="2"></rect>
                      <circle cx="8.5" cy="8.5" r="1.5"></circle>
                      <polyline points="21 15 16 10 5 21"></polyline>
                    </svg>
                    查看所有图片
                  </button>

                  <button class="contact-btn">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                      <path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"></path>
                      <polyline points="22,6 12,13 2,6"></polyline>
                    </svg>
                    咨询类似方案
                  </button>
                </div>
              </div>
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
  name: "CaseListingView",
  components: { Layout },
  data() {
    return {
      tabIndex: 0,
      currentPage: 1,
      itemsPerPage: 8,
      tabList: [
        { id: 1, name: '主要案例', icon: 'star' },
        { id: 2, name: '政府案例', icon: 'landmark' },
        { id: 3, name: '商业办公案例', icon: 'briefcase' },
        { id: 4, name: '公共服务案例', icon: 'users' },
        { id: 5, name: '房地产案例', icon: 'building' },
        { id: 6, name: '教育案例', icon: 'book' },
      ],
      caseData: [
        {
          type: '主要案例',
          cases: [
            {
              id: 101,
              title: '星光商业广场发光字招牌',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '上海市静安区南京西路',
              client: '星光商业管理有限公司',
              completionTime: '2024年3月',
              description: '星光商业广场作为城市新地标，需要一套能够在夜间彰显品牌魅力的标识系统。我们采用了RGB智能变色LED技术，为其打造了一套可根据节日和活动主题变换色彩的大型发光字招牌。'
            },
            {
              id: 102,
              title: '海天国际酒店门头设计',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '广州市天河区珠江新城',
              client: '海天国际酒店集团',
              completionTime: '2023年12月',
              description: '为海天国际酒店设计的门头招牌，采用了高档金属材质与内嵌LED灯带相结合的方式，在白天展现豪华稳重的气质，夜晚则通过精心设计的灯光方案彰显高端奢华的品牌定位。'
            },
            {
              id: 103,
              title: '蓝天科技园区整体标识系统',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '深圳市南山区科技园',
              client: '蓝天科技有限公司',
              completionTime: '2024年2月',
              description: '为蓝天科技园区打造的整体标识系统，包括园区入口标识、楼宇发光字、指示牌等多种形式。整体设计理念源于科技与自然的融合，采用了蓝色渐变光效与生态树脂材料相结合，展现科技感与环保理念。'
            },
            {
              id: 104,
              title: '新月购物中心品牌墙',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '北京市朝阳区建国路',
              client: '新月商业地产开发有限公司',
              completionTime: '2023年10月',
              description: '新月购物中心的品牌墙位于商场主入口，作为视觉焦点需要具有强烈的冲击力。我们采用了镜面不锈钢与LED逆发光技术，打造出似漂浮在空中的品牌标识，配合智能感应系统，可根据人流量调整亮度和动画效果。'
            },
            {
              id: 105,
              title: '绿洲咖啡连锁店发光招牌',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '多地连锁',
              client: '绿洲咖啡有限公司',
              completionTime: '2024年1月',
              description: '为绿洲咖啡连锁店设计的标准化发光招牌，采用环保亚克力与暖白光源相结合，体现品牌温馨自然的调性。招牌设计兼顾了日夜两种视觉效果，并充分考虑了不同城市的安装环境和法规要求。'
            },
            {
              id: 106,
              title: '东方文化中心大型LED屏',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '重庆市渝中区人民广场',
              client: '重庆市文化旅游局',
              completionTime: '2023年9月',
              description: '为东方文化中心量身定制的大型LED显示屏，面积达200平方米，采用了最新的小间距LED技术，可播放8K超高清内容。系统集成了智能温控、远程管理等功能，并针对当地多雨潮湿的气候做了特殊防水设计。'
            }
          ]
        },
        {
          type: '政府案例',
          cases: [
            {
              id: 201,
              title: '市政府大楼外立面标识工程',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '杭州市西湖区',
              client: '杭州市政府办公厅',
              completionTime: '2023年11月',
              description: '为杭州市政府新办公大楼设计的外立面标识工程，采用316L不锈钢镜面工艺，结合特殊的防腐蚀处理，确保在湖区潮湿环境中长期保持良好状态。夜间通过精确计算的照明角度，使标识在湖面形成美丽倒影。'
            },
            {
              id: 202,
              title: '城市规划展览馆LED显示系统',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '南京市建邺区',
              client: '南京市规划局',
              completionTime: '2024年1月',
              description: '为城市规划展览馆设计的大型LED显示系统，包括弧形屏、互动投影等多种形式。展示系统采用5G远程控制技术，可实时更新城市规划内容，并支持参观者通过手机互动参与虚拟城市建设。'
            },
            {
              id: 203,
              title: '文化广场城市灯光标识',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '武汉市江汉区',
              client: '武汉市文化旅游局',
              completionTime: '2023年8月',
              description: '为武汉文化广场设计的城市灯光标识，高达18米，采用钢结构骨架与透光膜材质，内置1600个独立可控LED点光源，能够呈现复杂的光影效果，成为城市新地标。系统集成了气象数据采集功能，可根据天气状况自动调整灯光表现。'
            }
          ]
        },
        {
          type: '商业办公案例',
          cases: [
            {
              id: 301,
              title: '金融中心大厦顶层标识',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '上海市陆家嘴金融区',
              client: '国际金融集团',
              completionTime: '2024年2月',
              description: '为金融中心大厦设计的顶层发光标识，高度位于320米的建筑顶端，需要考虑极端天气条件下的稳定性和维护便捷性。采用了航空级铝合金框架与超高亮度LED模组，配合远程监控系统，确保在各种条件下的正常运行。'
            },
            {
              id: 302,
              title: '创意产业园区导视系统',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '北京市朝阳区798艺术区',
              client: '创意空间管理有限公司',
              completionTime: '2023年12月',
              description: '为798艺术区内的创意产业园设计的整体导视系统，融合了工业风格与现代艺术元素，采用锈蚀钢板与LED光源相结合的方式，既保留了原有工业遗存的质感，又增添了现代科技感，形成独特的视觉标识。'
            },
            {
              id: 303,
              title: '云端科技总部大厦标识',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '深圳市南山区高新技术园区',
              client: '云端科技有限公司',
              completionTime: '2024年1月',
              description: '为云端科技公司总部大厦设计的企业标识，采用半透明导光材料与微型LED阵列相结合的方式，在日光下呈现轻盈通透的效果，夜间则通过精密的光程控制，营造出如云层般流动的光效，完美诠释了公司"云端"的品牌理念。'
            }
          ]
        },
        {
          type: '公共服务案例',
          cases: [
            {
              id: 401,
              title: '中心医院医疗导视系统',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '广州市天河区',
              client: '广州中心医院',
              completionTime: '2023年10月',
              description: '为广州中心医院设计的全院导视系统，包括门诊、住院、急诊等多个区域的标识与导航。系统采用了色彩编码分区设计，结合智能终端查询，大幅提升了患者的就医体验。所有标识材料均采用抗菌材质，符合医疗环境的特殊要求。'
            },
            {
              id: 402,
              title: '城市轨道交通标识系统',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '成都市地铁18号线',
              client: '成都地铁集团',
              completionTime: '2023年9月',
              description: '为成都地铁18号线设计的全线标识系统，包括车站入口标识、方向指引、站台信息牌等多种形式。设计融入了成都地方文化元素，采用了耐候性强的材料与节能LED照明，确保长期使用的安全性与美观性。'
            },
            {
              id: 403,
              title: '体育中心赛事指示系统',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '西安市雁塔区',
              client: '陕西省体育局',
              completionTime: '2024年3月',
              description: '为西安体育中心设计的赛事指示系统，采用模块化设计，可根据不同赛事快速更换内容。系统结合了电子墨水屏与LED照明，既保证了信息的清晰度，又大幅降低了能耗。特别考虑了大客流疏散的需求，在紧急情况下可切换为应急指引模式。'
            }
          ]
        },
        {
          type: '房地产案例',
          cases: [
            {
              id: 501,
              title: '城市花园小区入口标识',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '上海市松江区',
              client: '绿城房地产开发有限公司',
              completionTime: '2023年11月',
              description: '为城市花园高端住宅小区设计的入口标识，采用了天然石材与铜板相结合的方式，体现项目的高端品质。夜间照明采用了隐藏式设计，营造出温馨而不张扬的氛围，同时考虑了周边居民的光污染问题，精确控制了光照角度与亮度。'
            },
            {
              id: 502,
              title: '滨海公寓综合标识系统',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '厦门市思明区',
              client: '万科地产',
              completionTime: '2023年12月',
              description: '为滨海公寓设计的综合标识系统，包括楼栋标识、景观指示牌、公共设施标识等多个部分。设计灵感来源于海浪元素，采用了防腐蚀材料与特殊工艺，适应海边潮湿多盐的环境特点。夜间照明考虑了居住舒适度，采用了柔和的间接光源。'
            },
            {
              id: 503,
              title: '云境商业广场品牌标识',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '重庆市渝北区',
              client: '华润置地',
              completionTime: '2024年2月',
              description: '为云境商业广场打造的品牌标识，结合了当地山城特色与现代商业气息。主招牌采用了大型悬臂结构与3D立体字相结合的形式，并通过特殊的表面处理，在不同角度呈现出渐变的视觉效果。照明系统支持多种场景切换，适应不同季节和营销活动。'
            }
          ]
        },
        {
          type: '教育案例',
          cases: [
            {
              id: 601,
              title: '未来科技学院校园标识',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '北京市海淀区',
              client: '北京理工大学',
              completionTime: '2023年8月',
              description: '为未来科技学院设计的校园标识系统，融合了学院前沿科技的理念与传统学府的人文精神。入口处的大型标识采用了动态光电材料，可根据环境光线自动调整亮度和颜色，校内指示系统则采用了环保材料与简约设计，营造出轻松开放的学习氛围。'
            },
            {
              id: 602,
              title: '儿童科技馆互动标识',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '上海市普陀区',
              client: '上海市科协',
              completionTime: '2024年1月',
              description: '为儿童科技馆设计的互动标识系统，将导视功能与科普内容有机结合。系统采用了触控屏幕、声光感应等多种交互技术，让孩子们在寻找展区的过程中也能获取知识。所有材料均符合儿童安全标准，并采用了防撞圆角设计。'
            },
            {
              id: 603,
              title: '图书馆阅读空间标识',
              thumbImg: require('@/assets/images/about/beij3.jpg'),
              images: [
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg'),
                require('@/assets/images/about/beij3.jpg')
              ],
              location: '南京市鼓楼区',
              client: '南京大学图书馆',
              completionTime: '2023年10月',
              description: '为大学图书馆阅读空间设计的标识系统，注重细节与阅读环境的和谐。系统采用了无反光材料与静音设计，最大限度减少对读者的干扰。分区色彩基于色彩心理学精心挑选，有助于调节阅读情绪，提高学习效率。导视设计结合了古籍元素，彰显深厚的文化底蕴。'
            }
          ]
        }
      ],
      loading: false,
      lightboxVisible: false,
      lightboxImages: [],
      lightboxTitle: '',
      currentLightboxIndex: 0,
      // New properties for the detail modal
      detailModalVisible: false,
      currentCase: {},
      currentImageIndex: 0
    }
  },
  computed: {
    filteredCases() {
      const currentTabType = this.tabList[this.tabIndex].name;
      const tabData = this.caseData.find(item => item.type === currentTabType) || { cases: [] };
      return tabData.cases;
    },
    totalPages() {
      return Math.ceil(this.filteredCases.length / this.itemsPerPage);
    },
    paginatedCases() {
      const start = (this.currentPage - 1) * this.itemsPerPage;
      const end = start + this.itemsPerPage;
      return this.filteredCases.slice(start, end);
    }
  },
  mounted() {
    document.title = '客户案例 - 广告装饰发光字及招牌设计制作';
  },
  methods: {
    changeTab(index) {
      if (this.tabIndex === index) return;
      this.tabIndex = index;
      this.currentPage = 1;
      this.loading = true;

      // 模拟加载效果
      setTimeout(() => {
        this.loading = false;
        this.scrollToGallery();
      }, 500);
    },

    scrollToGallery() {
      const galleryContainer = document.querySelector('.gallery-container');
      if (galleryContainer) {
        galleryContainer.scrollIntoView({ behavior: 'smooth', block: 'start' });
      }
    },

    changePage(page) {
      if (page < 1 || page > this.totalPages || page === this.currentPage) return;
      this.currentPage = page;
      this.scrollToGallery();
    },

    getCurrentTabName() {
      return this.tabList[this.tabIndex].name;
    },

    navigateToDetail(tabIndex, caseId) {
      // 使用路由导航到详情页
      this.$router.push({
        name: 'CaseDetail',
        params: { id: caseId },
        query: { tab: tabIndex }
      });
    },

    // Case detail modal methods
    openDetailModal(caseItem) {
      this.currentCase = { ...caseItem };
      this.currentImageIndex = 0;
      this.detailModalVisible = true;
      document.body.classList.add('no-scroll');
    },

    closeDetailModal() {
      this.detailModalVisible = false;
      document.body.classList.remove('no-scroll');
    },

    changeImage(direction) {
      const imagesLength = this.currentCase.images.length;
      if (!imagesLength) return;

      this.currentImageIndex = (this.currentImageIndex + direction + imagesLength) % imagesLength;
    },

    viewAllImages() {
      this.openLightbox(this.currentCase.images, this.currentCase.title, this.currentImageIndex);
    },

    // Lightbox methods
    openLightbox(images, title, startIndex = 0) {
      this.lightboxImages = images;
      this.lightboxTitle = title;
      this.currentLightboxIndex = startIndex;
      this.lightboxVisible = true;
      document.body.classList.add('no-scroll');
    },

    closeLightbox() {
      this.lightboxVisible = false;
      document.body.classList.remove('no-scroll');
    },

    navigateLightbox(direction) {
      const imagesLength = this.lightboxImages.length;
      if (!imagesLength) return;

      this.currentLightboxIndex = (this.currentLightboxIndex + direction + imagesLength) % imagesLength;
    }
  }
}
</script>

<style scoped>
/* ===============================
   GLOBAL STYLES
   =============================== */
.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 15px;
}

/* Animation keyframes for reuse */
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
  from { opacity: 0; }
  to { opacity: 1; }
}

@keyframes spin {
  to { transform: rotate(360deg); }
}

@keyframes modalFadeIn {
  from { opacity: 0; transform: translateY(20px); }
  to { opacity: 1; transform: translateY(0); }
}

/* Transitions */
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.4s ease, transform 0.4s ease;
}

.fade-enter,
.fade-leave-to {
  opacity: 0;
  transform: translateY(10px);
}

/* ===============================
   HERO SECTION (UNTOUCHED PER REQUEST)
   =============================== */
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

.hero-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: linear-gradient(135deg, rgba(45, 71, 141, 0.9) 0%, rgba(32, 54, 114, 0.8) 100%);
  background-image: linear-gradient(135deg, rgba(45, 71, 141, 0.9) 0%, rgba(32, 54, 114, 0.8) 100%), url("data:image/svg+xml,%3Csvg width='60' height='60' viewBox='0 0 60 60' xmlns='http://www.w3.org/2000/svg'%3E%3Cg fill='none' fill-rule='evenodd'%3E%3Cg fill='%23ffffff' fill-opacity='0.05'%3E%3Cpath d='M36 34v-4h-2v4h-4v2h4v4h2v-4h4v-2h-4zm0-30V0h-2v4h-4v2h4v4h2V6h4V4h-4zM6 34v-4H4v4H0v2h4v4h2v-4h4v-2H6zM6 4V0H4v4H0v2h4v4h2V6h4V4H6z'/%3E%3C/g%3E%3C/g%3E%3C/svg%3E");
}

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

/* ===============================
   BREADCRUMB
   =============================== */
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

/* ===============================
   SECTION HEADERS
   =============================== */
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

/* ===============================
   CASE TABS
   =============================== */
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

/* ===============================
   GALLERY GRID
   =============================== */
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
  padding-top: 75%; /* 4:3 ratio */
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

/* ===============================
   PAGINATION
   =============================== */
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

/* ===============================
   LOADING & EMPTY STATES
   =============================== */
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

/* ===============================
   MODAL & LIGHTBOX
   =============================== */
.case-detail-modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.85);
  z-index: 1000;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
  overflow-y: auto;
}

.case-modal-content {
  background-color: #fff;
  border-radius: 8px;
  width: 100%;
  max-width: 1200px;
  max-height: 90vh;
  position: relative;
  overflow: hidden;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
  animation: modalFadeIn 0.3s ease-out;
}

.modal-close {
  position: absolute;
  top: 15px;
  right: 15px;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: rgba(255, 255, 255, 0.9);
  border: none;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 10;
  transition: all 0.2s ease;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.modal-close:hover {
  background-color: #f0f0f0;
  transform: scale(1.05);
}

.case-modal-body {
  display: flex;
  flex-direction: column;
}

.case-modal-gallery {
  width: 100%;
  flex: 0 0 60%;
  background-color: #f0f0f0;
  position: relative;
}

.featured-image {
  width: 100%;
  height: 100%;
  position: relative;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #000;
}

.featured-image img {
  max-width: 100%;
  max-height: 100%;
  object-fit: contain;
  transition: opacity 0.3s ease;
}

.image-controls {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 20px;
  pointer-events: none;
}

.image-nav {
  width: 44px;
  height: 44px;
  border-radius: 50%;
  background-color: rgba(255, 255, 255, 0.9);
  border: none;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  pointer-events: auto;
  transition: all 0.2s ease;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.15);
}

.image-nav:hover {
  background-color: #fff;
  transform: scale(1.05);
}

.image-thumbnails {
  display: flex;
  padding: 15px;
  gap: 10px;
  overflow-x: auto;
  background-color: #fff;
  border-top: 1px solid #eee;
}

.thumbnail {
  width: 70px;
  height: 70px;
  flex-shrink: 0;
  border-radius: 4px;
  overflow: hidden;
  cursor: pointer;
  border: 2px solid transparent;
  transition: all 0.2s ease;
}

.thumbnail:hover {
  transform: translateY(-2px);
}

.thumbnail.active {
  border-color: #0078d4;
}

.thumbnail img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.case-modal-details {
  width: 100%;
  flex: 0 0 40%;
  padding: 25px;
  overflow-y: auto;
}

.case-title {
  font-size: 1.8rem;
  font-weight: 600;
  margin-bottom: 20px;
  color: #222;
}

.case-meta {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 15px;
  margin-bottom: 25px;
}

.meta-item {
  display: flex;
  align-items: center;
  gap: 8px;
  color: #555;
}

.meta-item svg {
  color: #0078d4;
}

.case-description {
  margin-bottom: 30px;
}

.case-description h3 {
  font-size: 1.2rem;
  font-weight: 600;
  margin-bottom: 12px;
  color: #333;
}

.case-description p {
  line-height: 1.6;
  color: #444;
}

.case-footer {
  display: flex;
  gap: 15px;
  margin-top: auto;
  padding-top: 20px;
  border-top: 1px solid #eee;
}

.view-all-btn,
.contact-btn {
  padding: 10px 20px;
  border-radius: 6px;
  font-weight: 500;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  transition: all 0.2s ease;
  cursor: pointer;
}

.view-all-btn {
  background-color: #f0f0f0;
  color: #333;
  border: 1px solid #ddd;
}

.view-all-btn:hover {
  background-color: #e5e5e5;
}

.contact-btn {
  background-color: #0078d4;
  color: white;
  border: none;
  flex-grow: 1;
}

.contact-btn:hover {
  background-color: #0069b8;
}

/* Lightbox styles */
.lightbox {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
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

/* Removed duplicate lightbox styles */

/* ===============================
   RESPONSIVE STYLES
   =============================== */
@media (max-width: 992px) {
  .page-hero {
    padding: 60px 0 40px;
  }

  .hero-section {
    height: 350px;
  }

  .hero-title {
    font-size: 42px;
  }

  .hero-description {
    font-size: 18px;
  }

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

  .section-title {
    font-size: 26px;
  }

  .section-description {
    font-size: 15px;
  }

  .tabs-container {
    justify-content: flex-start;
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