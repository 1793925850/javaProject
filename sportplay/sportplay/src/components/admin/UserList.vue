<template>
    <div>
        <!--面包屑导航-->
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>权限管理</el-breadcrumb-item>
            <el-breadcrumb-item>用户列表</el-breadcrumb-item>
        </el-breadcrumb>
        <!--用户列表主体-->
        <el-card>

            <!--搜索区域-->
            <el-row :gutter="25">
                <!-- 搜索添加 -->
                <el-col :span="10">
                    <el-input placeholder="请输入搜索内容">
                        <el-button slot="append" icon="el-icon-search" @click="getUserList"></el-button>
                    </el-input>
                </el-col>
                <!--搜索按钮-->
                <el-col :span="4">
                    <el-button type="primary" @click="addDialogVisible = true">添加用户</el-button>
                </el-col>
            </el-row>

            <span>
                {{ userList }}
            </span>

        </el-card>
    </div>
</template>

<script>
export default {
    created() {
        this.getUserList();
    },

    data() {
        return {
            // 查询信息实体
            queryInfo: {
                query: "",
                pageNum: 1,
                pageSize: 5,
            },
            userList: [], // 用户列表
            total: 0, // 总记录数
        }
    },

    methods: {
        // 获取用户列表
        async getUserList() {
            const {data: res} = await this.$http.get("alluser", {params: this.queryInfo});
            this.userList = res.data;
            this.total = res.number;
        },

        addDialogVisible() {

        },
    },
}
</script>

<style lang="less" scoped>
/* 面包屑样式 */
.el-breadcrumb {
  margin-bottom: 15px;
  font-size: 17px;
}


</style>