<template>
    <div class="row justify-content-center body">
        <div class="col col-md-6 my-5">

            <!-- form 1 -->
            <form class="form shadow p-5" v-show="currentStep == 1" @submit.prevent="nextStep">
                <h2 class="mb-5 text-dark" align="center">Owner Information</h2>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="nama-pem-bis">Pemilik Bisnis</label>
                        <input v-model="merchantData.namaPemBis" type="text" class="form-control " id="nama-pem-bis"
                            placeholder="Nama Pemilik Bisnis" required />
                    </div>
                    <div class="form-group col-md-6">
                        <label for="kontakPemBis">No Kontak Pebisnis</label>
                        <input v-model="merchantData.kontakPemBis" type="number" class="form-control" id="kontakPemBis"
                            placeholder="No kontak pemilik bisnis" required />
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="ownerEmail">Email</label>
                        <input v-model="merchantData.email" type="email" class="form-control" id="ownerEmail"
                            placeholder="Email" required />
                    </div>
                    <div class="form-group col-md-6">
                        <label for="npwp">NPWP</label>
                        <input v-model="merchantData.npwp" type="text" class="form-control" id="npwp" placeholder="NPWP"
                            required />
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="f-ktp" class="lable-foto">Foto KTP</label>
                            <input type="file" required @change="handleFileUpload('fKtp', $event)" class="form-control"
                                id="f-ktp" />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="fSelfie" class="lable-foto">Foto Selfie KTP</label>
                            <input type="file" required @change="handleFileUpload('fSelfie', $event)" class="form-control"
                                id="fSelfie" />
                        </div>
                    </div>
                </div>
                <div class="d-flex flex-row justify-content-end">
                    <button type="submit" class="btn">Next</button>
                </div>
            </form>
            <!-- end form 1 -->

            <!-- form 2 -->
            <form class=" p-5" v-show="currentStep == 2" @submit.prevent="nextStep">
                <h1 class="mb-5" align="center">Merchant Information</h1>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="brand">Nama Brand</label>
                        <input v-model="merchantData.brand" type="text" class="form-control" id="brand"
                            placeholder="Nama Brand" required />
                    </div>
                    <div class="form-group col-md-6">
                        <label for="emailBis">Email Bisnis</label>
                        <input v-model="merchantData.emailBis" type="email" class="form-control" id="emailBis"
                            placeholder="Email Bisnis" required />
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="jmlhMerch">Jumlah Merchant</label>
                            <input v-model="merchantData.jmlhMerch" type="number" class="form-control" id="jmlhMerch"
                                placeholder="Jumlah Merchant" required />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="kategori-merchant">Kategori Merchant</label>
                            <select id="kategori-merchant" class="form-control" v-model="merchantData.kategoriMerch"
                                required>
                                <option selected disabled value="">Choose...</option>
                                <option id="food">Food & Baverage</option>
                                <option id="shopping">Shopping</option>
                                <option id="fashion">Fashion & Acc</option>
                                <option id="groceries">Groceries</option>
                                <option id="personal">Personal Service</option>
                                <option id="automotive">Automotive</option>
                                <option id="donasi">Donasi</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="lable-foto" for="fLogo">Logo Brand</label>
                            <input type="file" required @change="handleFileUpload('fLogo', $event)" class="form-control"
                                id="fLogo" />
                        </div>
                        <div class="form-group col-md-6">
                            <label class="lable-foto" for="fMerchant">Foto Merchant</label>
                            <input type="file" required @change="handleFileUpload('fMerchant', $event)" class="form-control"
                                id="fMerchant" />
                        </div>
                    </div>
                </div>
                <div class="form-group">

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="kota" class="form-label">Kota</label>
                            <input class="form-control" v-model="merchantData.kota" list="datalistOptions" id="kota"
                                placeholder="Type to search..." required>
                            <datalist id="datalistOptions">
                                <option id="jakarata">Jakarta</option>
                                <option id="bandung">Bandung</option>
                                <option id="tangerang">Tangerang</option>
                                <option id="tasik">Tasik</option>
                                <option id="lampung">Lampung</option>
                            </datalist>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="kodePos" class="form-label">Kode Pos</label>
                            <input class="form-control" type="number" v-model="merchantData.kodePos" list="detailKodePos"
                                id="kodePos" placeholder="Type to search..." required>
                            <datalist id="detailKodePos">
                                <option id="15710">15710</option>
                                <option id="13721">13721</option>
                                <option id="14124">14124</option>
                                <option id="16729">16729</option>
                                <option id="46106">46106</option>
                            </datalist>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="alamat-bisnis">Alamat Lengkap Bisnis</label>
                    <textarea v-model="merchantData.alamat" class="form-control" id="alamat-bisnis" rows="3"
                        placeholder="Alamat Lengkap" required></textarea>
                </div>
                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn-back" @click.prevent="previousStep">Back</button>
                    <button type="submit" class="btn">Next</button>
                </div>
            </form>
            <!-- end form 2 -->

            <!-- form 3 -->
            <form class="p-5" v-show="currentStep == 3" @submit.prevent="inputShipping">
                <h1 class="mb-5" align="center">Bank Account</h1>

                <div class="form-row mt-5">
                    <div class="form-group col-md-12">
                        <label for="noRek">Nomor Rekening</label>
                        <input v-model="merchantData.noRek" type="number" class="form-control" id="noRek"
                            placeholder="Nomor Rekening" required />
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="namaPemRek">Nama Pemilik Rekening</label>
                        <input v-model="merchantData.namaPemRek" type="text" class="form-control" id="namaPemRek"
                            placeholder="Pemilik Rekening" required />
                    </div>
                    <div class="form-group col-md-6">
                        <label for="jenisBank">Bank</label>
                        <select id="jenisBank" class="form-control" v-model="merchantData.bank" required>
                            <option selected disabled value="">Choose...</option>
                            <option id="madiri">Mandiri</option>
                            <option id="bca">BCA</option>
                            <option id="bri">BRI</option>
                        </select>
                    </div>
                </div>

                <div class="d-flex justify-content-start mb-3">
                    <label>
                        <input type="checkbox" name="terms" required>
                        Saya setuju dengan syarat dan ketentuan
                    </label>
                </div>

                <div class="d-flex justify-content-between">
                    <button class="btn-back" @click.prevent="previousStep">Back</button>
                    <button type="submit" class="btn">Submit</button>
                </div>


            </form>
            <!-- end form 3 -->

            <div v-show="currentStep == 0">
            </div>

            <SuccessForm v-show="success"></SuccessForm>
        </div>
    </div>
