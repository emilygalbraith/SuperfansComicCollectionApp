<template>
<div class="background">
  <div id="login" class="text-center">
    <div class="header"> <img src="https://blogger.googleusercontent.com/img/a/AVvXsEjWh3P6u-ytyvYQe3Q2B5cXXCulnHsallroZ5Nr_xNu7pz7rA5CXDSwSeX3ZfY-16aZ0qVHMsni8WFKotXAlujWTqHji9OVZiJ2m7YObpuv_PI2pTBuvS8VZ16CzJgH3K9knqhY1awNGpDXWmpv6F5jwJTwY0yWrFx-GTzmIAF2-Qzg7rW8CSh-ygzVlQ=s2870"
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
      <label for="username" class="sr-only">Username</label><br>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      /><br>
      <label for="password" class="sr-only">Password</label><br>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      /><br>
      <button type="submit">Sign in</button><br><br>
      <div id="CreateAccount"><router-link :to="{ name: 'register' }">Create an account</router-link></div><br>
      
    </form>
  </div>
  <div>
    <collection-list />
  </div>
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
@import url('<link href="https://fonts.googleapis.com/css2?family=Comic+Neue:wght@300&family=Sacramento&display=swap" rel="stylesheet">');

img {
  width: 100%;
}
.header {
width: 100%;
margin: none;
padding: none;
margin-block-start: -2%;
}
h1 {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 150%;
  color: white;
  margin-top: 0px;
}
h1 {
  padding-top: 4%;
}
.form-signin {
/* background: #071926; */
height: 75%;
width: 100%;
}
.form-signin {
  margin-block-start: -1%;
}
.form-signin {
  font-family: 'Comic Neue', cursive;
  color: whitesmoke;
  text-align: center;
  font-size: 40px;
}
input[type=text] {
  width: 10%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
input[type=password] {
  width: 10%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
button {
  background-color: #4CAF50; 
  border: none;
  color: white;
  padding: 10px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
.background {
  background-color: #071926;
}
#CreateAccount {
  font-size: 50%;
}


</style>
