<template>
    <div>
        <h1 class="text-center my-4">Owner List</h1>
        <table class="table">
            <thead class="thead-light">
                <tr>
                    <th scope="col">No</th>
                    <th scope="col">ID</th>
                    <th scope="col">Nama</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone Number</th>
                    <th scope="col">NPWP</th>
                    <th scope="col" class="text-center">Action</th>
                </tr>
            </thead>
            <tbody v-if="ownerData.length > 0">
                <tr v-for="(item, index) in ownerData" :key="item.id">
                    <th>{{ index + 1 }}</th>
                    <td>{{ item.id }}</td>
                    <td>{{ item.namaPemBis }}</td>
                    <td>{{ item.email }}</td>
                    <td>{{ item.kontakPemBis }}</td>
                    <td>{{ item.npwp }}</td>
                    <td class="text-center">
                        <button class="btn btn-sm btn-warning mr-2 text-white">Detail</button>
                        <button class="btn btn-sm btn-danger" @click="deleteOwnerFunc(item.id)">Delete</button>
                        <!-- <button class="btn btn-sm btn-danger" @click="deleteOwnerFunc(item.id)">Delete</button> -->
                    </td>
                </tr>
            </tbody>
            <tbody v-else>
                <tr>
                    <td colspan="7" class="text-center">
                        <h4 class="text-center msg-agt">Owner data is not found</h4>
                        <hr>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import ownerService from "../services/ownerService"

export default {
    name: 'OwnerListComp',

    methods: {
        getOwner() {
            ownerService.GetAll()
                .then(response => {
                    this.ownerData = response.data;
                    console.log(this.ownerData);
                })
                .catch(e => {
                    console.log(e);
                });
        },

        deleteOwnerFunc(id) {
            if (confirm("Apakah Anda Yakin?")) {
                ownerService.deleteOwner(id)
                    .then(response => {
                        console.log(response.data);
                        window.setInterval(() => {
                            location.reload();
                        }, 1000)
                    })
                    .catch(e => {
                        this.respons = e["request"]['status']
                        if (this.respons == 302) {
                            alert(`Data lainnya dengan Owner ID ${id} masih ada!`)
                        }
                        console.log(e);
                    });

            } else {
                alert("Hapus dibatalkan!")
            }
        }
    },

    mounted() {
        this.getOwner();
    },

    data() {
        return {
            ownerData: [],
            respons: null,
        }
    }
};
</script>

<style></style>