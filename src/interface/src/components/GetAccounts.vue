
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<template>




  <!-- <b-table striped hover :items="items"></b-table>-->
<center>

  <h1>Get Accounts</h1>
  <br>
  <br>

    <div id="search" class="input-group input-group-lg">
      <div class="input-group-prepend">
        <span class="input-group-text" id="inputGroup-sizing-lg">ACCOUNT NUMBER</span>
      </div>
      <input type="text" v-model="accountNumber" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm">

      <v-btn id="btnSearch" large @click="searchAccount" color="primary">GET</v-btn>

    </div>



    <div id="members">
      <div class="col-md-8 col-md-offset-2">

        <table class="table table-bordered table-striped">
          <thead>
          <th>Firstname</th>
          <th>Lastname</th>
          <th>Account Number</th>
          <th>Action</th>
          </thead>
          <tbody>
          <tr  v-for="account, index) in accounts">
            <td>{{ account.firstName.charAt(0).toUpperCase()+ account.firstName.slice(1) }}</td>
            <td>{{ account.lastName.charAt(0).toUpperCase()+ account.lastName.slice(1) }}</td>
            <td>{{ account.accountNumber }}</td>
            <td>
              <button class="btn btn-success" @click="editAccount(account.accountNumber, index)"><span class="glyphicon glyphicon-edit"></span> Edit</button> <button class="btn btn-danger" @click="deleteAccount(account.accountNumber, index)"><span class="glyphicon glyphicon-trash"></span> Delete</button>

            </td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>

</center>


</template>




<script>

  import Vue from 'vue'
  import axios from 'axios'
  import VueAxios from 'vue-axios'


  Vue.use(VueAxios, axios)




    export default {
        name: "#members",

      data() {
          return {
            accounts: [],

            accountNumber: this.accountNumber

            }
      },



      mounted() {
        this.getAllAccounts()
      //  this.searchAccount()
      },



      methods:{

        editAccount: function(accountNumber, index){



        //  this.$router.push('EditAccount')

         // this.$router.push({ name: 'EditAccount', params: { userId: 123 }})
          this.$router.push({ path: 'EditAccount', query: { accountnumber: accountNumber }})
        //  router.push({ path: `/editUser/${userId}` })

        },

        deleteAccount: function(accountNumber, index){

          this.accounts.splice(index, 1);

          axios.delete(`api/accounts/delete/`+accountNumber)
            .then(response => {
              console.log(response.status)
              this.getAllAccounts()

            })
            .catch(e => {
              this.errors.push(e)
            })


        },

        searchAccount: function(){

          axios.get(`api/accounts/`+this.accountNumber)
            .then(response => {

              // JSON responses are automatically parsed.
              // this.data = response.status+""
              console.log(response.status)
              this.accounts = response.data;
              console.log(response.data)


            })
            .catch(e => {
              this.errors.push(e)
            })


        },

        getAllAccounts: function(){

          axios.get(`api/accounts`)
            .then(response => {
              // JSON responses are automatically parsed.
              // this.data = response.status+""
              console.log(response.status)
              this.accounts = response.data;


            })
            .catch(e => {
              this.errors.push(e)
            })


        }
      }

    }

</script>

<style scoped>
  #search {
    width : 800px;
  }
  #btnSearch {
    margin: 0px;
    margin-left: 20px;

  }

  #members {
    margin-top: 30px;
  }

  h1, h2 {
    font-weight: lighter;
  }
</style>
