<template>
    <div class="row mx-5 mb-5 mt-5" id="icon-kursi">
        <!-- pilihan -->
        <div class="col-2 d-flex flex-column justify-content-between">
            <div>
                <a href="#"><img src="../assets/img/side-1.png" class="rounded-circle" alt="kursi1" /></a>
            </div>
            <div>
                <a href="#"><img src="../assets/img/side-2.png" class="rounded-circle" alt="kursi2" /></a>
            </div>
            <div>
                <a href="#"><img src="../assets/img/side-1.png" class="rounded-circle" alt="kursi3" /></a>
            </div>
            <div>
                <a href="#"><img src="../assets/img/side-3.png" class="rounded-circle" alt="kursi4" /></a>
            </div>
        </div>

        <!-- gambar kursi -->
        <div class="col-6">
            <img :src="require('@/assets/img/' + imageLink + '.png')" alt="kursi" class="img" />
        </div>

        <!-- isi -->
        <div class="col-4">
            <div class="mb-40">
                <h2>Chair Thatty</h2>
                <p>IDR 12.000.000</p>
                <router-link to="/shipping">
                    <button type="submit" class="btn">
                        <img src="../assets/img/cart-icon.png" alt="keranjang" />&nbsp;&nbsp; <b>Add to Chart</b>
                    </button>
                </router-link>
            </div>

            <div>
                <hr />
                <h4>About the product</h4>
                <p>
                    Tailored to a lever of perfection synonymous with that of a Savile Row
                    suit and with understated quality in the detail, Jetty has been
                    influenced by timeless 1950s style.
                </p>
                <p>
                    Providing a subtle nod to the past, Jetty also provides a perfect
                    solution for the way we work today. A comprehensive product family,
                    Jetty features a variety of elegant chairs and sofas.
                </p>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "GalleryComponent",
    props: ["imageLink"],
};
</script>

<style scoped>
button {
    background-color: pink;
    border-radius: 10px;
}

.img {
    height: 609px;
    width: 560px;
}
</style>