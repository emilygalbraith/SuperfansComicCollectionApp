<template>
<div class="wrapper">
  <div id="register" class="text-center">
    <div class="header"> <img src="https://blogger.googleusercontent.com/img/a/AVvXsEjWh3P6u-ytyvYQe3Q2B5cXXCulnHsallroZ5Nr_xNu7pz7rA5CXDSwSeX3ZfY-16aZ0qVHMsni8WFKotXAlujWTqHji9OVZiJ2m7YObpuv_PI2pTBuvS8VZ16CzJgH3K9knqhY1awNGpDXWmpv6F5jwJTwY0yWrFx-GTzmIAF2-Qzg7rW8CSh-ygzVlQ=s2870"
alt="imgheader" class="imgheader"> </div>
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
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
      /> <br>
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      /><br>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button><br>
      <router-link :to="{ name: 'login' }">Have an account?</router-link><br>
      
    </form>
  </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>
.wrapper {
  display: grid;
  grid-template-columns: 80%;
  justify-content: center;
}
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
  font-family: 'Comic Neue', cursive;
  font-size: 150%;
  color: white;
  margin-top: 0px;
}
h1 {
  padding-top: 4%;
}
.form-register {
background: #071926;
height: 74%;
width: 100%;
}
.form-register {
  margin-block-start: -1%;
}
.form-register {
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
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 10px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
</style>
