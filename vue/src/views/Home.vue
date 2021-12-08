<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <!-- <router-link v-bind:to="{name: 'all-collections'}">View All Collections</router-link> |  -->
    <router-link v-bind:to="{name: 'profile'}">View Profile</router-link>
    <collection-list />
  </div>
</template>

<script>
import CollectionList from '../components/CollectionList.vue';
export default {
  components: { CollectionList },
  name: "home"
};
</script>
