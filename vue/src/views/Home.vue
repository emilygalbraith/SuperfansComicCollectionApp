<template>
  <div class="background">
    <div class="home">

        <h1>Home</h1>
        <p>You must be authenticated to see this</p>
      
    </div>
    <!-- <router-link v-bind:to="{name: 'all-collections'}">View All Collections</router-link> |  -->
    <router-link v-bind:to="{name: 'profile'}">View Profile</router-link>
    <div>
      <collection-list />
    </div>
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

img {
  width: 100%;
}
h1 {
  text-align: center;
}
img {
  width: 100%;
}
.header {
width: 100%;
margin: none;
padding: none;
margin-block-start: -2%;
}
h1 {
  font-family: 'Comic Neue', cursive;
  font-size: 150%;
  color: white;
  margin-top: 0px;
}
h1 {
  padding-top: 4%;
}
/* .background {
  background-color: #071926;
} */
</style>