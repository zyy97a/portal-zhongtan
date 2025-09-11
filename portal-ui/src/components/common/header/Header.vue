<template>
  <div class="header-wrapper">
    <!-- 顶部栏 -->
    <div class="header" :class="{ 'header-mobile': isMobile }">
      <div class="header-left">
        <img src="../../../assets/images/index/log.jpg" alt="公司logo" class="company-logo">
      </div>

      <!-- 桌面端中间部分 -->
      <div class="header-mid" v-if="!isMobile">
        <div class="header-item">
          <i class="contact-icon am-icon-phone"></i>
          <div class="item">
            <strong>13078164038</strong>
            <span>周一 ~ 周五, 8:30 - 17:30</span>
          </div>
        </div>
        <div class="header-item">
          <i class="contact-icon am-icon-map-marker"></i>
          <div class="item">
            <strong>广东省佛山市南海区</strong>
            <span>佛山市钟潭装饰工程有限公司</span>
          </div>
        </div>
      </div>

      <!-- 右侧部分 -->
      <div class="header-right">
        <!-- 桌面端显示完整按钮和二维码 -->
        <template v-if="!isMobile">
          <a href="tel:+8613078164038" class="contact-button">
            <button type="button">联系我们</button>
          </a>
          <div class="qrcode-container">
            <img
                :src="require('@/assets/images/about/wechat_qrcode.jpg')"
                alt="微信公众号二维码"
                class="wechat-qrcode"
                @mouseover="showLargeQrCode($event)"
                @mouseout="hideLargeQrCode"
            />
            <img
                v-if="isLargeQrCodeVisible"
                :src="qrCodeSrc"
                alt="放大的微信公众号二维码"
                class="large-wechat-qrcode"
                :style="{
                  left: largeQrCodeLeft + 'px',
                  top: largeQrCodeTop + 'px'
                }"
            />
          </div>
        </template>

        <!-- 手机端只显示电话按钮 -->
        <a v-if="isMobile" href="tel:+8613078164038" class="mobile-call-btn">
          <i class="am-icon-phone"></i>
        </a>

        <!-- 手机端汉堡菜单按钮 -->
        <button v-if="isMobile" @click="toggleMenu" class="mobile-menu-btn" :class="{ 'active': isMobileMenuOpen }">
          <span></span>
          <span></span>
          <span></span>
        </button>
      </div>
    </div>

    <!-- 导航栏 -->
    <div class="nav-wrapper" :class="{ 'sticky': isSticky }">
      <!-- 桌面端导航 -->
      <div class="nav desktop-nav" v-if="!isMobile">
        <ul class="am-nav am-nav-pills am-nav-justify">
          <li><router-link class="router" to="/index">网站首页</router-link></li>
          <li><router-link class="router" to="/product">产品中心</router-link></li>
          <li><router-link class="router" to="/example">客户案例</router-link></li>
          <li><router-link class="router" to="/news">公司动态</router-link></li>
          <li><router-link class="router" to="/about">关于我们</router-link></li>
        </ul>
      </div>

      <!-- 手机端导航菜单 -->
      <div v-if="isMobile" class="mobile-nav-container" :class="{ 'menu-open': isMobileMenuOpen }">
        <!-- 背景遮罩 -->
        <div class="mobile-nav-overlay" @click="closeMenu"></div>

        <!-- 侧边菜单 -->
        <div class="mobile-nav-menu">
          <!-- 公司信息区域 -->
          <div class="mobile-company-info">
            <img :src="require('@/assets/images/index/log.jpg')" alt="公司logo" class="mobile-company-logo">
            <h3>佛山市钟潭装饰工程有限公司</h3>
          </div>

          <!-- 导航菜单 -->
          <ul class="mobile-nav-links">
            <li>
              <router-link to="/index" @click.native="closeMenu">
                <i class="am-icon-home"></i>
                <span>网站首页</span>
              </router-link>
            </li>
            <li>
              <router-link to="/product" @click.native="closeMenu">
                <i class="am-icon-cubes"></i>
                <span>产品中心</span>
              </router-link>
            </li>
            <li>
              <router-link to="/example" @click.native="closeMenu">
                <i class="am-icon-briefcase"></i>
                <span>客户案例</span>
              </router-link>
            </li>
            <li>
              <router-link to="/news" @click.native="closeMenu">
                <i class="am-icon-newspaper-o"></i>
                <span>公司动态</span>
              </router-link>
            </li>
            <li>
              <router-link to="/about" @click.native="closeMenu">
                <i class="am-icon-info-circle"></i>
                <span>关于我们</span>
              </router-link>
            </li>
          </ul>

          <!-- 联系信息 -->
          <div class="mobile-contact-info">
            <div class="mobile-contact-item">
              <i class="am-icon-phone"></i>
              <span>13078164038</span>
            </div>
            <div class="mobile-contact-item">
              <i class="am-icon-clock-o"></i>
              <span>周一 ~ 周五, 8:30 - 17:30</span>
            </div>
            <div class="mobile-contact-item">
              <i class="am-icon-map-marker"></i>
              <span>广东省佛山市南海区</span>
            </div>
          </div>

          <!-- 社交媒体区域 -->
          <div class="mobile-social">
            <div class="mobile-qrcode">
              <img :src="require('@/assets/images/about/wechat_qrcode.jpg')" alt="微信公众号">
              <p>扫码关注我们</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AppFunctions from "@/utils/AppFunctions";
