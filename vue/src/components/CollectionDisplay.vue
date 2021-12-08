<template>
    <div>
        <button v-on:click="updateFilter">{{collection.collectionName}}</button>
        <comic-list v-if="show" />
        <!-- waiting to know the name of the variable for image column <img v-bind:src="collection.image"> -->
    </div>
</template>

<script>
import ComicList from './ComicList.vue';
export default {
  components: { ComicList },
    name: 'collection-display',
    data() {
        return {
            show: false
        }
    },
    props: ['collection'],
    methods: {
        updateFilter() {
            this.$store.commit("UPDATE_FILTER", parseInt(this.collection.collectionId));
            this.show = true;
        }
    }
}
</script>

<style>
/* button {

} */
</style>