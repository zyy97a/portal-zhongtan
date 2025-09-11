<template>
  <Layout>
    <div class="hero-section">
      <div class="hero-overlay"></div>
      <div class="hero-content">
        <div class="container">
          <h1 class="hero-title">您可靠的招牌专家</h1>
          <div class="title-separator"></div>
          <p class="hero-description">钟潭熟悉每种制作材料和制作工艺，擅长叠加使用放大您的品牌优势。钟潭坚持定制化原则，倾听您的需求，在任何时候都能给你提供专业的招牌和金属制品的意见和帮助，创建符合您期望要求的品牌标志。</p>
          <div class="hero-cta">
            <a href="#product-section" class="btn-explore">浏览产品</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Product section -->
    <div class="product-section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">产品介绍</h2>
          <div class="title-underline"></div>
          <p class="section-description">
            我们是一家专业从事广告招牌设计与制作的厂商，提供多元化的产品和服务，满足客户的各种需求。以下是我们的主要产品介绍
          </p>
        </div>

        <!-- Tabs section -->
        <div class="tabs-container">
          <div class="tabs-nav-wrapper">
            <ul class="tabs-nav">
              <li
                  v-for="(tab, index) in tabList"
                  :key="index"
                  @click.prevent="changeTab(index, tab.typeId)"
                  :class="tabIndex === index ? 'active' : ''"
              >
                <a href="#">{{ tab.typeName }}</a>
              </li>
            </ul>
          </div>

          <!-- Product grid -->
          <div class="tabs-content">
            <div class="product-grid">
              <div
                  class="product-card"
                  v-for="(goods, index) in goodsList"
                  :key="index"
                  @click="handleDetails(goods.typeDetaisId)"
              >
                <div class="product-image">
                  <img :src="goods.imageUrl1" :alt="goods.title">
                </div>
                <div class="product-info">
                  <h3 class="product-title">{{ goods.title }}</h3>
                  <div class="view-details">查看详情 <i class="fa fa-arrow-right"></i></div>
                </div>
              </div>
            </div>

            <!-- Empty state when no products -->
            <div class="empty-state" v-if="goodsList.length === 0">
              <p>暂无产品信息</p>
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
  components: { Layout },
  data() {
    return {
      tabList: [],
      tabIndex: 0,
      goodsList: [],
      loading: false,
      // 硬编码的产品类型数据
      mockTabData: [
        {
          "typeId": 1,
          "typeName": "发光招牌",
          "isDelete": 0,
          "createTime": "2020-10-03 "
        },
        {
          "typeId": 2,
          "typeName": "不发光招牌",
          "isDelete": 0,
          "createTime": "2020-10-03 "
        },
        {
          "typeId": 3,
          "typeName": "金属制品",
          "isDelete": 0,
          "createTime": "2020-10-03 "
        },
        {
          "typeId": 4,
          "typeName": "指示牌",
          "isDelete": 0,
          "createTime": null
        },
        {
          "typeId": 5,
          "typeName": "灯箱",
          "isDelete": 0,
          "createTime": null
        },
        {
          "typeId": 6,
          "typeName": "贴纸裱画",
          "isDelete": 0,
          "createTime": null
        }
      ],
      // 硬编码的产品详情数据
      mockProductData: {
        1: [ // 发光招牌
          {
            "typeDetaisId": 1,
            "title": "无边字",
            "imageUrl1": require('@/assets/images/product/wbz.jpg'),
            "imageUrl2": null,
            "imageUrl3": null,
            "imageUrl4": null,
            "imageUrl5": null,
            "introduction": "正面是亚克力面板，侧边由铝材质围边，内置LED灯制作而成。无边字作为质量最轻便且价格实惠的发光字，是现在所有门头的首选。",
            "typeId": 1,
            "createTime": "2020-10-03",
            "isDelete": 0
          },
          {
            "typeDetaisId": 2,
            "title": "霓虹灯字",
            "imageUrl1": require('@/assets/images/product/nhdz.jpg'),
            "imageUrl2": null,
            "imageUrl3": null,
            "imageUrl4": null,
            "imageUrl5": null,
            "introduction": "由霓虹灯带按照所展示的文字轮廓双线条围边，粘合在亚克力或者金属烤漆面板上。因其色彩饱和度高，呈现复古摩登的视觉效果，在整条街上突出而醒目。",
            "typeId": 1,
            "createTime": "2020-10-03",
            "isDelete": 0
          },
          {
            "typeDetaisId": 3,
            "title": "亚克力背光字",
            "imageUrl1": require('@/assets/images/product/yklbgz.jpg'),
            "imageUrl2": null,
            "imageUrl3": null,
            "imageUrl4": null,
            "imageUrl5": null,
            "introduction": "正面是不锈钢围边焊接面板，背垫一定厚度的透明亚克力背打光制成。因背面透明亚克力透光性强，而正面不发光，视觉层次感强，是很多高端品牌的首选。",
            "typeId": 1,
            "createTime": "2020-10-03",
            "isDelete": 0
          },
          {
            "typeDetaisId": 4,
            "title": "撑脚背光字",
            "imageUrl1": require('@/assets/images/product/cjbgz.jpg'),
            "imageUrl2": null,
            "imageUrl3": null,
            "imageUrl4": null,
            "imageUrl5": null,
            "introduction": "由不锈钢焊接固定金属脚背打光制成。不同于亚克力背光字，其质量轻盈易于安装，室内户外都适用。一定长度的金属撑脚与灯影相互映衬，艺术视觉立体感强。",
            "typeId": 1,
            "createTime": null,
            "isDelete": 0
          },
          {
            "typeDetaisId": 5,
            "title": "迷你字",
            "imageUrl1": require('@/assets/images/product/mnz.jpg'),
            "imageUrl2": null,
            "imageUrl3": null,
            "imageUrl4": null,
            "imageUrl5": null,
            "introduction": "正面和背面都由亚克力双层叠加而成，是笔画能做到最小、最薄的发光字。因其发光均匀，整体造型轻薄，是商场里大部分的商家会选择的发光字。",
            "typeId": 1,
            "createTime": null,
            "isDelete": 0
          },
          {
            "typeDetaisId": 21,
            "title": "不锈钢扣边字",
            "imageUrl1": require('@/assets/images/product/bxgkbz.jpg'),
            "imageUrl2": null,
            "imageUrl3": null,
            "imageUrl4": null,
            "imageUrl5": null,
            "introduction": "由不锈钢围边焊接，扩边扣住亚克力面板而成。因其侧面和背板都是不锈钢板，是最牢固的发光字。抗风性强、使用周期长，是户外大型门头和高空顶楼字的最佳选择。",
            "typeId": 1,
            "createTime": null,
            "isDelete": 0
          },
          {
            "typeDetaisId": 22,
            "title": "复古灯泡字",
            "imageUrl1": require('@/assets/images/product/fgdpz.jpg'),
            "imageUrl2": null,
            "imageUrl3": null,
            "imageUrl4": null,
            "imageUrl5": null,
            "introduction": "由不锈钢反向围边焊接，内置柔光灯泡制成。外置的复古灯泡醒目而不刺眼，营造出复古浪漫的发光氛围，更多适用于主题餐厅、夜场和艺术街区的广告招牌。",
            "typeId": 1,
            "createTime": null,
            "isDelete": 0
          },
          {
            "typeDetaisId": 23,
            "title": "软膜灯箱",
            "imageUrl1": require('@/assets/images/product/rmdx.jpg'),
            "imageUrl2": null,
            "imageUrl3": null,
            "imageUrl4": null,
            "imageUrl5": null,
            "introduction": "铝合金作为外边框，画面内容为高精度的喷绘打印而成。因其画面容易更换且价格实惠，是很多街边商铺店招的选择。",
            "typeId": 1,
            "createTime": null,
            "isDelete": 0
          }
        ],
        2: [ // 不发光招牌
          {
            "typeDetaisId": 6,
            "title": "平面招牌",
            "imageUrl1": require('@/assets/images/product/pmzp.jpg'),
            "imageUrl2": require('@/assets/images/product/pmzp1.jpg'),
            "imageUrl3": require('@/assets/images/product/pmzp2.jpg'),
            "imageUrl4": require('@/assets/images/product/pmzp3.jpg'),
            "imageUrl5": null,
            "introduction": "采用优质金属材料制作，工艺精良，外观大气，适合各种商业场所使用。",
            "typeId": 2,
            "createTime": "2020-10-03",
            "isDelete": 0
          },
          {
            "typeDetaisId": 7,
            "title": "亚克力字招牌",
            "imageUrl1": require('@/assets/images/product/ykl.jpg'),
            "imageUrl2": require('@/assets/images/product/ykl1.jpg'),
            "imageUrl3": require('@/assets/images/product/ykl2.jpg'),
            "imageUrl4": require('@/assets/images/product/ykl3.jpg'),
            "imageUrl5": require('@/assets/images/product/ykl4.jpg'),
            "introduction": "采用优质亚克力材料，色彩鲜艳，不易褪色，性价比高。",
            "typeId": 2,
            "createTime": "2020-10-03",
            "isDelete": 0
          }
        ],
        3: [ // 金属制品
          {
            "typeDetaisId": 8,
            "title": "宣传栅/公告箱",
            "imageUrl1": require('@/assets/images/product/ggx.jpg'),
            "imageUrl2": require('@/assets/images/product/ggx1.jpg'),
            "imageUrl3": require('@/assets/images/product/ggx2.jpg'),
            "imageUrl4": require('@/assets/images/product/ggx3.jpg'),
            "imageUrl5": require('@/assets/images/product/ggx4.jpg'),
            "introduction": "宣传栅和公告箱由背板，边框、正面可视面板组成，用于装载宣传海报和告示。宣传海报和告示纸张可使用图钉或者粘贴方式固定在背板，正面面板可开合设计方便根据需求更换展示内容。",
            "typeId": 3,
            "createTime": "2020-10-03",
            "isDelete": 0
          },{
            "typeDetaisId": 9,
            "title": "信箱",
            "imageUrl1": require('@/assets/images/product/xinx.jpg'),
            "imageUrl2": require('@/assets/images/product/xinx1.jpg'),
            "imageUrl3": require('@/assets/images/product/xinx2.jpg'),
            "imageUrl4": require('@/assets/images/product/xinx3.jpg'),
            "imageUrl5": null,
            "introduction": "组合信箱是箱体金属制品，由多个小箱体组合而成的一体化的储存柜，一致性高，样式偏差小，通常用于公寓、大厦等居民的信件、公函储存，还可根据不同的应用场景设计用于公众场所的物品储存，如手机，平板电脑，钱包，钥匙和其他小贵重物品等。",
            "typeId": 3,
            "createTime": "2020-10-03",
            "isDelete": 0
          },{
            "typeDetaisId": 10,
            "title": "展示架",
            "imageUrl1": require('@/assets/images/product/zsj.jpg'),
            "imageUrl2": require('@/assets/images/product/zsj1.jpg'),
            "imageUrl3": require('@/assets/images/product/zsj2.jpg'),
            "imageUrl4": require('@/assets/images/product/zsj3.jpg'),
            "imageUrl5": null,
            "introduction": "展示架是商品和展览品的承托道具，通常配合物品的大小和形象设计而成，方便观看和储存。 大华展示架采用最优质的材料制作而成，款式设计新颖独特，外观优美，结构牢固，风格优美，高贵典雅，还可加入LED发光装置，其良好的装饰效果衬托出产品不同凡响的魅力。",
            "typeId": 3,
            "createTime": "2020-10-03",
            "isDelete": 0
          }
        ],
        4: [ // 指示牌
          {
            "typeDetaisId": 11,
            "title": "铝指示牌",
            "imageUrl1": require('@/assets/images/product/lzsp.jpg'),
            "imageUrl2": require('@/assets/images/product/lzsp1.jpg'),
            "imageUrl3": require('@/assets/images/product/lzsp2.jpg'),
            "imageUrl4": null,
            "imageUrl5": null,
            "introduction": "铝指示牌材料为铝材质，然后在正面上印绘文字和图案内容作指示信息，其重量轻巧，生产快捷，价格便宜，内容信息可独立更换，维护方便，是预算小，短时间使用的指示牌的经济选择。",
            "typeId": 4,
            "createTime": null,
            "isDelete": 0
          },{
            "typeDetaisId": 12,
            "title": "不锈钢指示牌",
            "imageUrl1": require('@/assets/images/product/bxgzsp.jpg'),
            "imageUrl2": require('@/assets/images/product/bxgzsp1.jpg'),
            "imageUrl3": require('@/assets/images/product/bxgzsp2.jpg'),
            "imageUrl4": require('@/assets/images/product/bxgzsp3.jpg'),
            "imageUrl5": require('@/assets/images/product/bxgzsp4.jpg'),
            "introduction": "钢指示牌是使用#304或#316不锈钢材质，可以利用丝印、喷画、喷漆等技术印制指示图案内容和信息；因不锈钢具有良好的耐腐蚀性能，还可以利用化学腐蚀技术做蚀刻标牌，从而令指示图案内容和信息实现凹凸效果，立体感强烈，并保留金属色泽，边缘轮廓明显，这也是不锈钢指示牌有别于其他指示牌最大的特点和特色",
            "typeId": 4,
            "createTime": null,
            "isDelete": 0
          },{
            "typeDetaisId": 13,
            "title": "胶指示牌",
            "imageUrl1": require('@/assets/images/product/jzsp.jpg'),
            "imageUrl2": require('@/assets/images/product/jzsp1.jpg'),
            "imageUrl3": require('@/assets/images/product/jzsp2.jpg'),
            "imageUrl4": require('@/assets/images/product/jzsp3.jpg'),
            "imageUrl5": null,
            "introduction": "胶指示牌材料为亚克力胶板，采用丝印、喷画、喷漆等技术印制指示图案内容和信息；亚克力具有较好的透明性、化学稳定性，具有独特的水晶质感，且易于加工、染色，外观优美，简约独特，色彩多样、绚丽，内容清晰明白，视觉冲击力强；其工艺简单快捷，材料价格低廉，经济实惠，性价比极高。",
            "typeId": 4,
            "createTime": null,
            "isDelete": 0
          },{
            "typeDetaisId": 14,
            "title": "玻璃指示牌",
            "imageUrl1": require('@/assets/images/product/blzsp.jpg'),
            "imageUrl2": null,
            "imageUrl3": null,
            "imageUrl4": null,
            "imageUrl5": null,
            "introduction": "玻璃指示牌以玻璃材质制作，最大的特点是其独有的晶莹剔透的质感，令整个指示牌显得柔和干净；玻璃属于易碎材质，此特质大大增加了生产、运输及安装的难度，因此造价较高，整体价格较贵。大华是少数提供玻璃指示牌的公司之一。",
            "typeId": 4,
            "createTime": null,
            "isDelete": 0
          },{
            "typeDetaisId": 15,
            "title": "木指示牌",
            "imageUrl1": require('@/assets/images/product/mzsp.jpg'),
            "imageUrl2": require('@/assets/images/product/mzsp1.jpg'),
            "imageUrl3": require('@/assets/images/product/mzsp2.jpg'),
            "imageUrl4": require('@/assets/images/product/mzsp3.jpg'),
            "imageUrl5": null,
            "introduction": "木制指示牌通常可以雕刻文字图案，再加以打磨喷漆等表面处理；雕刻技术繁琐，工艺要求较高，制作成本比胶制指示牌稍微贵；木质标识牌展现简约、传统、自然的风格，能给人清新的视觉感受；木指示牌富涵复古经典之风尚，典雅大气之秀美，深度内涵的富贵表现。",
            "typeId": 4,
            "createTime": null,
            "isDelete": 0
          },{
            "typeDetaisId": 16,
            "title": "混合指示牌",
            "imageUrl1": require('@/assets/images/product/hhzsp.jpg'),
            "imageUrl2": require('@/assets/images/product/hhzsp1.jpg'),
            "imageUrl3": require('@/assets/images/product/hhzsp2.jpg'),
            "imageUrl4": require('@/assets/images/product/hhzsp3.jpg'),
            "imageUrl5": null,
            "introduction": "混合指示牌是指结合多种材质搭配组合生产制成的指示牌。混合指示牌相对传统指示牌，设计风格上别具一格，利用混搭效果达到令人意想不到的效果，其创新独特的设计令人眼前一亮，更具观赏性。",
            "typeId": 4,
            "createTime": null,
            "isDelete": 0
          }
        ],
        5: [ // 灯箱
          {
            "typeDetaisId": 17,
            "title": "拉布灯箱",
            "imageUrl1": require('@/assets/images/product/bldx.jpg'),
            "imageUrl2": null,
            "imageUrl3": null,
            "imageUrl4": null,
            "imageUrl5": null,
            "introduction": "拉布灯箱外框采用优质铝型材直接切割组合而成，正面发光面选用喷绘布面，按客人指定内容在布面上进行 UV 喷绘；内装 CE 及 ECA 认证的LED 灯条光源；其结构组成简单，材料造价低，制作快捷，在广告灯箱行业中极具价格竞争力；拉布广告灯箱发光均匀，发光面积大，亮度高，广告效果宏大，相比传统灯箱更能吸引眼球；适用于商场，机场或户外场地等大型场所，更能衬托出广告的产品优势。",
            "typeId": 5,
            "createTime": null,
            "isDelete": 0
          },{
            "typeDetaisId": 18,
            "title": "胶片灯箱",
            "imageUrl1": require('@/assets/images/product/jdx.jpg'),
            "imageUrl2": require('@/assets/images/product/jdx1.jpg'),
            "imageUrl3": require('@/assets/images/product/jdx2.jpg'),
            "imageUrl4": require('@/assets/images/product/jdx3.jpg'),
            "imageUrl5": require('@/assets/images/product/jdx4.jpg'),
            "imageUrl6": require('@/assets/images/product/jdx5.jpg'),
            "introduction": "胶片灯箱的整个面板都为亚克力胶板，发光面积大，亮度高；胶片灯箱利用 UV 喷绘技术在胶片上喷绘出商家要展示的图案及内容信息，再结合灯光完美展示出广告效果，颜色多姿多彩，内容信息丰富饱满。灯箱框体一般选用金属材质，经激光切割、焊接加工等工序制成不同形状。胶片灯箱耐用持久，可直接通过更换胶片而改变广告信息，简单便利，且造价较低，性价比较高，特别适用于小型或室内灯箱、门店招牌、餐厅悬挂的菜单牌或洗手间灯牌等。",
            "typeId": 5,
            "createTime": null,
            "isDelete": 0
          },{
            "typeDetaisId": 19,
            "title": "金属灯箱",
            "imageUrl1": require('@/assets/images/product/jsdx.jpg'),
            "imageUrl2": require('@/assets/images/product/jsdx1.jpg'),
            "imageUrl3": require('@/assets/images/product/jsdx2.jpg'),
            "imageUrl4": null,
            "imageUrl5": null,
            "introduction": "金属灯箱选用不锈钢板、铜板、铁板或铝板等金属作灯箱箱体，金属面直接利用激光切割技术拉穿图案内容作发光面，也可在拉穿位置托一层亚克力胶板增强发光效果；金属灯箱外形款式丰富多变，图案精准清晰，准确突出客人要展示的内容信息，整体感觉尽显高贵沉稳有信誉力。",
            "typeId": 5,
            "createTime": null,
            "isDelete": 0
          }/*,{
            "typeDetaisId": 20,
            "title": "突字灯箱",
            "imageUrl1": "https://via.placeholder.com/300x200/ff6600/ffffff?text=LED灯箱",
            "imageUrl2": null,
            "imageUrl3": null,
            "imageUrl4": null,
            "imageUrl5": null,
            "introduction": "突字灯箱其实就是在金属灯箱基础上，浮突出亚克力发光面，整体视觉效果就是发光灯字和金属箱体的组合，因此发光效果多变，造型独特显眼，立体感十分强烈，令其同时具备灯字的柔和精美效果和灯箱的宏大高亮效果。",
            "typeId": 5,
            "createTime": null,
            "isDelete": 0
          }*/
        ],
        6: [
          {
            "typeDetaisId": 20,
            "title": "贴纸裱画",
            "imageUrl1": require('@/assets/images/product/tzbh3.jpg'),
            "imageUrl2": require('@/assets/images/product/tzbh.jpg'),
            "imageUrl3": require('@/assets/images/product/tzbh1.jpg'),
            "imageUrl4": require('@/assets/images/product/tzbh2.jpg'),
            "imageUrl5": null,
            "introduction": "广告贴纸属于广告材料的一种，广泛应用于广告牌、壁画、标志、棚架遮布、橱窗展示图画、海报招贴、户内展板广告、广告展示图、橱窗广告、商业与民用室内装潢等众多领域。相比大幅招牌广告制作，贴纸裱画具有轻便简约的优势，同时兼具贴合活动或者组织风格传递广告信息的作用，是经济实用的首选。",
            "typeId": 5,
            "createTime": null,
            "isDelete": 0
          }
        ]
      }
    };
  },
  mounted() {
    this.getTabList();
  },
  methods: {
    getTabList() {
      this.loading = true;

      // 模拟API调用延迟
      setTimeout(() => {
        try {
          this.tabList = this.mockTabData;
          if (this.tabList.length > 0) {
            this.getGoodsList(this.tabList[0].typeId);
          }
        } catch (error) {
          console.error("获取产品类型失败:", error);
        } finally {
          this.loading = false;
        }
      }, 500);
    },
    changeTab(index, typeId) {
      this.tabIndex = index;
      this.getGoodsList(typeId);
    },
    getGoodsList(typeId) {
      this.loading = true;
      this.goodsList = []; // Clear current list while loading

      // 模拟API调用延迟
      setTimeout(() => {
        try {
          this.goodsList = this.mockProductData[typeId] || [];
        } catch (error) {
          console.error("获取产品列表失败:", error);
        } finally {
          this.loading = false;
        }
      }, 300);
    },
    handleDetails(productId) {
      // 简单跳转，传递产品ID
      this.$router.push({
        name: 'ProductDetail', // 假设详情页路由名称为 ProductDetail
        params: { id: productId }
      });

      // 或者使用 path 方式
      // this.$router.push({ path: `/product/${productId}` });
    }
  }
};
</script>

