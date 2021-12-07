<template>
  <form v-on:submit.prevent>
      <div>
          <label for="collection-name">Collection Name</label>
          <input type="text" v-model="collection.collectionName" />
      </div>
      <div>
          <label for="private">Private</label>
          <input type="radio" id="private" v-bind:value="true" v-model="collection.private">
          <label for="public">Public</label>
          <input type="radio" id="public" v-bind:value="false" v-model="collection.private">
      </div>
      <div>
          <button type="submit" v-on:click="createCollection()">Create Collection</button>
      </div>
  </form>
</template>

<script>
import comicService from "../services/ComicService";

export default {
    name: "create-collection",
    data() {
        return {
            collection: {
            },
            currentUser: this.$store.state.currentUser
        };
    },
    methods: {
        createCollection() {
            this.collection.userId = this.currentUser.userId;
            comicService.addCollection(this.collection).then( response => {
                if(response.status === 201) {
                    this.$router.push( {name: 'my-collections'} );
                }
            })
        }
    }

};
</script>

<style>

</style>