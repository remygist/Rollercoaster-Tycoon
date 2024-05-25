<script>
export default {
    props: {
        title: String,
        attractions: Array
    }
}
</script>

<template>
    <div class="category">
        <p>Name:{{ title }}</p>
        <p>Attractions with this category: <span v-for="(attraction, index) in attractions" :key="index">
            {{ attraction.name }},
            </span>
        </p>
        <RouterLink :to="{ path: '/category/edit', query: { title: title} }" class="btn">Edit Category</RouterLink>
    </div>
</template>

