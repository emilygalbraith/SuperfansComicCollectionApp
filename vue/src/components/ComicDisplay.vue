<template>
    <div>
        <h2>{{comic.comicName}}</h2>
        <img v-bind:src="comic.image" />
    </div>
</template>

<script>
export default {
    name: 'comic-display',
    props: ['comic']
}
</script>

<style>

</style>