<style scoped>
/* Global styles */
.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 15px;
}

/* Hero section - 桌面端 */
.hero-section {
  position: relative;
  height: 450px;
  width: 100%;
  background-image: url('../assets/images/product/abouthostorybg.jpg');
  background-size: cover;
  background-position: center center;
  background-repeat: no-repeat;
  background-attachment: fixed;
  color: #fff;
  margin-bottom: 0;
  overflow: hidden;
}

.hero-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(90deg, rgba(0, 0, 0, 0.65), rgba(0, 48, 87, 0.7));
}

.hero-content {
  position: relative;
  z-index: 2;
  height: 100%;
  display: flex;
  align-items: center;
  text-align: center;
}

.hero-content .container {
  width: 100%;
  max-width: 1000px;
  padding: 0 20px;
}

.hero-title {
  font-size: 44px;
  font-weight: 800;
  margin-bottom: 20px;
  color: #fff;
  text-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
  animation: fadeInDown 1s ease-out;
  letter-spacing: 1px;
  line-height: 1.2;
}

.title-separator {
  height: 3px;
  width: 80px;
  background-color: #f39c12;
  margin: 0 auto 25px;
  animation: scaleIn 1.2s ease-out;
}

.hero-description {
  font-size: 18px;
  line-height: 1.8;
  margin: 0 auto 30px;
  max-width: 800px;
  opacity: 0.95;
  animation: fadeInUp 1s ease-out 0.3s;
  animation-fill-mode: both;
  text-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
}

