<template>
    <div>
        <h2>{{$store.state.user.username}}</h2>
        <!-- <img :src="image" />
        <input type="file" id="file" ref="fileInput"/>  not sure how to work with profile photo yet-->   
        <collection-list />
    </div>
</template>

<script>
import CollectionList from './CollectionList.vue'

export default {
  components: { CollectionList },
    name: 'my-profile',
    data() {
        return {
            // image: this.$refs.fileInput.files[0]
        }
    }
}
</script>

<style>

</style>