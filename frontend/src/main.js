import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
// import './plugins/socketPlugin';
import store from "./store";
// import io from "socket.io-client";

//배포에 대한 팁 출력x
Vue.config.productionTip = false;

//socket conn
// const socket = io("http://localhost:8080/ws");

//Q
// Vue.prototype.$socket = socket;

new Vue({
  vuetify,
  store,
  render: (h) => h(App),
}).$mount("#app");
