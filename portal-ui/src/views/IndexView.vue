<template>
  <Layout>
    <!-- 顶部公司介绍 -->
    <section class="hero-section">
      <div class="container">
        <div class="company-header">
          <h1 class="company-title">佛山市钟潭装饰工程有限公司</h1>
          <div class="title-underline"></div>
          <p class="company-description">钟潭熟悉每种制作材料和制作工艺，擅长叠加使用放大您的品牌优势。钟潭坚持定制化原则，倾听您的需求，在任何时候都能给你提供专业的招牌和金属制品的意见和帮助，创建符合您期望要求的品牌标志。</p>
        </div>
      </div>
    </section>

    <!-- 轮播Banner区域 -->
    <section class="banner-section">
      <div
          class="banner-slide"
          v-if="slideshow.length > 0"
          :style="{
          backgroundImage: `url(${slideshow[tabIndex]?.imageUrl})`,
        }"
      >
        <div class="banner-overlay">
          <div class="container">
            <div class="banner-content">
              <h2 class="banner-title">定制化服务，首选钟潭装饰</h2>
              <div class="banner-divider"></div>
              <p class="banner-text">钟潭熟悉每种制作材料和制作工艺，擅长叠加使用放大您的品牌优势。钟潭坚持定制化原则，倾听您的需求，在任何时候都能给你提供专业的招牌和金属制品的意见和帮助，创建符合您期望要求的品牌标志。</p>
              <router-link to="/about" class="primary-btn">了解更多</router-link>
            </div>
          </div>
        </div>
      </div>

      <!-- 导航标签 -->
      <div class="tab-navigation">
        <div class="container">
          <div class="tab-container">
            <div
                v-for="(tab, index) in tabList"
                :key="index"
                :class="['tab-item', tabIndex === index ? 'tab-active' : '']"
                @click="changeTab(index)"
            >
              <div class="tab-inner">
                <div class="tab-icon">
                  <i :class="tab.icon"></i>
                </div>
                <div class="tab-content">
                  <h3 class="tab-title">{{tab.name}}</h3>
                  <p class="tab-description">{{tab.desc}}</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- 核心优势部分 -->
    <section class="advantage-section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">核心优势</h2>
          <div class="section-divider"></div>
          <p class="section-description">
            丰富的现场施工经验·专业的技术团队·多元化的业务范围·卓越的项目履历·坚定的核心价值观·明确的经营宗旨·合作共赢的理念
          </p>
        </div>

        <div class="advantage-grid">
          <div
              v-for="(advantage, index) in advantageList"
              :key="index"
              class="advantage-card"
              @click="goToAbout"
          >
            <div class="advantage-image-wrapper">
              <img :src="advantage.cover" :alt="advantage.title" class="advantage-image">
              <div class="image-overlay">
                <span class="overlay-icon">
                  <i class="am-icon-search-plus"></i>
                </span>
              </div>
            </div>
            <div class="advantage-content">
              <h3 class="advantage-title">{{advantage.title}}</h3>
              <div class="advantage-divider"></div>
              <p class="advantage-description">{{advantage.desc}}</p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- 服务部分 -->
    <section class="service-section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">我们的服务</h2>
          <div class="section-divider"></div>
          <p class="section-description">
            作为佛山领先的招牌及金属制作公司，钟潭一手包办"一条龙"专业服务，目标是使招牌标志的设计订购和安装过程变得透明、简单，从而节省客户的时间，金钱和精力！
          </p>
        </div>

        <div class="service-grid">
          <div
              v-for="(service, index) in serviceList"
              :key="index"
              class="service-card"
          >
            <div class="service-icon-wrapper">
              <i :class="service.icon"></i>
            </div>
            <h3 class="service-title">{{ service.title }}</h3>
            <div class="service-divider"></div>
            <p class="service-description">{{service.desc}}</p>
            <div class="service-footer">
              <router-link to="/about" class="service-link">了解更多 <i class="am-icon-angle-right"></i></router-link>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- 底部联系我们 -->
    <section class="contact-section">
      <div class="container">
        <div class="section-header light">
          <h2 class="section-title">联系我们</h2>
          <div class="section-divider"></div>
          <p class="section-description">
            钟潭在流程的每个步骤都为客户提供战略和创意资源，将灵感与业务目标、专有制造技术相结合，为您制造完美的招牌!
          </p>
        </div>

        <div class="contact-cta">
          <a href="tel:+8613078164038" class="primary-btn">立即咨询</a>
          <router-link to="/example" class="outline-btn">查看案例</router-link>
        </div>
      </div>
    </section>
  </Layout>
