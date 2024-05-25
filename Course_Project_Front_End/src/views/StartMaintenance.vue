<script>
export default {
    data() {
        return {
            attractionName: this.$route.query.name,
            reason: null,
            startDate: null
        };
    },
    methods: {
        submit() {
            this.startDate = new Date().toISOString();

            const maintenanceData = {
                reason: this.reason,
                startDate: this.startDate
            }
            console.log(maintenanceData);
            fetch(`http://localhost:8080/maintenance/addMaintenance/${this.attractionName}`, {
                method: 'POST',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(maintenanceData)
            }).then(function (response) {
                console.log(response);
            })
        }

    }
}
</script>

<template>
    <form @submit.prevent="submit">
        <p>Reason: <input type="text" v-model="reason"></p>
        <button type="submit">Start Maintenance</button>
    </form>
</template>