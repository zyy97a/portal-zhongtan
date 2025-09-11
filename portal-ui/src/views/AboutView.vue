<template>
  <Layout>
    <!-- 优化后的全宽页面顶部英雄区域 -->
    <div class="hero-section">
      <div class="hero-background"></div>
      <div class="hero-pattern-overlay"></div>
      <div class="container">
        <div class="hero-content">
          <span class="hero-badge">佛山市钟潭装饰工程有限公司</span>
          <h1 class="hero-title">关于我们</h1>
          <div class="title-underline"></div>
          <p class="hero-description">质量第一、用户至上、以质兴业、以优取胜</p>
          <p class="hero-description-en">Quality first and customer foremost; developing the industry through quality and achieving success through excellence.</p>
          <div class="hero-cta">
            <a href="tel:+8613078164038" class="hero-button">联系我们</a>
            <router-link to="/example" class="hero-button-secondary">查看项目 <i class="hero-arrow-icon">→</i></router-link>
          </div>
          <div class="hero-stats">
            <div class="stat-item">
              <span class="stat-number">10+</span>
              <span class="stat-label">年行业经验</span>
            </div>
            <div class="stat-item">
              <span class="stat-number">100+</span>
              <span class="stat-label">成功项目</span>
            </div>
            <div class="stat-item">
              <span class="stat-number">50+</span>
              <span class="stat-label">合作企业</span>
            </div>
          </div>
        </div>
      </div>
      <!--      <div class="hero-scroll-indicator">
              <div class="scroll-icon"></div>
              <span class="scroll-text">向下滚动探索更多</span>
            </div>-->
    </div>
    <!--    &lt;!&ndash; Breadcrumb &ndash;&gt;
        <div class="breadcrumb-container">
          <div class="container">
            <ol class="breadcrumb">
              <li><router-link to="/">首页</router-link></li>
              <li class="active">关于我们</li>
            </ol>
          </div>
        </div>-->

    <!-- 公司介绍区域 -->
    <div class="company-section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">{{companyInfo.name || '佛山市钟潭装饰工程有限公司'}}</h2>
          <div class="section-description" v-if="companyInfo.introduction">
            <p>{{companyInfo.introduction}}</p>
          </div>
        </div>

        <div class="company-info-container">
          <div class="company-info-row">
            <div class="company-info-col">
              <div class="company-info-text">
                <!--                <h3 class="company-name">佛山钟潭装饰工程有限公司</h3>-->
                <div class="company-description">
                  <h2>公司简介</h2>
                  <p>
                    佛山市钟潭装饰工程有限公司的前身是一支具有高度专业素养的装饰施工工程队，经过十余年的稳步发展与不断积累，已逐步成长为一家集设计、施工、维护于一体的综合型装饰工程企业。公司自成立以来，始终秉持"诚信为本、质量至上、客户满意"的经营理念，凭借丰富的现场施工管理经验和精湛的技术力量，赢得了广大客户的一致认可与良好口碑。
                  </p>
                  <p>
                    公司业务范围广泛，主要承接各类室内外装修装饰工程，涵盖住宅、商业空间、办公场所、厂房等多种类型，同时在广告制作与安装、钢结构工程、不锈钢工程等多个领域拥有成熟的解决方案和成功案例。无论是精细化的空间设计，还是高强度的工程施工，公司均能提供一站式、个性化、高品质的服务。
                  </p>
                  <p>
                    我们拥有一支经验丰富、技术过硬的专业团队，具备高效的项目执行能力和良好的协作精神，能够在确保安全与质量的前提下，高效完成各类工程项目。未来，佛山市钟潭装饰工程有限公司将继续以客户需求为导向，以技术创新为驱动，致力于为更多客户打造安全、美观、实用的优质空间环境，推动企业不断迈向更高的发展阶段。
                  </p>
                </div>
              </div>
            </div>

            <div class="company-info-col">
              <div class="company-quote-container">
                <div class="company-quote-row">
                  <div class="company-image-col">
                    <div class="company-image">
                      <img src="../assets/images/about/ykl.jpg" alt="钟潭装饰工程" />
                    </div>
                  </div>

                  <div class="company-quote-col">
                    <div class="company-quote">
                      <p>作为佛山领先的招牌及金属制作公司，钟潭一手包办"一条龙"专业服务，目标是使招牌标志的设计订购和安装过程变得透明、简单，从而节省客户的时间，金钱和精力！钟潭在流程的每个步骤都为客户提供战略和创意资源，将灵感与业务目标、专有制造技术相结合，为您制造完美的招牌!</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="section-divider">
      <div class="divider-line"></div>
    </div>

    <!-- 合作伙伴区域 -->
    <div class="partners-section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">合作伙伴</h2>
          <div class="section-description">
            <p>质量第一、用户至上、以质兴业、以优取胜</p>
            <p class="english-motto">Quality first and customer foremost; developing the industry through quality and achieving success through excellence.</p>
          </div>
        </div>

        <div class="partners-grid">
          <!-- 政府部门 -->
          <div class="partner-card">
            <div class="partner-image">
              <img src="../assets/images/about/f02.jpg" alt="政府部门">
              <div class="image-overlay"></div>
            </div>
            <div class="partner-content">
              <h3 class="partner-title">政府部门</h3>
              <ul class="partner-list">
                <li>南方电网指定供应商名单。</li>
                <li>负责南方电网标志标识制作和安装。</li>
                <li>多年来年与南方电网合作制作标志标识，并为多个政府机关安装使用。</li>
              </ul>
            </div>
          </div>

          <!-- 工程公司 -->
          <div class="partner-card">
            <div class="partner-image">
              <img src="../assets/images/about/f03.jpg" alt="工程公司">
              <div class="image-overlay"></div>
            </div>
            <div class="partner-content">
              <h3 class="partner-title">工程公司</h3>
              <ul class="partner-list">
                <li>协助制作建筑工程中的大型广告招牌。</li>
                <li>提供招牌等产品专属立体图，完善投标方案。</li>
                <li>落实招牌等产品的时间和质量要求，不耽误工程进度和不影响工程满意度。</li>
              </ul>
            </div>
          </div>

          <!-- 品牌&设计公司 -->
          <div class="partner-card">
            <div class="partner-image">
              <img src="../assets/images/about/f04.jpg" alt="品牌&设计公司">
              <div class="image-overlay"></div>
            </div>
            <div class="partner-content">
              <h3 class="partner-title">品牌&设计公司</h3>
              <ul class="partner-list">
                <li>协助完成新产品发布展示所需要的展示架、形象招牌。</li>
                <li>参与设计制作品牌策划中logo的实体展示。</li>
                <li>熟悉多个行业匹配不同招牌的营销要求。</li>
              </ul>
            </div>
          </div>

          <!-- 个体&初创企业 -->
          <div class="partner-card">
            <div class="partner-image">
              <img src="../assets/images/about/f01.jpg" alt="个体&初创企业">
              <div class="image-overlay"></div>
            </div>
            <div class="partner-content">
              <h3 class="partner-title">个体&初创企业</h3>
              <ul class="partner-list">
                <li>负责过青年创业者、工作室招牌创作和制作工作。</li>
                <li>专人对接了解需求，并按要求生产制作。</li>
                <li>欢迎个人参与到设计制作过程，共同打造专属风格招牌。</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="section-divider">
      <div class="divider-line"></div>
    </div>

    <!-- 团队展示区域 -->
    <div class="team-section" v-if="designers && designers.length > 0">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">我们的团队</h2>
          <div class="section-description">
            <p>专业的团队，为您提供一流的服务</p>
          </div>
        </div>

        <div class="team-grid">
          <div class="team-card" v-for="(designer, index) in designers" :key="index">
            <div class="team-image">
              <img :src="designer.avatar" :alt="designer.name">
              <div class="image-overlay"></div>
            </div>
            <div class="team-info">
              <h3 class="team-name">{{designer.name}}</h3>
              <p class="team-position">{{designer.content}}</p>
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
  name: "AboutView",
  components: { Layout },
  data() {
    return {
      companyInfo: {},
      designers: [],
    }
  },
  mounted() {
    this.getCompanyInfo();
    // this.getDesigners();
  },
  methods: {
    getCompanyInfo() {
      this.getRequest("/findCompanyInfo").then(resp => {
        if (resp && resp.data && resp.data.data) {
          this.companyInfo = resp.data.data;
        }
      }).catch(err => {
        console.error("获取公司信息失败", err);
      });
    },
    /*    getDesigners() {
          this.getRequest("/findDesigners").then(resp => {
            if (resp && resp.data && resp.data.data) {
              this.designers = resp.data.data;
            }
          }).catch(err => {
            console.error("获取设计师信息失败", err);
          });
        }*/
  }
}
</script>

