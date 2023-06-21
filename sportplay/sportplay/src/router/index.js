import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../components/Login.vue"
import Home from "@/components/Home.vue";
import Welcome from "@/components/Welcome.vue";

Vue.use(VueRouter)

const routes = [
    {
        path: "/",
        redirect: "/login"
    },
    {
        path: "/login",
        component: Login
    },
    {
        path: "/home",
        component: Home,
        redirect: "/welcome",
        children: [
            {path: "/welcome", component: Welcome,}
        ],
    },
]

const router = new VueRouter({
    routes
})
// 挂载路由导航守卫，全局的，负责监视session是否被正常创建或销毁
router.beforeEach((to, from, next) => {
    // to 将要访问
    // from 从哪访问
    // next 接着干 next(url) 重定向到url上
    if (to.path === '/login') return next();
    // 获取user
    const userFlag = window.sessionStorage.getItem("user"); // 取出当前用户
    if (!userFlag) return next('/login'); // 无值，返回登录页
    next();
})

export default router
