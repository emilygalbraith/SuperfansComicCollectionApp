<template>
<header>
  <div id="app">
    
    <div class="header"> 
      <img src="https://blogger.googleusercontent.com/img/a/AVvXsEjWh3P6u-ytyvYQe3Q2B5cXXCulnHsallroZ5Nr_xNu7pz7rA5CXDSwSeX3ZfY-16aZ0qVHMsni8WFKotXAlujWTqHji9OVZiJ2m7YObpuv_PI2pTBuvS8VZ16CzJgH3K9knqhY1awNGpDXWmpv6F5jwJTwY0yWrFx-GTzmIAF2-Qzg7rW8CSh-ygzVlQ=s2870" alt="imgheader" class="imgheader"> 
    </div>
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link><div id="bar">|</div>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link :to="{name: 'login'}" v-if="$store.state.token == ''">Login</router-link><div id="bar">|</div>
      <router-link :to="{name: 'register'}" v-if="$store.state.token == ''">Register</router-link>
      <router-link v-bind:to="{name: 'profile'}" v-if="$store.state.token != ''">View Profile</router-link>
    </div>
    <router-view />
     <div>
  </div>
  </div>
</header>
</template>

<style scoped>
@import url('<link href="https://fonts.googleapis.com/css2?family=Comic+Neue:wght@300&family=Sacramento&display=swap" rel="stylesheet">');


* {
  font-family: 'Comic Neue', cursive;
}
  #nav {
    display: flex;
    width: 100%;
    justify-content: center;
    font-size: 30px;
  }
  img {
    width: 100%;
    height: 100%;
  }
  .header {
    width: 100%;
    margin: none;
    padding: none;
    margin-block-start: -2%;
  }
  #app {
  background-color: #071926;
  height: 200em;
}
a:link {
  color: white;
  text-decoration: none;
  font-size: 1.5vw;
}
a:visited {
  color: lightsteelblue;
}
a:hover {
  color: #feac24;
}
#bar {
  color: lightsteelblue;
  font-size: 1.5vw;
  margin-right: 10px;
  margin-left: 10px;
}
</style>
