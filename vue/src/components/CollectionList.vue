<template>
    <div>
        <collection-display v-for="collection in collections" v-bind:key="collection.collectionId" 
                            v-bind:collection="collection" />
        <router-link :to="{ name: 'create-collection'}">Create A New Collection</router-link>  
    </div>
</template>

<script>
import CollectionDisplay from './CollectionDisplay.vue'
import comicService from '@/services/ComicService.js'

export default {
    name: 'collection-list',
    components: { CollectionDisplay },
    data() {
        return {
            collections: []
        }
    },
    created() {
        const currentUser = this.$store.state.user;
        comicService.getCollectionByUserId(currentUser.id).then(response => {
                this.collections = response.data;
            });
    }
}
</script>

<style>

</style>