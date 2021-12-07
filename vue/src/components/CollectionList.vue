<template>
    <div>
        <collection-display v-for="collection in allCollections" v-bind:key="collection.collectionId" v-bind:collection="collection" />
    </div>
</template>

<script>
import CollectionDisplay from './CollectionDisplay.vue'
import comicService from '@/services/ComicService.js'

export default {
    name: 'collection-list',
    components: { CollectionDisplay },
    methods: {
        allCollections() {
            comicService.getAllCollections().then(response => {
                this.$store.state.collections = response.data;
            });
        }
    }
}
</script>

<style>

</style>