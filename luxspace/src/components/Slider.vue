<template>
    <div class="p-5 mt-5" id="der">
        <h3>Completed Your Room</h3>
        <h3>With What We Designed</h3>
        <div class="d-flex justify-content-between mt-4">
            <Card v-for="(item, index) in arrCardTitle" :key="index" :card-title="item"
                :card-price="arrCardPrice[index]" :card-image="arrCardImage[index]" @changePictures="changePictureFunc">
                ></Card>
        </div>
    </div>
</template>

<script>
import Card from './Card.vue';

export default {
    name: 'SliderComponent',
    components: {
        Card
    },

    methods: {
        changePictureFunc: function (cardImage) {
            this.$emit('changeImg', cardImage)
        }
    },

    data() {
        return {
            arrCardTitle: ["Cangkir Mauttie", "Saman Kakka", "Lino Dino", "Syail Ammeno"],
            arrCardPrice: ["89.300.000", "14.500.000", "22.000.000", "12.000.000"],
            arrCardImage: ["chair-4", "chair-3", "chair-2", "chair-1"]
        }
    }
}
</script>

<style scoped>
#der {
    background-color: rgb(216, 216, 216);
}
</style>