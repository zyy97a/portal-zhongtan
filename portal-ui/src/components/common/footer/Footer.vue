<template>
	<div class="footer">
		<div style="background-color:#383d61" class="footer--bg"></div>
		<div class="footer--inner">
			<div class="am-g">
				<div class="am-u-md-3 ">
					<div class="footer_main--column">
						<strong class="footer_main--column_title">产品中心</strong>
						<ul class="footer_navigation">
							<li class="footer_navigation--item"><router-link to="/product" class="footer_navigation--link">发光招牌</router-link></li>
							<li class="footer_navigation--item"><router-link to="/product" class="footer_navigation--link">指示牌</router-link></li>
							<li class="footer_navigation--item"><router-link to="/product" class="footer_navigation--link">雕塑品</router-link></li>
						</ul>
					</div>
				</div>
				<div class="am-u-md-6 ">
					<div class="footer_main--column">
						<strong class="footer_main--column_title">关于我们</strong>
						<div class="footer_about">
							<p class="footer_about--text">
                诚信创造价值，品质源于专业”是公司的核心价值观。团结、创新、务实、奋进是公司矢志不渝的追求。公司倍加珍惜每一份荣誉，坚持“质量第一、用户至上、以质兴业、以优取胜”的经营宗旨。致力与我们的合作伙伴真诚相待，在“合作共赢”的理念下不断将优秀装饰产品贡献社会，与社会各界优势互补、同创辉煌！
							</p>
						</div>
					</div>
				</div>
				<div class="am-u-md-3 ">
					<div class="footer_main--column">
						<strong class="footer_main--column_title">联系详情</strong>
						<ul class="footer_contact_info">
							<li class="footer_contact_info--item"><i class="am-icon-phone"></i><span>服务专线：15284734274</span></li>
							<li class="footer_contact_info--item"><i class="am-icon-map-marker"></i><span>广东省佛山市南海区</span></li>
							<li class="footer_contact_info--item"><i class="am-icon-clock-o"></i><span>周一 ~ 周日, 8:00 - 23:00 </span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	name: "Footer"
}
</script>

<style scoped>

</style>
