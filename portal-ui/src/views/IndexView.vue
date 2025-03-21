<template>
	<Layout>
		<div  style="width: 100%">
			<div class="index-page">
				<div data-am-widget="tabs" class="am-tabs am-tabs-default">
					<div class="am-tabs-bd">
						<div
							class="am-tab-panel am-active"
							v-if="slideshow.length > 0"
							:style="{ backgroundImage: `url(${slideshow[tabIndex].imageUrl})`}">
							<div class="index-banner">
								<div class="index-mask">
									<div class="container">
										<div class="am-g">
											<div class="am-u-md-10 am-u-sm-centered" style="text-align: center">
												<h1 class="slide_simple--title">定制化服务，首选钟潭装饰</h1>
												<p class="slide_simple--text am-text-left" style="display: flex;justify-content: center">
													全球领先的HTML5企业移动化解决方案供应商，安全高效的帮助您的企业移动化。云适配企业浏览器Enterploer,让企业安全迈进移动办公时代！
												</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<ul class="am-tabs-nav am-cf index-tab">
						<li v-for="(tab,index) in tabList" :key="index" :class="tabIndex === index ? 'am-active':''" >
							<a href="#" @click.prevent="changeTab(index)">
								<div class="am-u-md-3 am-u-sm-3 am-padding-right-0">
									<i :class="tab.icon"></i>
								</div>
								<div class="school-item-right am-u-md-9 am-u-sm-9 am-text-left">
									<strong class="promo_slider_nav--item_title">{{tab.name}}</strong>
									<p class="promo_slider_nav--item_description">{{tab.desc}}</p>
								</div>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="section">
			<div class="container" style="max-width: 1160px;">
				<div class="section--header">
					<h2 class="section--title">核心优势</h2>
					<p class="section--description">
<!--						全球领先HTML5企业移动化解决方案供应商，由前微软美国总部IE浏览器核心研发团队成员及移动互联网行业专家在美国西雅图创立,获得了微软创投的扶持以及晨兴资本、IDG资本、天创资本等国际顶级风投机构的投资。-->
            丰富的现场施工经验·专业的技术团队·多元化的业务范围·卓越的项目履历·坚定的核心价值观·明确的经营宗旨·合作共赢的理念
          </p>
				</div>

				<div class="index-container">
					<div class="am-g">
						<div class="am-u-md-3" v-for="(advantage,index) in advantageList" :key="index">
							<div class="features_item">
								<img :src="advantage.cover" alt="">
								<h3 class="features_item--title">{{advantage.title}}</h3>
								<p class="features_item--text">{{advantage.desc}}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="section" style="border-bottom: 1px solid #e9e9e9; padding-top: 0">
			<div class="container" style="max-width: 1160px;">
				<div class="section--header">
					<h2 class="section--title">我们的服务</h2>
					<p class="section--description">
