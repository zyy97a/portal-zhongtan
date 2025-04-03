<template>
    <div class="header-wrapper">
        <div class="header">
            <div class="header-left">
                <img src="../../../assets/images/index/log.jpg" alt="">
            </div>
            <div class="header-mid">
                <div class="header-item">
                    <i style="color:#7c6aa6" class="contact-icon am-icon-phone"></i>
                    <div class="item">
                        <strong>13078164038</strong>
                        <span>周一 ~ 周五, 8:30 - 17:30</span>
                    </div>
                </div>
                <div class="header-item">
                    <i style="color:#7c6aa6" class="contact-icon am-icon-map-marker"></i>
                    <div class="item">
                        <strong>广东省佛山市南海区</strong>
                        <span>佛山钟潭装饰工程有限公司</span>
                    </div>
                </div>
            </div>
            <div class="header-right">
                <a href="tel:+17734792020">
                    <button type="button">联系我们</button>
                </a>
                <!-- 修改图片路径 -->
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
        </div>
        
        <div class="nav-wrapper header-default">
            <div class="nav">
                <ul class="am-nav am-nav-pills am-nav-justify">
                    <li><router-link class="router" to="/index">网站首页</router-link></li>
                    <li><router-link class="router" to="/product">产品中心</router-link></li>
                    <li><router-link class="router" to="/example">客户案例</router-link></li>
                    <li><router-link class="router" to="/news">公司动态</router-link></li>
                    <li><router-link class="router" to="/about">关于我们</router-link></li>
                </ul>
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
            largeQrCodeTop: 0
        };
    },
    methods: {
        toggleStickyHeader() {
            const scrolled = document.documentElement.scrollTop;
            if (scrolled > 100) {
                AppFunctions.addClass('.header-default', 'sticky');
            } else if (scrolled <= 100) {
                AppFunctions.removeClass('.header-default', 'sticky');
            }
        },
        showLargeQrCode(event) {
            this.isLargeQrCodeVisible = true;
            this.largeQrCodeLeft = event.clientX;
            this.largeQrCodeTop = event.clientY;
            console.log('Show large QR code:', this.isLargeQrCodeVisible); // 调试输出
        },
        hideLargeQrCode() {
            this.isLargeQrCodeVisible = false;
            console.log('Hide large QR code:', this.isLargeQrCodeVisible); // 调试输出
        }
    },
    created() {
        window.addEventListener('scroll', this.toggleStickyHeader);
    },
    mounted() {
        this.toggleStickyHeader();
    },
    beforeDestroy() {
        window.removeEventListener('scroll', this.toggleStickyHeader);
    }
};
</script>

<style scoped>
.router.router-link-active {
    /*color: #fff;*/
    /*background-color: #0e90d2;*/
    /*border: 1px solid #0e90d2;*/
    cursor: default;
    color: #0e90d2;
}

/* 添加图片样式 */
.wechat-qrcode {
    width: 40px; /* 调整图片宽度 */
    height: 40px; /* 调整图片高度 */
    margin-left: 10px; /* 调整图片与按钮的间距 */
    vertical-align: middle; /* 垂直居中对齐 */
    transition: transform 0.3s ease; /* 添加过渡效果 */
}

/* 鼠标悬停时放大图片 */
.wechat-qrcode:hover {
    transform: scale(1.2); /* 放大到 1.2 倍 */
}

.large-wechat-qrcode {
    position: absolute;
    width: 200px; /* 调整放大后图片的宽度 */
    height: 200px; /* 调整放大后图片的高度 */
    z-index: 1000; /* 确保图片显示在最上层 */
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); /* 添加阴影效果 */
    display: block; /* 确保图片显示 */
}
</style>
