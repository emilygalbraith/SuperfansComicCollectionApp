<template>
  <div>
    <div id="start" v-if="!show">
      <router-link :to="{name: 'login'}">Login</router-link> |
      <router-link :to="{name: 'register'}">Register</router-link>
    </div>
    <div id="home" v-if="show">
      <h1>Welcome</h1>
      <p>You must be authenticated to see this</p>
      <!-- <router-link v-bind:to="{name: 'all-collections'}">View All Collections</router-link> |  -->
      <router-link v-bind:to="{name: 'profile'}">View Profile</router-link>
    </div>
    <collection-list />
  </div>
</template>

<script>
import CollectionList from '../components/CollectionList.vue'

export default {
  components: { CollectionList },
  name: "home",
  computed: {
    show() {
      return this.$store.state.show;
    }
  }
}
</script>

<style>
@import url('<link href="https://fonts.googleapis.com/css2?family=Comic+Neue:wght@300&family=Sacramento&display=swap" rel="stylesheet">');

h1 {
  text-align: center;
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
</style>