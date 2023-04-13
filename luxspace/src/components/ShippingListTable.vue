<template>
    <div>
        <h1 class="text-center my-4">Shipping List Table</h1>
        <table class="table">
            <thead class="thead-light">
                <tr>
                    <th scope="col">No</th>
                    <th scope="col">ID</th>
                    <th scope="col">Nama</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone Number</th>
                    <th scope="col">City</th>
                    <th scope="col">Alamat</th>
                    <th scope="col">Postal Code</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody v-if="shippingData.length > 0">
                <tr v-for="(item, index) in shippingData" :key="item.id">
                    <th>{{ index + 1 }}</th>
                    <td>{{ item.id }}</td>
                    <td>{{ item.first_name + " " + item.last_name }}</td>
                    <td>{{ item.email }}</td>
                    <td>{{ item.phone_number }}</td>
                    <td>{{ item.city }}</td>
                    <td>{{ item.address }}</td>
                    <td>{{ item.postal_code }}</td>
                    <td class="d-flex">
                        <button class="btn btn-sm btn-warning mr-2 text-white"
                            @click="$emit('updateShippingFunc', item)">Update</button>
                        <button class="btn btn-sm btn-danger" @click="deleteShippingFunc(item.id)">Delete</button>
                    </td>
                </tr>
            </tbody>
            <tbody v-else>
                <tr>
                    <td colspan="9" class="text-center">
                        <h4 class="text-center msg-agt">Shipping data is not found</h4>
                        <hr>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import shippingService from "../services/shippingService"

export default {
    methods: {
        getShipping() {
            shippingService.getAll()
                .then(response => {
                    this.shippingData = response.data;
                    console.log(this.shippingData);
                })
                .catch(e => {
                    console.log(e);
                });
        },

        deleteShippingFunc(id) {
            if (confirm("Apakah Anda Yakin?")) {
                shippingService.deleteShipping(id)
                    .then(response => {
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });
                window.setInterval(() => {
                    location.reload();
                }, 1000)

            } else {
                alert("Hapus dibatalkan!")
            }
        }
    },

    mounted() {
        this.getShipping();
    },

    data() {
        return {
            shippingData: [],
        }
    }
};
</script>

<style></style>