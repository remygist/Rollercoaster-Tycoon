<script>
import Attraction from "./Attraction.vue";

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
            <Attraction v-for="attraction in attractions" :name="attraction.name" :capacity="attraction.capacity"></Attraction>
</template>
