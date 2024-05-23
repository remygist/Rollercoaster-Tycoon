import { createWebHistory, createRouter } from 'vue-router'

import HomeView from '../views/Homepage.vue'
import AddAttractionView from '../views/AddAttractions.vue'
import EditAttraction from '@/views/EditAttraction.vue'

const routes = [
  { path: '/', component: HomeView },
  { path: '/attractions/add', component: AddAttractionView },
  { path: '/attraction/edit', component: EditAttraction }
]

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
  routes,
})

export default router