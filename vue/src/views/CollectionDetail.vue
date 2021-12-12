<template>
    <div>
        <h2>{{collection.collectionName}}</h2>
        <collection-statistics/>
        <comic-list id="collection" v-bind:collectionId="collection.collectionId"/>
    </div>
</template>

<script>
import comicService from '@/services/ComicService.js'
import ComicList from '../components/ComicList.vue';
import CollectionStatistics from '../components/CollectionStatistics.vue';

export default {
  components: { ComicList, CollectionStatistics },
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
#collection {
    display: flex;
    gap: 20px;
}
</style>