<style scoped>
/* 全局样式 */
.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
}

/* 优化后的全宽英雄区域 */
.hero-section {
  position: relative;
  height: 100vh; /* 使用视口高度使其更壮观 */
  min-height: 600px; /* 确保最小高度 */
  max-height: 800px; /* 最大高度限制，适合各种屏幕 */
  width: 100%;
  overflow: hidden;
  display: flex;
  align-items: center;
  color: #fff;
  margin-bottom: 0;
}

.hero-background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: url('../assets/images/about/ykl.jpg');
  background-size: cover;
  background-position: center;
  background-attachment: fixed;
  z-index: -2;
  transform: scale(1.05); /* 轻微放大背景图，增强视觉冲击 */
  animation: slowZoom 20s infinite alternate; /* 缓慢缩放动画 */
}



.hero-pattern-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: url("data:image/svg+xml,%3Csvg width='20' height='20' viewBox='0 0 20 20' xmlns='http://www.w3.org/2000/svg'%3E%3Cg fill='%23ffffff' fill-opacity='0.05' fill-rule='evenodd'%3E%3Ccircle cx='3' cy='3' r='3'/%3E%3Ccircle cx='13' cy='13' r='3'/%3E%3C/g%3E%3C/svg%3E");
  opacity: 0.8;
  z-index: -1;
}