export default {
  name: "Header",
  components: {},
  data() {
    return {
      AppFunctions,
      isLargeQrCodeVisible: false,
      qrCodeSrc: require('@/assets/images/about/wechat_qrcode.jpg'),
      largeQrCodeLeft: 0,
      largeQrCodeTop: 0,
      isMobile: window.innerWidth < 768,
      isMobileMenuOpen: false,
      isSticky: false
    };
  },
  methods: {
    toggleStickyHeader() {
      const scrolled = document.documentElement.scrollTop;
      this.isSticky = scrolled > 100;
    },
    showLargeQrCode(event) {
      this.isLargeQrCodeVisible = true;
      // 将二维码显示在左侧而不是右侧
      this.largeQrCodeLeft = event.clientX - 230; // 减去二维码宽度(220px)加上一些边距
      this.largeQrCodeTop = event.clientY + 10;
    },
    hideLargeQrCode() {
      this.isLargeQrCodeVisible = false;
    },
    toggleMenu() {
      this.isMobileMenuOpen = !this.isMobileMenuOpen;
      // 当菜单打开时，禁止背景滚动
      document.body.style.overflow = this.isMobileMenuOpen ? 'hidden' : '';
    },
    closeMenu() {
      this.isMobileMenuOpen = false;
      document.body.style.overflow = '';
    },
    checkMobile() {
      const wasMobile = this.isMobile;
      this.isMobile = window.innerWidth < 768;

      // 如果从移动端切换到桌面端，确保关闭菜单
      if (wasMobile && !this.isMobile) {
        this.closeMenu();
      }
    }
  },
  created() {
    window.addEventListener('scroll', this.toggleStickyHeader);
    window.addEventListener('resize', this.checkMobile);
  },
  mounted() {
    this.toggleStickyHeader();
    this.checkMobile();
  },
  beforeDestroy() {
    window.removeEventListener('scroll', this.toggleStickyHeader);
    window.removeEventListener('resize', this.checkMobile);
    document.body.style.overflow = '';
  }
};
</script>

<style scoped>
/* ===== 通用样式 ===== */
.header-wrapper {
  width: 100%;
  position: relative;
  font-family: 'Microsoft YaHei', sans-serif;
}

/* ===== 顶部栏样式 ===== */
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 15px 20px;
  background: #fff;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
}

.company-logo {
  height: 60px;
  object-fit: contain;
}

.header-mid {
  display: flex;
  gap: 30px;
}

