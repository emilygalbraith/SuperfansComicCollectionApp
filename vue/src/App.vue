<template>
<header>
  <div id="app">
    <div class="header"> 
      <img src="https://blogger.googleusercontent.com/img/a/AVvXsEjWh3P6u-ytyvYQe3Q2B5cXXCulnHsallroZ5Nr_xNu7pz7rA5CXDSwSeX3ZfY-16aZ0qVHMsni8WFKotXAlujWTqHji9OVZiJ2m7YObpuv_PI2pTBuvS8VZ16CzJgH3K9knqhY1awNGpDXWmpv6F5jwJTwY0yWrFx-GTzmIAF2-Qzg7rW8CSh-ygzVlQ=s2870" alt="imgheader" class="imgheader"> 
    </div>
    <div id="nav">
      <router-link v-bind:to="{ name: 'welcome' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
     <div>
  </div>
  </div>
  </header>
</template>

<style scoped>
  #nav {
    display: flex;
    width: 100%;
    justify-content: center;
    font-size: 30px;n
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
  #app {
  background-color: #071926;
  height: 81em;
}
</style>
