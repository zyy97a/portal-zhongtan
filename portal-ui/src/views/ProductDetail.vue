<template>
  <Layout>
    <div class="product-detail-container">
      <div class="container">
        <!-- 面包屑导航 -->
        <div class="breadcrumb">
          <a href="/" class="breadcrumb-link">首页</a>
          <span class="breadcrumb-separator">/</span>
          <a href="/products" class="breadcrumb-link">产品中心</a>
          <span class="breadcrumb-separator">/</span>
          <span class="breadcrumb-current">{{ productDetail.title }}</span>
        </div>

        <!-- 产品详情内容 -->
        <div class="product-detail-content" v-if="productDetail">
          <div class="product-detail-main">
            <!-- 产品图片 -->
            <div class="product-images">
              <div class="main-image">
                <img :src="currentMainImage" :alt="productDetail.title">
                <!-- 图片导航箭头 -->
                <div class="image-nav" v-if="hasMultipleImages">
                  <button
                      class="nav-btn prev-btn"
                      @click="previousImage"
                      :disabled="currentImageIndex === 0"
                  >
                    ❮
                  </button>
                  <button
                      class="nav-btn next-btn"
                      @click="nextImage"
                      :disabled="currentImageIndex === validImages.length - 1"
                  >
                    ❯
                  </button>
                </div>
                <!-- 图片指示器 -->
                <div class="image-indicators" v-if="hasMultipleImages">
                  <span
                      v-for="(image, index) in validImages"
                      :key="index"
                      :class="['indicator', { active: currentImageIndex === index }]"
                      @click="setCurrentImage(index)"
                  ></span>
                </div>
              </div>

              <!-- 缩略图 -->
              <div class="thumbnail-images" v-if="hasMultipleImages">
                <img
                    v-for="(image, index) in validImages"
                    :key="index"
                    :src="image"
                    :alt="productDetail.title"
                    :class="['thumbnail', { active: currentImageIndex === index }]"
                    @click="setCurrentImage(index)"
                >
              </div>
            </div>

            <!-- 产品信息 -->
            <div class="product-info">
              <h1 class="product-title">{{ productDetail.title }}</h1>

              <div class="product-meta">
                <span class="product-category">分类：{{ getTypeName(productDetail.typeId) }}</span>
                <span class="product-date" v-if="productDetail.createTime">
                  发布时间：{{ productDetail.createTime }}
                </span>
              </div>

              <div class="product-description">
                <h3>产品介绍</h3>
                <p>{{ productDetail.introduction }}</p>
              </div>

              <div class="product-actions">
                <button class="btn-contact">联系我们</button>
                <button class="btn-back" @click="goBack">返回列表</button>
              </div>
            </div>
          </div>

          <!-- 相关产品推荐 -->
          <div class="related-products" v-if="relatedProducts.length > 0">
            <h3>相关产品</h3>
            <div class="related-products-grid">
              <div
                  class="related-product-card"
                  v-for="product in relatedProducts"
                  :key="product.typeDetaisId"
                  @click="handleDetails(product.typeDetaisId)"
              >
                <div class="related-product-image">
                  <img :src="product.imageUrl1" :alt="product.title">
                </div>
                <div class="related-product-info">
                  <h4>{{ product.title }}</h4>
                </div>
              </div>
            </div>
          </div>
        </div>

        <!-- 加载状态 -->
        <div class="loading-state" v-else-if="loading">
          <p>加载中...</p>
        </div>

        <!-- 未找到产品 -->
        <div class="not-found" v-else>
          <h2>产品未找到</h2>
          <p>抱歉，您查找的产品不存在。</p>
          <button class="btn-back" @click="goBack">返回列表</button>
        </div>
      </div>
    </div>
  </Layout>
</template>

<script>
import Layout from "@/components/common/Layout";