.hero-section::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(135deg, rgba(0, 0, 0, 0.85) 0%, rgba(0, 0, 0, 0.5) 50%, rgba(0, 0, 0, 0.3) 100%);
  z-index: -1;
}
.hero-content {
  max-width: 750px;
  padding: 30px 0;
  position: relative;
  z-index: 1;
  animation: fadeIn 1.5s ease;
}

.hero-badge {
  display: inline-block;
  background-color: rgba(240, 165, 0, 0.2);
  color: #f0a500;
  padding: 8px 16px;
  border-radius: 50px;
  font-size: 14px;
  font-weight: 600;
  letter-spacing: 1px;
  margin-bottom: 20px;
  border: 1px solid rgba(240, 165, 0, 0.3);
  animation: fadeInDown 1s ease;
  backdrop-filter: blur(5px);
}

.hero-title {
  font-size: 60px;
  font-weight: 800;
  margin: 0 0 15px;
  letter-spacing: 2px;
  text-transform: uppercase;
  animation: fadeInDown 1s ease 0.2s both;
  position: relative;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
}
.title-underline {
  width: 100px;
  height: 5px;
  background: linear-gradient(90deg, #f0a500, rgba(245, 180, 97, 0.6));
  margin-bottom: 25px;
  animation: widthGrow 1s ease 0.4s both;
  border-radius: 3px;
  box-shadow: 0 2px 5px rgba(240, 165, 0, 0.3);
}

.hero-description {
  font-size: 24px;
  line-height: 1.6;
  margin: 0 0 15px;
  opacity: 0.9;
  animation: fadeInUp 1s ease 0.6s both;
  text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.3);
  font-weight: 500;
}

.hero-description-en {
  font-size: 16px;
  line-height: 1.6;
  margin: 0 0 30px;
  opacity: 0.7;
  animation: fadeInUp 1s ease 0.8s both;
  font-style: italic;
  font-weight: 300;
}

.hero-cta {
  animation: fadeInUp 1s ease 1s both;
  display: flex;
  gap: 20px;
  margin-bottom: 50px;
}

.hero-button {
  display: inline-block;
  padding: 15px 35px;
  background: linear-gradient(90deg, #f0a500, #f5b461);
  color: #fff;
  font-size: 16px;
  font-weight: 600;
  text-decoration: none;
  border-radius: 50px;
  transition: all 0.3s ease;
  border: none;
  cursor: pointer;
  text-transform: uppercase;
  letter-spacing: 1px;
  box-shadow: 0 6px 20px rgba(240, 165, 0, 0.3);
  position: relative;
  overflow: hidden;
}

.hero-button::before {
  content: '';
  position: absolute;
  top: 0;
  left: -100%;
  width: 100%;
  height: 100%;
  background: linear-gradient(90deg, transparent, rgba(255, 255, 255, 0.2), transparent);
  transition: all 0.6s ease;
}

.hero-button:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 30px rgba(240, 165, 0, 0.5);
}


