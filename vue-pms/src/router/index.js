import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* 布局页 Layout */
import Layout from '@/layout'

/* Router Modules */

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   如果设置为真，项目将不会显示在侧栏(默认为假),如401，login等页面，或者如一些编辑页面/edit/1
 *
 * alwaysShow: true               如果设置为真，将始终显示根菜单,一直显示根路由，不显示（禁用子路由，也就是侧边栏的根菜单，然后展开的子菜单被禁用了)
 *                                如果不设置alwaysShow，当项目有多个子路由时，它将成为嵌套模式，否则不显示根菜单
 *                                当你一个路由下面的 children 声明的路由大于1个时，自动会变成嵌套的模式--如组件页面
 *                                只有一个时，会将那个子路由当做根路由显示在侧边栏--如引导页面
 *                                若你想不管路由下面的 children 声明的个数都显示你的根路由
 *
 * redirect: noRedirect           如果设置noRedirect将不会在面包屑中重定向,该路由在面包屑导航中不可被点击
 * name:'router-name'             设定路由的名字，一定要填写不然使用<keep-alive>时会出现各种问题
 * meta : {
    roles: ['admin','editor']    设置该路由进入的权限，支持多个权限叠加,控制页面角色(您可以设置多个角色)
    title: 'title'               设置该路由的名称显示在侧栏和面包屑(推荐设置)
    icon: 'svg-name'             设置该路由的图标,图标显示在侧栏中
    noCache: true                如果设置为真，页面将不会被 <keep-alive> 缓存 (默认为假)
    affix: true                  如果设置为真，则标记将附加在标记视图中(也就是面包屑下面的)
    breadcrumb: false            如果设置为false，则不会在breadcrumb面包屑中显示
    activeMenu: '/example/list'  如果设置路径，侧栏将突出显示您设置的路径
  }
 */

/**
 * constantRoutes 代表那些不需要动态判断权限的路由，如登录页、404、等通用页面。
 * 可以访问所有角色
 */
export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path(.*)',
        component: () => import('@/views/redirect/index')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/login/auth-redirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error-page/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error-page/401'),
    hidden: true
  },
  {
    path: '/',
    component: Layout,
    redirect: '/home',
    children: [
      {
        path: 'home',
        component: () => import('@/views/home/index'),
        name: 'Home',
        meta: { title: '首页', icon: 'dashboard', affix: true }
      }
    ]

  },

  {
    path: '/profile',
    component: Layout,
    redirect: '/profile/index',
    hidden: true,
    name: '',
    children: [
      {
        path: 'index',
        component: () => import('@/views/profile/index'),
        name: 'Profile',
        meta: { title: '个人信息', icon: 'user', noCache: true }
      }
    ]
  },
  // ,
  {
    path: '/employee',
    component: Layout,
    redirect: '/employee/basic',
    hidden: true,
    meta: { title: '员工资料', requireAuth: true },
    children: [
      {
        path: 'basic',
        component: () => import('@/views/employee/basic'),
        name: 'EmployeeBasic',
        meta: { title: '基本资料', requireAuth: true }
      },
      {
        path: 'advanced',
        component: () => import('@/views/employee/advanced'),
        name: 'EmployeeAdvanced',
        meta: { title: '高级资料' }
      }
    ]
  },
  {
    path: '/personnel',
    component: Layout,
    redirect: '/personnel/information',
    hidden: true,
    meta: { title: '人事管理'},
    children: [
      {
        path: 'information',
        component: () => import('@/views/personnel/information'),
        name: 'PersonnelInformation',
        meta: { title: '人事资料'}
      }
    ]
  }



]

/**
 * asyncRoutes 异步挂载的路由
 * 动态需要根据权限加载的路由表
 * 需要根据用户角色动态加载的路由
 */
