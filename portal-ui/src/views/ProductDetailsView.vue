<template>
  <Layout>
    <div class="gallery-box" v-if="title && photos.length">
      <div class="layout-container">
        <div class="solution-page">
          <div class="container">
            <h2>{{ title }}</h2>
            <p>{{ introduction }}</p>
          </div>
        </div>
      </div>

      <div class="gallery">
        <div
            class="active-photo"
            :style="{ backgroundImage: 'url(' + photos[activePhoto] + ')' }"
        >
          <button
              type="button"
              aria-label="Previous Photo"
              class="previous"
              @click="previousPhoto"
          >
            ◀
          </button>
          <button
              type="button"
              aria-label="Next Photo"
              class="next"
              @click="nextPhoto"
          >
            ▶
          </button>
        </div>
        <div class="thumbnails">
          <div
              v-for="(photo, index) in photos"
              :key="index"
              @click="activePhoto = index"
              :class="{ active: activePhoto === index }"
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

.gallery-box {
  display: flex;
  flex-direction: column;
  align-items: center;
  overflow: auto;
  text-align: center;
  width: 100%;
}

.gallery-box .gallery {
  width: 100%;
  max-width: 900px;
  display: flex;
  flex-direction: column;
  background-color: #fff;
  padding: 8px;
  border-radius: 8px;
  margin-bottom: 30px;
}

.gallery-box .gallery .active-photo {
  width: 100%;
  padding-bottom: 65%;
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  position: relative;
  border: 2px solid #fff;
  margin-bottom: 10px;
}

.gallery-box .gallery .active-photo button {
  border: none;
  background: transparent;
  font-size: 30px;
  color: #59bcdb;
  opacity: 0.5;
  cursor: pointer;
  position: absolute;
  top: 0;
  height: 100%;
  width: 15%;
  transition: opacity 0.2s;
}

.gallery-box .gallery .active-photo button:hover {
  opacity: 0.9;
}

.gallery-box .gallery .active-photo .previous {
  left: 0;
  background: linear-gradient(to right, rgba(0, 0, 0, 0.3), transparent);
}

.gallery-box .gallery .active-photo .next {
  right: 0;
  background: linear-gradient(to left, rgba(0, 0, 0, 0.3), transparent);
}

.gallery-box .gallery .thumbnails {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(90px, 1fr));
  grid-gap: 6px;
}

.thumbnails div {
  border: 2px solid #fff;
  outline: 2px solid #fff;
  cursor: pointer;
  padding-bottom: 65%;
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  transition: outline-color 0.3s, opacity 0.3s;
}

.thumbnails .active {
  outline-color: #59bcdb;
  opacity: 0.6;
}
</style>
