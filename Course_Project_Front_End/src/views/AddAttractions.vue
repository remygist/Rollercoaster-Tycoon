<script>
export default {
    data() {
        return {
            name: '',
            capacity: 0,
            dateOfBuild: '',
            image: '',
            onrideVideo: '',
            maintenanceFrequency: '',
            duration: 0,
            minHeight: 0,
            speed: 0,
            inMaintenance: ""
        }
    },
    methods: {
        submit() {
            const attractionData = {
                name: this.name,
                capacity: this.capacity,
                dateOfBuild: this.dateOfBuild,
                image: this.image,
                onrideVideo: this.onrideVideo,
                maintenanceFrequency: this.maintenanceFrequency,
                duration: this.duration,
                minHeight: this.minHeight,
                speed: this.speed,
                inMaintenance: this.inMaintenance
            };
            fetch('http://localhost:8080/index',{
                method: 'POST',
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(attractionData)
            }).then(function (response){
                console.log(response);
            })
        }
    }
}
</script>

<template>
    <form @submit.prevent="submit">
        <h1>Add attraction</h1>
        <p>Name: <input type="text" v-model="name"></p>
        <p>Capacity: <input type="number" v-model="capacity"></p>
        <p>Date Of Build: <input type="date" v-model="dateOfBuild"></p>
        <p>Image: <input type="text" v-model="image"></p>
        <p>Onride Video: <input type="text" v-model="onrideVideo"></p>
        <p>Maintenance frequency: <input type="number" v-model="maintenanceFrequency"></p>
        <p>Duration (in seconds): <input type="number" v-model="duration"></p>
        <p>Minimum height (in cm): <input type="number" v-model="minHeight"></p>
        <p>Speed: (in km/h) <input type="number" v-model="speed"></p>
        <button type="submit">Add attraction</button>
    </form>
</template>