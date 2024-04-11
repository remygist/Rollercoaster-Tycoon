<script>
export default {
    props: {
        name: String,
        capacity: Number
    }
}
</script>

<template>
    <div class="attraction">
        <p>Name:{{ name }}</p>
        <p>Capacity: {{ capacity }}</p>
        <br>
    </div>
</template>
