<template>
    <div>
        <collection-display v-for="collection in collections" v-bind:key="collection.collectionId" 
                            v-bind:collection="collection" />  
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
            if (this.$route.name == 'home' && this.$store.state.show == false) {
                this.getAllPublicCollections();
            }
            if (this.$route.name == 'home' && this.$store.state.show == true) {
                this.retrieveAllCollections();
            }
            if (this.$route.name == 'profile') {
                this.getCurrentUserCollections();
            }
        }
    }
}
</script>

<style>

</style>