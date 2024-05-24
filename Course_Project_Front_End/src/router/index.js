import { createWebHistory, createRouter } from 'vue-router'

import HomeView from '../views/Homepage.vue'
import AddAttractionView from '../views/AddAttractions.vue'
import EditAttraction from '../views/EditAttraction.vue'
import AllCategories from '../views/AllCategories.vue'
import EditCategories from '../views/EditCategories.vue'

const routes = [
  { path: '/', component: HomeView },
  { path: '/attractions/add', component: AddAttractionView },
  { path: '/attraction/edit', component: EditAttraction },
  { path: '/categories', component: AllCategories},
  { path:	'/category/editCategory', component: EditCategories}
]

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
  routes,
})

export default router