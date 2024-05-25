<script>
export default {
    data(){
        return {
            title: '',
        }
    },
    methods:{
        submit(){
            const categoryData = {
                title: this.title,
            };
            fetch('http://localhost:8080/category',{
                method: 'POST',
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(categoryData)
            }).then(function (response){
                console.log(response);
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