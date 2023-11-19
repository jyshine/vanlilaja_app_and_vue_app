import './assets/main.css'
// 이 부분은 웹 애플리케이션에 사용되는 스타일 시트를 가져오는 부분입니다. 
// main.css 파일은 애플리케이션의 전반적인 스타일을 정의하는데 사용될 것으로 예상됩니다.

import { createApp } from 'vue'
// 이 부분은 Vue.js 라이브러리에서 createApp 함수를 가져오고 있습니다. 
// createApp 함수는 Vue 애플리케이션 인스턴스를 생성하는 데 사용됩니다. 

import App from './App.vue'
// 이 부분은 프로젝트에 포함된 App.vue 파일을 가져오고 있습니다. 
// 이 파일은 일반적으로 Vue 애플리케이션의 최상위 컴포넌트로 사용되며, 
// 애플리케이션의 구조와 레이아웃을 정의합니다.
createApp(App).mount('#app')
// 이 부분은 앞서 가져온 createApp 함수를 사용하여 
// Vue 애플리케이션 인스턴스를 생성하고, 
// 생성한 애플리케이션을 HTML 문서의 특정 요소에 마운트(mount)하는 부분입니다.
// #app은 HTML 문서에서 해당 애플리케이션이 마운트될 요소의 ID를 나타냅니다. 
// 예를 들어, <div id="app"></div>와 같이 정의된 요소에 Vue 애플리케이션이 마운트됩니다.