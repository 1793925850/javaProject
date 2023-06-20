<template>
  <!--引入container布局-->
    <el-container class="home-container">
        <!--头部-->
        <el-header>
            <div>
                <img src="../assets/logo2.png" alt="">
                <span>个人运动平台</span>
            </div>
            <el-button type="info" @click="logout">安全退出</el-button>
        </el-header>
        <!--主体-->
        <el-container>
            <!--侧边栏-->
            <el-aside width="200px">Aside</el-aside>
            <!--主体内容-->
            <el-main>Main</el-main>
        </el-container>
    </el-container>
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
.home-container {
  height: 100%;
}

// 头样式
.el-header {
  background-color: #373d41;
  display: flex;
  justify-content: space-between; // 左右贴边
  padding-left: 0%; // 左边界
  color: #fff;
  font-size: 20px;

  > div {
    display: flex;
    align-items: center;

    span {
      margin-left: 15px;
    }
  }

}

// 侧边样式
.el-aside {
  background-color: #333744;
}

// 主体样式
.el-main {
  background-color: #eaedf1;
}

img {
  width: 55px;
  height: 55px;
}

</style>