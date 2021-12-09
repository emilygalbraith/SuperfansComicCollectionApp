<template>
    <div>
        <h3>{{collection.collectionName}}</h3>
        <comic-list id="collection" :collectionId="collection.collectionId" />
        <!-- waiting to know the name of the variable for image column < v-bind:src="collection.image"> -->
    </div>
</template>

<script>
import ComicList from './ComicList.vue';

export default {
  components: { ComicList },
    name: 'collection-display',
    props: ['collection']
}
</script>

<style>
/* button {

} */
#collection {
    display: flex;
    gap: 20px;
}
</style>