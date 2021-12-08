<template>
    <div>
        <h2>{{$store.state.user.username}}</h2>
        <!-- <img :src="image" />
        <input type="file" id="file" ref="fileInput"/>  not sure how to work with profile photo yet-->   
        <router-link v-bind:to="{name: 'my-collections'}">My Collections</router-link>
    </div>
</template>

<script>
export default {
    name: 'my-profile',
    data() {
        return {
            image: this.$refs.fileInput.files[0]
        }
    }
}
</script>

<style>

</style>