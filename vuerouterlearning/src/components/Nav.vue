<script setup>
    import { RouterLink } from 'vue-router';
</script>
<template>
    <div>
        <RouterLink active-class="active" to="/">HOME</RouterLink>
    </div>
    <div>
        <RouterLink active-class="active" to="/about">ABOUT</RouterLink>
    </div>
</template>


<style scoped>
    .active {
        font-weight: 900;
        color: blue;
    }

</style>