<template>
  <nav>
    <RouterLink to="/">All attractions</RouterLink>
    <RouterLink to="/attractions/add">Add attractions</RouterLink>
    <RouterLink to="/categories">All categories</RouterLink>
  </nav>
  <main>
    <RouterView />
  </main>
</template>