.header-item {
  display: flex;
  align-items: center;
  gap: 12px;
}

.contact-icon {
  font-size: 24px;
  color: #7c6aa6;
  width: 45px;
  height: 45px;
  border-radius: 50%;
  background: #f9f7fc;
  display: flex;
  align-items: center;
  justify-content: center;
}

.item {
  display: flex;
  flex-direction: column;
}

.item strong {
  font-size: 16px;
  color: #333;
  margin-bottom: 5px;
}

.item span {
  font-size: 13px;
  color: #777;
}

.header-right {
  display: flex;
  align-items: center;
  gap: 20px;
}

.contact-button button {
  background: linear-gradient(45deg, #7c6aa6, #9383c0);
  color: white;
  border: none;
  padding: 10px 25px;
  border-radius: 50px;
  font-size: 15px;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.3s ease;
  box-shadow: 0 4px 15px rgba(124, 106, 166, 0.3);
}

.contact-button button:hover {
  transform: translateY(-3px);
  box-shadow: 0 6px 18px rgba(124, 106, 166, 0.4);
}

.wechat-qrcode {
  width: 40px;
  height: 40px;
  border-radius: 8px;
  cursor: pointer;
  transition: transform 0.3s ease;
  border: 2px solid #f0f0f0;
}

.wechat-qrcode:hover {
  transform: scale(1.15);
  border-color: #7c6aa6;
}

.large-wechat-qrcode {
  position: fixed;
  width: 220px;
  height: 220px;
  z-index: 1000;
  box-shadow: 0 8px 25px rgba(0, 0, 0, 0.15);
  border-radius: 12px;
  border: 3px solid #7c6aa6;
  padding: 5px;
  background: white;
}

/* ===== 导航栏样式 ===== */
.nav-wrapper {
  background: linear-gradient(to right, #f8f7fc, #f0ecf9);
  border-bottom: 1px solid #eee5fb;
  transition: all 0.3s ease;
  z-index: 98;
}

.nav-wrapper.sticky {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.08);
  animation: slideDown 0.4s forwards;
}

@keyframes slideDown {
  from { transform: translateY(-100%); }
  to { transform: translateY(0); }
}

.desktop-nav {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
}

.am-nav {
  display: flex;
  justify-content: space-between;
  list-style: none;
  padding: 0;
  margin: 0;
}

.am-nav li {
  flex: 1;
  text-align: center;
}

.router {
  display: block;
  padding: 15px 0;
  text-decoration: none;
  color: #333;
  font-weight: 500;
  font-size: 16px;
  transition: all 0.3s;
  position: relative;
}

.router:hover,
.router.router-link-active {
  color: #7c6aa6;
}

.router::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 50%;
  width: 0;
  height: 3px;
  background: linear-gradient(45deg, #7c6aa6, #9383c0);
  transition: all 0.3s;
  transform: translateX(-50%);
  opacity: 0;
}

.router:hover::after,
.router.router-link-active::after {
  width: 65%;
  opacity: 1;
}

/* ===== 手机端样式 ===== */
@media (max-width: 768px) {
  .header-mobile {
    padding: 10px 15px;
  }

  .header-mobile .company-logo {
    height: 45px;
  }

  /* 手机端电话按钮 */
  .mobile-call-btn {
    width: 38px;
    height: 38px;
    background: #7c6aa6;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    color: white;
    text-decoration: none;
    box-shadow: 0 4px 10px rgba(124, 106, 166, 0.3);
  }

  .mobile-call-btn i {
    font-size: 20px;
  }

  /* 汉堡菜单按钮 */
  .mobile-menu-btn {
    width: 38px;
    height: 38px;
    background: rgba(124, 106, 166, 0.1);
    border: none;
    border-radius: 8px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 6px;
    cursor: pointer;
    padding: 0;
    position: relative;
    transition: all 0.3s ease;
  }

  .mobile-menu-btn:hover {
    background: rgba(124, 106, 166, 0.15);
  }

  .mobile-menu-btn span {
    display: block;
    width: 22px;
    height: 2px;
    background-color: #7c6aa6;
    border-radius: 2px;
    transition: all 0.3s ease;
  }

  .mobile-menu-btn.active {
    background: #7c6aa6;
  }

  .mobile-menu-btn.active span {
    background-color: white;
  }

  .mobile-menu-btn.active span:nth-child(1) {
    transform: translateY(8px) rotate(45deg);
  }

  .mobile-menu-btn.active span:nth-child(2) {
    opacity: 0;
  }

  .mobile-menu-btn.active span:nth-child(3) {
    transform: translateY(-8px) rotate(-45deg);
  }

  /* 手机导航菜单容器 */
  .mobile-nav-container {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 1000;
    visibility: hidden;
  }

  .mobile-nav-container.menu-open {
    visibility: visible;
  }

  /* 背景遮罩 */
  .mobile-nav-overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.6);
    opacity: 0;
    transition: opacity 0.4s ease;
  }

  .menu-open .mobile-nav-overlay {
    opacity: 1;
  }

  /* 侧边菜单 */
  .mobile-nav-menu {
    position: absolute;
    top: 0;
    right: -100%;
    width: 85%;
    height: 100%;
    background: white;
    box-shadow: -5px 0 30px rgba(0, 0, 0, 0.15);
    transition: right 0.5s cubic-bezier(0.77, 0, 0.175, 1);
    display: flex;
    flex-direction: column;
    overflow-y: auto;
  }

  .menu-open .mobile-nav-menu {
    right: 0;
  }

  /* 公司信息区域 */
  .mobile-company-info {
    padding: 25px 20px;
    text-align: center;
    background: linear-gradient(45deg, #f8f7fc, #f0ecf9);
    border-bottom: 1px solid #eee5fb;
  }

  .mobile-company-logo {
    width: 120px;
    height: auto;
    margin-bottom: 15px;
  }

  .mobile-company-info h3 {
    font-size: 16px;
    color: #333;
    margin: 0;
    font-weight: 600;
  }

  /* 导航链接 */
  .mobile-nav-links {
    list-style: none;
    padding: 15px 0;
    margin: 0;
  }

  .mobile-nav-links li {
    margin: 0;
  }

  .mobile-nav-links a {
    display: flex;
    align-items: center;
    padding: 15px 25px;
    text-decoration: none;
    color: #333;
    border-bottom: 1px solid #f5f5f5;
    transition: all 0.3s;
  }

  .mobile-nav-links a:hover,
  .mobile-nav-links a.router-link-active {
    background-color: #f9f7fc;
    color: #7c6aa6;
    padding-left: 30px;
  }

  .mobile-nav-links i {
    font-size: 20px;
    margin-right: 15px;
    color: #7c6aa6;
    width: 24px;
    text-align: center;
  }

  /* 联系信息 */
  .mobile-contact-info {
    padding: 20px 25px;
    background: #f9f7fc;
    margin-top: auto;
    border-top: 1px solid #eee5fb;
  }

  .mobile-contact-item {
    display: flex;
    align-items: center;
    margin-bottom: 12px;
  }

  .mobile-contact-item:last-child {
    margin-bottom: 0;
  }

  .mobile-contact-item i {
    font-size: 18px;
    color: #7c6aa6;
    margin-right: 15px;
    width: 20px;
    text-align: center;
  }

  .mobile-contact-item span {
    font-size: 14px;
    color: #555;
  }

  /* 社交媒体区域 */
  .mobile-social {
    padding: 20px;
    text-align: center;
    background: #fff;
    border-top: 1px solid #eee;
  }

  .mobile-qrcode {
    display: inline-block;
  }

  .mobile-qrcode img {
    width: 120px;
    height: 120px;
    border-radius: 8px;
    border: 3px solid #f0ecf9;
  }

  .mobile-qrcode p {
    margin-top: 10px;
    font-size: 14px;
    color: #7c6aa6;
  }
}
</style>