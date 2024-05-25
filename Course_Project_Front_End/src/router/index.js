import { createWebHistory, createRouter } from 'vue-router'

import HomeView from '../views/Homepage.vue'
import AddAttractionView from '../views/AddAttractions.vue'
import EditAttraction from '../views/EditAttraction.vue'
import AllCategories from '../views/AllCategories.vue'
import EditCategories from '../views/EditCategories.vue'
import AddCategories from '../views/AddCategories.vue'
import StartMaintenance from '@/views/StartMaintenance.vue'

const routes = [
  { path: '/', component: HomeView },
  { path: '/attractions/add', component: AddAttractionView },
  { path: '/attraction/edit', component: EditAttraction },
  { path: '/categories', component: AllCategories },
  { path: '/category/edit', component: EditCategories },
  { path: '/categories/add', component: AddCategories},
  { path: '/maintenance/add',component: StartMaintenance}
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
})

export default router