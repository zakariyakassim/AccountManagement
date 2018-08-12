<template>


  <div id="app">
    <v-app id="inspire">
     <!-- <v-layout align-center> -->

          <div id="buttons"><center>
            <v-btn  @click.native="btnDashBoardEvent" large color="primary">DASHBOARD</v-btn>
            <v-btn  @click.native="btnAddAccountEvent" large color="primary">ADD ACCOUNTS</v-btn>
            <v-btn  @click.native="btnGetAccountEvent" large color="primary">GET ACCOUNTS</v-btn>
          </center>
          </div>
      <br>
      <br>
      <router-view/>

    </v-app>
  </div>

  <!--<div id="app">



    <div id="buttons"><center>
      <v-btn large disabled color="primary">DASHBOARD</v-btn>
      <v-btn large color="primary">ADD ACCOUNTS</v-btn>
      <v-btn large color="primary">GET ACCOUNTS</v-btn>

    </center>
    </div>

    <router-view/>
  </div> -->
</template>

<script>



  import router from './router'
  export default {
    name: 'App',


    methods: {


      btnDashBoardEvent() {
       router.push({ name: "DashBoard" });


      },
      btnAddAccountEvent() {
        router.push({ name: "AddAccount" });

      },
      btnGetAccountEvent() {
        router.push({ name: "GetAccounts" });
      }
    }

  }






</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 0px;
  }

  #buttons {
    margin-top: 20px;
    margin-left: auto;
    margin-right: auto;

  }

</style>
