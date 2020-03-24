# pms
## 人事管理系统，后台模块
## maven多模块开发依赖注意事项：
- domain,mapper,service,admin（web）,commons,dependencies
- dependencies是统一的依赖管理
- commons是公用模块，所有除本身和dependencies模块都可以依赖
- domain被mapper依赖，mapper被service依赖，service被admin(web)依赖。（解决）

