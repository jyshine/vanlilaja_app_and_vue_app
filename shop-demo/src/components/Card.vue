<script setup>
import {defineProps} from "vue";

const { item } = defineProps(['item']);

</script>

<template>
  <div class="card shadow-sm">
    <span class="img" :style="{backgroundImage: `url(${item.imgPath})`}"/>
<!--    <img :src="item.imgPath">-->
<!--    <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>-->
    <div class="card-body">
      <p class="card-text">{{item.name}}</p>
      <div class="d-flex justify-content-between align-items-center">
<!--        <div class="btn-group">-->
<!--          <button type="button" class="btn btn-sm btn-outline-secondary">View</button>-->
<!--          <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>-->
<!--        </div>-->
        <button class="btn btn-primary">구입하기</button>
        <small class="text-body-secondary">{{item.price}}</small>
      </div>
    </div>
  </div>
</template>

<style scoped>
.card .img {
  display: inline-block;
  width: 100%;
  height: 250px;
  background-size: cover;
  background-position: center;
}

.card .card-body .price {
  text-decoration: line-through;
}
</style>