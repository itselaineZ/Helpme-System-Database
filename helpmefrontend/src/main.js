import './plugins/axios'
import { createApp } from 'vue'
import App from './App.vue'
import HomeView from ".//views/HomeView";
import router from './router'
import store from './store'
import axios from 'axios'
//import './assets/scss/paper-dashboard.scss'
import './assets/css/bootstrap.min.css'
import './assets/css/paper-dashboard.css'
//import './assets/scss/paper-dashboard/_sidebar-and-main-panel.scss'
//import './assets/css/font-face.css'
//import './assets/css/font-awesome.min.css'
//import './assets/css/demo.css'
import './plugins/demo'
//import {formatDate} from './plugins/Utils'

const app = createApp(App)
app.config.globalProperties.$axios = axios
app.use(store).use(router).mount('#app')

