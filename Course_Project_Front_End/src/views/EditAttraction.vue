<script>
export default {
    data() {
        return {
            attractionName: this.$route.query.name,
            attraction: null
        };
    },
    mounted() {
        this.fetchAttraction();
    },
    methods: {
        async fetchAttraction() {
            const currentComponent = this;

            fetch(`http://localhost:8080/index/getOne/${this.attractionName}`)
                .then(response => response.json())
                .then(function (attraction) {
                    currentComponent.attraction = attraction;
                    console.log(currentComponent.attraction);
                })
        },
        submit() {
            const attractionData = {
                name: this.attraction.name,
                capacity: this.attraction.capacity,
                dateOfBuild: this.attraction.dateOfBuild,
                image: this.attraction.image,
                onrideVideo: this.attraction.onrideVideo,
                maintenanceFrequency: this.attraction.maintenanceFrequency,
                duration: this.attraction.duration,
                minHeight: this.attraction.minHeight,
                speed: this.attraction.speed,
                inMaintenance: this.attraction.inMaintenance,
                nextMaintenance: this.attraction.nextMaintenance
            };

            console.log(attractionData);
            fetch(`http://localhost:8080/index/editAttraction/${this.attractionName}`,{
                method: 'PUT',
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(attractionData)
            }).then(function (response){
                console.log(response);
            })
        },
        deleteAttraction(){
            const currentComponent = this;

            fetch(`http://localhost:8080/index/deleteAttraction/${this.attractionName}`,{
                method: 'DELETE',
                headers: {"Content-Type": "application/json"},
            }).then(function (response){
                console.log(response);
            })
            this.$router.push('/');
            
        }
    }
}
</script>

<template>
    <div>
        <h1>Edit Attraction</h1>
        <p>Editing: {{ attractionName }}</p>
        <div v-if="attraction">
            <form @submit.prevent="submit">
                <h2>Edit Attraction Details</h2>
                <p>Name: <input type="text" v-model="attraction.name"></p>
                <p>Capacity: <input type="number" v-model="attraction.capacity"></p>
                <p>Date of Build: <input type="date" v-model="attraction.dateOfBuild"></p>
                <p>Image: <input type="text" v-model="attraction.image"></p>
                <p>Onride Video: <input type="text" v-model="attraction.onrideVideo"></p>
                <p>Maintenance frequency: <input type="number" v-model="attraction.maintenanceFrequency"></p>
                <p>Duration (in seconds): <input type="number" v-model="attraction.duration"></p>
                <p>Minimum height (in cm): <input type="number" v-model="attraction.minHeight"></p>
                <p>Speed: (in km/h) <input type="number" v-model="attraction.speed"></p>
                <button type="submit">Save Changes</button>
                <button @click="deleteAttraction">Delete Attraction</button>
            </form>
        </div>
        <div v-else>
            <p>Loading...</p>
        </div>
    </div>
</template>