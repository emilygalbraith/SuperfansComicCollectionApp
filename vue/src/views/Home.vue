<template>
    <div>
        <router-link :to="{name: 'login'}">Login</router-link> |
        <router-link :to="{name: 'register'}">Register</router-link>
        <collection-list />
    </div>
</template>

<script>
import CollectionList from '../components/CollectionList.vue'

export default {
  components: { CollectionList },

}
</script>

<style>

</style>