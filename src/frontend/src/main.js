import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import Uploader from 'vue-media-upload';

createApp(App)
.use(router)
.component('Uploader', Uploader)
.mount('#app')
