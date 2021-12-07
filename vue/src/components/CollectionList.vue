<template>
    <div>
        <collection-display v-for="collection in filteredCollections" v-bind:key="collection.collectionId" 
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
            filter: 0
        }
    },
    methods: {
        allCollections() {
            comicService.getAllCollections().then(response => {
                this.$store.state.collections = response.data;
            });
            this.filter = 0;
        },
        myCollection() {
            const currentUser = this.$store.state.user.currentUser;
            comicService.getCollectionByUserId(currentUser.id).then(response => {
                this.$store.state.collections = response.data;
            });
            this.filter = 1;
        },
        filteredCollections() {
            if (this.filter === 0) {
                return this.allCollections();
            } else {
                return this.myCollection();
            }
        }
    }
}
</script>

<style>

</style>