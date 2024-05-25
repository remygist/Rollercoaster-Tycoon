<script>
export default {
    data() {
        return {
            categoryTitle: this.$route.query.title,
            originalTitle: this.$route.query.title,
            category: null
        };
    },
    methods: {
        submit() {
            const categoryData = {
                title: this.categoryTitle
            };

            console.log(categoryData);
            fetch(`http://localhost:8080/category/editCategory/${this.originalTitle}`,{
                method: 'PUT',
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(categoryData)
            }).then(function (response){
                console.log(response);
            })
        },
        deleteCategory(){
            const currentComponent = this;

            fetch(`http://localhost:8080/category/deleteCategory/${this.originalTitle}`,{
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
        <form @submit.prevent="submit">
                <h2>Edit Attraction Details</h2>
                <p>Name: <input type="text" v-model="categoryTitle"></p>
                <button type="submit">Save Changes</button>
                <button @click="deleteCategory">Delete Category</button>
            </form>
    </div>
</template>