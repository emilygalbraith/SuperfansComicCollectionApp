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
        this.showCollections();
    },
    methods: {
        retrieveAllCollections() {
            comicService.getAllCollections().then(response => {
                if (response.status === 200) {
                    this.collections = response.data;
                }
            });
        },
        getAllPublicCollections() {
            comicService.getPublicCollections().then(response => {
                if (response.status === 200) {
                    this.collections = response.data;
                }
            });
        },
        getCurrentUserCollections() {
            const currentUser = this.$store.state.user;
            comicService.getCollectionByUserId(currentUser.id).then(response => {
                if (response.status === 200) {
                    this.collections = response.data;
                }
            });
        },
        showCollections() {
            if (this.$route.name === 'login' || this.$route.name === 'register') {
                this.getAllPublicCollections();
            }
            if (this.$store.state.user != null) {
                this.getCurrentUserCollections();
            }
        }
    }
}
</script>

<style>

</style>