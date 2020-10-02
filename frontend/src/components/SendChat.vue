<template>
  <v-form @submit.prevent="sendMsg">
    <v-label>~메시지를 입력하시오~</v-label>
    <v-row>
      <v-col cols="9">
        <v-text-field v-model="message" required></v-text-field>
      </v-col>

      <v-col cols="3">
        <v-btn :disabled="disabled" type="submit">send</v-btn>
      </v-col>
    </v-row>
  </v-form>
</template>

<script>

export default {
  data() {
    return {
      message: "",
    };
  },

  computed: {
    disabled() {
      return !this.message;
    },
  },

  methods: {
    //this.$socket.emit('서버로 보낼 이벤트명', 데이터);
    //this.$socket.on('서버에서 받을 이벤트명', 데이터);

    sendMsg() {
      this.$socket.emit('chat', this.msg);
      this.message = "";
    },
  },
};
</script>
