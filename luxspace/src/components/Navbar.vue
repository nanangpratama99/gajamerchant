<template>
    <nav class="navbar navbar-expand-sm bg-white navbar-dark justify-content-between" id="navbar-id">
        <div>
            <a class="navbar-brand mx-5" href="#">
                <!-- <img src="../assets/img/logo.png" alt="logo"> -->
            </a>
        </div>

        <div class="navbar-nav">
            <div class="nav-item d-flex">
                <div>
                    <router-link to="/merchant" class="nav-link text-dark">Merchant</router-link>
                </div>

                <div>
                    <router-link to="/ownerList" class="nav-link text-dark">Owner List</router-link>
                </div>

                <div>
                    <a class="nav-link text-dark" href="#">Delivery</a>
                </div>

                <div>
                    <router-link to="/shippingList" class="nav-link text-dark">Shipping List</router-link>
                </div>

                <div>
                    <img src="../assets/img/cart-icon.png" alt="keranjang">
                </div>
            </div>
        </div>
    </nav>
</template>

<script>
export default {
    name: 'NavbarsComponent'
}
</script>

<style></style>