<template>
  <v-content>
    <v-container fluid>
      <v-layout align-center justify-center class="overflow-y-auto">
        <v-row>
          <v-col cols="12" sm="4">
            <v-flex>
              <v-card>
                <!-- received message -->
                <v-card-text>
                  <v-label>채팅 목록</v-label>
                  <v-list class="elevation-1 pa-5">
                    <message-list :messages="messages"> </message-list>
                  </v-list>
                </v-card-text>

                <v-divider></v-divider>

                <!-- enter message -->
                <my-chat class="pa-5" @send-message="sendMessage"></my-chat>
              </v-card>
            </v-flex>
          </v-col>
        </v-row>
      </v-layout>
    </v-container>
  </v-content>
</template>

<script>
import { mapMutations, mapState } from "vuex";
import Chat from "@/components/ChatList";
import SendChat from "@/components/SendChat";
// import store from "../store";

import Stomp from "webstomp-client";
import SockJS from "sockjs-client";

const path = "http://localhost:3000/ws";

export default {
  name: "HelloWorld",

  components: {
    "message-list": Chat,
    "my-chat": SendChat,
  },

  data: () => ({
    // recvList: [],
  }),

  created() {
    //try socket conn
    let socket = new SockJS(path);
    this.stompClient = Stomp.over(socket);
    console.log(`소켓 연결을 시도합니다. 서버 주소는 ${path}입니다`);
    this.stompClient.connect(
      {}, //headers
      (frame) => {
        this.connected = true;
        console.log("연결 성공", frame);

        //서버의 메시지 전송 endpoint 구독
        this.stompClient.subscribe("/topic/public", (res) => {
          console.log("구독으로 받은 메시지", res.body);

          //받은 데이터 json으로 파싱싱
          this.messages.push(JSON.parse(res.body));
        });
      },
      (error) => {
        this.connected = false;
        console.log("연결 실패", error);
      }
    );
  },

  methods: {
    ...mapMutations(["sendMessage"]),

    sendMessage(message) {
      console.log(message);

      if (this.stompClient && this.stompClient.connected) {
        const msg = {
          userId: 1,
          content: message,
        };
        //controller의 MessageMapping으로 간다
        this.stompClient.send("/pub/sendMsg", JSON.stringify(msg), {});
      }
    },
  },

  mounted() {
    // this.$socket.on('sendMessage', function(content){
    //   store.commit('sendMessage', content);
    // })
  },

  computed: {
    ...mapState(["messages"]),
  },
};
</script>
