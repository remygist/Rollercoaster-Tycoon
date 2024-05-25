<script>
export default {
    props: {
        name: String,
        capacity: Number,
        dateOfBuild: String,
        image: String,
        onrideVideo: String,
        maintenanceFrequency: Number,
        duration: Number,
        minHeight: Number,
        speed: Number,
        inMaintenance: Boolean,
        nextMaintenance: String,
        categories: Array,
        maintenances: Array
    }
}
</script>

<template>
    <div class="attraction">
        <p>Name:{{ name }}</p>
        <p>Capacity: {{ capacity }}</p>
        <p>Date of build: {{ dateOfBuild }}</p>
        <p>Maintenance frequency: {{ maintenanceFrequency }}</p>
        <p>Duration: {{ duration }}</p>
        <p>Minimum height: {{ minHeight }}</p>
        <p>Speed: {{ speed }}</p>
        <p>In maintenance: {{ inMaintenance }}</p>
        <p>Categories: <span v-for="(category, index) in categories" :key="index">
                {{ category.title }},
            </span></p>
        <p>Previous maintenances: {{ maintenances }}</p>
        <p>Next maintenance due: {{ nextMaintenance }}</p>
        <a :href="onrideVideo" target="_blank">Onride video</a>
        <img :src="image" :alt="name">
        <br>
        <br>
        <RouterLink :to="{ path: '/attraction/edit', query: { name: name } }" class="btn">Edit Attraction</RouterLink>
        <RouterLink :to="{ path: '/maintenance/add', query: { name: name } }" class="btn">Start Maintenance</RouterLink>
    </div>
</template>

