<script setup>

import {userInfoStore} from "@/store/user";
import router from "@/router";

const userInfo = userInfoStore()

const logout = () => {
  userInfo.account.id = null;
  sessionStorage.removeItem("id");
  router.push({path: "/"});

}

</script>

<template>
  <header data-bs-theme="dark">
    <div class="collapse text-bg-dark" id="navbarHeader">
      <div class="container">
        <div class="row">
<!--          <div class="col-sm-8 col-md-7 py-4">-->
<!--            <h4>About</h4>-->
<!--            <p class="text-body-secondary">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>-->
<!--          </div>-->
<!--          <div class="col-sm-4 offset-md-1 py-4">-->
<!--            <h4>Contact</h4>-->
<!--            <ul class="list-unstyled">-->
<!--              <li><a href="#" class="text-white">Follow on Twitter</a></li>-->
<!--              <li><a href="#" class="text-white">Like on Facebook</a></li>-->
<!--              <li><a href="#" class="text-white">Email me</a></li>-->
<!--            </ul>-->
<!--          </div>-->
          <div class="col-sm-4  py-4">
            <h4>사이트맵</h4>
            <ul class="list-unstyled">
              <li><router-link to="/" class="text-white">메인 화면</router-link></li>
              <li>
                <router-link to="/login" class="text-white" v-if="userInfo.account.id===null">로그인</router-link>
                <a @click="logout" class="text-white"  v-else>로그아웃</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="navbar navbar-dark bg-dark shadow-sm">
      <div class="container">
        <a href="#" class="navbar-brand d-flex align-items-center">
          <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" aria-hidden="true" class="me-2" viewBox="0 0 24 24"><path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"/><circle cx="12" cy="13" r="4"/></svg>
          <strong>Album</strong>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
    </div>
  </header>
</template>

<style scoped>

</style>