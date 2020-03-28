import { login, logout, getInfo, getRouterMenu } from '@/api/user'
import { getToken, setToken, removeToken } from '@/utils/auth'
import router, { resetRouter } from '@/router'

// 用户令牌和角色信息
const state = {
    token: getToken(),
    name: '',
    avatar: '',
    introduction: '',
    roles: [],
    menus: []
}

// 自定义权限信息
const mutations = {
    SET_TOKEN: (state, token) => {
        state.token = token
    },
    SET_INTRODUCTION: (state, introduction) => {
        state.introduction = introduction
    },
    SET_NAME: (state, name) => {
        state.name = name
    },
    SET_AVATAR: (state, avatar) => {
        state.avatar = avatar
    },
    SET_ROLES: (state, roles) => {
        state.roles = roles
    },
    SET_MENUS: (state, menus) => {
      state.menus = menus
    }
}

// 用户登录逻辑
const actions = {

    // 获取路由表
    getRouterMenu({ commit, state }) {
      return new Promise(((resolve, reject) => {
        getRouterMenu(state.token).then(response => {
          const { data } = response
          console.log(data)

          if (!data) {
            reject('验证失败，请重新登录')
          }

          const menus = data
          if (!menus || menus.length <= 0) {
            reject('路由菜单不能为空')
          }
          commit('SET_MENUS', menus)
          resolve(menus)
        }).catch(error => {
          reject(error)
        })
      }))
    },

    // 用户登录
    login({ commit }, userInfo) {
        const { username, password } = userInfo
        return new Promise((resolve, reject) => {
            login({ username: username.trim(), password: password }).then(response => {
                const { data } = response
                commit('SET_TOKEN', data.token)
                // 把令牌写入 cookie
                setToken(data.token)
                resolve()
            }).catch(error => {
                reject(error)
            })
        })
    },

    // 获取用户角色信息
    getInfo({ commit, state }) {
        return new Promise((resolve, reject) => {
            getInfo(state.token).then(response => {
                const { data } = response

                if (!data) {
                    reject('验证失败，请重新登录。')
                }

                const { roles, name, avatar, introduction } = data

                // 角色必须是非空数组
                if (!roles || roles.length <= 0) {
                    reject('getInfo: 角色必须是非空数组!')
                }

                commit('SET_ROLES', roles)
                commit('SET_NAME', name)
                commit('SET_AVATAR', avatar)
                commit('SET_INTRODUCTION', introduction)
                resolve(data)
            }).catch(error => {
                reject(error)
            })
        })
    },

    // user logout 退出
    logout({ commit, state, dispatch }) {
        return new Promise((resolve, reject) => {
            logout(state.token).then(() => {
                commit('SET_TOKEN', '')
                commit('SET_ROLES', [])
                removeToken()
                resetRouter()

                // reset visited views and cached views
                // to fixed https://github.com/PanJiaChen/vue-element-admin/issues/2485
                dispatch('tagsView/delAllViews', null, { root: true })

                resolve()
            }).catch(error => {
                reject(error)
            })
        })
    },

    // 重置/删除令牌token
    resetToken({ commit }) {
        return new Promise(resolve => {
            commit('SET_TOKEN', '')
            commit('SET_ROLES', [])
            removeToken()
            resolve()
        })
    },

    // dynamically modify permissions
    changeRoles({ commit, dispatch }, role) {
        return new Promise(async resolve => {
            const token = role + '-token'

            commit('SET_TOKEN', token)
            setToken(token)

            const { roles } = await dispatch('getInfo')

            resetRouter()

            // generate accessible routes map based on roles
            const accessRoutes = await dispatch('permission/generateRoutes', roles, { root: true })

            // dynamically add accessible routes
            router.addRoutes(accessRoutes)

            // reset visited views and cached views
            dispatch('tagsView/delAllViews', null, { root: true })

            resolve()
        })
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions
}

















//
// import { login, logout, getInfo } from '@/api/user'
// import { getToken, setToken, removeToken } from '@/utils/auth'
// import router, { resetRouter } from '@/router'
//
// // 用户令牌和角色信息
// const state = {
//   token: getToken(),
//   name: '',
//   avatar: '',
//   introduction: '',
//   roles: []
// }
//
// // 自定义权限信息
// const mutations = {
//   SET_TOKEN: (state, token) => {
//     state.token = token
//   },
//   SET_INTRODUCTION: (state, introduction) => {
//     state.introduction = introduction
//   },
//   SET_NAME: (state, name) => {
//     state.name = name
//   },
//   SET_AVATAR: (state, avatar) => {
//     state.avatar = avatar
//   },
//   SET_ROLES: (state, roles) => {
//     state.roles = roles
//   }
// }
//
// // 用户登录逻辑
// const actions = {
//
//   // 用户登录
//   login({ commit }, userInfo) {
//     const { username, password } = userInfo
//     return new Promise((resolve, reject) => {
//       login({ username: username.trim(), password: password }).then(response => {
//         const { data } = response
//         commit('SET_TOKEN', data.token)
//         // 把令牌写入 cookie
//         setToken(data.token)
//         resolve()
//       }).catch(error => {
//         reject(error)
//       })
//     })
//   },
//
//   // 获取用户角色信息
//   getInfo({ commit, state }) {
//     return new Promise((resolve, reject) => {
//       getInfo(state.token).then(response => {
//         const { data } = response
//
//         if (!data) {
//           reject('验证失败，请重新登录。')
//         }
//
//         const { roles, name, avatar, introduction } = data
//
//         // 角色必须是非空数组
//         if (!roles || roles.length <= 0) {
//           reject('getInfo: 角色必须是非空数组!')
//         }
//
//         commit('SET_ROLES', roles)
//         commit('SET_NAME', name)
//         commit('SET_AVATAR', avatar)
//         commit('SET_INTRODUCTION', introduction)
//         resolve(data)
//       }).catch(error => {
//         reject(error)
//       })
//     })
//   },
//
//   // user logout 退出
//   logout({ commit, state, dispatch }) {
//     return new Promise((resolve, reject) => {
//       logout(state.token).then(() => {
//         commit('SET_TOKEN', '')
//         commit('SET_ROLES', [])
//         removeToken()
//         resetRouter()
//
//         // reset visited views and cached views
//         // to fixed https://github.com/PanJiaChen/vue-element-admin/issues/2485
//         dispatch('tagsView/delAllViews', null, { root: true })
//
//         resolve()
//       }).catch(error => {
//         reject(error)
//       })
//     })
//   },
//
//   // 重置/删除令牌token
//   resetToken({ commit }) {
//     return new Promise(resolve => {
//       commit('SET_TOKEN', '')
//       commit('SET_ROLES', [])
//       removeToken()
//       resolve()
//     })
//   },
//
//   // dynamically modify permissions
//   changeRoles({ commit, dispatch }, role) {
//     return new Promise(async resolve => {
//       const token = role + '-token'
//
//       commit('SET_TOKEN', token)
//       setToken(token)
//
//       const { roles } = await dispatch('getInfo')
//
//       resetRouter()
//
//       // generate accessible routes map based on roles
//       const accessRoutes = await dispatch('permission/generateRoutes', roles, { root: true })
//
//       // dynamically add accessible routes
//       router.addRoutes(accessRoutes)
//
//       // reset visited views and cached views
//       dispatch('tagsView/delAllViews', null, { root: true })
//
//       resolve()
//     })
//   }
// }
//
// export default {
//   namespaced: true,
//   state,
//   mutations,
//   actions
// }