</template>

  <script>
    import Layout from "@/components/common/Layout";
    export default {
      name: "IndexView",
      components: { Layout },
      data() {
        return {
          tabList: [
            {name: '招牌定制', desc: '专业定制各类招牌', icon: 'am-icon-cog'},
            {name: '质量保证', desc: '精工细作保证品质', icon: 'am-icon-lightbulb-o'},
            {name: '安装使用', desc: '专业团队现场安装', icon: 'am-icon-line-chart'},
            {name: '维修保养', desc: '长期售后维护保养', icon: 'am-icon-hourglass-end'},
          ],
          tabIndex: 0,
          slideshow: [
            { imageUrl: require('@/assets/images/about/beij1.jpg') },
            { imageUrl: require('@/assets/images/about/beij2.jpg') },
            { imageUrl: require('@/assets/images/about/beij3.jpg') },
            { imageUrl: require('@/assets/images/about/beij4.jpg') }
          ],
          advantageList: [
            {id: 1, cover: require('../assets/images/about/beij1.jpg'), title: '丰富的现场施工经验', desc: '公司拥有十余年的发展历程，积累了大量的实际施工经验，能够高效应对各种复杂的施工环境和挑战。'},
            {id: 2, cover: require('../assets/images/about/beij2.jpg'), title: '专业的技术团队', desc: '公司拥有专业的技术团队，确保工程的高质量实施和创新性解决方案的提供。'},
            {id: 3, cover: require('../assets/images/about/beij3.jpg'), title: '多元化的业务范围', desc: '公司承揽室内外装修、广告制作安装、钢结构安装、不锈钢工程等多种业务，展现了全方位的服务能力。'},
            {id: 4, cover: require('../assets/images/about/beij4.jpg'), title: '卓越的项目履历', desc: '公司完成了如南方电网电力工程、联塑集团安装工程等大型项目，证明了其在大型工程中的实力和信誉。'},
          ],
          serviceList: [
            {id: 1, icon: 'am-icon-diamond', title: '招牌定制', desc: '提供超过300种素材方案，涵盖不锈钢、铝、亚克力等空间设计材质，可做不同效果的电镀、抛光、喷漆等流行要素，为客户创造广阔的创作空间，帮助实现营销展示导引等作用。'},
            {id: 2, icon: 'am-icon-user', title: '质量保证', desc: '标牌制作生产基地位于佛山，拥有先进的雕刻机、激光切割机、开槽机、开料机、数控剪板机、折弯机等金属处理机械，无论是精细工艺处理还是大尺寸物料处理都能轻松应付。'},
            {id: 3, icon: 'am-icon-umbrella', title: '安装使用', desc: '钟潭拥有专业安装维护团队，不需要额外寻找供应商，只需要向钟潭预约安装，安装维护团队准时到达，标价明确，无二次收费，按要求完成安装任务。'},
            {id: 4, icon: 'am-icon-briefcase', title: '维修保养', desc: '设有保用教学，帮助您更能掌握使用产品，并在超过保修期之后仍提供有偿维修。在产品生命周期结束后，钟潭会提供优惠供客户重新定制以替旧换新。'}
          ]
        }
      },
      methods: {
        changeTab(index) {
          this.tabIndex = index
        },
        goToAbout() {
          this.$router.push('/about')
        },
        getSlideshow() {
          // 如果需要从API获取幻灯片数据
          this.getRequest("/findAllSlideshow").then(resp => {
            if (resp) {
              this.slideshow = resp.data.data
            }
          })
        }
      },
      // 如果需要从API获取数据，请取消以下注释
      // mounted() {
      //   this.getSlideshow()
      // }
    }
  </script>

