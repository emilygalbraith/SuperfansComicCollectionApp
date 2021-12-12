<template>
  <div id="statistics-display">
    <div id="superhero">
      <h3>Top 5 Superheroes in Collection:</h3>
      <p v-for="superhero in superheroStats" v-bind:key="superhero.heroName">
        {{ superhero.heroName }}: {{ superhero.occurrences }}
      </p>
    </div>
    <div id="publisher">
      <h3>Top 5 Publishers in Collection:</h3>
      <p v-for="publisher in publisherStats" v-bind:key="publisher.publisherName">
        {{ publisher.publisherName }}: {{ publisher.occurrences }}
      </p>
    </div>
    <div id="series">
      <h3>Top 5 Series in Collection:</h3>
      <p v-for="series in seriesStats" v-bind:key="series.seriesName">
        {{ series.seriesName }}: {{ series.occurrences }}
      </p>
    </div>
  </div>
</template>

<script>
import comicService from "@/services/ComicService.js";
export default {
  name: "collection-statistics",
  data() {
    return {
      superheroStats: [],
      publisherStats: [],
      seriesStats: [],
    };
  },
  created() {
    this.getSuperheroStats();
    this.getPublisherStats();
    this.getSeriesStats();
  },
  methods: {
    getSuperheroStats() {
      comicService
        .getSuperheroCollectionStats(this.$route.params.collectionId)
        .then((response) => {
          if (response.status === 200) {
            this.superheroStats = response.data;
            this.superheroStats.sort((a, b) => b.occurrences - a.occurrences);
            this.superheroStats.splice(6);
          }
        });
    },

    getPublisherStats() {
      comicService
        .getPublisherCollectionStats(this.$route.params.collectionId)
        .then((response) => {
          if (response.status === 200) {
            this.publisherStats = response.data;
          }
        });
    },

    getSeriesStats() {
      comicService
        .getSeriesCollectionStats(this.$route.params.collectionId)
        .then((response) => {
          if (response.status === 200) {
            this.seriesStats = response.data;
          }
        });
    },
  },
};
</script>

<style>
#statistics-display {
  display: flex;
  flex-direction: column;
}
#superhero {
    margin-bottom: 40px;
}
#publisher {
    margin-bottom: 40px;
}
h3 {
    color: white;
    text-decoration: underline;
    font-weight: bold;
}

</style>