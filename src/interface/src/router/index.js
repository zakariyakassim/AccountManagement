/*import Vue from 'vue'
import Vuetify from 'vuetify'

Vue.use(Vuetify)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    }
  ]
}) */

/*import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    }
  ]
})*/

import Vue from 'vue'
import Router from 'vue-router'
import GetAccounts from '@/components/GetAccounts'
import AddAccount from '@/components/AddAccount'
import DashBoard from '@/components/DashBoard'
import EditAccount from '@/components/EditAccount'




Vue.use(Router)

export default new Router({
  routes: [
    {
      path: "/",
      redirect: {
        name: "GetAccounts"
      }
    },
    {
      path: '/DashBoard',
      name: 'DashBoard',
      component: DashBoard
    },
    {
      path: '/GetAccounts',
      name: 'GetAccounts',
      component: GetAccounts
    },
    {
      path: '/AddAccount',
      name: 'AddAccount',
      component: AddAccount
    },
    {
      path: '/EditAccount',
      name: 'EditAccount',
      component: EditAccount
    }
  ]
})


