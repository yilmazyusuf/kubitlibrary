import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import Uploader from 'vue-media-upload';



const app  = createApp(App)
.use(router)
.component('Uploader', Uploader);

app.config.globalProperties.$filters = {
  currencyUSD(text,length,suffix) {
     if (text.length > length) {
                    return text.substring(0, length) + suffix;
                } else {
                    return text;
                }
  }
}
app.mount('#app');




