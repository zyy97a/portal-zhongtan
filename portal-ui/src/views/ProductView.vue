<template>
	<Layout>
		<!--<div class="product-background"></div>-->
		
		<div class="layout-container" style="width: 100%">
			<div class="solution-page">
				<div class="container" style="text-align: center">
					<h2>您可靠的招牌专家</h2>
					<p>钟潭熟悉每种制作材料和制作工艺，擅长叠加使用放大您的品牌优势。大华坚持定制化原则，倾听您的需求，在任何时候都能给你提供专业的招牌和金属制品的意见和帮助，创建符合您期望要求的品牌标志。</p>
				</div>
			</div>
		</div>
		<div class="layout-container" style="width: 100%">
			<div class="breadcrumb-box">
				<div class="am-container">
					<ol class="am-breadcrumb">
						<li><router-link to="/">首页</router-link></li>
						<li class="am-active">产品中心</li>
					</ol>
				</div>
			</div>
		</div>
		
		<div class="section">
			<div class="container" style="max-width: 1160px">
				<div class="section--header">
					<h2 class="section--title">产品介绍</h2>
					<p class="section--description">
            我们是一家专业从事广告招牌设计与制作的工厂，提供多元化的产品和服务，满足客户的各种需求。以下是我们的主要产品介绍
					</p>
				</div>
				
				<div class="solution-container">
					<div data-am-widget="tabs" class="am-tabs ">
						<ul class="am-tabs-nav am-cf">
							<li v-for="(tab,index) in tabList"
								:key="index"
								@click.prevent="changeTab(index,tab.typeId)"
								:class="tabIndex === index ? 'am-active':''">
								<a href="#">{{tab.typeName}}</a>
							</li>
						</ul>
						<div class="am-tabs-bd">
							<div class=am-tabs-tab>
								<div class="am-tab"
									v-for="(goods,index) in goodsList"
									:key="index"
									@click="handleDetails(goods.typeDetaisId)">
									<img :src="goods.imageUrl1" alt="">
									<p>{{goods.title}}</p>
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
	name: "ProductView",
	components: {Layout},
	data(){
		return{
			tabList:[],
			list:[],
			tabIndex: 0,
			goodsList:[],
		}
	},
	mounted() {
		this.getTabList()
		this.getGoodsList(1)
	},
	methods:{
		getTabList(){
			this.getRequest("/findAllType").then(resp =>{
				if (resp){
					this.tabList = resp.data.data
					//console.log(resp.data.data)
				}
			})
		},
		changeTab(index,typeId){
			this.tabIndex = index
			console.log(typeId)
			this.getGoodsList(typeId)
		},
		getGoodsList(typeId){
			this.getRequest(`/findTypeDetailsByTypeId/${typeId}`).then(resp =>{
				if (resp){
					this.goodsList = resp.data.data
					//console.log(resp.data.data)
				}
			})
		},
		handleDetails(productId){
			this.$router.push({path:`/product/productId/${productId}`})
		}
	}
}
</script>

<style scoped>

</style>
