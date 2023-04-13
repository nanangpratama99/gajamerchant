<template>
    <div>
        <Navbar>
        </Navbar>

        <Breadcrumb>
        </Breadcrumb>

        <Form>
        </Form>

        <SuccessForm class="d-none">
        </SuccessForm>

        <Footer>
        </Footer>

        <Copyright>
        </Copyright>
    </div>
</template>

<script>
import Copyright from '../components/Copyright.vue';
import Breadcrumb from '../components/Breadcrumb.vue';
import Footer from '../components/Footer.vue';
import Form from '../components/Form.vue';
import Navbar from '../components/Navbar.vue';
import SuccessForm from "../components/SuccessForm.vue"

export default {
    name: 'FormShipping',
    components: {
        Copyright, Footer, Form, Navbar, Breadcrumb, SuccessForm
    }
}
</script>

<style>

</style>