.hero-cta {
  margin-top: 35px;
  animation: fadeIn 1.5s ease-out 0.6s;
  animation-fill-mode: both;
}

.btn-explore {
  display: inline-block;
  background-color: #f39c12;
  color: white;
  font-size: 16px;
  font-weight: 600;
  padding: 12px 32px;
  border-radius: 30px;
  text-decoration: none;
  box-shadow: 0 4px 15px rgba(243, 156, 18, 0.4);
  transition: all 0.3s ease;
  text-transform: uppercase;
  letter-spacing: 1px;
  border: none;
  cursor: pointer;
}

.btn-explore:hover {
  background-color: #e67e22;
  transform: translateY(-2px);
  box-shadow: 0 6px 20px rgba(243, 156, 18, 0.6);
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
  flex-wrap: wrap;
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

/* Section styles */
.product-section {
  padding: 40px 0 60px;
}

.section-header {
  text-align: center;
  margin-bottom: 40px;
}

.section-title {
  font-size: 28px;
  font-weight: 700;
  margin-bottom: 15px;
  color: #333;
  line-height: 1.3;
}

.title-underline {
  height: 3px;
  width: 60px;
  background-color: #f39c12;
  margin: 0 auto 20px;
}

.section-description {
  max-width: 800px;
  margin: 0 auto;
  color: #666;
  line-height: 1.6;
}

/* Tabs - 桌面端 */
.tabs-container {
  margin-top: 30px;
}

.tabs-nav-wrapper {
  position: relative;
  margin-bottom: 30px;
  border-bottom: 1px solid #e5e7eb;
  background: #fff;
}

.tabs-nav {
  display: flex;
  list-style: none;
  padding: 0;
  margin: 0;
  background: #ffffff;
}

.tabs-nav li {
  margin-right: 8px;
}

.tabs-nav li a {
  display: block;
  padding: 16px 24px;
  color: #4b5563;
  text-decoration: none;
  font-size: 16px;
  font-weight: 600;
  transition: all 0.2s ease;
  border-bottom: 2px solid transparent;
  position: relative;
  white-space: nowrap;
}

.tabs-nav li:hover a {
  color: #1f2937;
}

.tabs-nav li.active a {
  color: #f59e0b;
  border-bottom-color: #f59e0b;
  font-weight: 700;
}

.tabs-nav li a::after {
  content: '';
  position: absolute;
  bottom: -2px;
  left: 50%;
  width: 0;
  height: 2px;
  background: #f59e0b;
  transition: all 0.3s ease;
  transform: translateX(-50%);
}

.tabs-nav li:hover a::after {
  width: 80%;
}

.tabs-nav li.active a::after {
  width: 100%;
}

/* Product grid */
.product-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 25px;
}

