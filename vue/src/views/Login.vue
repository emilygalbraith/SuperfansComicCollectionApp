<template>
<div class="wrapper">
  <div id="login" class="text-center">
    <div class="header"> <img src="https://blogger.googleusercontent.com/img/a/AVvXsEjXiM4ceD4fpsfj1DJVVz4xYMFF9VRNe4fSg1uIS0iRXOx_QvRnNThv56ipJUcedsbh0c7WpUSSbrjtnoXgW6LNJ_uDB7FGLkdZS8NU7LVTQDaR75fsTiXnTYPCFNhKCq34uP-K0bk_pHMd4nywFsJ0VW_xWackRwz2pJA4v75ZxpilX5Jlsqy6uCXM-w=s2870"
alt="imgheader" class="imgheader"> </div>
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Sign in</button>
    </form>
  </div>
  <collection-list />
  </div>
</template>

<script>
import CollectionList from '../components/CollectionList.vue';
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {CollectionList},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>



<style scoped>
.wrapper {
  display: grid;
  grid-template-columns: 80%;
  justify-content: center;
}
img {
  width: 100%;
  padding: 0em;
  /* margin-bottom: ; */
}
.header {
width: 100%;
margin: none;
padding: none;
justify-self: start;
}
h1 {
  font-family: 'Times New Roman', Times, serif;
  font-size: 200%;
  color: white;
  margin-top: 0px;
}
.form-signin {
background: #162e40;
height: 100%;
width: 100%;
}
form {
  background: blue;
}
.form-signin {
  font-family: Georgia, 'Times New Roman', Times, serif;
  color: whitesmoke;
  text-align: center;
  font-size: 40px;
}
#username {
  font-family: 'Courier New', Courier, monospace
}

</style>