export default {
  name: "ProductDetail",
  components: { Layout },
  data() {
    return {
      productDetail: null,
      relatedProducts: [],
      loading: true,
      currentImageIndex: 0, // 当前显示的图片索引
      // 复用相同的硬编码数据
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
            "imageUrl4": null,
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
        6: [ // 贴纸裱画
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
  computed: {
    // 获取所有有效的图片URL
    validImages() {
      if (!this.productDetail) return [];
      const images = [];
      for (let i = 1; i <= 5; i++) {
        if (this.productDetail[`imageUrl${i}`]) {
          images.push(this.productDetail[`imageUrl${i}`]);
        }
      }
      return images;
    },
    // 判断是否有多张图片
    hasMultipleImages() {
      return this.validImages.length > 1;
    },
    // 当前主图片
    currentMainImage() {
      return this.validImages[this.currentImageIndex] || '';
    }
  },
  mounted() {
    this.loadProductDetail();
  },
  methods: {
    loadProductDetail() {
      this.loading = true;
      this.currentImageIndex = 0; // 重置图片索引

      // 获取路由参数中的产品ID
      const productId = parseInt(this.$route.params.id);

      // 模拟API调用延迟
      setTimeout(() => {
        try {
          // 从硬编码数据中查找产品详情
          let foundProduct = null;
          let productTypeId = null;

          for (let typeId in this.mockProductData) {
            const product = this.mockProductData[typeId].find(item => item.typeDetaisId === productId);
            if (product) {
              foundProduct = product;
              productTypeId = parseInt(typeId);
              break;
            }
          }

          if (foundProduct) {
            this.productDetail = foundProduct;
            // 加载相关产品（同类型的其他产品）
            this.loadRelatedProducts(productTypeId, productId);
          } else {
            console.error('未找到产品详情数据');
          }
        } catch (error) {
          console.error("加载产品详情失败:", error);
        } finally {
          this.loading = false;
        }
      }, 500);
    },

    loadRelatedProducts(typeId, currentProductId) {
      // 获取同类型的其他产品作为相关产品
      const allProductsOfType = this.mockProductData[typeId] || [];
      this.relatedProducts = allProductsOfType
          .filter(product => product.typeDetaisId !== currentProductId)
          .slice(0, 3); // 只显示3个相关产品
    },

    getTypeName(typeId) {
      const type = this.mockTabData.find(tab => tab.typeId === typeId);
      return type ? type.typeName : '未知分类';
    },

    handleDetails(productId) {
      // 跳转到其他产品详情
      this.$router.push({path: `/product/${productId}`});
      // 重新加载数据
      this.loadProductDetail();
    },

    goBack() {
      this.$router.go(-1); // 返回上一页
      // 或者跳转到产品列表页
      // this.$router.push({ path: '/products' });
    },

    // 图片切换相关方法
    setCurrentImage(index) {
      this.currentImageIndex = index;
    },

    previousImage() {
      if (this.currentImageIndex > 0) {
        this.currentImageIndex--;
      }
    },

    nextImage() {
      if (this.currentImageIndex < this.validImages.length - 1) {
        this.currentImageIndex++;
      }
    },

    // 支持键盘导航
    handleKeydown(event) {
      if (!this.hasMultipleImages) return;

      if (event.key === 'ArrowLeft') {
        this.previousImage();
      } else if (event.key === 'ArrowRight') {
        this.nextImage();
      }
    }
  },

  // 监听路由变化，当在详情页之间跳转时重新加载数据
  watch: {
    '$route'(to, from) {
      if (to.params.id !== from.params.id) {
        this.loadProductDetail();
      }
    }
  },

  // 添加键盘事件监听
  created() {
    window.addEventListener('keydown', this.handleKeydown);
  },

  beforeDestroy() {
    window.removeEventListener('keydown', this.handleKeydown);
  }
};
</script>

<style scoped>
.product-detail-container {
  padding: 20px 0;
  min-height: 80vh;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
}

.breadcrumb {
  margin-bottom: 30px;
  font-size: 14px;
}

.breadcrumb-link {
  color: #666;
  text-decoration: none;
}

.breadcrumb-link:hover {
  color: #333;
}

.breadcrumb-separator {
  margin: 0 10px;
  color: #ccc;
}

.breadcrumb-current {
  color: #333;
  font-weight: bold;
}

.product-detail-main {
  display: flex;
  gap: 40px;
  margin-bottom: 50px;
}

.product-images {
  flex: 1;
}

.main-image {
  position: relative;
  margin-bottom: 15px;
}

.main-image img {
  width: 100%;
  height: auto;
  border-radius: 8px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  transition: opacity 0.3s ease;
}

/* 图片导航箭头 */
.image-nav {
  position: absolute;
  top: 50%;
  left: 0;
  right: 0;
  transform: translateY(-50%);
  display: flex;
  justify-content: space-between;
  padding: 0 10px;
  pointer-events: none;
}

.nav-btn {
  background: rgba(0, 0, 0, 0.5);
  color: white;
  border: none;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  font-size: 18px;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: all 0.3s ease;
  pointer-events: all;
}

.nav-btn:hover:not(:disabled) {
  background: rgba(0, 0, 0, 0.7);
  transform: scale(1.1);
}

.nav-btn:disabled {
  opacity: 0.3;
  cursor: not-allowed;
}

/* 图片指示器 */
.image-indicators {
  position: absolute;
  bottom: 15px;
  left: 50%;
  transform: translateX(-50%);
  display: flex;
  gap: 8px;
}

.indicator {
  width: 10px;
  height: 10px;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.5);
  cursor: pointer;
  transition: all 0.3s ease;
}

.indicator.active {
  background: white;
  transform: scale(1.2);
}

.indicator:hover {
  background: rgba(255, 255, 255, 0.8);
}

.thumbnail-images {
  display: flex;
  gap: 10px;
  flex-wrap: wrap;
}

.thumbnail {
  width: 80px;
  height: 60px;
  object-fit: cover;
  border-radius: 4px;
  cursor: pointer;
  border: 2px solid transparent;
  transition: all 0.3s ease;
}

.thumbnail:hover {
  border-color: #007bff;
  transform: scale(1.05);
}

.thumbnail.active {
  border-color: #007bff;
  box-shadow: 0 0 8px rgba(0, 123, 255, 0.3);
}

.product-info {
  flex: 1;
}

.product-title {
  font-size: 32px;
  font-weight: bold;
  margin-bottom: 20px;
  color: #333;
}

.product-meta {
  margin-bottom: 30px;
}

.product-meta span {
  display: block;
  margin-bottom: 10px;
  color: #666;
}

.product-description {
  margin-bottom: 40px;
}

.product-description h3 {
  font-size: 20px;
  margin-bottom: 15px;
  color: #333;
}

.product-description p {
  line-height: 1.8;
  color: #666;
  white-space: pre-line;
}

.product-actions {
  display: flex;
  gap: 15px;
}

.btn-contact,
.btn-back {
  padding: 12px 30px;
  border: none;
  border-radius: 6px;
  font-size: 16px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.btn-contact {
  background-color: #007bff;
  color: white;
}

.btn-contact:hover {
  background-color: #0056b3;
}

.btn-back {
  background-color: #6c757d;
  color: white;
}

.btn-back:hover {
  background-color: #545b62;
}

.related-products {
  margin-top: 50px;
}

.related-products h3 {
  font-size: 24px;
  margin-bottom: 20px;
  color: #333;
}

.related-products-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 20px;
}

.related-product-card {
  border: 1px solid #eee;
  border-radius: 8px;
  overflow: hidden;
  cursor: pointer;
  transition: all 0.3s ease;
}

.related-product-card:hover {
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  transform: translateY(-2px);
}

.related-product-image img {
  width: 100%;
  height: 150px;
  object-fit: cover;
}

.related-product-info {
  padding: 15px;
}

.related-product-info h4 {
  font-size: 16px;
  margin: 0;
  color: #333;
}

.loading-state,
.not-found {
  text-align: center;
  padding: 50px 20px;
}

.not-found h2 {
  color: #666;
  margin-bottom: 15px;
}

@media (max-width: 768px) {
  .product-detail-main {
    flex-direction: column;
    gap: 20px;
  }

  .product-title {
    font-size: 24px;
  }

  .product-actions {
    flex-direction: column;
  }

  .related-products-grid {
    grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
  }

  .nav-btn {
    width: 35px;
    height: 35px;
    font-size: 16px;
  }

  .thumbnail {
    width: 60px;
    height: 45px;
  }
}

/* 图片加载动画 */
.main-image img {
  opacity: 0;
  animation: fadeIn 0.3s ease-in-out forwards;
}

@keyframes fadeIn {
  to {
    opacity: 1;
  }
}
</style>