<style>
/* 全局样式 */
:root {
  --primary-color: #1976d2;
  --primary-light: #63a4ff;
  --primary-dark: #004ba0;
  --secondary-color: #ff6d00;
  --text-dark: #333333;
  --text-light: #666666;
  --text-lighter: #999999;
  --bg-light: #f8f9fa;
  --bg-dark: #212121;
  --border-color: #e0e0e0;
  --shadow-sm: 0 2px 8px rgba(0,0,0,0.1);
  --shadow-md: 0 4px 16px rgba(0,0,0,0.1);
  --shadow-lg: 0 8px 24px rgba(0,0,0,0.15);
  --radius-sm: 4px;
  --radius-md: 8px;
  --radius-lg: 16px;
  --spacing-xs: 4px;
  --spacing-sm: 8px;
  --spacing-md: 16px;
  --spacing-lg: 24px;
  --spacing-xl: 32px;
  --spacing-xxl: 48px;
  --transition-fast: 0.2s;
  --transition-normal: 0.3s;
  --transition-slow: 0.5s;
}

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  font-family: 'Helvetica Neue', Arial, sans-serif;
  color: var(--text-dark);
  line-height: 1.6;
  background-color: #ffffff;
}

.container {
  width: 100%;
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 var(--spacing-lg);
}

a {
  color: var(--primary-color);
  text-decoration: none;
  transition: color var(--transition-fast) ease;
}

a:hover {
  color: var(--primary-light);
}

/* 按钮样式 */
.primary-btn {
  background-color: var(--primary-color);
  color: white;
  border: none;
  padding: 12px 24px;
  border-radius: var(--radius-sm);
  font-weight: 500;
  cursor: pointer;
  transition: all var(--transition-fast) ease;
  text-transform: uppercase;
  letter-spacing: 1px;
  font-size: 14px;
  box-shadow: var(--shadow-sm);
}

.primary-btn:hover {
  background-color: var(--primary-dark);
  box-shadow: var(--shadow-md);
  transform: translateY(-2px);
}

.outline-btn {
  background-color: transparent;
  color: white;
  border: 2px solid white;
  padding: 10px 22px;
  border-radius: var(--radius-sm);
  font-weight: 500;
  cursor: pointer;
  transition: all var(--transition-fast) ease;
  text-transform: uppercase;
  letter-spacing: 1px;
  font-size: 14px;
  margin-left: var(--spacing-md);
}

.outline-btn:hover {
  background-color: rgba(255, 255, 255, 0.1);
  transform: translateY(-2px);
}

/* 分隔线 */
.title-underline, .section-divider, .advantage-divider, .service-divider {
  height: 3px;
  width: 60px;
  background-color: var(--primary-color);
  margin: var(--spacing-md) auto;
  display: block;
}

.advantage-divider, .service-divider {
  width: 40px;
  margin: var(--spacing-sm) 0;
  background-color: var(--secondary-color);
}

/* 公司介绍区域 */
.hero-section {
  padding: var(--spacing-xl) 0;
  background-color: var(--bg-light);
}

.company-header {
  text-align: center;
  max-width: 800px;
  margin: 0 auto;
}

.company-title {
  font-size: 28px;
  font-weight: 700;
  color: var(--primary-dark);
}

.company-description {
  font-size: 16px;
  color: var(--text-light);
  margin-top: var(--spacing-md);
  line-height: 1.8;
}

/* Banner区域 */
.banner-section {
  position: relative;
}

.banner-slide {
  height: 500px;
  background-size: cover;
  background-position: center;
  position: relative;
}

.banner-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.7));
  display: flex;
  align-items: center;
}

.banner-content {
  color: white;
  max-width: 600px;
  text-align: left;
}

