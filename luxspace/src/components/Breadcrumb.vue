<template>
    <nav class="nav" id="icon-kursi">
        <router-link to="/" class="ml-5" href="#">Home /&nbsp;</router-link>

        <!-- detail -->
        <router-link to="/" v-show="breadLink == '/'">Office Room /&nbsp;</router-link>
        <router-link to="/" v-show="breadLink == '/'"><b>Detail</b></router-link>

        <!-- shipping -->
        <router-link to="/" v-show="breadLink == '/shipping'">Office Room /&nbsp;</router-link>
        <router-link to="/" v-show="breadLink == '/shipping'">Detail</router-link>
        <router-link to="/shipping" v-show="breadLink == '/shipping'">&nbsp;/ <b>Shipping</b></router-link>

        <!-- owner list -->
        <router-link to="/merchant" v-show="breadLink == '/ownerList'">Merchant</router-link>
        <router-link to="/ownerList" v-show="breadLink == '/ownerList'">&nbsp;/ <b>Shipping</b></router-link>

        <!-- merchant -->
        <router-link to="/merchant" v-show="breadLink == '/merchant'"><b>Merchant</b></router-link>

        <!-- shipping list -->
        <router-link to="/" v-show="breadLink == '/shippingList'">Office Room /&nbsp;</router-link>
        <router-link to="/" v-show="breadLink == '/shippingList'">Detail</router-link>
        <router-link to="/shippingList" v-show="breadLink == '/shippingList'">&nbsp;/ <b>Shipping List</b></router-link>
    </nav>
</template>

<script>
export default {
    name: 'BreadcrumbComponent',

    data() {
        return {
            breadLink: this.$route.path
        }
    }
}
</script>

<style></style>