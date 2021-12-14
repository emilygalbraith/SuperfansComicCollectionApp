<template>
    <div id="collection-display">
        <router-link :to="{name: 'collection-detail', params: {collectionId: collection.collectionId}}">
            {{collection.collectionName}}
        </router-link>
        <comic-list id="collection" :collectionId="collection.collectionId" />
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

<style scoped>
@import url('<link href="https://fonts.googleapis.com/css2?family=Comic+Neue:wght@300&family=Sacramento&display=swap" rel="stylesheet">');

h3 {
    font-family: 'Comic Neue', cursive;
    color: #DB504A;
}
#collection {
    display: flex;
    gap: 20px;
}

#collection-display {
    margin-bottom: 20px;
    font-size: 1.5em;
}
</style>