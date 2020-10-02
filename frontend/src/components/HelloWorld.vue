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
                    <message-list
                        :messages="messages"
                    >
                    </message-list>
                  </v-list>
                </v-card-text>

                <v-divider></v-divider>

                <!-- enter message -->
                <my-chat class="pa-5" :user="1"></my-chat>
              </v-card>
            </v-flex>
          </v-col>
        </v-row>
      </v-layout>
    </v-container>
  </v-content>
</template>

<script>
import {mapMutations, mapState} from 'vuex';
import Chat from '@/components/ChatList';
import SendChat from "@/components/SendChat";
import store from '../store';

  export default {
    name: 'HelloWorld',

    components: {
      'message-list': Chat,
      'my-chat': SendChat,
    },

    data: () => ({
      recvList: [],
    }),

    mounted() {
      this.$socket.on('sendMessage', function(content){
        store.commit('sendMessage', content);
      })
    },

    computed:{
      ...mapState(['messages']),
    },

    methods:{
      ...mapMutations(['sendMessage',])
    },
  }
</script>
