<template>
    <div>
        <Navbar></Navbar>
        <Breadcrumbs></Breadcrumbs>
        <div class="row justify-content-center">
            <div class="col-10">
                <OwnerListTable></OwnerListTable>
            </div>
        </div>
        <Footer class="mt-4"></Footer>
        <Copyright></Copyright>
    </div>
</template>

<script>
import Navbar from "../components/Navbar.vue"
import Breadcrumbs from "../components/Breadcrumb.vue"
import Footer from "../components/Footer.vue"
import Copyright from "../components/Copyright.vue"
import OwnerListTable from "../components/OwnerListTable.vue"

export default {
    name: "OwnerList",
    components: {
        Navbar,
        Breadcrumbs,
        Footer,
        Copyright,
        OwnerListTable,
    },
}
</script>

<style></style>