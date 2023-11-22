import {createRouter, createWebHistory} from "vue-router"
import Home from "@/pages/Home.vue";
import Login from "@/pages/Login.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: "/",
            name: "home",
            component: Home
        },
        {
            path: "/login",
            name: "Login",
            component: Login
        }
    ]

})

export default router