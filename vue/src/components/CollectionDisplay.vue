<template>
    <div>
        <h2>{{collection.collectionName}}</h2>
        <!-- waiting to know the name of the variable for image column <img v-bind:src="collection.image"> -->
    </div>
</template>

<script>
export default {
    name: 'collection-display',
    props: ['collection']
}
</script>

<style>

</style>