.banner-title {
  font-size: 36px;
  font-weight: 700;
  margin-bottom: var(--spacing-md);
}

.banner-divider {
  height: 3px;
  width: 60px;
  background-color: var(--secondary-color);
  margin-bottom: var(--spacing-md);
}

.banner-text {
  font-size: 18px;
  margin-bottom: var(--spacing-xl);
  line-height: 1.8;
}

/* 导航标签 */
.tab-navigation {
  background-color: white;
  box-shadow: var(--shadow-md);
  position: relative;
  z-index: 10;
}

.tab-container {
  display: flex;
  flex-wrap: wrap;
}

.tab-item {
  flex: 1;
  min-width: 25%;
  cursor: pointer;
  transition: all var(--transition-normal) ease;
  border-bottom: 3px solid transparent;
}

.tab-inner {
  padding: var(--spacing-lg);
  display: flex;
  align-items: center;
}

.tab-icon {
  width: 50px;
  height: 50px;
  background-color: var(--primary-light);
  color: white;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-right: var(--spacing-md);
  font-size: 20px;
  transition: all var(--transition-fast) ease;
}

.tab-content {
  flex: 1;
}

.tab-title {
  font-size: 18px;
  margin-bottom: var(--spacing-xs);
  color: var(--text-dark);
  transition: color var(--transition-fast) ease;
}

.tab-description {
  font-size: 14px;
  color: var(--text-lighter);
  margin: 0;
}

.tab-active {
  border-bottom: 3px solid var(--primary-color);
}

.tab-active .tab-icon {
  background-color: var(--primary-color);
  transform: scale(1.1);
}

.tab-active .tab-title {
  color: var(--primary-color);
}

.tab-item:hover .tab-icon {
  background-color: var(--primary-color);
  transform: scale(1.05);
}

.tab-item:hover .tab-title {
  color: var(--primary-color);
}

/* 核心优势部分 */
.advantage-section {
  padding: var(--spacing-xxl) 0;
  background-color: white;
}

.section-header {
  text-align: center;
  max-width: 900px;
  margin: 0 auto var(--spacing-xxl) auto;
}

.section-title {
  font-size: 30px;
  font-weight: 700;
  color: var(--text-dark);
}

.section-description {
  font-size: 16px;
  color: var(--text-light);
  line-height: 1.8;
  margin-top: var(--spacing-md);
}

/* 修改为两列布局 */
.advantage-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: var(--spacing-xl);
}

.advantage-card {
  border-radius: var(--radius-md);
  overflow: hidden;
  box-shadow: var(--shadow-sm);
  transition: all var(--transition-normal) ease;
  background-color: white;
}

.advantage-card:hover {
  box-shadow: var(--shadow-md);
  transform: translateY(-5px);
}

.advantage-image-wrapper {
  height: 250px;
  overflow: hidden;
  position: relative;
}

.advantage-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform var(--transition-normal) ease;
}

.image-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.3);
  display: flex;
  align-items: center;
  justify-content: center;
  opacity: 0;
  transition: opacity var(--transition-normal) ease;
}



.overlay-icon {
  color: white;
  font-size: 24px;
  background-color: var(--primary-color);
  width: 50px;
  height: 50px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  transform: scale(0.8);
  transition: transform var(--transition-normal) ease;
}

.advantage-card:hover .advantage-image {
  transform: scale(1.05);
}

.advantage-card:hover .image-overlay {
  opacity: 1;
}

.advantage-card:hover .overlay-icon {
  transform: scale(1);
}

.advantage-content {
  padding: var(--spacing-xl);
}

.advantage-title {
  font-size: 22px;
  font-weight: 600;
  margin-bottom: var(--spacing-md);
  color: var(--text-dark);
}

.advantage-description {
  font-size: 16px;
  color: var(--text-light);
  line-height: 1.8;
}

/* 服务部分 */
.service-section {
  padding: var(--spacing-xxl) 0;
  background-color: var(--bg-light);
}

/* 修改为两列布局 */
.service-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: var(--spacing-xl);
}

