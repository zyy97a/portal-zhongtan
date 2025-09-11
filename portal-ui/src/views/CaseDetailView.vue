<template>
  <div class="case-detail-container">
    <!-- 返回按钮 -->
    <div class="back-button" @click="goBack">
      <i class="lucide-arrow-left"></i>
      <span>返回案例列表</span>
    </div>

    <div v-if="currentCase" class="case-detail-content">
      <!-- 顶部区域：标题和基本信息 -->
      <div class="top-section">
        <h1 class="case-title">{{ currentCase.title }}</h1>
        <div class="case-meta">
          <div class="meta-item">
            <i class="lucide-map-pin"></i>
            <span>{{ currentCase.location }}</span>
          </div>
          <div class="meta-item">
            <i class="lucide-users"></i>
            <span>{{ currentCase.client }}</span>
          </div>
          <div class="meta-item">
            <i class="lucide-calendar"></i>
            <span>{{ currentCase.completionTime }}</span>
          </div>
          <div class="meta-tag">
            {{ getCaseType(currentCase.id) }}
          </div>
        </div>
      </div>

      <!-- 图片展示区 -->
      <div class="image-gallery">
        <div class="main-image">
          <img :src="currentImages[currentImageIndex]" alt="案例图片" @click="openLightbox(currentImages, 0)" />
          <div class="image-controls">
            <button @click="prevImage" class="control-button">
              <i class="lucide-chevron-left"></i>
            </button>
            <div class="image-indicator">
              {{ currentImageIndex + 1 }}/{{ currentImages.length }}
            </div>
            <button @click="nextImage" class="control-button">
              <i class="lucide-chevron-right"></i>
            </button>
          </div>
        </div>
        <div class="thumbnail-strip">
          <div
              v-for="(img, index) in currentImages"
              :key="index"
              class="thumbnail"
              :class="{ active: index === currentImageIndex }"
              @click="currentImageIndex = index"
          >
            <img :src="img" :alt="`缩略图 ${index + 1}`" />
          </div>
        </div>
      </div>

      <!-- 案例详情 -->
      <div class="case-details">
        <h2 class="section-title">项目描述</h2>
        <p class="description">{{ currentCase.description }}</p>

        <div class="detail-cards">
          <div class="detail-card">
            <i class="lucide-map"></i>
            <h3>项目地点</h3>
            <p>{{ currentCase.location }}</p>
          </div>
          <div class="detail-card">
            <i class="lucide-building"></i>
            <h3>客户</h3>
            <p>{{ currentCase.client }}</p>
          </div>
          <div class="detail-card">
            <i class="lucide-calendar-check"></i>
            <h3>完成时间</h3>
            <p>{{ currentCase.completionTime }}</p>
          </div>
          <div class="detail-card">
            <i class="lucide-tag"></i>
            <h3>项目类型</h3>
            <p>{{ getCaseType(currentCase.id) }}</p>
          </div>
        </div>
      </div>

      <!-- 相关案例推荐 -->
      <div class="related-cases">
        <h2 class="section-title">相关案例</h2>
        <div class="related-grid">
          <div
              v-for="(item, index) in relatedCases"
              :key="item.id"
              class="related-case-card"
              @click="viewCase(item)"
          >
            <div class="related-image">
              <img :src="item.thumbImg" :alt="item.title" />
            </div>
            <h3>{{ item.title }}</h3>
            <p class="related-location">
              <i class="lucide-map-pin"></i> {{ item.location }}
            </p>
          </div>
        </div>
      </div>
    </div>

    <!-- 占位区域 -->
    <div v-else class="loading-placeholder">
      <div class="loading-spinner"></div>
      <p>加载案例数据中...</p>
    </div>

    <!-- 图片放大查看器 -->
    <div v-if="lightboxVisible" class="lightbox">
      <div class="lightbox-backdrop" @click="closeLightbox"></div>
      <div class="lightbox-content">
        <button class="lightbox-close" @click="closeLightbox">
          <i class="lucide-x"></i>
        </button>
        <button class="lightbox-prev" @click="prevLightboxImage">
          <i class="lucide-chevron-left"></i>
        </button>
        <img :src="lightboxImages[currentLightboxIndex]" alt="案例图片" />
        <button class="lightbox-next" @click="nextLightboxImage">
          <i class="lucide-chevron-right"></i>
        </button>
        <div class="lightbox-caption">
          <h3>{{ currentCase.title }}</h3>
          <p>{{ currentLightboxIndex + 1 }} / {{ lightboxImages.length }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { computed, ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';

export default {
  name: 'CaseDetail',
  setup() {
    const route = useRoute();
    const router = useRouter();
    const caseId = ref(parseInt(route.params.id));
    const currentCase = ref(null);
    const currentImageIndex = ref(0);
    const lightboxVisible = ref(false);
    const lightboxImages = ref([]);
    const currentLightboxIndex = ref(0);

    // 所有案例数据
    const caseData = ref([
      {
        type: '主要案例',
        cases: [
          {
            id: 101,
            title: '联塑招牌',
            thumbImg: require('@/assets/images/about/beij3.jpg'),
            images: [
              require('@/assets/images/about/beij3.jpg'),
              require('@/assets/images/about/beij3.jpg'),
              require('@/assets/images/about/beij3.jpg'),
              require('@/assets/images/about/beij3.jpg')
            ],
            location: '上海市静安区南京西路',
            client: '星光商业管理有限公司',
            completionTime: '2024年3月',
            description: '星光商业广场作为城市新地标，需要一套能够在夜间彰显品牌魅力的标识系统。我们采用了RGB智能变色LED技术，为其打造了一套可根据节日和活动主题变换色彩的大型发光字招牌。'
          },
          // ... 其他案例数据
        ]
      },
      // ... 其他类型数据
    ]);

    // 初始化数据
    onMounted(() => {
      // 模拟从 store 或 API 获取数据
      caseData.value = JSON.parse(JSON.stringify(window.caseDataFromStore));
      loadCaseData();
    });

    // 加载案例详情
    const loadCaseData = () => {
      // 查找当前案例
      const allCases = [];
      caseData.value.forEach(typeGroup => {
        typeGroup.cases.forEach(caseItem => {
          allCases.push(caseItem);
        });
      });

      currentCase.value = allCases.find(c => c.id === caseId.value);

      if (!currentCase.value) {
        router.push('/cases'); // 如果找不到案例，返回列表页
        return;
      }

      currentImageIndex.value = 0;
    };

    // 当前案例的所有图片
    const currentImages = computed(() => {
      return currentCase.value ? currentCase.value.images : [];
    });

    // 相关案例(同类型的其他案例，最多显示3个)
    const relatedCases = computed(() => {
      if (!currentCase.value) return [];

      const caseType = getCaseType(caseId.value);
      const typeGroup = caseData.value.find(group => group.type === caseType);

      if (!typeGroup) return [];

      return typeGroup.cases
          .filter(c => c.id !== caseId.value)
          .slice(0, 3);
    });

    // 根据ID获取案例类型
    const getCaseType = (id) => {
      const idPrefix = Math.floor(id / 100);
      switch (idPrefix) {
        case 1: return '主要案例';
        case 2: return '政府案例';
        case 3: return '商业办公案例';
        case 4: return '公共服务案例';
        case 5: return '房地产案例';
        case 6: return '教育案例';
        default: return '其他案例';
      }
    };

    // 图片轮播控制
    const nextImage = () => {
      if (currentImages.value.length <= 1) return;
      currentImageIndex.value = (currentImageIndex.value + 1) % currentImages.value.length;
    };

    const prevImage = () => {
      if (currentImages.value.length <= 1) return;
      currentImageIndex.value = (currentImageIndex.value - 1 + currentImages.value.length) % currentImages.value.length;
    };

    // 灯箱功能
    const openLightbox = (images, index) => {
      lightboxImages.value = images;
      currentLightboxIndex.value = index;
      lightboxVisible.value = true;
      document.body.style.overflow = 'hidden'; // 防止滚动
    };

    const closeLightbox = () => {
      lightboxVisible.value = false;
      document.body.style.overflow = ''; // 恢复滚动
    };

    const nextLightboxImage = () => {
      currentLightboxIndex.value = (currentLightboxIndex.value + 1) % lightboxImages.value.length;
    };

    const prevLightboxImage = () => {
      currentLightboxIndex.value = (currentLightboxIndex.value - 1 + lightboxImages.value.length) % lightboxImages.value.length;
    };

    // 查看其他案例
    const viewCase = (caseItem) => {
      router.push(`/case/${caseItem.id}`);
    };

    // 返回列表页
    const goBack = () => {
      router.push('/cases');
    };

    return {
      currentCase,
      currentImages,
      currentImageIndex,
      relatedCases,
      lightboxVisible,
      lightboxImages,
      currentLightboxIndex,
      nextImage,
      prevImage,
      openLightbox,
      closeLightbox,
      nextLightboxImage,
      prevLightboxImage,
      getCaseType,
      viewCase,
      goBack
    };
  }
};
</script>

<style scoped>
.case-detail-container {
  max-width: 1280px;
  margin: 0 auto;
  padding: 40px 20px;
  color: #333;
}

/* 返回按钮 */
.back-button {
  display: flex;
  align-items: center;
  gap: 8px;
  font-size: 16px;
  color: #666;
  margin-bottom: 32px;
  cursor: pointer;
  transition: color 0.2s;
  width: fit-content;
}

.back-button:hover {
  color: #1a73e8;
}

/* 顶部区域 */
.top-section {
  margin-bottom: 40px;
}

.case-title {
  font-size: 36px;
  font-weight: 700;
  margin-bottom: 16px;
  color: #222;
}

.case-meta {
  display: flex;
  flex-wrap: wrap;
  gap: 24px;
  align-items: center;
}

.meta-item {
  display: flex;
  align-items: center;
  gap: 8px;
  color: #666;
}

.meta-tag {
  background-color: #f0f4ff;
  color: #3b82f6;
  padding: 6px 12px;
  border-radius: 20px;
  font-size: 14px;
  font-weight: 500;
}

/* 图片展示区 */
.image-gallery {
  margin-bottom: 48px;
}

.main-image {
  position: relative;
  width: 100%;
  height: 600px;
  overflow: hidden;
  border-radius: 8px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
  margin-bottom: 16px;
}

.main-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.3s;
  cursor: pointer;
}

.main-image img:hover {
  transform: scale(1.02);
}

.image-controls {
  position: absolute;
  bottom: 20px;
  left: 50%;
  transform: translateX(-50%);
  display: flex;
  align-items: center;
  background-color: rgba(0, 0, 0, 0.6);
  padding: 8px 16px;
  border-radius: 24px;
  color: white;
}

.control-button {
  background: none;
  border: none;
  color: white;
  cursor: pointer;
  padding: 4px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.control-button:hover {
  opacity: 0.8;
}

.image-indicator {
  margin: 0 16px;
  font-size: 14px;
}

.thumbnail-strip {
  display: flex;
  gap: 12px;
  overflow-x: auto;
  padding-bottom: 8px;
}

.thumbnail {
  width: 120px;
  height: 80px;
  border-radius: 4px;
  overflow: hidden;
  cursor: pointer;
  position: relative;
  flex-shrink: 0;
  transition: transform 0.2s;
}

.thumbnail:hover {
  transform: translateY(-2px);
}

.thumbnail.active {
  border: 3px solid #3b82f6;
}

.thumbnail img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

/* 案例详情 */
.case-details {
  margin-bottom: 60px;
}

.section-title {
  font-size: 24px;
  font-weight: 600;
  margin-bottom: 20px;
  color: #222;
  position: relative;
  padding-left: 16px;
}

.section-title::before {
  content: '';
  position: absolute;
  left: 0;
  top: 50%;
  transform: translateY(-50%);
  width: 4px;
  height: 24px;
  background-color: #3b82f6;
  border-radius: 2px;
}

.description {
  font-size: 16px;
  line-height: 1.8;
  color: #444;
  margin-bottom: 40px;
}

.detail-cards {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  gap: 20px;
}

.detail-card {
  padding: 24px;
  border-radius: 8px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.05);
  background-color: #f9fafc;
  transition: transform 0.3s, box-shadow 0.3s;
}

.detail-card:hover {
  transform: translateY(-4px);
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
}

.detail-card i {
  font-size: 24px;
  color: #3b82f6;
  margin-bottom: 12px;
}

.detail-card h3 {
  font-size: 18px;
  font-weight: 600;
  margin-bottom: 8px;
  color: #222;
}

.detail-card p {
  color: #666;
}

/* 相关案例 */
.related-cases {
  margin-bottom: 40px;
}

.related-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 24px;
}

