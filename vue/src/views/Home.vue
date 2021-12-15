<template>
  <div>
    <div id="start" v-if="!show">
      <h2>All Public Collections:</h2>
    </div>
    <div id="home" v-if="show">
      <h2 id="welcome">Welcome {{$store.state.user.username}}</h2>
      <h2>All Collections:</h2>
    </div>
    <div id="collection-and-stats">
      <div id="collection">
        <collection-list />
      </div>
      <aggregate-statistics/>
    </div>
  </div>
</template>

<script>
import AggregateStatistics from '../components/AggregateStatistics.vue';
import CollectionList from '../components/CollectionList.vue'

export default {
  components: { CollectionList, AggregateStatistics },
  name: "home",
  data() {
    return {

    }
  },
  computed: {
    show() {
      return this.$store.state.show;
    }
  }
}
</script>

<style>

h1 {
  text-align: center;
}
h1 {
  font-size: 150%;
  color: white;
  margin-top: 0px;
  padding-top: 4%;
}
h2 {
  color: white;
  font-size: 2em;
}
p {
  color: white;
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
#collection-and-stats{
    display: grid;
    grid-template-columns: 3fr 1fr;
}
#collection{
  overflow-x: auto;
  overflow-y: hidden;
}
img{
  width: 150px;
  height: 225px;
}
#welcome{
  font-size: 2.2em;
}
collection-list {
  align-content: center;
}
</style>