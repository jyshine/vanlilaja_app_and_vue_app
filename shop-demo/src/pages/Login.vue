<script setup>
import {reactive} from "vue";
import axios from "axios";
import {userInfoStore} from "@/store/user";
import router from "@/router";

const state = reactive({
  form: {
    email: "",
    password: ""
  }
})

const userStore = userInfoStore();
const submit = () => {
  axios.post("/api/account/signin", state.form)
      .then((data) => {
        console.log(data.data);
        userStore.setAccount(data.data);
        sessionStorage.setItem("token", data.data);

        window.alert("로그인 성공")
        router.push({path: "/"})
      })
      .catch((error) => {
        console.log(error)
        window.alert("로그인 실패")
      });
}

</script>

<template>
  <div class="form-signin w-100 m-auto">
<!--    <form>-->
      <img class="mb-4" src="/img/img1.jpeg" alt="" width="72" height="57">
      <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

      <div class="form-floating">
        <input type="email" class="form-control" id="floatingInput"  v-model.trim="state.form.email">
        <label for="floatingInput">Email address</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword"  v-model.trim="state.form.password">
        <label for="floatingPassword">Password</label>
      </div>

      <div class="form-check text-start my-3">
        <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
        <label class="form-check-label" for="flexCheckDefault">
          Remember me
        </label>
      </div>
      <button class="btn btn-primary w-100 py-2" @click="submit">Sign in</button>
      <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2023</p>
<!--    </form>-->
  </div>
</template>

<style scoped>
.form-signin {
  max-width: 330px;
  padding: 1rem;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>