<template>
    <div>
        <img v-bind:src="comic.image" />
        <h4 v-if="show()">{{comic.comicName}}</h4>
    </div>
</template>

<script>
export default {
    name: 'comic-display',
    props: ['comic'],
    methods: {
        show() {
            if (this.$route.name == 'home' || this.$route.name == 'profile') {
                return false;
            } else {
                return true;
            }
        }
    }
}
</script>

<style scoped>
h4 {
    color: white;
    width: 150px
}
</style>