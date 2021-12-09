<template>
    <div>
        <button v-on:click="updateFilter">{{collection.collectionName}}</button>
        <comic-list v-if="show" id="collection"/>
        <!-- waiting to know the name of the variable for image column < v-bind:src="collection.image"> -->
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
            if (this.show === false) {
                this.show = true;
            } else {
                this.show = false;
            }
            
        }
    }
}
</script>

<style>
/* button {

} */
#collection {
    display: flex;
}
</style>