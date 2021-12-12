<template>
  <div>
    <div id="start" v-if="!show">
      <router-link :to="{name: 'login'}">Login</router-link> |
      <router-link :to="{name: 'register'}">Register</router-link>
      <h2>All Public Collections:</h2>
    </div>
    <div id="home" v-if="show">
      <h1>Welcome</h1>
      <p>You must be authenticated to see this</p>
      <!-- <router-link v-bind:to="{name: 'all-collections'}">View All Collections</router-link> |  -->
      <router-link v-bind:to="{name: 'profile'}">View Profile</router-link>
      <h2>All Collections:</h2>
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

h1 {
  text-align: center;
}
h1 {
  font-size: 150%;
  color: white;
  margin-top: 0px;
  padding-top: 4%;
}
h2 {
  color: white;
}
p {
  color: white;
}
a:link {
  color: white;
  text-decoration: none;
}
a:visited {
  color: lightsteelblue;
}
a:hover {
  color: #dbb702;
}
</style>