<template>
    <div>
        <!-- <h4>{{comic.comicName}}</h4> -->
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