.service-card {
  background-color: white;
  border-radius: var(--radius-md);
  padding: var(--spacing-xl);
  box-shadow: var(--shadow-sm);
  transition: all var(--transition-normal) ease;
  text-align: center;
}

.service-card:hover {
  box-shadow: var(--shadow-md);
  transform: translateY(-5px);
}

.service-icon-wrapper {
  width: 80px;
  height: 80px;
  background-color: var(--primary-light);
  color: white;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 0 auto var(--spacing-lg) auto;
  font-size: 32px;
  transition: all var(--transition-normal) ease;
}

.service-card:hover .service-icon-wrapper {
  background-color: var(--primary-color);
  transform: rotate(360deg) scale(1.1);
}

.service-title {
  font-size: 22px;
  font-weight: 600;
  margin-bottom: var(--spacing-md);
  color: var(--text-dark);
}

.service-description {
  font-size: 16px;
  color: var(--text-light);
  line-height: 1.8;
  margin-bottom: var(--spacing-lg);
}

.service-footer {
  border-top: 1px solid var(--border-color);
  padding-top: var(--spacing-md);
}

.service-link {
  font-size: 14px;
  font-weight: 500;
  color: var(--primary-color);
  display: inline-flex;
  align-items: center;
}

.service-link i {
  margin-left: var(--spacing-xs);
  transition: transform var(--transition-fast) ease;
}

.service-link:hover i {
  transform: translateX(3px);
}

/* 联系我们部分 */
.contact-section {
  padding: var(--spacing-xxl) 0;
  background-color: var(--primary-dark);
  color: white;
}

.light {
  color: white;
}

.light .section-title {
  color: white;
}

.light .section-description {
  color: rgba(255, 255, 255, 0.8);
}

.contact-cta {
  display: flex;
  justify-content: center;
  margin-top: var(--spacing-xl);
}

/* 响应式调整 */
@media (max-width: 992px) {
  .tab-item {
    min-width: 50%;
  }

  .banner-slide {
    height: 400px;
  }

  .banner-title {
    font-size: 30px;
  }

  .banner-text {
    font-size: 16px;
  }

  .section-title {
    font-size: 26px;
  }

  .advantage-title, .service-title {
    font-size: 20px;
  }
}

@media (max-width: 768px) {
  .company-title {
    font-size: 24px;
  }

  .banner-slide {
    height: 350px;
  }

  .banner-content {
    text-align: center;
    margin: 0 auto;
  }

  .banner-divider {
    margin: var(--spacing-md) auto;
  }

  .tab-item {
    min-width: 100%;
  }

  .tab-inner {
    padding: var(--spacing-md);
  }

  .section-title {
    font-size: 24px;
  }

  /* 小屏幕改为一列布局 */
  .advantage-grid, .service-grid {
    grid-template-columns: 1fr;
    gap: var(--spacing-lg);
  }

  /* 在小屏幕上保持较大的图片高度 */
  .advantage-image-wrapper {
    height: 220px;
  }

  .contact-cta {
    flex-direction: column;
    align-items: center;
  }

  .outline-btn {
    margin-left: 0;
    margin-top: var(--spacing-md);
  }
}

@media (max-width: 576px) {
  .company-title {
    font-size: 20px;
  }

  .company-description {
    font-size: 14px;
  }

  .banner-slide {
    height: 300px;
  }

  .banner-title {
    font-size: 24px;
  }

  .banner-text {
    font-size: 14px;
    margin-bottom: var(--spacing-lg);
  }

  .tab-icon {
    width: 40px;
    height: 40px;
    font-size: 16px;
  }

  .tab-title {
    font-size: 16px;
  }

  .section-title {
    font-size: 22px;
  }

  .section-description {
    font-size: 14px;
  }

  .advantage-title,
  .service-title {
    font-size: 18px;
  }

  .service-icon-wrapper {
    width: 60px;
    height: 60px;
    font-size: 24px;
  }

  .primary-btn, .outline-btn {
    padding: 10px 20px;
    font-size: 12px;
  }
}
</style>