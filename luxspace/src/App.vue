<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',

}
</script>

<style>
.nav {
  width: 100%;
  height: 50px;
  line-height: 10px;
  background-color: rgb(216, 216, 216);
  display: flex;
  flex-direction: row;
  align-items: center;
  padding: 20px;
  padding-left: 20px;
  margin-bottom: 20px;
}

.nav a {
  color: black;
  text-decoration: none;
}

.btnn {
  width: 200px;
  background-color: pink;
  border-radius: 50px;
}

.mb-40 {
  margin-bottom: 40px;
}

.katalog {
  background-color: rgb(216, 216, 216);
}

.bg-img-katalog {
  padding: 10px;
  border-radius: 20px;
}

.button {
  width: 50px;
  border-radius: 10px;
}


</style>
