<template>
    <div>
        <collection-list />
        <router-link :to="{ name: 'create-collection'}">Create A New Collection</router-link>
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