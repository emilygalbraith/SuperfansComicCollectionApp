<template>
    <div>
        <h2>{{collection.collectionName}}</h2>
        <comic-list v-bind:collectionId="collection.collectionId" />
    </div>
</template>

<script>
import comicService from '@/services/ComicService.js'
import ComicList from '../components/ComicList.vue';

export default {
  components: { ComicList },
    name: 'collection-detail',
    data() {
        return {
            collection: {}
        }
    },
    created() {
        comicService.getCollectionById(this.$route.params.collectionId).then(response => {
            if (response.status === 200) {
                this.collection = response.data;
            }
        });
    }
}
</script>

<style>

</style>