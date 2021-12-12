<template>
    <div>
        <h2>{{collection.collectionName}}</h2>
        <div id="collection-detail">
        <comic-list id="collection" v-bind:collectionId="collection.collectionId"/>
        <collection-statistics id="stats"/>
        </div>
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
h2{
    text-align: center;
}
#collection {
    display: flex;
    gap: 20px;
}
#collection-detail{
    display: grid;
    grid-template-columns: 3fr 1fr;
}
</style>