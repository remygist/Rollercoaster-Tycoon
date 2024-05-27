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
    },
    methods: {
        endMaintenance() {
            fetch(`http://localhost:8080/maintenance/finishMaintenance/${this.name}`, {
                method: 'PUT',
                headers: { "Content-Type": "application/json" },
            }).then(function (response) {
                if (!response.ok) {
                    throw new Error('Failed to end maintenance. Please try again later.');
                }
                alert('Maintenance ended succesfully!');
                console.log(response);
                window.location.reload();
            })
        },
        formatDate(dateString) {
            return new Date(dateString).toISOString().split('T')[0];
        },

    }
}
</script>

<template>
    <div class="attraction">
        <p>Name: {{ name }}</p>
        <p>Capacity: {{ capacity }}</p>
        <p>Date of build: {{ formatDate(dateOfBuild) }}</p>
        <p>Maintenance frequency: {{ maintenanceFrequency }}</p>
        <p>Duration: {{ duration }}</p>
        <p>Minimum height: {{ minHeight }}</p>
        <p>Speed: {{ speed }}</p>
        <p>In maintenance: {{ inMaintenance }}</p>
        <p v-if="inMaintenance">Next maintenance due: Ongoing</p>
        <p v-else>Next maintenance due: {{ formatDate(nextMaintenance) }}</p>
        <p>Categories:
            <span v-for="(category, index) in categories" :key="index">{{ category.title }}, </span>
        </p>
        <template v-if="!inMaintenance">
            <p>Previous maintenances:
                <span v-for="(maintenance, index) in maintenances" :key="index">{{ maintenance.reason }}, </span>
            </p>
        </template>
        <a :href="onrideVideo" target="_blank">Onride video</a>
        <img :src="image" :alt="name">
        <br><br>
        <RouterLink :to="{ path: '/attraction/edit', query: { name: name } }" class="btn">Edit Attraction</RouterLink>
        <template v-if="inMaintenance">
            <button @click="endMaintenance" class="btn">End Maintenance</button>
        </template>
        <template v-else>
            <RouterLink :to="{ path: '/maintenance/add', query: { name: name } }" class="btn">Start Maintenance
            </RouterLink>
        </template>
    </div>
</template>
