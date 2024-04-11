<script>
import Attraction from "../components/Attraction.vue";

export default {
    data() {
        return {
            attractions: []
        }
    },
    methods: {
        async getAttractions() {
            const currentComponent = this;

            fetch('http://localhost:8080/index')
                .then(response => response.json())
                .then(function (attractions) {
                    currentComponent.attractions = attractions;
                    console.log(currentComponent.attractions);
                })
        }
    },
    mounted() {
        console.log('attractions component');
        this.getAttractions();
    },
    components: {
        Attraction
    }
}
</script>

<template>
    <div class="attractionLayout">
        <Attraction v-for="attraction in attractions" :name="attraction.name" :capacity="attraction.capacity"
            :dateOfBuild="attraction.dateOfBuild" :maintenance="attraction.maintenance" :duration="attraction.duration"
            :minHeight="attraction.minHeight" :speed="attraction.speed" :onrideVideo="attraction.onrideVideo">
        </Attraction>
    </div>
    <RouterLink to="/attractions/add" class="btn">Add Attraction</RouterLink>
</template>
