
import router from './router'
import store from './store'
import { Message } from 'element-ui'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import { getToken } from '@/utils/auth' // get token from cookie
import getPageTitle from '@/utils/get-page-title'

NProgress.configure({ showSpinner: false }) // NProgress Configuration

const whiteList = ['/login', '/auth-redirect'] // 没有重定向白名单

// 钩子函数之前的回调
router.beforeEach(async(to, from, next) => {
    // 开始进度条
    NProgress.start()

    // 设置页面标题
    document.title = getPageTitle(to.meta.title)

    // 确定用户是否已登录
    const hasToken = getToken()

    // 如果携带了token
    if (hasToken) {
        if (to.path === '/login') {
            // 如果已登录，则重定向到主页
            next({ path: '/' })
            // 进度条开始
            NProgress.done()
        } else {
            // 确定用户是否通过getInfo获得了他的权限角色
            const hasRoles = store.getters.roles && store.getters.roles.length > 0
            if (hasRoles) {
                next()
            } else {
                try {
                    // 获取用户信息
                    // 注意:角色必须是一个对象数组!例如:['admin']或，['developer'，'editor']
                    const { roles } = await store.dispatch('user/getInfo')

                    // 根据角色生成可访问路由映射
                    const accessRoutes = await store.dispatch('permission/generateRoutes', roles)

                    // 动态添加可访问路由
                    router.addRoutes(accessRoutes)

                    // hack方法，以确保addRoutes是完整的
                    // 设置replace: true，这样导航就不会留下历史记录
                    next({ ...to, replace: true })
                } catch (error) {
                    // 删除令牌，进入登录页面重新登录
                    await store.dispatch('user/resetToken')
                    Message.error(error || 'Has Error')
                    next(`/login?redirect=${to.path}`)
                    NProgress.done()
                }
            }
        }
    } else {
    /* 没有令牌 token*/

        if (whiteList.indexOf(to.path) !== -1) {
            // 在免费登录白名单，直接去
            next()
        } else {
            // 没有访问权限的其他页面被重定向到登录页面。
            next(`/login?redirect=${to.path}`)
            NProgress.done()
        }
    }
})

// 钩子函数之后的回调
router.afterEach(() => {
    // 完成进度条
    NProgress.done()
})






















// import router from './router'
// import store from './store'
// import { Message } from 'element-ui'
// import NProgress from 'nprogress' // progress bar
// import 'nprogress/nprogress.css' // progress bar style
// import { getToken } from '@/utils/auth' // get token from cookie
// import getPageTitle from '@/utils/get-page-title'
//
// NProgress.configure({ showSpinner: false }) // NProgress Configuration
//
// const whiteList = ['/login', '/auth-redirect'] // 没有重定向白名单
//
// // 钩子函数之前的回调
// router.beforeEach(async(to, from, next) => {
//     // 开始进度条
//     NProgress.start()
//
//     // 设置页面标题
//     document.title = getPageTitle(to.meta.title)
//
//     // 确定用户是否已登录
//     const hasToken = getToken()
//
//     // 如果携带了token
//     if (hasToken) {
//         if (to.path === '/login') {
//             // 如果已登录，则重定向到主页
//             next({ path: '/' })
//             // 进度条开始
//             NProgress.done()
//         } else {
//             // 确定用户是否通过getInfo获得了他的权限角色
//             const hasRoles = store.getters.roles && store.getters.roles.length > 0
//             if (hasRoles) {
//                 next()
//             } else {
//                 try {
//                     // 获取用户信息
//                     // 注意:角色必须是一个对象数组!例如:['admin']或，['developer'，'editor']
//                     const { roles } = await store.dispatch('user/getInfo')
//
//                     // 根据角色生成可访问路由映射
//                     const accessRoutes = await store.dispatch('permission/generateRoutes', roles)
//
//                     // 动态添加可访问路由
//                     router.addRoutes(accessRoutes)
//
//                     // hack方法，以确保addRoutes是完整的
//                     // 设置replace: true，这样导航就不会留下历史记录
//                     next({ ...to, replace: true })
//                 } catch (error) {
//                     // 删除令牌，进入登录页面重新登录
//                     await store.dispatch('user/resetToken')
//                     Message.error(error || 'Has Error')
//                     next(`/login?redirect=${to.path}`)
//                     NProgress.done()
//                 }
//             }
//         }
//     } else {
//     /* 没有令牌 token*/
//
//         if (whiteList.indexOf(to.path) !== -1) {
//             // 在免费登录白名单，直接去
//             next()
//         } else {
//             // 没有访问权限的其他页面被重定向到登录页面。
//             next(`/login?redirect=${to.path}`)
//             NProgress.done()
//         }
//     }
// })
//
// // 钩子函数之后的回调
// router.afterEach(() => {
//     // 完成进度条
//     NProgress.done()
// })
