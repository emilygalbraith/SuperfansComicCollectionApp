<template>
<div class="wrapper">
  <div class="home">
    <div class="header"> <img src="https://blogger.googleusercontent.com/img/a/AVvXsEjWh3P6u-ytyvYQe3Q2B5cXXCulnHsallroZ5Nr_xNu7pz7rA5CXDSwSeX3ZfY-16aZ0qVHMsni8WFKotXAlujWTqHji9OVZiJ2m7YObpuv_PI2pTBuvS8VZ16CzJgH3K9knqhY1awNGpDXWmpv6F5jwJTwY0yWrFx-GTzmIAF2-Qzg7rW8CSh-ygzVlQ=s2870"
alt="imgheader" class="imgheader"> </div>
<div id="bodypage-corpo">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
<<<<<<< HEAD
    <router-link v-bind:to="{name: 'all-collections'}">View All Collections</router-link>
  </div>
  </div>
=======
    <!-- <router-link v-bind:to="{name: 'all-collections'}">View All Collections</router-link> |  -->
    <router-link v-bind:to="{name: 'profile'}">View Profile</router-link>
    <collection-list />
>>>>>>> c7fe2f9969b9eab2dd6d50ffd452d9e59ec98af2
  </div>
</template>

<script>
import CollectionList from '../components/CollectionList.vue';
export default {
  components: { CollectionList },
  name: "home"
};
</script>


<style scoped>
@import url('<link href="https://fonts.googleapis.com/css2?family=Comic+Neue:wght@300&family=Sacramento&display=swap" rel="stylesheet">');
.wrapper {
  display: grid;
  grid-template-columns: 80%;
  justify-content: center;
}
img {
  width: 100%;
}
#bodypage-corpo {
  color: aliceblue;
  background-color: #071926;
  width: 100%;
  height: 148%;
  margin-block-start: -1%;
}
</style>