<script>
export default {
    props: {
        name: String,
        capacity: Number,
        dateOfBuild: String,
        maintenance: String,
        duration: Number,
        minHeight: Number,
        speed: Number,
        image: String,
        onrideVideo: String
    }
}
</script>

<template>
    <div class="attraction">
        <p>Name:{{ name }}</p>
        <p>Capacity: {{ capacity }}</p>
        <p>Date of build: {{ dateOfBuild }}</p>
        <p>Maintenance: {{ maintenance }}</p>
        <p>Duration: {{ duration }}</p>
        <p>Minimum height: {{ minHeight }}</p>
        <p>Speed: {{ speed }}</p>
        <a :href="onrideVideo" target="_blank">Onride video</a>
        <img :src="image" :alt="name">
        <br>
        <br>
        <RouterLink :to="{ path: '/attraction/edit', query: { name: name } }" class="btn">Edit Attraction</RouterLink>
    </div>
</template>

