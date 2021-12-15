<template>
  <div>
    <button v-on:click="flipShowStatus()" v-if="!show">Add New Collection</button>
    <form class="form" v-on:submit.prevent v-if="show">
      <h1>Create Collection</h1>
      <div>
        <label for="collection-name">Collection Name: </label><br />
        <input type="text" v-model="collection.collectionName" />
      </div>
      <div>
        <label for="private">Private</label>
        <input
          type="radio"
          id="private"
          v-bind:value="true"
          v-model="collection.private"
        /><br />
        <label for="public">Public</label>
        <input
          type="radio"
          id="public"
          v-bind:value="false"
          v-model="collection.private"
        />
      </div>
      <div>
        <button id="button" type="submit" v-on:click="createCollection()">
          Create Collection
        </button>
        <button id="button" v-on:click="flipShowStatus()">Cancel</button>
      </div>
    </form>
  </div>
</template>

<script>
import comicService from "../services/ComicService";

export default {
  name: "create-collection",
  data() {
    return {
      collection: {},
      show: false,
    };
  },
  methods: {
    createCollection() {
      const token = this.$store.state.token;
      const currentUser = this.$store.state.user;
      this.collection.userId = currentUser.id;
      comicService
        .addCollection(this.collection, token)
        .then((response) => {
          if (response.status === 201) {
            this.collection = response.data;
            this.flipShowStatus();
            this.$router.go();
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
    flipShowStatus() {
      this.show = !this.show;
    },
  },
};
</script>

<style>
label[for="collection-name"] {
  color: white;
}
label[for="private"] {
  color: white;
}
label[for="public"] {
  color: white;
}
h1 {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 150%;
  color: white;
  margin-top: 0px;
  padding-top: 4%;
}
.form {
  height: 75%;
  width: 100%;
  margin-block-start: -1%;
  font-family: "Comic Neue", cursive;
  color: whitesmoke;
  text-align: center;
}
input[type="text"] {
  width: 10%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
button {
  background-color: #4caf50;
  border: none;
  color: white;
  padding: 10px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  width: 8%;
}
#button {
  margin-right: 20px;
  align-self: center;
}
</style>