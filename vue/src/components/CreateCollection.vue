<template>
  <form v-on:submit.prevent>
    <div>
      <label for="collection-name">Collection Name</label>
      <input type="text" v-model="collection.collectionName" />
    </div>
    <div>
      <label for="private">Private</label>
      <input
        type="radio"
        id="private"
        v-bind:value="true"
        v-model="collection.private"
      />
      <label for="public">Public</label>
      <input
        type="radio"
        id="public"
        v-bind:value="false"
        v-model="collection.private"
      />
    </div>
    <div>
      <label for="add-comic"
        >Would you like to add comics to this collection now?</label
      >
      <label for="yes">Yes</label>
      <input type="radio" id="yes" v-bind:value="true" v-model="addComic" />
      <label for="no">No</label>
      <input type="radio" id="no" v-bind:value="false" v-model="addComic" />
    </div>
    <div>
      <button type="submit" v-on:click="createCollection()">
        Create Collection
      </button>
    </div>
  </form>
</template>

<script>
import comicService from "../services/ComicService";

export default {
  name: "create-collection",
  data() {
    return {
      collection: {},
      addComic: "",
    };
  },
  methods: {
    createCollection() {
      const token = this.$store.state.token;
      const currentUser = this.$store.state.user;
      this.collection.userId = currentUser.id;
      comicService.addCollection(this.collection, token).then((response) => {
        if (response.status === 201) {
          this.collection = response.data;
          if (this.addComic == "true") {
            this.$router.push({ name: "add-comic", params: {collectionId: this.collection.collectionId} });
          } else {
            this.$router.push({ name: "my-collections" });
          }
        }
      }).catch(error => {
          if(error.response) {
              console.log(error.response.statusText);
          } else if(error.request) {
              console.log('error in request');
          } else {
              console.log('error occured');
          }
      });
    },
  },
};
</script>

<style>
</style>