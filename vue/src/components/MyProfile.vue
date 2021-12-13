<template>
    <div   id="profile" >
        <!-- <img :src="image" />
        <input type="file" id="file" ref="fileInput"/>  not sure how to work with profile photo yet-->
        <h2>{{$store.state.user.username}}</h2>
        <h3 id="no-underline" class="user-type">{{userType}}</h3>  
        <h3 id="no-underline">All My Collections:</h3> 
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
            userType: "",
            collections: []
        }
    },
    created() {
        this.getUserType();
    },
    methods: {
        getUserType() {
            const currentUser = this.$store.state.user
            this.collections = ComicService.getCollectionByUserId(currentUser.id);
            let count = 1;
            for(let i = 0; i < this.collections.length; i++) {
                count++;
            }
            if(count >= 0 && count <= 3) {
                if(count == 1) {
                    this.userType = count + " collection | Standard "
                } else {
                this.userType = count + " collections | Standard ";
                }
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
#no-underline {
    text-decoration: none;
}
#create {
    align-self: center;
}
</style>