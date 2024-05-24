<script>
import Category from "../components/Category.vue";

export default {
    data() {
        return {
            categories: []
        }
    },
    methods: {
        async getCategories() {
            const currentComponent = this;

            fetch('http://localhost:8080/category')
                .then(response => response.json())
                .then(function (categories) {
                    currentComponent.categories = categories;
                    console.log(currentComponent.categories);
                })
        },
    },
    mounted() {
        console.log('categories component');
        this.getCategories();
    },
    beforeRouteEnter(to, from, next) {
        next(vm => {
            vm.getCategories();
        });
    },
    components: {
        Category
    }
}
</script>

<template>
    <div class="categoryLayout">
        <Category v-for="category in categories" :title="category.title" :attractions="category.attractions">

        </Category>
    </div>
</template>