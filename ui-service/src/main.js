import Vue from 'vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'
import VueAui from 'vue-aui'

import App from './App.vue'
import routes from './router'
import store from './store'

Vue.use(VueRouter)
Vue.use(VueResource)
Vue.use(VueAui)

Vue.config.debug = true;

const router = new VueRouter({
  routes // short for routes: routes
})

const app = new Vue({
    store,
    router,
    replace: false,
    components: {
        App
    },
    render: h => h(App)
}).$mount('#app')