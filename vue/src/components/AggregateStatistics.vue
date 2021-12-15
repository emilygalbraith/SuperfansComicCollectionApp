<template>
  <div id="statistics-display">
    <div id="totalComics">
        <h3>Total Comics On Superfans: {{totalComics}}</h3>
    </div>
    <div id="superhero">
      <h3>Top 5 Superheroes:</h3>
      <p v-for="superhero in superheroStats" v-bind:key="superhero.heroName">
        {{ superhero.heroName }}: {{ superhero.occurrences }}
      </p>
    </div>
    <div id="publisher">
      <h3>Top 5 Publishers:</h3>
      <p v-for="publisher in publisherStats" v-bind:key="publisher.publisherName">
        {{ publisher.publisherName }}: {{ publisher.occurrences }}
      </p>
    </div>
    <div id="series">
      <h3>Top 5 Series:</h3>
      <p v-for="series in seriesStats" v-bind:key="series.seriesName">
        {{ series.seriesName }}: {{ series.occurrences }}
      </p>
    </div>
  </div>
</template>

<script>
import comicService from "@/services/ComicService.js";
export default {
  name: "aggregate-statistics",
  data() {
    return {
      totalComics: 0,
      superheroStats: [],
      publisherStats: [],
      seriesStats: [],
    };
  },
  created() {
    this.getTotalComics();
    this.getSuperheroStats();
    this.getPublisherStats();
    this.getSeriesStats();
  },
  methods: {
    getTotalComics() {
      comicService.getTotalComics().then( response => {
          if(response.status === 200) {
              this.totalComics = response.data;
          }
      })
    },
    getSuperheroStats() {
      comicService
        .getSuperheroStats()
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
        .getPublisherStats()
        .then((response) => {
          if (response.status === 200) {
            this.publisherStats = response.data;
            this.publisherStats.sort((a, b) => b.occurrences - a.occurrences);
            this.publisherStats.splice(6);
          }
        });
    },

    getSeriesStats() {
      comicService
        .getSeriesStats()
        .then((response) => {
          if (response.status === 200) {
            this.seriesStats = response.data;
            this.seriesStats.sort((a, b) => b.occurrences - a.occurrences);
            this.seriesStats.splice(6);
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
#totalComics {
    margin-bottom: 10px;
}
h3 {
    color: white;
    text-decoration: underline;
    font-weight: bold;
}

</style>