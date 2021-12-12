<template>
  <div id="statistics-display">

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
    methods: {
        getSuperheroStats() {
            comicService.getSuperheroCollectionStats(this.$route.params.collectionId).then( response => {
                if(response.status === 200) {
                    this.superheroStats = response.data;
                }
            })
        }
    }

}
</script>

<style>

</style>