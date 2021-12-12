<template>
  <div id="statistics-display">
      <div id="superhero"></div>
      <div id="publisher"></div>
      <div id="series"></div>
  </div>
</template>

<script>
import comicService from '@/services/ComicService.js'
export default {
    name: "collection-statistics",
    data() {
        return {
            superheroStats: [],
            publisherStats: [],
            seriesStats: [],
        }
    },
    created() {
        this.getSuperheroStats();
        this.getPublisherStats();
        this.getSeriesStats();
    },
    methods: {
        getSuperheroStats() {
            comicService.getSuperheroCollectionStats(this.$route.params.collectionId).then( response => {
                if(response.status === 200) {
                    this.superheroStats = response.data;
                }
            });
        },

        getPublisherStats() {
            comicService.getPublisherCollectionStats(this.$route.params.collectionId).then( response => {
                if(response.status === 200) {
                    this.publisherStats = response.data;
                }
            });
        },

        getSeriesStats() {
            comicService.getSeriesCollectionStats(this.$route.params.collectionId).then( response => {
                if(response.status === 200) {
                    this.seriesStats = response.data;
                }
            });
        }
    }

}
</script>

<style>
#statistics-display{
    display: flex;
}
</style>