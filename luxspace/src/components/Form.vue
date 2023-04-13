<template>
    <div class="row justify-content-center">
        <div class="col col-md-5 my-5">
            <form class="border rounded-sm border-primary p-5" @submit.prevent="inputShipping" id="form-checkout"
                v-show="!success">
                <h1 class="mb-5" align="center">Shipping Form</h1>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="first-name">First Name</label>
                        <input v-model="shippingData.first_name" placeholder="Enter your first name" type="text"
                            class="form-control" id="first-name" required>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="phone-number">Phone Number</label>
                        <input v-model="shippingData.phone_number" placeholder="Enter your phone number" type="number"
                            class="form-control" id="phone-number" required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="last-name">Last Name</label>
                        <input v-model="shippingData.last_name" placeholder="Enter your last name" type="text"
                            class="form-control" id="last-name" required>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="city">City</label>
                        <input v-model="shippingData.city" placeholder="Enter City" type="text" class="form-control"
                            id="city" required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="email">Email Addres</label>
                        <input v-model="shippingData.email" placeholder="Enter email" type="email" class="form-control"
                            id="email" required>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="postal-code">Postal Code</label>
                        <input v-model="shippingData.postal_code" placeholder="Enter postal code" type="text"
                            class="form-control" id="postal-code" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputAddress">Address</label>
                    <textarea v-model="shippingData.address" name="address" class="form-control" id="inputAddress" rows="4"
                        placeholder="Enter address" required></textarea>
                </div>


                <button type="submit" class="btn btn-primary" style="background-color: pink;">{{ buttonValue }}</button>
            </form>
            <SuccessForm v-show="success"></SuccessForm>
        </div>
    </div>
</template>

<script>
import shippingService from "../services/shippingService.js"
import SuccessForm from "./SuccessForm.vue"

export default {
    name: 'FormComponent',
    data() {
        return {
            shippingData: {
                "first_name": null,
                "last_name": null,
                "email": null,
                "phone_number": null,
                "city": null,
                "postal_code": null,
                "address": null
            },
            success: false,
            buttonValue: "Submit"
        }
    },
    methods: {
        inputShipping() {
            let data = this.shippingData;

            if (this.buttonValue === "Submit") {
                shippingService.create(data)
                    .then(response => {
                        console.log(response.data);
                        this.success = true;
                    })
                    .catch(e => {
                        console.log(e);
                    });
            } else {
                shippingService.updateShipping(data.id, data)
                    .then(response => {
                        console.log(response.data);
                        this.success = true;
                    })
                    .catch(e => {
                        console.log(e);
                    });
            }
        },
    },

    components: {
        SuccessForm
    },
    props: ["shippingDataProps"],
    watch: {
        'shippingDataProps'(newValue) {
            this.shippingData = newValue;
            console.log(this.shippingData);
            this.buttonValue = "Update"
        },
    }
}
</script>

<style></style>