.related-case-card {
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
  transition: transform 0.3s, box-shadow 0.3s;
  cursor: pointer;
}

.related-case-card:hover {
  transform: translateY(-6px);
  box-shadow: 0 12px 24px rgba(0, 0, 0, 0.1);
}

.related-image {
  height: 200px;
  overflow: hidden;
}

.related-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.5s;
}

.related-case-card:hover .related-image img {
  transform: scale(1.05);
}

.related-case-card h3 {
  font-size: 18px;
  font-weight: 600;
  color: #222;
  padding: 16px 16px 8px;
}

.related-location {
  display: flex;
  align-items: center;
  gap: 6px;
  padding: 0 16px 16px;
  color: #666;
  font-size: 14px;
}

/* 加载占位 */
.loading-placeholder {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 400px;
}

.loading-spinner {
  width: 40px;
  height: 40px;
  border: 4px solid #f3f3f3;
  border-top: 4px solid #3b82f6;
  border-radius: 50%;
  animation: spin 1s linear infinite;
  margin-bottom: 16px;
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

/* 灯箱 */
.lightbox {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1000;
  display: flex;
  align-items: center;
  justify-content: center;
}

.lightbox-backdrop {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.9);
}

.lightbox-content {
  position: relative;
  max-width: 90%;
  max-height: 90%;
  z-index: 1001;
}

