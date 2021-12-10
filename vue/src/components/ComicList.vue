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
    props: ['collectionId'],
    created() {
        this.showComics();
    },
    methods: {
        getLimitedComics() {
            comicService.getComicsByCollectionId(this.collectionId).then(response => {
                if (response.status === 200) {
                    if (response.data.length > 6) {
                        this.comics = response.data.slice(5);
                    } else {
                        this.comics = response.data;
                    }
                }
            });
        },
        getAllComics() {
            comicService.getComicsByCollectionId(this.collectionId).then(response => {
                if (response.status === 200) {
                    this.comics = response.data;
                }
            });
        },
        showComics() {
            if (this.$route.name == 'profile' || this.$route.name == 'home') {
                this.getLimitedComics();
            } else {
                this.getAllComics();
            }
        }
    }
}
</script>

<style>

</style>