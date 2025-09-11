<template>
  <Layout>
    <div class="gallery-section" v-if="title && photos.length">
      <div class="gallery-header">
        <div class="container">
          <h2 class="gallery-title">{{ title }}</h2>
          <p class="gallery-intro">{{ introduction }}</p>
        </div>
      </div>

      <div class="gallery-container">
        <div
            class="featured-image"
            :style="{ backgroundImage: 'url(' + photos[activePhoto] + ')' }"
        >
          <div class="navigation-controls">
            <button
                type="button"
                aria-label="Previous Photo"
                class="nav-button prev-button"
                @click="previousPhoto"
            >
              <span class="nav-icon">❮</span>
            </button>
            <button
                type="button"
                aria-label="Next Photo"
                class="nav-button next-button"
                @click="nextPhoto"
            >
              <span class="nav-icon">❯</span>
            </button>
          </div>
          <div class="photo-counter">{{ activePhoto + 1 }} / {{ photos.length }}</div>
        </div>

        <div class="thumbnail-container">
          <div
              v-for="(photo, index) in photos"
              :key="index"
              @click="activePhoto = index"
              :class="['thumbnail', { active: activePhoto === index }]"
              :style="{ backgroundImage: 'url(' + photo + ')' }"
          ></div>
        </div>
      </div>
    </div>
  </Layout>
</template>

<script>
import Layout from "@/components/common/Layout";

export default {
  name: "ProductDetailsView",
  components: { Layout },
  data() {
    return {
      title: '',
      introduction: '',
      activePhoto: 0,
      photos: []
    };
  },
  mounted() {
    this.getProductById(this.$route.params.productId);
    window.addEventListener("keydown", this.handleKeydown);
  },
  beforeDestroy() {
    window.removeEventListener("keydown", this.handleKeydown);
  },
  methods: {
    handleKeydown(event) {
      if (event.key === "ArrowLeft") this.previousPhoto();
      if (event.key === "ArrowRight") this.nextPhoto();
    },
    extractPhotos(data) {
      return Array.from({ length: 5 }, (_, i) => data['imageUrl' + (i + 1)])
          .filter((url, index, self) => url && self.indexOf(url) === index);
    },
    getProductById(typeDetailsId) {
      this.getRequest(`/findTypeDetailsByTypeDetailsId/${typeDetailsId}`).then(resp => {
        if (resp && resp.data && resp.data.data) {
          const temp = resp.data.data;
          this.title = temp.title;
          this.introduction = temp.introduction;
          this.photos = this.extractPhotos(temp);
        }
      });
    },
    nextPhoto() {
      this.activePhoto = (this.activePhoto + 1) % this.photos.length;
    },
    previousPhoto() {
      this.activePhoto = (this.activePhoto - 1 + this.photos.length) % this.photos.length;
    }
  }
};
</script>

<style scoped>
* {
  box-sizing: border-box;
  outline: none;
}

.gallery-section {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 40px 0;
  background-color: #f8f9fa;
}

.gallery-header {
  width: 100%;
  max-width: 1200px;
  text-align: center;
  margin-bottom: 40px;
  padding: 0 20px;
}

.gallery-title {
  font-size: 2.5rem;
  font-weight: 700;
  color: #333;
  margin-bottom: 16px;
  position: relative;
  display: inline-block;
}

.gallery-title:after {
  content: '';
  position: absolute;
  width: 60px;
  height: 4px;
  background-color: #59bcdb;
  bottom: -12px;
  left: 50%;
  transform: translateX(-50%);
  border-radius: 2px;
}

.gallery-intro {
  font-size: 1.1rem;
  color: #666;
  max-width: 800px;
  margin: 0 auto;
  line-height: 1.6;
}

.gallery-container {
  width: 100%;
  max-width: 1000px;
  display: flex;
  flex-direction: column;
  background-color: #fff;
  border-radius: 12px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  margin: 0 20px 40px;
}

.featured-image {
  width: 100%;
  padding-bottom: 60%;
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  position: relative;
  transition: all 0.3s ease;
}

.navigation-controls {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.nav-button {
  background: transparent;
  border: none;
  cursor: pointer;
  height: 100%;
  width: 80px;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: all 0.3s ease;
}

.prev-button {
  background: linear-gradient(to right, rgba(0, 0, 0, 0.4), transparent);
}

.next-button {
  background: linear-gradient(to left, rgba(0, 0, 0, 0.4), transparent);
}

.nav-icon {
  font-size: 2.5rem;
  color: white;
  text-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
  opacity: 0.7;
  transition: all 0.2s ease;
}

.nav-button:hover .nav-icon {
  opacity: 1;
  transform: scale(1.1);
}

.photo-counter {
  position: absolute;
  bottom: 20px;
  right: 20px;
  background-color: rgba(0, 0, 0, 0.6);
  color: white;
  padding: 6px 12px;
  border-radius: 20px;
  font-size: 0.9rem;
  font-weight: 500;
}

.thumbnail-container {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(120px, 1fr));
  grid-gap: 8px;
  padding: 16px;
  background-color: #fff;
}

.thumbnail {
  padding-bottom: 70%;
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  cursor: pointer;
  border-radius: 6px;
  border: 3px solid transparent;
  transition: all 0.2s ease;
  position: relative;
  overflow: hidden;
}

.thumbnail:hover {
  transform: translateY(-3px);
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
}

.thumbnail.active {
  border-color: #59bcdb;
}

.thumbnail.active:after {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(89, 188, 219, 0.3);
}

@media (max-width: 768px) {
  .gallery-title {
    font-size: 2rem;
  }

  .gallery-intro {
    font-size: 1rem;
  }

  .thumbnail-container {
    grid-template-columns: repeat(auto-fill, minmax(80px, 1fr));
  }

  .nav-icon {
    font-size: 2rem;
  }
}
</style>