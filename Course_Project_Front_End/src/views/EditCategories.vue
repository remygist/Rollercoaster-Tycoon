<script>
export default {
    data() {
        return {
            categoryTitle: this.$route.query.title,
            originalTitle: this.$route.query.title,
            category: null,
            addAttractionName: null,
            removeAttractionName: null,
            attractions: []
        };
    },
    methods: {
        submit() {
            if (!this.categoryTitle || !this.attractions) {
            alert('Please fill in a category name.');
            return;
            }
            const categoryData = {
                title: this.categoryTitle,
                attractions: this.attractions
            };

            console.log(categoryData);
            fetch(`http://localhost:8080/category/editCategory/${this.originalTitle}`, {
                method: 'PUT',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(categoryData)
            }).then(function (response) {
                if (!response.ok) {
                    throw new Error('Failed to update category name. Please try again later.');
                }
                alert('Category name updated succesfully!');
                console.log(response);
            })
        },
        deleteCategory() {
            const currentComponent = this;

            fetch(`http://localhost:8080/category/deleteCategory/${this.originalTitle}`, {
                method: 'DELETE',
                headers: { "Content-Type": "application/json" },
            }).then(function (response) {
                if (!response.ok) {
                    throw new Error('Failed to delete category. Please try again later.');
                }
                alert('Category deleted succesfully!');
                console.log(response);
            })
            this.$router.push('/');

        },
        addAttraction() {  

            if (!this.categoryTitle || !this.addAttractionName) {
            alert('Please fill in the name of the attraction you want to add.');
            return;
        }

            const categoryData = {
                categoryName: this.categoryTitle,
                attractionName: this.addAttractionName
            }
            console.log(categoryData)
            fetch(`http://localhost:8080/index/addCategory`, {
                method: 'POST',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(categoryData)
            }).then(function (response) {
                if (!response.ok) {
                    throw new Error('Failed to add attraction to category. Please try again later.');
                }
                alert('Category added to attraction succesfully!');
                console.log(response);
            })
            
     
        },
        deleteAttractionFromCategory() { 
            if (!this.categoryTitle || !this.removeAttractionName) {
            alert('Please fill in the name of the attraction you want to delete.');
            return;
            }
            const attractionData = {
                name: this.removeAttractionName
            }
            console.log(attractionData)
            fetch(`http://localhost:8080/index/deleteCategoryFromAttraction/${this.categoryTitle}`, {
                method: 'DELETE',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(attractionData)
            }).then(function (response) {
                if (!response.ok) {
                    throw new Error('Failed to delete attraction from category. Please try again later.');
                }
                alert('Category deleted from attraction succesfully!');
                console.log(response);
            })
            
     
        }
    }
}
</script>

<template>
    <div>
        <form @submit.prevent="submit">
            <h2>Edit Categories Details</h2>
            <p>Name: <input type="text" v-model="categoryTitle"></p>
            <button type="submit">Save Changes</button>
            <button @click="deleteCategory">Delete Category</button>
            <div>
                <h3>Add Attraction To Catergory</h3>
                <input type="text" v-model="addAttractionName" placeholder="Attraction Name">
                <button type="button" @click="addAttraction">Add Attraction</button>
            </div>
            <div>
                <h3>Delete Attraction From Catergory</h3>
                <input type="text" v-model="removeAttractionName" placeholder="Attraction Name">
                <button type="button" @click="deleteAttractionFromCategory">Delete Attraction</button>
            </div>
        </form>
    </div>

</template>