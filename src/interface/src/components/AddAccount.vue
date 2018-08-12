<template>


  <v-layout justify-center>
    <v-flex xs12 sm10 md8 lg6>

      <h1>Add Account</h1>
      <br>
      <br>

      <v-card id="form" ref="form">
        <v-card-text>
          <v-text-field
            ref="firstName"
            v-model="firstName"
            :rules="[() => !!firstName || 'This field is required']"
            :error-messages="errorMessages"
            label="First Name"
            placeholder="John"
            required
          ></v-text-field>
          <br>
          <v-text-field
            ref="lastName"
            v-model="lastName"
            :rules="[() => !!lastName || 'This field is required']"
            :error-messages="errorMessages"
            label="Last Name"
            placeholder="Doe"
            required
          ></v-text-field>
          <br>
          <v-text-field
            ref="accountNumber"
            v-model="accountNumber"
            :rules="[() => !!accountNumber || 'This field is required']"
            :error-messages="errorMessages"
            label="Account Number"
            placeholder="3343563"
            required
          ></v-text-field>
        </v-card-text>
        <v-divider class="mt-5"></v-divider>
        <v-card-actions>
          <v-btn flat @click="resetForm">Clear</v-btn>
          <v-spacer></v-spacer>
          <v-slide-x-reverse-transition>
            <v-tooltip
              v-if="formHasErrors"
              left
            >

            </v-tooltip>
          </v-slide-x-reverse-transition>
          <v-btn color="primary" flat @click="submit">Submit</v-btn>
        </v-card-actions>
      </v-card>
    </v-flex>
  </v-layout>


</template>

<script>


  import Vue from 'vue'
  import axios from 'axios'
  import VueAxios from 'vue-axios'


  Vue.use(VueAxios, axios)


  export default {
    el: '',
    data: () => ({
      errorMessages: '',
      firstName: null,
      lastName: null,
      accountNumber: null,

      formHasErrors: false
    }),

    computed: {
      form() {
        return {
          firstName: this.firstName,
          lastName: this.lastName,
          accountNumber: this.accountNumber,

        }
      }
    },

    watch: {
      name() {
        this.errorMessages = ''
      }
    },

    methods: {



      postData: function () {


       // if (this.containsObject(this.accountNumber,))

      /*  axios.get(`api/accounts/`+this.accountNumber)
          .then(response => {

            alert("Account number has been taken.")


          })
          .catch(e => { */


            axios.post('api/accounts', {
              firstName: this.firstName,
              lastName: this.lastName,
              accountNumber: this.accountNumber

            })


            this.resetForm()


      },


      resetForm() {




        this.errorMessages = []
        this.formHasErrors = false

        Object.keys(this.form).forEach(f => {
          this.$refs[f].reset()
        })
      },
      submit() {


        this.formHasErrors = false

        Object.keys(this.form).forEach(f => {
          if (!this.form[f]) this.formHasErrors = true

          this.$refs[f].validate(true)

          // window.location.href = this.firstName;


        })
        if (!this.formHasErrors) {
          this.postData()
        }
      }
    }
  }


</script>

<style scoped>
  h1, h2 {
    font-weight: lighter;
  }
</style>