.hero-button:hover::before {
  left: 100%;
}

.hero-button-secondary {
  display: inline-block;
  padding: 15px 35px;
  background: transparent;
  color: #fff;
  font-size: 16px;
  font-weight: 600;
  text-decoration: none;
  border-radius: 50px;
  transition: all 0.3s ease;
  border: 2px solid rgba(255, 255, 255, 0.3);
  cursor: pointer;
  text-transform: uppercase;
  letter-spacing: 1px;
  position: relative;
  backdrop-filter: blur(5px);
}

.hero-button-secondary:hover {
  background-color: rgba(255, 255, 255, 0.1);
  transform: translateY(-5px);
  border-color: rgba(255, 255, 255, 0.5);
}

.hero-arrow-icon {
  margin-left: 8px;
  transition: transform 0.3s ease;
  display: inline-block;
  font-style: normal;
}

.hero-button-secondary:hover .hero-arrow-icon {
  transform: translateX(5px);
}

.hero-stats {
  display: flex;
  gap: 40px;
  margin-top: 30px;
  animation: fadeInUp 1s ease 1.2s both;
}

.stat-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 15px 25px;
  background-color: rgba(0, 0, 0, 0.3);
  border-radius: 8px;
  backdrop-filter: blur(10px);
  border: 1px solid rgba(255, 255, 255, 0.1);
  transition: all 0.3s ease;
}

.stat-item:hover {
  transform: translateY(-5px);
  background-color: rgba(240, 165, 0, 0.2);
  border-color: rgba(240, 165, 0, 0.3);
}


.stat-number {
  font-size: 32px;
  font-weight: 700;
  margin-bottom: 5px;
  background: linear-gradient(90deg, #f0a500, #f5b461);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  text-shadow: none;
}

.stat-label {
  font-size: 14px;
  color: rgba(255, 255, 255, 0.8);
}

.hero-scroll-indicator {
  position: absolute;
  bottom: 30px;
  left: 50%;
  transform: translateX(-50%);
  display: flex;
  flex-direction: column;
  align-items: center;
  color: rgba(255, 255, 255, 0.8);
  animation: fadeInUp 1s ease 1.4s both, bounce 2s infinite 2s;
  cursor: pointer;
  z-index: 10;
}

.scroll-icon {
  width: 30px;
  height: 50px;
  border: 2px solid rgba(255, 255, 255, 0.3);
  border-radius: 25px;
  margin-bottom: 10px;
  position: relative;
}

.scroll-icon::before {
  content: '';
  position: absolute;
  top: 8px;
  left: 50%;
  width: 6px;
  height: 6px;
  background-color: #fff;
  border-radius: 50%;
  transform: translateX(-50%);
  animation: scrollDown 2s infinite;
}

.scroll-text {
  font-size: 12px;
  letter-spacing: 1px;
  opacity: 0.7;
}


/* Breadcrumb */
.breadcrumb-container {
  background-color: #f5f5f5;
  padding: 15px 0;
  margin-bottom: 30px;
  border-bottom: 1px solid #eee;
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
  transition: color 0.2s;
}

.breadcrumb a:hover {
  color: #f0a500;
}

.breadcrumb .active {
  color: #333;
  font-weight: 600;
}

/* 公共区块样式 */
.company-section,
.partners-section,
.team-section {
  padding: 80px 0;
  background-color: #f8f9fa;
}

.section-header {
  text-align: center;
  margin-bottom: 50px;
}

.section-title {
  font-size: 32px;
  font-weight: 700;
  margin: 0 0 20px;
  color: #1a1a2e;
  position: relative;
  display: inline-block;
}

.section-title::after {
  content: '';
  display: block;
  width: 80px;
  height: 3px;
  background: linear-gradient(90deg, #f0a500, #f5b461);
  margin: 15px auto 0;
}

.section-description {
  max-width: 800px;
  margin: 0 auto;
  color: #555;
  line-height: 1.6;
}

.section-description p {
  margin: 8px 0;
}

/* 分隔线 */
.section-divider {
  padding: 0;
}

.divider-line {
  height: 1px;
  background: linear-gradient(90deg, rgba(240, 165, 0, 0.1), rgba(240, 165, 0, 0.5) 50%, rgba(240, 165, 0, 0.1) 100%);
  margin: 0 auto;
  max-width: 1000px;
}

/* 公司介绍区块 */
.company-info-container {
  margin-top: 40px;
}

.company-info-row {
  display: flex;
  flex-wrap: wrap;
  margin: -15px;
}

.company-info-col {
  flex: 1;
  min-width: 300px;
  padding: 15px;
}

.company-info-text {
  background-color: #fff;
  padding: 30px;
  height: 100%;
  border-radius: 8px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
  transition: transform 0.3s, box-shadow 0.3s;
}

.company-info-text:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
}

.company-name {
  font-size: 24px;
  margin-top: 0;
  margin-bottom: 20px;
  color: #1a1a2e;
  position: relative;
  padding-bottom: 15px;
}

.company-name::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 50px;
  height: 2px;
  background-color: #f0a500;
}

