import Vue from "vue";
import Vuex from "vuex";

//Vuex 사용을 위한 등록
Vue.use(Vuex);

export default new Vuex.Store({

    //변수
    state:{
        messages: [],
    },

    //state를 사용하는 함수
   mutations:{
        sendMessage() {

        },
    },
});