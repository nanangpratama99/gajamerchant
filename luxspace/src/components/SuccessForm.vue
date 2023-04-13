<template>
    <div class="card-body">
        <h5 class="card-title">Success!</h5>
        <p class="card-text">Your Data Has Been Submitted!</p>
        <router-link to="/" class="btn">Back</router-link>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.border-color-pink {
    border: solid 2px #F9CADA;
}

.bg-color-pink {
    background-color: #F9CADA;
}

.card-body {
    border-radius: 20px;
    background: white;
}

.btn {
    background: green;
    padding: 5px 20px;
    color: white;
}
</style>