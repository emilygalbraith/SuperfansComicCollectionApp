<template>
  <my-profile />
</template>

<script>
import MyProfile from "../components/MyProfile.vue";

export default {
  components: { MyProfile },
  created() {
    this.$store.commit("FLIP_SHOW", true);
  },
};
</script>

<style>
</style>