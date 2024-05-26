<script>
export default {
    data() {
        return {
            title: '',
        }
    },
    methods: {
        submit() {
            if (!this.title.trim()) {
                alert('Please enter a title.');
                return;
            }

            const categoryData = {
                title: this.title,
            };
            fetch('http://localhost:8080/category', {
                method: 'POST',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(categoryData)
            }).then(function (response) {
                if (!response.ok) {
                    throw new Error('Failed to add category. Please try again later.');
                }
                alert('Category added succesfully!');
                console.log(response);
                window.location.reload();
            })
        }
    }
}
</script>

<template>
    <form @submit.prevent="submit">
        <h1>Add category:</h1>
        <p>Title: <input type="text" v-model="title"></p>
        <button type="submit">Add category</button>
    </form>
</template>