<template>
  <div id="profile">
    <h2>{{ $store.state.user.username }}</h2>
    <div id="avatar-placeholder" v-if="!show"></div>
    <img :src="profile.imgUrl" v-if="show" id="avatar" />
    <h3 id="no-underline" class="user-type">{{ userType }}</h3>
    <div>
      <button @click="flipShowAvatar">Please Choose Your Avatar Image</button>
      <div id="profile-imgs" v-if="showAvatar">
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
      profile: {
        imgUrl: "",
      },
      showAvatar: false,
    };
  },
  created() {
    this.getUserType();
    this.getAllAvatarImgs();
    this.getProfileImg();
  },
  computed: {
    show() {
      return this.profile.imgUrl != "";
    },
  },
  methods: {
    getUserType() {
      const currentUser = this.$store.state.user;
      ComicService.getCollectionByUserId(currentUser.id).then((response) => {
        if (response.status === 200) {
          this.collections = response.data;
          let numOfCollections = this.collections.length;
          if (numOfCollections >= 0 && numOfCollections <= 3) {
            if (numOfCollections == 1) {
              this.userType = numOfCollections + " collection | Standard ";
            } else {
              this.userType = numOfCollections + " collections | Standard ";
            }
          } else if (numOfCollections > 3) {
            this.userType = numOfCollections + " collections | Premium ";
          }
        }
      });
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
      this.$router.go();
    },
    getProfileImg() {
      const currentUser = this.$store.state.user;
      ComicService.getProfileById(currentUser.id).then((response) => {
        if (response.status === 200) {
          this.profile = response.data;
          if (this.profile.imgUrl != "") {
            this.toggleShow();
          }
        }
      });
    },
    toggleShow() {
      this.show = !this.show;
    },
    flipShowAvatar() {
      this.showAvatar = !this.showAvatar;
    },
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
  text-align: center;
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
  display: block;
  /* margin-bottom: 10px; */
  width: auto;
  margin: 10px auto;
}
#avatar-placeholder {
  height: 150px;
  width: 150px;
  background-color: white;
  margin: 10px;
  align-self: center;
  border-radius: 10px;
}
#profile-imgs > img {
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