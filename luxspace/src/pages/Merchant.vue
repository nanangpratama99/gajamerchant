<template>
    <div>
        <Navbar>
        </Navbar>

        <Form>
        </Form>

        <SuccessForm class="d-none">
        </SuccessForm>

    </div>
</template>

<script>
import Form from '../components/FormMerchant.vue';
import Navbar from '../components/Navbar.vue';
import SuccessForm from "../components/SuccessForm.vue"

export default {
    name: 'FormMerchant',
    components: {
      Form, Navbar, SuccessForm
    }
}
</script>

<style></style>