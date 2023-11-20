<script setup>
import cars from "../data/cars.json"
import { RouterLink } from "vue-router";
</script>

<template>
    <div>
        <h1>HOME VIEW</h1>
        <div class="cars">
            <RouterLink :to="`/cars/${car.id}`" v-for="car in cars" :key="car.id" href="">
                {{ car.name }}
            </RouterLink>
        </div>
    </div>
</template>

<style scoped>
.cars {
    display: flex;
}

.cars a {
    text-decoration: none;
    color: black;
    background-color: aqua;
    width: 100%;
    box-shadow: 1px 1px 10px rgba(red, green, blue, alpha);
    margin: 10px;
}
</style>