<!--						全球领先HTML5企业移动化解决方案供应商，由前微软美国总部IE浏览器核心研发团队成员及移动互联网行业专家在美国西雅图创立-->
            作为佛山领先的招牌及金属制作公司，钟潭一手包办“一条龙”专业服务，目标是使招牌标志的设计订购和安装过程变得透明、简单，从而节省客户的时间，金钱和精力！钟潭在流程的每个步骤都为客户提供战略和创意资源，将灵感与业务目标、专有制造技术相结合，为您制造完美的招牌!
            <br>一条龙专业服务核心精神
					</p>
				</div>
				
				<div class="index-container">
					<div class="am-g">
						<div class="am-u-md-3" v-for="(service,index) in serviceList" :key="index">
							<div class="service_item">
								<i class="service_item--icon" :class="service.icon"></i>
								<h3 class="service_item--title">{{ service.title }}</h3>
								<div class="service_item--text"><p>{{service.desc}}</p></div>
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
	name: "IndexView",
	components: {Layout},
	data(){
		return{
/*			tabList:[
				{name:'招牌定制', desc:'一句话概括特点', icon:'am-icon-cog'},
				{name:'质量保证', desc:'一句话概括特点', icon:'am-icon-lightbulb-o'},
				{name:'安装使用', desc:'一句话概括特点', icon:'am-icon-line-chart'},
				{name:'维修保养', desc:'一句话概括特点', icon:'am-icon-hourglass-end'},
			],*/
      tabIndex: 0,
      slideshow:[],
      /*tabIndex: 0,
      slideshow: [
        { imageUrl: require('@/assets/images/about/gc1.jpg') },
        { imageUrl: require('@/assets/images/about/gc2.jpg') },
        { imageUrl: require('@/assets/images/about/gc2.jpg') },
        { imageUrl: require('@/assets/images/about/gc3.jpg') }
        // 添加更多图片路径
      ],*/
			advantageList:[
				{id:1,cover:require('../assets/images/about/gc1.jpg'),title:'丰富的现场施工经验',desc:'公司拥有十余年的发展历程，积累了大量的实际施工经验，能够高效应对各种复杂的施工环境和挑战。'},
				{id:2,cover:require('../assets/images/about/gc2.jpg'),title:'专业的技术团队',desc:'公司拥有专业的技术团队，确保工程的高质量实施和创新性解决方案的提供。'},
				{id:3,cover:require('../assets/images/about/gc4.jpg'),title:'多元化的业务范围',desc:'公司承揽室内外装修、广告制作安装、钢结构安装、电力设备维护、不锈钢工程等多种业务，展现了全方位的服务能力。'},
				{id:4,cover:require('../assets/images/about/gc5.jpg'),title:'卓越的项目履历',desc:'公司完成了如南京青奥会室外大型配套广告安装工程、南方电网电力工程、龙建路桥钢结构安装工程等大型项目，证明了其在大型工程中的实力和信誉。'},
			],
			serviceList:[
				{id:1,icon:'am-icon-diamond',title:'招牌定制',desc:'提供超过300种素材方案，涵盖不锈钢、铝、亚克力等空间设计材质，可做不同效果的电镀、抛光、喷漆等流行要素，为客户创造广阔的创作空间，帮助实现营销展示导引等作用。根据拟定的材料和工艺和尺寸规格等，为客户产品绘制工程图，确保产品实物效果"零"偏差，并符合客户想要的展示效果。同时钟潭也接受客户直接来稿制作。'},
				{id:2,icon:'am-icon-user',title:'质量保证',desc:'标牌制作生产基地位于佛山，拥有先进的雕刻机、激光切割机、开槽机、开料机、数控剪板机、折弯机等金属处理机械，无论是精细工艺处理还是大尺寸物料处理都能轻松应付。工匠师傅经验丰富，手工和机械相结合，能实现小众精致制作，也能实现批量制作，细心打磨好每件招牌。'},
				{id:3,icon:'am-icon-umbrella',title:'安装使用',desc:'钟潭拥有专业安装维护团队，不需要额外寻找供应商，只需要向大华预约安装，安装维护团队准时到达，标价明确，无二次收费，按要求完成安装任务。大华获香港政府屋宇署批准注册小型工程承建商第 II 及III 级别 C 类型招牌工程，同时严格遵循香港消委会、海关等相关法律法规。专业的安装师傅按标准程序及操作规程执行，确保作业过程安全和使用安全。'},
				{id:4,icon:'am-icon-briefcase',title:'维修保养',desc:'设有保用教学，帮助您更能掌握使用产品，并在超过保修期之后仍提供有偿维修。在产品生命周期结束后，钟潭会提供优惠供客户重新定制以替旧换新。'}
			]
		}
	},
/*	mounted() {
		this.getSlideshow()
	},
	methods:{
		changeTab(index){
			this.tabIndex = index
		},
		getSlideshow(){
			this.getRequest("/findAllSlideshow").then(resp =>{
				if (resp){
					this.slideshow = resp.data.data
					//console.log(this.slideshow)
				}
			})
		}
	},*/
}
</script>

<style scoped>

</style>
