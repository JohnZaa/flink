# feat 管理

## 基础系统功能（System Foundation）

Feature 编号	功能名	描述
F001	项目初始化与模块拆分	基于 Spring Boot 3、WebFlux 初始化项目结构，划分 controller/service/api 等模块
F002	通用配置中心	加载并管理 application.yaml / Flink 连接配置
F003	通用异常处理机制	全局异常捕捉与统一响应（WebFlux 异常适配）
F004	接口文档支持（可选）	接入 springdoc-openapi / GraphQL Playground


⸻

## 规则配置管理（Flink sql Rule Config）

Feature 编号	功能名	描述
F101	新增规则配置	提交规则表达式（Flink Sql）
F102	修改规则配置	编辑规则内容及其元信息
F103	查询规则列表	获取所有规则及其元数据（分页、搜索）
F104	删除规则配置	逻辑删除规则
F105	规则语法校验（可选）	对 SQL 表达式等做基础语义校验
F106	规则版本管理（可选）	保留历史版本、支持回滚


⸻

## Flink 任务配置管理（Job Config）

Feature 编号	功能名	描述
F201	创建任务配置	输入任务名称、并行度、规则引用、运行方式等
F202	编辑任务配置	修改任务参数
F203	查询任务列表	获取所有已保存的任务配置
F204	删除任务配置	逻辑删除
F205	YAML/JSON 导入导出	支持任务配置导入导出（备份用途）
F206	Job 模板支持（可选）	预定义常用任务模板，快速生成任务


⸻

## Flink 作业提交与运行（Job Submission）

Feature 编号	功能名	描述
F301	提交任务至 Flink	使用配置构建 Flink job，并提交至 Flink 集群（REST / CLI）
F302	支持多种运行模式	支持 standalone、yarn-per-job、k8s 运行模式切换
F303	查看作业运行状态	查询 Flink REST API 获取 job 状态、task 状态等
F304	取消正在运行的作业	提供 cancel job 操作
F305	查看作业运行日志（可选）	可通过日志系统（如 Loki）或 WebSocket 实时查看运行日志
F306	Job 提交失败重试（可选）	异步重试提交失败的任务


⸻

## 任务历史与监控（Job History & Monitor）

Feature 编号	功能名	描述
F401	作业运行记录保存	每次提交记录 jobId、时间、提交人、状态等
F402	查询任务提交历史	支持查看某任务下的多次运行记录
F403	作业失败报警（可选）	提供 webhook、钉钉、企业微信报警
F404	实时作业状态轮询（可选）	提供任务状态变更的订阅机制（WebSocket 推送）


⸻

## 系统管理（System Admin）

Feature 编号	功能名	描述
F501	用户登录（可选）	Spring Security 实现登录管理
F502	权限管理（可选）	基于角色（管理员/普通用户）控制访问资源
F503	系统运行配置项管理	设置 Flink Rest URL、默认并发度等
F504	集群健康检查（可选）	周期性检查 Flink 集群可用性与提交能力


⸻

## 接口设计支持（API & UI 支撑）

Feature 编号	功能名	描述
F601	REST 接口支持或 GraphQL	可选 GraphQL 或 REST 作为后端接口
F602	接口校验与响应标准化	使用 @Validated + 响应封装 DTO
F603	Swagger 或 GraphQL UI	开发期间查看接口请求结构



⸻