.company-description {
  max-width: 900px;
  margin: 0 auto;
  padding: 2rem;
  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 1.5rem;
  line-height: 1.8;
  color: #333;
  background-color: #f9f9f9;
  border-radius: 16px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
}

.company-description h2 {
  font-size: 3rem;
  margin-bottom: 1.2rem;
  color: #1a1a1a;
  text-align: center;
}

.company-description p {
  margin-bottom: 1.5rem;
  text-indent: 2em;
}

.company-quote-container {
  background-color: #fff;
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
  height: 100%;
  transition: transform 0.3s, box-shadow 0.3s;
}

.company-quote-container:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
}

.company-quote-row {
  display: flex;
  flex-direction: column;
  height: 100%;
}

.company-image-col {
  flex: 1;
  min-height: 200px;
}

.company-image {
  width: 100%;
  height: 100%;
  overflow: hidden;
}

.company-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.5s;
}

.company-quote-container:hover .company-image img {
  transform: scale(1.05);
}

.company-quote-col {
  padding: 25px;
}

.company-quote {
  position: relative;
  padding-left: 20px;
  border-left: 3px solid #f0a500;
}

.company-quote p {
  margin: 0;
  color: #555;
  line-height: 1.7;
  font-style: italic;
}

.english-motto {
  color: #777;
  font-style: italic;
}

/* 合作伙伴区块 */
.partners-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  gap: 30px;
  margin-top: 50px;
}

.partner-card {
  background-color: #fff;
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
  transition: transform 0.3s, box-shadow 0.3s;
}

.partner-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
}

.partner-image {
  position: relative;
  padding-top: 60%;
  overflow: hidden;
}

.partner-image img {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.5s;
}

.partner-card:hover .partner-image img {
  transform: scale(1.05);
}

.image-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: linear-gradient(to bottom, rgba(26, 26, 46, 0.1), rgba(26, 26, 46, 0.6));
}

.partner-content {
  padding: 25px;
}

.partner-title {
  font-size: 20px;
  margin-top: 0;
  margin-bottom: 20px;
  color: #1a1a2e;
  position: relative;
  padding-bottom: 12px;
}

.partner-title::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 40px;
  height: 2px;
  background-color: #f0a500;
}

.partner-list {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

.partner-list li {
  padding-left: 20px;
  position: relative;
  margin-bottom: 10px;
  color: #555;
  line-height: 1.5;
}

.partner-list li::before {
  content: '';
  position: absolute;
  left: 0;
  top: 9px;
  width: 8px;
  height: 8px;
  border-radius: 50%;
  background-color: #f0a500;
}

/* 团队展示区块 */
.team-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  gap: 30px;
  margin-top: 50px;
}

.team-card {
  background-color: #fff;
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
  transition: transform 0.3s, box-shadow 0.3s;
}

.team-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
}

.team-image {
  position: relative;
  padding-top: 100%;
  overflow: hidden;
}

.team-image img {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.5s;
}

.team-card:hover .team-image img {
  transform: scale(1.05);
}

.team-info {
  padding: 20px;
  text-align: center;
}

.team-name {
  font-size: 18px;
  margin: 0 0 5px;
  color: #1a1a2e;
}

