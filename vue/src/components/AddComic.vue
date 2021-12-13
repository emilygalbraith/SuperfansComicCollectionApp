<template>
  <form v-on:submit.prevent>
    <div>
      <label for="comic-name">Comic Name</label>
      <input type="text" v-model="newComic.comic.comicName" />
    </div>
    <div>
      <label for="author">Author</label>
      <input type="text" v-model="newComic.comic.author" />
    </div>
    <!-- <div>
      <label for="image">Upload Image</label>
      <input type="file" id="file" ref="fileInput" />
    </div> -->
    <div>
      <label for="image">Image URL</label>
      <input type="text" v-model="newComic.comic.image"/>
    </div>
    <div>
      <label for="releaseDate">Release Date</label>
      <input type="date" v-model="newComic.comic.releaseDate" />
    </div>
    <div>
      <label for="publisher">Publisher</label>
      <input type="text" v-model="newComic.publisher" />
    </div>
    <div>
      <label for="series">Series</label>
      <input type="text" v-model="newComic.series" />
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
      <button type="submit" v-on:click="saveComic()">Add Comic</button>
    </div>
  </form>
</template>

<script>
import comicService from "../services/ComicService";

export default {
  data() {
    return {
      newComic: {
        comic: {
          comicName: "",
          author: "",
          image: "",
          releaseDate: "",
        },
        publisher: "",
        series: "",
      },
      addComic: "",
    };
  },
  methods: {
    saveComic() {
      const token = this.$store.state.token;
    //   this.newComic.comic.image = this.$refs.fileInput.files[0];
      const collectionId = this.$route.params.collectionId;
      comicService
        .addComic(this.newComic, collectionId, token)
        .then((response) => {
          if (response.status === 201) {
            if (this.addComic == "true") {
              this.$router.push({
                name: "add-comic-form",
                params: { collectionId: collectionId },
              });
            } else {
              this.$router.push({ name: "my-collections" });
            }
          }
        })
        .catch((error) => {
          if (error.response) {
            console.log(error.response.statusText);
          } else if (error.request) {
            console.log("error in request");
          } else {
            console.log("error occured");
          }
        });
    },
  },
};
</script>

<style scoped>
label {
  color: white;
}
</style>