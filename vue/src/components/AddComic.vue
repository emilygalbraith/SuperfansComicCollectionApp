<template>
  <div>
    <button v-on:click="toggleShow()" v-if="!show">Add New Comic To Collection</button>
    <form v-on:submit.prevent v-if="show">
      <div>
        <label for="comic-name">Comic Name: </label>
        <input type="text" v-model="newComic.comic.comicName" />
        <label for="author">Author: </label>
        <input type="text" v-model="newComic.comic.author" />
        <label for="image">Image URL: </label>
        <input type="text" v-model="newComic.comic.image" />
      </div>
      <div>
        <label for="releaseDate">Release Date: </label>
        <input type="date" v-model="newComic.comic.releaseDate" />

        <label for="publisher">Publisher: </label>
        <input type="text" v-model="newComic.publisher" />
        <label for="series">Series: </label>
        <input type="text" v-model="newComic.series" />
      </div>
      <label for="superheroes">Please Check All Superheroes In Comic</label
      ><br />
      <span v-for="superhero in superheroList" :key="superhero.superheroId">
        <input
          type="checkbox"
          :id="superhero.superheroName"
          v-model="newComic.superheroes"
          :value="superhero.superheroName"
        />
        <label :for="superhero.superheroId">{{
          superhero.superheroName
        }}</label>
      </span>
      <div>
        <button type="submit" v-on:click="saveComic()">Add Comic</button>
      </div>
    </form>
  </div>
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
        superheroes: [],
      },
      addComic: "",
      superheroList: [],
      show: false
    };
  },
  created() {
    this.getListOfSuperheroes();
  },
  methods: {
    getListOfSuperheroes() {
      comicService.getAllSuperheroes().then((response) => {
        if (response.status === 200) {
          this.superheroList = response.data;
        }
      });
    },
    saveComic() {
      const token = this.$store.state.token;
      //   this.newComic.comic.image = this.$refs.fileInput.files[0];
      const collectionId = this.$route.params.collectionId;
      comicService
        .addComic(this.newComic, collectionId, token)
        .then((response) => {
          if (response.status === 201) {
            this.toggleShow();
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
    toggleShow() {
      if(this.show) {
        this.show = false;
      } else {
        this.show = true;
      }
    }
  },
};
</script>

<style scoped>
label {
  color: white;
}
span {
  margin-right: 20px;
}
form {
  margin-top: 50px;
  margin-right: 30px;
}
input {
  margin-right: 30px;
}
</style>