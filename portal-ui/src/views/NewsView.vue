<template>
	<Layout>
		<div class="layout-container" style="width: 100%">
			<div class="page-header">
				<div class="am-container">
					<h1 class="page-header-title">公司动态</h1>
				</div>
			</div>
			
			<div class="breadcrumb-box">
				<div class="am-container">
					<ol class="am-breadcrumb">
						<li><router-link to="/">首页</router-link></li>
						<li class="am-active">公司动态</li>
					</ol>
				</div>
			</div>
		</div>
		
		<div class="section">
			<div class="container" style="max-width: 1160px">
				<div class="section--header">
					<h2 class="section--title">最近新闻</h2>
					<p class="section--description">
            广告标识制作的工艺
						<br>广告标识制作的工艺范围较广，只要是具有表现力、具有装饰性能的工艺手段，几乎都能被标牌工艺所采纳。据标识圈了解，铜牌蚀刻诚然有过它历史的辉煌，或者说现在仍有沿用，但时下已不是主流；而采用科技含量高的加工手段，才是提高广告标识品味的发展方向。
					</p>
				</div>
				
				<div class="news-contaier">
					<div class="blog">
						<div class="am-g">
							<div class="am-u-lg-4 am-u-md-6 am-u-end" v-for="(article,index) in articles.records" :key="index">
								<div class="article">
									<div class="article-img">
										<img :src="article.cover" alt="" />
									</div>
									<div class="article-header">
										<h2><router-link :to="{name:'newsDetails',params:{newsId:article.articleId}}" rel="">{{article.title}}</router-link></h2>
										<ul class="article--meta">
											<li class="article--meta_item -date">{{article.createTime}}</li>
										</ul>
									</div>
									<div class="article--content">
										<p>{{article.introduction}}</p>
									</div>
									<div class="article--footer">
										<router-link :to="{name:'newsDetails',params:{newsId:article.articleId}}" class="link">查看更多</router-link>
									</div>
								</div>
							</div>
						</div>
						
						<ul class="am-pagination" style="text-align: center;">
							<li :class="pageIndex === 1 ? 'am-disabled':''"
								@click="changeIndex(pageIndex - 1)">
								<a href="#">&laquo;</a>
							</li>
							
							<li v-for="(p,index) in articles.pages"
								:key="index"
								@click="changeIndex(p)"
								:class="pageIndex === p ? 'am-active':''">
								<a href="#">{{p}}</a>
							</li>
							
							<li :class="pageIndex === articles.pages ? 'am-disabled':''"
								@click="changeIndex(pageIndex + 1)">
								<a href="#">&raquo;</a>
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
	components: {Layout},
	data(){
		return{
			articles: {},
			pageIndex: 1,
		}
	},
	mounted() {
		this.getArticle(1)
	},
	methods:{
		getArticle(pageIndex){
			this.getRequest(`/findArticles/${pageIndex}`).then(resp =>{
				if (resp){
					this.articles = resp.data.data
					console.log(this.articles)
					
				}
			})
		},
		changeIndex(p){
			if (p === 0){
				this.pageIndex = 1
			}else if (p === this.articles.pages + 1){
				this.pageIndex = this.articles.pages
			}else{
				this.pageIndex = p;
				this.getArticle(p)
			}
		}
	}
}
</script>

<style scoped>

</style>