.team-position {
  margin: 0;
  color: #777;
  font-size: 14px;
}

/* 动画关键帧 */
@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

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

@keyframes widthGrow {
  from {
    width: 0;
  }
  to {
    width: 100px;
  }
}

@keyframes bounce {
  0%, 20%, 50%, 80%, 100% {
    transform: translateY(0) translateX(-50%);
  }
  40% {
    transform: translateY(-10px) translateX(-50%);
  }
  60% {
    transform: translateY(-5px) translateX(-50%);
  }
}

@keyframes scrollDown {
  0% {
    opacity: 1;
    top: 8px;
  }
  100% {
    opacity: 0;
    top: 32px;
  }
}

@keyframes slowZoom {
  from {
    transform: scale(1.05);
  }
  to {
    transform: scale(1.15);
  }
}


/* 响应式适配 */
@media (max-width: 992px) {
  .hero-section {
    height: 85vh;
    min-height: 550px;
  }

  .hero-title {
    font-size: 48px;
  }

  .hero-description {
    font-size: 20px;
  }

  .hero-button {
    padding: 10px 25px;
  }

  .section-title {
    font-size: 28px;
  }

  .company-section,
  .partners-section,
  .team-section {
    padding: 60px 0;
  }

  .company-name {
    font-size: 22px;
  }

  .partner-title {
    font-size: 18px;
  }




  .hero-stats {
    gap: 20px;
  }

  .stat-item {
    padding: 12px 20px;
  }

}

@media (max-width: 768px) {
  .hero-section {
    height: 80vh;
    min-height: 500px;
  }

  .hero-title {
    font-size: 40px;
  }

  .section-title {
    font-size: 24px;
  }


  .hero-description {
    font-size: 18px;
  }

  .hero-button {
    padding: 10px 20px;
    font-size: 14px;
  }

  .partners-grid,
  .team-grid {
    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
    gap: 20px;
  }

  .company-image-col {
    min-height: 150px;
  }

  .company-quote-row {
    flex-direction: column;
  }

  .company-description {
    padding: 1rem;
    font-size: 1rem;
  }

  .company-description h2 {
    font-size: 1.5rem;
  }



  .hero-cta {
    flex-direction: column;
    gap: 15px;
    align-items: flex-start;
  }

  .hero-button, .hero-button-secondary {
    padding: 12px 25px;
    width: 100%;
    text-align: center;
  }

  .hero-stats {
    flex-wrap: wrap;
    justify-content: space-between;
  }

  .stat-item {
    flex: 0 0 calc(50% - 10px);
    margin-bottom: 15px;
  }

}

@media (max-width: 576px) {
  .hero-section {
    height: auto;
    min-height: 450px;
    padding: 60px 0;
  }


  .hero-title {
    font-size: 32px;
  }

  .title-underline {
    width: 70px;
    height: 4px;
    margin-bottom: 15px;
  }

  .hero-description {
    font-size: 16px;
  }

  .section-title {
    font-size: 22px;
  }

  .company-section,
  .partners-section,
  .team-section {
    padding: 40px 0;
  }

  .company-info-text,
  .company-quote-col {
    padding: 20px;
  }

  .partner-content {
    padding: 20px;
  }

  .section-header {
    margin-bottom: 30px;
  }

  .partners-grid,
  .team-grid {
    grid-template-columns: 1fr;
  }

  .partner-title {
    font-size: 18px;
    margin-bottom: 15px;
  }



  .hero-description-en {
    font-size: 14px;
  }



  .hero-badge {
    font-size: 12px;
    padding: 6px 12px;
  }

  .stat-number {
    font-size: 24px;
  }

  .stat-label {
    font-size: 12px;
  }

  .hero-scroll-indicator {
    display: none;
  }
}

/*!* 平板端横屏特别优化 *!
@media (min-width: 769px) and (max-width: 992px) {
  .company-quote-row {
    flex-direction: row;
  }

  .company-image-col,
  .company-quote-col {
    flex: 1;
  }
}*/

/*!* 平板端和桌面端特别优化 *!
@media (min-width: 769px) {
  .company-quote-row {
    flex-direction: row;
  }

  .company-image-col {
    flex: 0 0 40%;
  }

  .company-quote-col {
    flex: 0 0 60%;
    display: flex;
    align-items: center;
  }
}*/
</style>