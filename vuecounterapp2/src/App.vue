<script setup>
  // 이 부분은 Vue 3의 <script setup> 문법을 나타냅니다.
  // 이 영역에서는 일반적인 Vue 컴포넌트의 data, methods, computed 등을 
  // 정의하는 대신, setup 함수와 함께 필요한 로직을 작성합니다.
  
  import {ref} from "vue";  
  // Vue 라이브러리에서 ref 함수를 가져옵니다. ref 함수는 반응적인 데이터를 생성하는 데 사용됩니다.

  const count = ref(0);
  // count라는 변수를 선언하고, 
  // 이 변수를 ref 함수로 감싸 초기값을 0으로 설정합니다. 
  // ref 함수로 감싼 변수는 Vue의 반응적인 시스템에 의해 추적되며, 값이 변경될 때 컴포넌트가 자동으로 리렌더링됩니다.
</script>
<template>
  <main>
    <div>
        <h4>The current count is...</h4>
        <h1 >
          {{count}}
        </h1>
        <button @click="count--">-</button>
        <button @click="count++">+</button>
    </div>
</main>
</template> 

<style scoped>
  main {
    background-color: aliceblue;
    height: 100vh;
    width: 100vw;
    display: flex;
    align-items: center;
    justify-content: center;
  }

div {
  text-align: center;
}
</style>