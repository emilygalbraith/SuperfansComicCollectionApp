<template>
    <div>
        <comic-display v-for="comic in comics" v-bind:key="comic.comicId" v-bind:comic="comic" />
    </div>
</template>

<script>
import ComicDisplay from './ComicDisplay.vue'
import comicService from '@/services/ComicService.js'

export default {
    components: { ComicDisplay },
    name: 'comic-list',
    data() {
        return {
            comics: []
        }
    },
    created() {
        comicService.getComicsByCollectionId(this.$store.state.filter).then(response => {
            if (response.status === 200) {
                this.comics = response.data;
            }
        });
    }
}
</script>

<style>

</style>