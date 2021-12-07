<template>
  <form v-on:submit.prevent>
    <div>
      <label for="comic-name">Comic Name</label>
      <input type="text" v-model="comic.comicName" />
    </div>
    <div>
      <label for="author">Author</label>
      <input type="text" v-model="comic.author" />
    </div>
    <div>
      <label for="image">Upload Image</label>
      <input type="file" id="file" ref="fileInput" />
    </div>
    <div>
      <label for="releaseDate">Release Date</label>
      <input type="date" v-model="comic.releaseDate" />
    </div>
    <div>
      <label for="publisher">Publisher</label>
      <input type="text" v-model="publisher" />
    </div>
    <div>
      <label for="series">Series</label>
      <input type="text" v-model="series" />
    </div>
    <div>
      <label for="add-comic"
        >Would you like to add another comic to this collection now?</label
      >
      <label for="yes">Yes</label>
      <input type="radio" id="yes" v-bind:value="true" v-model="addComic" />
      <label for="no">No</label>
      <input type="radio" id="no" v-bind:value="false" v-model="addComic" />
    </div>
    <div>
      <button type="submit" v-on:click="addComic()">Add Comic</button>
    </div>
  </form>
</template>

<script>
import comicService from "../services/ComicService";

export default {
  name: "add-comic",
  data() {
    return {
      newComic: {
        comic: {},
        publisher: "",
        series: "",
      },
      addComic: "",
    };
  },
  methods: {
    addComic() {
      const collectionId = this.$route.params.collectionId;
      comicService.addComic(this.newComic, collectionId).then((response) => {
        if (response.status === 201) {
          if (this.addComic == "true") {
            this.$router.push({
              name: "add-comic",
              params: { collectionId: collectionId },
            });
          } else {
            this.$router.push({ name: "my-collections" });
          }
        }
      });
    },
  },
};
</script>

<style>
</style>