<script>
export default {
    data() {
        return {
            categoryTitle: this.$route.query.title,
            category: null
        };
    },
    mounted() {
        this.fetchCategory();
    },
    methods: {
        async fetchCategory() {
            const currentComponent = this;

            fetch(`http://localhost:8080/category/getOne/${this.categoryTitle}`)
                .then(response => response.json())
                .then(function (category) {
                    currentComponent.category = category;
                    console.log(currentComponent.category);
                })
        },
        submit() {
            const categoryData = {
                
            };

            // console.log(categoryData);
            // fetch(`http://localhost:8080/index/editAttraction/${this.categoryTitle}`,{
            //     method: 'PUT',
            //     headers: {"Content-Type": "application/json"},
            //     body: JSON.stringify(categoryData)
            // }).then(function (response){
            //     console.log(response);
            // })
        },
        // deleteCategory(){
        //     const currentComponent = this;

        //     fetch(`http://localhost:8080/index/deleteAttraction/${this.attractionName}`,{
        //         method: 'DELETE',
        //         headers: {"Content-Type": "application/json"},
        //     }).then(function (response){
        //         console.log(response);
        //     })
        //     this.$router.push('/');
            
        // }
    }
}
</script>

<template>
    <div>
        <h1>Edit Category</h1>
        <p>Editing: {{ categoryTitle }}</p>
       
    </div>
</template>