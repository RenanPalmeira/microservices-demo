<template>
    <nav class="aui-header">
        <div class="aui-header-primary">
            <h1 id="logo" class="aui-header-logo aui-header-logo-aui">
                <a href="#">
                    <span class="aui-header-logo-device">finance</span>
                </a>
            </h1>
            <ul class="aui-nav">
                <li>
                    <form class="aui-quicksearch" method="post" action="/foo">
                        <label class="assistive" for="quicksearchid">Search</label>
                        <input type="text" name="quicksearchname" placeholder="Quick Search" class="search" id="quicksearchid">
                    </form>
                </li>
            </ul>
        </div>
        <div class="aui-header-secondary">
            <ul class="aui-nav">
                <li>
                    <a href="http://example.com/">
                        <span class="aui-icon aui-icon-small aui-iconfont-help">Help</span>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
    import Octicon from 'vue-octicon/components/Octicon.vue'

    export default {
        components: {
            Octicon
        }
    }
</script>