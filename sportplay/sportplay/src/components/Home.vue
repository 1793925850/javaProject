<template>
    <div>Home!
        <el-button type="info" @click="logout">安全退出</el-button>
    </div>
</template>
<script>
export default {
    methods: {
        // 安全退出
        logout() {
            window.sessionStorage.clear(); // 清楚session
            this.$router.push("/login"); // 返回登录页
        }
    }
}
</script>
<style lang="less" scoped>

</style>