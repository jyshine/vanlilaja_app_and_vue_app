<script setup>
import {ref} from "vue";
import Card from "@/components/Card.vue";
import axios from "axios";
import router from "@/router";

const items = ref([]);
axios.get("/api/items")
    .then(({data}) => {
      items.value = data
      console.log(items)
      console.log(items.value)
      console.log(items.value[0])
    })
    .catch((error) => {
      console.log(error)
    });

const signup = () => {
  axios.post("/api/account/signup")
      .then(({data}) => {
        console.log(data)
        router.push({path: "/login"})
        window.alert("회원가입 완료 : "+ data)
      })
      .catch((error) => {
        console.log(error)
        window.alert("회원 가입 실패")
      });
};

</script>

<template>
  <main>
    <div class="home">
      <section class="py-5 text-center container">
        <div class="row py-lg-5">
          <div class="col-lg-6 col-md-8 mx-auto">
            <h1 class="fw-light">Shop Demo</h1>
            <p class="lead text-body-secondary">Shop Demo Site</p>
            <p>
              <a href="/login" class="btn btn-primary my-2">로그인</a>
              <button @click="signup" class="btn btn-secondary my-2">회원가입</button>
            </p>
          </div>
        </div>
      </section>

      <div class="album py-5 bg-body-tertiary">
        <div class="container">
          <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <div class="col"  v-for="item in items" :key="item.id">
              <Card :item="item"/>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<style scoped>

</style>