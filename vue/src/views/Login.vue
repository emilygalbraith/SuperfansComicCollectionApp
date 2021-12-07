<template>
  <div id="login" class="text-center">
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
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
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
h1 {
  font-family: 'Times New Roman', Times, serif;
  font-size: 200%;
  color: white;
}
.form-signin {
background: black;
}
/* form {
  background: blue;
  width: 50%;
  height: 43em;
  margin-left: 5%;
  margin-right: 5%;
} */


.form-signin {
  font-family: Georgia, 'Times New Roman', Times, serif;
  color: brown;
  text-align: center;
  font-size: 20px;
}
/* #login {
  margin: 30px 30px 30px 30px;
  padding: 30px 30px 30px 30px;
  width: 80%;
  height: 50em;
  justify-content: left;
  background-origin: padding-box;
  background-color: rgb(10, 0, 32);
  font-family: Arial, Helvetica, sans-serif;
  color: aliceblue;
  display: flex;
} */

</style>