.product-card {
  background-color: #fff;
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.05);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  cursor: pointer;
}

.product-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
}

.product-image {
  width: 100%;
  height: 220px;
  overflow: hidden;
}

.product-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.5s ease;
}

.product-card:hover .product-image img {
  transform: scale(1.05);
}

.product-info {
  padding: 15px;
  border-top: 1px solid #eee;
}

.product-title {
  font-size: 16px;
  margin: 0 0 10px;
  color: #333;
  font-weight: 600;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.view-details {
  color: #f39c12;
  font-size: 14px;
  font-weight: 500;
  display: flex;
  align-items: center;
  opacity: 0;
  transition: opacity 0.3s ease;
}

.product-card:hover .view-details {
  opacity: 1;
}

.view-details i {
  margin-left: 5px;
}

.empty-state {
  text-align: center;
  padding: 40px 0;
  color: #999;
}

/* Animation keyframes */
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

@keyframes scaleIn {
  from {
    transform: scaleX(0);
  }
  to {
    transform: scaleX(1);
  }
}

@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

/* ================== 响应式设计 ================== */

/* 大屏幕 - 1200px+ */
@media (min-width: 1200px) {
  .container {
    padding: 0 20px;
  }

  .hero-title {
    font-size: 48px;
  }

  .hero-description {
    font-size: 20px;
  }
}

/* 中等屏幕 - 992px 到 1199px */
@media (max-width: 1199px) and (min-width: 992px) {
  .hero-title {
    font-size: 40px;
  }

  .hero-description {
    font-size: 17px;
  }
}

/* 平板横屏 - 768px 到 991px */
@media (max-width: 991px) and (min-width: 768px) {
  .product-grid {
    grid-template-columns: repeat(2, 1fr);
    gap: 20px;
  }

  .hero-section {
    height: 400px;
    background-attachment: scroll;
  }

  .hero-title {
    font-size: 36px;
  }

  .hero-description {
    font-size: 16px;
    line-height: 1.6;
  }

  .section-title {
    font-size: 26px;
  }

  .tabs-nav-wrapper {
    overflow-x: auto;
    -webkit-overflow-scrolling: touch;
    scrollbar-width: none;
    -ms-overflow-style: none;
  }

  .tabs-nav-wrapper::-webkit-scrollbar {
    display: none;
  }

  .tabs-nav {
    flex-wrap: nowrap;
    min-width: max-content;
  }

  .tabs-nav li {
    flex-shrink: 0;
    margin-right: 4px;
  }

  .tabs-nav li a {
    padding: 14px 20px;
    font-size: 15px;
  }
}

/* 平板竖屏 - 576px 到 767px */
@media (max-width: 767px) and (min-width: 576px) {
  .container {
    padding: 0 20px;
  }

  .hero-section {
    height: 350px;
    background-attachment: scroll;
  }

  .hero-title {
    font-size: 32px;
    margin-bottom: 15px;
    letter-spacing: 0.5px;
  }

  .title-separator {
    margin-bottom: 20px;
    width: 70px;
  }

  .hero-description {
    font-size: 16px;
    line-height: 1.6;
    margin-bottom: 25px;
  }

  .btn-explore {
    padding: 12px 28px;
    font-size: 15px;
  }

  .section-title {
    font-size: 24px;
  }

  /* 平板竖屏 tabs - 三列布局 */
  .tabs-nav-wrapper {
    margin-bottom: 25px;
    background: #f8f9fa;
    border: 1px solid #e9ecef;
    border-radius: 8px;
    padding: 10px;
  }

  .tabs-nav {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 8px;
    border-bottom: none;
    background: transparent;
  }

  .tabs-nav li {
    margin-right: 0;
  }

  .tabs-nav li a {
    padding: 12px 8px;
    font-size: 13px;
    border-radius: 6px;
    border-bottom: none;
    text-align: center;
    background: #fff;
    border: 1px solid #e9ecef;
    min-height: 44px;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .tabs-nav li.active a {
    background: #f59e0b;
    color: #fff;
    border-color: #f59e0b;
  }

  .tabs-nav li a::after {
    display: none;
  }

  .product-grid {
    grid-template-columns: repeat(2, 1fr);
    gap: 18px;
  }

  .product-image {
    height: 180px;
  }
}

/* 手机端 - 最大575px */
@media (max-width: 575px) {
  .container {
    padding: 0 15px;
  }

  /* Hero section 手机端优化 */
  .hero-section {
    height: 320px;
    background-attachment: scroll;
    background-position: center top;
  }

  .hero-content .container {
    padding: 0 15px;
  }

  .hero-title {
    font-size: 26px;
    margin-bottom: 12px;
    letter-spacing: 0;
    line-height: 1.3;
  }

  .title-separator {
    margin-bottom: 15px;
    width: 60px;
    height: 2px;
  }

  .hero-description {
    font-size: 15px;
    line-height: 1.5;
    margin-bottom: 20px;
    padding: 0 10px;
  }

  .hero-cta {
    margin-top: 20px;
  }

  .btn-explore {
    padding: 10px 24px;
    font-size: 14px;
    border-radius: 25px;
  }

  /* Breadcrumb 手机端 */
  .breadcrumb-container {
    padding: 8px 0;
    margin-bottom: 20px;
  }

  .breadcrumb li {
    font-size: 13px;
    margin-right: 8px;
  }

  .breadcrumb li:after {
    margin-left: 8px;
  }

  /* Section 手机端 */
  .product-section {
    padding: 30px 0 40px;
  }

  .section-header {
    margin-bottom: 25px;
  }

  .section-title {
    font-size: 22px;
    margin-bottom: 12px;
    line-height: 1.3;
  }

  .title-underline {
    width: 50px;
    margin-bottom: 15px;
  }

  .section-description {
    font-size: 15px;
    line-height: 1.5;
    padding: 0 10px;
  }

  /* Tabs 手机端 - 三列布局确保6个tab正好两行 */
  .tabs-container {
    margin-top: 25px;
  }

  .tabs-nav-wrapper {
    margin-bottom: 20px;
    background: #f8f9fa;
    border: 1px solid #e9ecef;
    border-radius: 10px;
    padding: 12px;
    margin-left: 0;
    margin-right: 0;
  }

  .tabs-nav {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 10px;
    border-bottom: none;
    background: transparent;
    padding: 0;
    margin: 0;
  }

  .tabs-nav li {
    margin-right: 0;
  }

  .tabs-nav li a {
    padding: 12px 8px;
    font-size: 13px;
    font-weight: 500;
    color: #6c757d;
    background: #fff;
    border: 1px solid #e9ecef;
    border-radius: 8px;
    border-bottom: none;
    text-align: center;
    min-height: 44px;
    display: flex;
    align-items: center;
    justify-content: center;
    transition: all 0.3s ease;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
    line-height: 1.2;
  }

  .tabs-nav li a:hover {
    color: #f59e0b;
    border-color: #f59e0b;
    box-shadow: 0 2px 6px rgba(245, 158, 11, 0.2);
  }

  .tabs-nav li.active a {
    background: linear-gradient(135deg, #f59e0b, #f97316);
    color: #fff;
    border-color: #f59e0b;
    font-weight: 600;
    box-shadow: 0 3px 8px rgba(245, 158, 11, 0.3);
  }

  .tabs-nav li a::after {
    display: none;
  }

  /* Product grid 手机端 - 单列布局，图片自适应 */
  .product-grid {
    grid-template-columns: 1fr;
    gap: 16px;
  }

  .product-card {
    border-radius: 10px;
    box-shadow: 0 3px 12px rgba(0, 0, 0, 0.08);
  }

  .product-image {
    height: 200px;
    border-radius: 10px 10px 0 0;
  }

  .product-info {
    padding: 16px;
  }

  .product-title {
    font-size: 16px;
    margin-bottom: 10px;
    white-space: normal;
    overflow: visible;
    text-overflow: initial;
    line-height: 1.4;
    font-weight: 600;
  }

  .view-details {
    opacity: 1;
    font-size: 14px;
    color: #f59e0b;
    font-weight: 500;
  }

  .empty-state {
    padding: 30px 0;
    font-size: 15px;
  }
}

/* 超小屏幕 - 最大375px */
@media (max-width: 375px) {
  .hero-section {
    height: 280px;
  }

  .hero-title {
    font-size: 22px;
  }

  .hero-description {
    font-size: 14px;
    padding: 0 5px;
  }

  .btn-explore {
    padding: 8px 20px;
    font-size: 13px;
  }

  .section-title {
    font-size: 20px;
  }

  /* 超小屏幕 tabs - 保持三列，但调整内边距 */
  .tabs-nav-wrapper {
    padding: 10px;
  }

  .tabs-nav {
    gap: 8px;
  }

  .tabs-nav li a {
    padding: 10px 6px;
    font-size: 12px;
    min-height: 40px;
  }

  .product-image {
    height: 160px;
  }

  .product-info {
    padding: 14px;
  }

  .product-title {
    font-size: 15px;
  }
}

/* 横屏模式优化 */
@media (max-height: 500px) and (orientation: landscape) {
  .hero-section {
    height: 100vh;
    min-height: 300px;
  }

  .hero-title {
    font-size: 24px;
    margin-bottom: 10px;
  }

  .hero-description {
    font-size: 14px;
    margin-bottom: 15px;
  }

  .title-separator {
    margin-bottom: 10px;
  }

  .hero-cta {
    margin-top: 15px;
  }
}

/* 触摸设备优化 */
@media (hover: none) and (pointer: coarse) {
  .product-card {
    transform: none;
  }

  .product-card:hover {
    transform: none;
  }

  .view-details {
    opacity: 1;
  }

  .tabs-nav li a {
    min-height: 48px;
    touch-action: manipulation;
  }

  .btn-explore:hover {
    transform: none;
  }
}

/* 高对比度模式支持 */
@media (prefers-contrast: high) {
  .hero-overlay {
    background: linear-gradient(90deg, rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8));
  }

  .product-card {
    border: 1px solid #ccc;
  }

  .tabs-nav {
    border-bottom: 2px solid #333;
  }

  .tabs-nav li a {
    border: 2px solid #ccc;
  }

  .tabs-nav li.active a {
    border: 2px solid #f59e0b;
  }
}

/* 减少动画偏好 */
@media (prefers-reduced-motion: reduce) {
  * {
    animation-duration: 0.01ms !important;
    animation-iteration-count: 1 !important;
    transition-duration: 0.01ms !important;
  }

  .hero-title,
  .hero-description,
  .hero-cta,
  .title-separator {
    animation: none;
  }
}
</style>