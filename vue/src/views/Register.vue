<template>
<div class="background">
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create an Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username:</label><br>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      /><br>
      <label for="password" class="sr-only">Password:</label><br>
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
      </button><br><br>
      <div id="HaveAccount"><router-link :to="{ name: 'login' }">Have an account?</router-link></div><br>
      
    </form>
  </div>
  <div id="back-to-home"><router-link :to="{name: 'home'}">Back to Home</router-link></div>
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

<style scoped>
h1 {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 150%;
  color: white;
  margin-top: 0px;
  padding-top: 4%;
}
.form-register {
  font-family: 'Comic Neue', cursive;
  color: whitesmoke;
  text-align: center;
  font-size: 40px;
  margin-block-start: -1%;
  height: 74%;
  width: 100%;
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
.background {
  background-color: #071926;
}
#HaveAccount {
  font-size: 60%;
}
#back-to-home {
  text-align: center;
}
a:link {
  color: white;
  text-decoration: none;
}
a:visited {
  color: lightsteelblue;
}
a:hover {
  color: #dbb702;
}
</style>
