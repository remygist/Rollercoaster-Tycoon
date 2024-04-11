import { createWebHistory, createRouter } from 'vue-router'

import HomeView from '../views/Homepage.vue'
import AboutView from '../views/AddAttractions.vue'

const routes = [
  { path: '/', component: HomeView },
  { path: '/attractions/add', component: AboutView },
]

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
  routes,
})

export default router