export const asyncRoutes = [
  // {
  //   path: '/employee',
  //   component: Layout,
  //   redirect: '/employee/basic',
  //   meta: { title: '员工资料123', requireAuth: true },
  //   children: [
  //     {
  //       path: 'basic',
  //       component: () => import('@/views/employee/basic'),
  //       name: 'EmployeeBasic',
  //       meta: { title: '基本资料', requireAuth: true }
  //     },
  //     {
  //       path: 'advanced',
  //       component: () => import('@/views/employee/advanced'),
  //       name: 'EmployeeAdvanced',
  //       meta: { title: '高级资料' }
  //     }
  //   ]
  // },
  /** when your routing map is too long, you can split it into small modules **/
  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

/**
 * 创建路由
 * @returns {VueRouter}
 */
const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

/**
 * 重置路由
 */
// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
































// import Vue from 'vue'
// import Router from 'vue-router'
//
// Vue.use(Router)
//
// /* 布局页 Layout */
// import Layout from '@/layout'
//
// /* Router Modules */
//
// /**
//  * Note: sub-menu only appear when route children.length >= 1
//  * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
//  *
//  * hidden: true                   如果设置为真，项目将不会显示在侧栏(默认为假),如401，login等页面，或者如一些编辑页面/edit/1
//  *
//  * alwaysShow: true               如果设置为真，将始终显示根菜单,一直显示根路由，不显示（禁用子路由，也就是侧边栏的根菜单，然后展开的子菜单被禁用了)
//  *                                如果不设置alwaysShow，当项目有多个子路由时，它将成为嵌套模式，否则不显示根菜单
//  *                                当你一个路由下面的 children 声明的路由大于1个时，自动会变成嵌套的模式--如组件页面
//  *                                只有一个时，会将那个子路由当做根路由显示在侧边栏--如引导页面
//  *                                若你想不管路由下面的 children 声明的个数都显示你的根路由
//  *
//  * redirect: noRedirect           如果设置noRedirect将不会在面包屑中重定向,该路由在面包屑导航中不可被点击
//  * name:'router-name'             设定路由的名字，一定要填写不然使用<keep-alive>时会出现各种问题
//  * meta : {
//     roles: ['admin','editor']    设置该路由进入的权限，支持多个权限叠加,控制页面角色(您可以设置多个角色)
//     title: 'title'               设置该路由的名称显示在侧栏和面包屑(推荐设置)
//     icon: 'svg-name'             设置该路由的图标,图标显示在侧栏中
//     noCache: true                如果设置为真，页面将不会被 <keep-alive> 缓存 (默认为假)
//     affix: true                  如果设置为真，则标记将附加在标记视图中(也就是面包屑下面的)
//     breadcrumb: false            如果设置为false，则不会在breadcrumb面包屑中显示
//     activeMenu: '/example/list'  如果设置路径，侧栏将突出显示您设置的路径
//   }
//  */
//
// /**
//  * constantRoutes 代表那些不需要动态判断权限的路由，如登录页、404、等通用页面。
//  * 可以访问所有角色
//  */
// export const constantRoutes = [
//     {
//         path: '/redirect',
//         component: Layout,
//         hidden: true,
//         children: [
//             {
//                 path: '/redirect/:path(.*)',
//                 component: () => import('@/views/redirect/index')
//             }
//         ]
//     },
//     {
//         path: '/login',
//         component: () => import('@/views/login/index'),
//         hidden: true
//     },
//     {
//         path: '/auth-redirect',
//         component: () => import('@/views/login/auth-redirect'),
//         hidden: true
//     },
//     {
//         path: '/404',
//         component: () => import('@/views/error-page/404'),
//         hidden: true
//     },
//     {
//         path: '/401',
//         component: () => import('@/views/error-page/401'),
//         hidden: true
//     },
//     {
//         path: '/',
//         component: Layout,
//         redirect: '/home',
//         children: [
//             {
//                 path: 'home',
//                 component: () => import('@/views/home/index'),
//                 name: 'Home',
//                 meta: { title: '首页', icon: 'dashboard', affix: true }
//             }
//         ]
//
//     },
//
//     {
//         path: '/profile',
//         component: Layout,
//         redirect: '/profile/index',
//         hidden: true,
//         children: [
//             {
//                 path: 'index',
//                 component: () => import('@/views/profile/index'),
//                 name: 'Profile',
//                 meta: { title: '个人信息', icon: 'user', noCache: true }
//             }
//         ]
//     },
//   {
//     path: '/employee',
//     component: Layout,
//     redirect: '/employee/basic',
//     meta: { title: '员工资料', requireAuth: true },
//     children: [
//       {
//         path: 'basic',
//         component: () => import('@/views/employee/basic'),
//         name: 'EmployeeBasic',
//         meta: { title: '基本资料', requireAuth: true }
//       },
//       {
//         path: 'advanced',
//         component: () => import('@/views/employee/advanced'),
//         name: 'EmployeeAdvanced',
//         meta: { title: '高级资料' }
//       }
//     ]
//   }
// ]
//
// /**
//  * asyncRoutes 异步挂载的路由
//  * 动态需要根据权限加载的路由表
//  * 需要根据用户角色动态加载的路由
//  */
// export const asyncRoutes = [
//
//     /** when your routing map is too long, you can split it into small modules **/
//     // 404 page must be placed at the end !!!
//     { path: '*', redirect: '/404', hidden: true }
// ]
//
// /**
//  * 创建路由
//  * @returns {VueRouter}
//  */
// const createRouter = () => new Router({
//     // mode: 'history', // require service support
//     scrollBehavior: () => ({ y: 0 }),
//     routes: constantRoutes
// })
//
// const router = createRouter()
//
// /**
//  * 重置路由
//  */
// // Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
// export function resetRouter() {
//     const newRouter = createRouter()
//     router.matcher = newRouter.matcher // reset router
// }
//
// export default router
