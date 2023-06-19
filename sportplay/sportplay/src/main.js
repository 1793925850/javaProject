import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import './assets/css/global.css' // 添加全局样式
import './assets/font/iconfont.css' // 引入iconfont

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
