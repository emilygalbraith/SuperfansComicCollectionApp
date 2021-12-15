<template>
  <div id="profile">
    <h2>{{ $store.state.user.username }}</h2>
    <div id="avatar-placeholder" v-if="!show"></div>
    <img :src="imgSrc" v-else id="avatar" />
    <h3 id="no-underline" class="user-type">{{ userType }}</h3>
    <div v-if="!show">
      <h3>Please Choose Your Avatar Image</h3>
      <img
        v-for="image in avatarImg"
        :key="image.profileId"
        :src="image.imgUrl"
        @click="
          (userProfile.profileId = image.profileId),
          (show = true),
          (imgSrc = image.imgUrl),
          linkProfileToUser()
        "
      />
    </div>
    <h3 id="no-underline">All My Collections:</h3>
    <collection-list id="my-collections" />
    <create-collection />
  </div>
</template>

<script>
import CollectionList from "./CollectionList.vue";
import ComicService from "../services/ComicService";
import CreateCollection from "./CreateCollection.vue";

export default {
  components: { CollectionList, CreateCollection },
  name: "my-profile",
  data() {
    return {
      avatarImg: [],
      userType: "",
      collections: [],
      imgSrc: "",
      userProfile: {
        userId: this.$store.state.user.id,
      },
    };
  },
  created() {
    this.getUserType();
    this.getAllAvatarImgs();
    this.getProfileImg();
  },
  computed: {
    show() {
      return this.imgSrc != "";
    }
  },
  methods: {
    getUserType() {
      const currentUser = this.$store.state.user;
      this.collections = ComicService.getCollectionByUserId(currentUser.id);
      let count = 1;
      for (let i = 0; i < this.collections.length; i++) {
        count++;
      }
      if (count >= 0 && count <= 3) {
        if (count == 1) {
          this.userType = count + " collection | Standard ";
        } else {
          this.userType = count + " collections | Standard ";
        }
      } else if (count > 3) {
        this.userType = count + " collections | Premium ";
      }
    },
    getAllAvatarImgs() {
      ComicService.getAllAvatarImgs().then((response) => {
        if (response.status === 200) {
          this.avatarImg = response.data;
        }
      });
    },
    linkProfileToUser() {
      ComicService.addUserProfile(this.userProfile, this.$store.state.token);
    },
    getProfileImg() {
      const currentUser = this.$store.state.user;
      ComicService.getProfileById(currentUser.id).then((response) => {
        if (response.status === 200) {
          this.imgSrc = response.data.imgUrl;
        }
      });
    },
    toggleShow() {
      this.show = !this.show;
    }
  },
};
</script>

<style>
#profile {
  display: flex;
  flex-direction: column;
}
h2 {
  font-size: 150%;
  width: 100%;
}
h3 {
  align-self: center;
  text-align: center;
}
#no-underline {
  text-decoration: none;
}
#create {
  align-self: center;
}
button {
  margin-bottom: 10px;
  align-self: center;
}
#avatar-placeholder {
  height: 150px;
  width: 150px;
  background-color: white;
  margin: 10px;
  align-self: center;
  border-radius: 10px;
}
#profile > div > img {
  height: 20%;
  margin: 10px;
}
#my-collections {
  align-self: center;
}
#profile-imgs {
  display: flex;
  justify-content: space-evenly;
}
#avatar {
  align-self: center;
  border-radius: 10px;
  height: 20%;
}
</style>