</template>

<script>
import shippingService from "../services/shippingService.js"
import ownerService from "../services/ownerService.js"
// import merchantService from "../services/merchantService.js"
// import bankService from "../services/bankService.js"
import SuccessForm from "./SuccessForm.vue"

export default {
    name: 'FormMercComponent',
    data() {
        return {
            currentStep: 1,

            // ownerData: {
            //     "namaPemBis": null,
            //     "kontakPemBis": null,
            //     "email": null,
            //     "npwp": null
            // },

            // merchantData: {
            //     "ownerId": null,
            //     "brand": null,
            //     "emailBis": null,
            //     "kota": "",
            //     "kodePos": null,
            //     "kategoriMerch": "",
            //     "jmlhMerch": null,
            //     "alamat": null,
            // },

            // bankData: {
            //     "ownerId": null,
            //     "bank": "",
            //     "namaPemRek": null,
            //     "noRek": null,
            // },


            merchantData: {
                "namaPemBis": null,
                "kontakPemBis": null,
                "email": null,
                "npwp": null,
                "brand": null,
                "emailBis": null,
                "kota": "",
                "kodePos": null,
                "kategoriMerch": "",
                "jmlhMerch": null,
                "alamat": "a",
                "bank": "",
                "namaPemRek": null,
                "noRek": null,
                "fmerchant": null,
                "fselfie": null,
                "flogo": null,
                "fktp": null
            },

            idOwner: null,

            image1: null,
            image2: null,
            image3: null,
            image4: null,

            success: false,
            buttonValue: "Submit"
        }
    },

    methods: {
        nextStep() {
            this.currentStep++;
            document.getElementById("navbar-id").scrollIntoView({ behavior: 'smooth' })
        },
        previousStep() {
            this.currentStep--;
        },
        handleFileUpload(fieldName, event) {
            if (event.target.files && event.target.files.length > 0) {
                let file = event.target.files[0];

                if (fieldName === 'fKtp') {
                    // console.log(file);
                    this.image1 = file;
                } else if (fieldName === 'fSelfie') {
                    // console.log(file);
                    this.image2 = file;
                } else if (fieldName === 'fLogo') {
                    // console.log(file);
                    this.image3 = file;
                } else if (fieldName === 'fMerchant') {
                    // console.log(file);
                    this.image4 = file;
                }
            }
        },
        inputShipping() {
            let data = this.shippingData;
            let merchantData = this.merchantData;
            let idOwner = this.idOwner;
            let image1 = this.image1;
            let image2 = this.image2;
            let image3 = this.image3;
            let image4 = this.image4;

            let fotoK = image1.name;
            let fotoS = image2.name;
            let fotoL = image3.name;
            let fotoM = image4.name;

            if (this.buttonValue === "Submit") {
                // Post Merchant data
                merchantData.fktp = fotoK;
                merchantData.fselfie = fotoS;
                merchantData.flogo = fotoL;
                merchantData.fmerchant = fotoM;
                ownerService.saveMerchant(merchantData)
                    .then(response => {
                        console.log(response.data.id);
                        console.log(response.data);
                        console.log(response.status);
                        // Upload Image data
                        idOwner = response.data.id;
                        console.log(image1);
                        console.log(image2);
                        console.log(image3);
                        console.log(image4);

                        ownerService.uploadImage(image1, idOwner)
                            .then(response => {
                                console.log(response.status);
                                console.log("uploading-KTP");
                            })
                            .catch(e => {
                                console.log(e);
                            });

                        ownerService.uploadImage(image2, idOwner)
                            .then(response => {
                                console.log(response.status);
                                console.log("uploading-Selfie-KTP");
                            })
                            .catch(e => {
                                console.log(e);
                            });

                        ownerService.uploadImage(image3, idOwner)
                            .then(response => {
                                console.log(response.status);
                                console.log("uploading-Brand-Logo");
                            })
                            .catch(e => {
                                console.log(e);
                            });

                        ownerService.uploadImage(image4, idOwner)
                            .then(response => {
                                console.log(response.status);
                                console.log("uploading-Merchant");
                            })
                            .catch(e => {
                                console.log(e);
                            });

                        this.currentStep = 0;
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
}
</script>

<style scoped>
::-webkit-file-upload-button {
    display: none;
}

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}

.lable-foto {
    border-style: dashed;
    border-color: rgb(211, 211, 211);
    display: inline-block;
    padding: 5px 30px;
    cursor: pointer;
    border-radius: 5px;
    margin-top: 5px;
    border-radius: 10px;
}

.lable-foto:hover {
    background-color: rgb(38, 146, 38);
    color: white;
    border-color: white;
}

form {
    border-radius: 25px;
    background: white;
}

input {
    background: rgb(235, 234, 234);
    border-radius: 10px;
}

.btn {
    background-color: rgb(38, 146, 38);
    color: white;
    padding: 7px 20px;
    border-radius: 10px;
}

.btn-back {
    background-color: orange;
    color: white;
    padding: 7px 20px;
    border-radius: 10px;
    border: none;
}

.btn:hover {
    color: white;
}

.body {
    background-color: #94AF9F;
}
</style>