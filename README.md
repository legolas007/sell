# sell

### 项目描述：一个从下单到接单流程完整，包含买家端和卖家端前后台功能的微信点餐系统 ,采用前后端分离。

**技术栈：前端**使用**Vue** ，**后端**使用**Spring Boot**、**SpringData**，**Mybatis**、**Mysql**、**Redis**、**WebSocket**等，基于**MVC模式**开发。

后端为前端提供**restful化**接口，接入微信**SDK**接口，用户通过微信扫码登录下单等，用**redis**存储**token**对用户进行识别与持久化，使用**AOP**技术验证卖家端登录身份信息，**websocket**实现消息推送实时监控订单，使用**redis**缓存减少**mysql**数据库查询压力。使用**FastDFS**分布式文件系统，作为图片服务器。