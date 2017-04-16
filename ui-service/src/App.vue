<template>
    <div id="app">
        <div id="page">
            <fn-header></fn-header>
            <section id="content" role="main">
                <fn-page-header></fn-page-header>
                <router-view></router-view>
            </section>
            <fn-footer></fn-footer>
        </div>
    </div>
</template>

<script>
    import FnHeader from './components/dashboard/FnHeader.vue'
    import FnPageHeader from './components/dashboard/FnPageHeader.vue'
    import FnFooter from './components/dashboard/FnFooter.vue'

    export default {
        name: 'app',
        components: {
            FnHeader,
            FnPageHeader,
            FnFooter
        }
    }
</script>