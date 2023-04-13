<template>
  <div>
    <Navbar></Navbar>
    <Breadcrumb></Breadcrumb>
    <Gallery :imageLink="img"></Gallery>
    <Slider @changeImg="fromSlider"></Slider>
    <Footer></Footer>
    <Copyright></Copyright>
  </div>
</template>
  
<script>
import Navbar from '../components/Navbar.vue';
import Breadcrumb from "../components/Breadcrumb.vue";
import Gallery from '../components/Gallery.vue';
import Slider from '../components/Slider.vue';
import Footer from '../components/Footer.vue';
import Copyright from '../components/Copyright.vue';

export default {
  name: 'DetailPage',

  components: {
    Navbar,
    Breadcrumb,
    Gallery,
    Slider,
    Footer,
    Copyright
  },

  data() {
    return {
      img: "chair"
    }
  },

  methods: {
    fromSlider: function (Image) {
      this.img = Image,
        document.getElementById("icon-kursi").scrollIntoView({ behavior: 'smooth' })
    }
  }
}
</script>
  
<style>

</style>
  