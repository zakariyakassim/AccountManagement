<template>


  <v-layout justify-center>
    <v-flex xs12 sm10 md8 lg6>

      <h1>Edit Account</h1>
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
            v-bind:placeholder="this.accounts[0].firstName"
            required
          ></v-text-field>
          <br>
          <v-text-field
            ref="lastName"
            v-model="lastName"
            :rules="[() => !!lastName || 'This field is required']"
            :error-messages="errorMessages"
            label="Last Name"
            v-bind:placeholder="this.accounts[0].lastName"
            required
          ></v-text-field>
          <br>
          <v-text-field
            ref="accountNumber"
            v-model="accountNumber"
            :rules="[() => !!accountNumber || 'This field is required']"
            :error-messages="errorMessages"
            label="Account Number"
            v-bind:placeholder="this.accounts[0].accountNumber"
            required :disabled="true"
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

    data() {
      return {
        errorMessages: '',
        firstName: null,
        lastName: null,
        accountNumber: null,
        formHasErrors: false,

        accounts: []

      }
    },

    mounted () {


      axios.get(`api/accounts/`+this.$route.query.accountnumber)
        .then(response => {

          // JSON responses are automatically parsed.
          // this.data = response.status+""
          console.log(response.status)


          this.accounts = response.data;
          this.lastName = this.accounts[0].lastName
          this.accountNumber = this.accounts[0].accountNumber
          this.firstName = this.accounts[0].firstName



        })
        .catch(e => {
          this.errors.push(e)
        })




    },



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

            axios.post('api/accounts', {


              firstName: this.firstName,
              lastName: this.lastName,
              accountNumber: this.accountNumber


            })



            this.resetForm()






      },


      resetForm() {

       // this.$router.push('GetAccounts')

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
          this.$router.push('GetAccounts')
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
