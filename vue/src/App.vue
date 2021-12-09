<template>
  <div id="app">
    <div class="header"> 
      <img src="../img/header.jpg" />
    </div>
    <div id="nav">
      <router-link v-bind:to="{ name: 'welcome' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style scoped>
  #nav {
    display: flex;
    width: 100%;
    justify-content: center;
    font-size: 30px;
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
</style>
