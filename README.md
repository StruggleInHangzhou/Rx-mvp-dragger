# 自己开分支
* 用自己的名字做分支名字

## 项目结构
* java资源文件夹下包说明
    * __adapter:__ 适配器包
    * __bean:__ 实体类包,自建实体类Entity结尾直接在bean包下
    * __bean.dto:__ 服务端返回数据类型包,此处的类型可以直接问服务端要，直接对应服务端的返回类型
    * __bean.query:__ 服务端接收参数类型包,同理可以直接问服务端要,直接对应请求参数
    * __net:__ 联网接口
    * __other:__ app配置final量的Config类;四大组件传输key值定义的IntentConfig类
    * __receiver:__ 四大组件广播包
    * __service:__ 四大组件服务类包
    * __ui.activity:__ 四大组件activity的包,包下含有其有关的类和包
    * __ui.activity.contract:__ MVP中的接口关联包。
    * __ui.activity.moudle:__ MVP中的M层。网络数据,数据库数据,本地数据都从这里获取
    * __ui.activity.presenter:__ MVP中的P层。逻辑处理类的包
    * __ui.activity:__ 四大组件activity的包,包下含有其有关的类和包
    * __ui.fragment.contract:__ MVP中的接口关联包。
    * __ui.fragment.moudle:__ MVP中的M层。网络数据,数据库数据,本地数据都从这里获取
    * __ui.fragment.presenter:__ MVP中的P层。逻辑处理类的包
    * __utils:__ 工具类包
    * __view:__ 自定义视图的包

* java-gen资源文件夹下包说明
     * __base:__ 实体类的父类
     * __component:__ 其他组件的
     * __constant:__ 枚举,静态字段
     * __core:__ MVP核心包
     * __db:__ 数据库核心包
     * __di:__ dragger2核心包
     * __network:__ 联网核心包