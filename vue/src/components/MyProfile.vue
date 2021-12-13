<template>
    <div   id="profile" >
        <h2>{{$store.state.user.username}}</h2>
        <!-- <img :src="image" />
        <input type="file" id="file" ref="fileInput"/>  not sure how to work with profile photo yet-->
        <h3>{{userType}}</h3>  
        <h3>All My Collections:</h3> 
        <collection-list />
        <router-link :to="{ name: 'create-collection'}" id="create">
            <button>Create A New Collection</button>
        </router-link>
    </div>
</template>

<script>
import CollectionList from './CollectionList.vue';
import ComicService from '../services/ComicService';

export default {
  components: { CollectionList },
    name: 'my-profile',
    data() {
        return {
            // image: this.$refs.fileInput.files[0]
            userType: ""
        }
    },
    created() {
        this.getUserType();
    },
    methods: {
        getUserType() {
            const currentUser = this.$store.state.user
            const usersCollections = ComicService.getCollectionByUserId(this.$route.params(currentUser.id));
            let count = 0;
            for(let i = 0; i < usersCollections.length; i++) {
                count++;
            }
            if(count >= 0 && count <= 3) {
                this.userType = count + " collections | Standard ";
            } else if (count > 3) {
                this.userType = count + " collections | Premium ";
            }
        }
    }
}
</script>

<style>
#profile{
    display: flex;
    flex-direction: column;
}
h3 {
    align-self: center;
}
#create {
    align-self: center;
}
</style>