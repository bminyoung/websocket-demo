<template>
  <v-list>
    <transition-group name="list">
      <div v-for="(msg, index) in messages" v-bind:key="index">
        <v-list-item>
          <v-list-item-action>
            <label>{{ msg.userId }} : </label>
          </v-list-item-action>

          <v-list-item-content>
            <v-textarea
              :value="msg.content"
              label="msg.userId"
              readonly
              dense
              rows="1"
              outlined
              auto-grow
              hide-details
            >
              <template v-slot:label>{{ msg.userId }}</template>
            </v-textarea>
          </v-list-item-content>
        </v-list-item>

        <v-divider></v-divider>
      </div>
    </transition-group>
  </v-list>
</template>

<script>
export default {
  props: ["messages"],
};
</script>

<style></style>