.lightbox-content img {
  max-width: 100%;
  max-height: 90vh;
  object-fit: contain;
}

.lightbox-close {
  position: absolute;
  top: -40px;
  right: 0;
  background: none;
  border: none;
  color: white;
  font-size: 24px;
  cursor: pointer;
  padding: 8px;
}

.lightbox-prev,
.lightbox-next {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  background: rgba(255, 255, 255, 0.2);
  border: none;
  color: white;
  width: 50px;
  height: 50px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: background 0.3s;
}

.lightbox-prev:hover,
.lightbox-next:hover {
  background: rgba(255, 255, 255, 0.3);
}

.lightbox-prev {
  left: -80px;
}

.lightbox-next {
  right: -80px;
}

.lightbox-caption {
  position: absolute;
  bottom: -60px;
  left: 0;
  width: 100%;
  color: white;
  text-align: center;
}

.lightbox-caption h3 {
  font-size: 18px;
  margin-bottom: 8px;
}

/* 响应式调整 */
@media (max-width: 992px) {
  .case-title {
    font-size: 28px;
  }

  .main-image {
    height: 400px;
  }

  .lightbox-prev {
    left: -60px;
  }

  .lightbox-next {
    right: -60px;
  }
}

@media (max-width: 768px) {
  .case-detail-container {
    padding: 20px 16px;
  }

  .case-title {
    font-size: 24px;
  }

  .main-image {
    height: 300px;
  }

  .detail-cards {
    grid-template-columns: 1fr;
  }

  .related-grid {
    grid-template-columns: 1fr;
  }

  .lightbox-prev {
    left: 20px;
  }

  .lightbox-next {
    right: 20px;
  }
}
</style>