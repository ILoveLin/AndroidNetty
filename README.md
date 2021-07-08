# ANetty

![Image](app/src/main/ic_launcher-web.png)

[![Download](https://img.shields.io/badge/download-App-blue.svg)](https://raw.githubusercontent.com/jenly1314/ANetty/master/app/release/app-release.apk)
[![JitPack](https://jitpack.io/v/jenly1314/ANetty.svg)](https://jitpack.io/#jenly1314/ANetty)
[![CI](https://travis-ci.org/jenly1314/ANetty.svg?branch=master)](https://travis-ci.org/jenly1314/ANetty)
[![CircleCI](https://circleci.com/gh/jenly1314/ANetty.svg?style=svg)](https://circleci.com/gh/jenly1314/ANetty)
[![API](https://img.shields.io/badge/API-16%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![License](https://img.shields.io/badge/license-Apche%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Blog](https://img.shields.io/badge/blog-Jenly-9933CC.svg)](https://jenly1314.github.io/)
[![QQGroup](https://img.shields.io/badge/QQGroup-20867961-blue.svg)](http://shang.qq.com/wpa/qunwpa?idkey=8fcc6a2f88552ea44b1411582c94fd124f7bb3ec227e2a400dbbfaad3dc2f5ad)

ANetty for Android 是基于Netty二次封装的Android链路通讯库，用以快速开发高性能，高可靠性的网络交互。在保证易于开发的同时还保证其应用的性能，稳定性和伸缩性。


## Gif 展示
![Image](GIF.gif)


## 引入

### Maven：
```maven
    <dependency>
      <groupId>com.king.anetty</groupId>
      <artifactId>anetty</artifactId>
      <version>1.0.3</version>
      <type>pom</type>
    </dependency>
```
### Gradle:
```gradle
    implementation 'com.king.anetty:anetty:1.0.3'
```
### Lvy:
```lvy
    <dependency org='com.king.anetty' name='anetty' rev='1.0.3'>
      <artifact name='$AID' ext='pom'></artifact>
    </dependency>
```

###### 如果Gradle出现compile失败的情况，可以在Project的build.gradle里面添加如下：（也可以使用上面的GitPack来complie）
```gradle
    allprojects {
        repositories {
            maven { url 'https://dl.bintray.com/jenly/maven' }
        }
    }
```

## 示例

代码示例

> ANetty暂并不提供Netty服务端封装库，因为在真实的场景中，服务端一般都依赖项目对应的业务。为了方便演示客户端效果，有个简易的[服务端demo](server)，直接以Java的形式直接运行ANettyServer即可启动Netty服务

Netty服务端：
```Java
    //初始化并启动服务
    new ANettyServer().start(String host,int port);
```

Netty客户端：
```Java
    //初始化Netty
    mNetty = new ANetty(new Netty.OnChannelHandler() {
        @Override
        public void onMessageReceived(ChannelHandlerContext ctx,String msg) {
            //TODO 接收到消息
        }

        @Override
        public void onExceptionCaught(ChannelHandlerContext ctx,Throwable e) {

        }
    }, true);
    //设置连接监听
    mNetty.setOnConnectListener(new Netty.OnConnectListener() {
        @Override
        public void onSuccess() {
            //TODO 连接成功
        }

        @Override
        public void onFailed() {
            //TODO 连接失败
        }

        @Override
        public void onError(Exception e) {
            //TODO 连接异常
            Log.e(ANetty.TAG,e.getMessage());
        }
    });
    //设置发送消息监听
    mNetty.setOnSendMessageListener(new Netty.OnSendMessageListener() {
        @Override
        public void onSendMessage(Object msg, boolean success) {
            //TODO 发送消息，根据success判断是否发送成功
        }

        @Override
        public void onException(Throwable e) {
            //TODO 异常
        }
    });

    //初始化后，连接Netty
    mNetty.connect(String host,int port);

```

更多使用详情，请查看[app](app)中的源码使用示例

### 相关开源项目
##### [EasyChat](https://github.com/yetel/EasyChatAndroidClient) 一款即时通讯APP


## 版本记录

#### v1.0.3：2019-11-13
*  OnChannelHandler接口内方法新增ChannelHandlerContext参数

#### v1.0.2：2019-10-30
*  新增setOnSendMessageListener方法
*  更新Netty依赖至4.1.43.Final

#### v1.0.1：2019-9-26
*  移除support依赖
*  更新Netty依赖至4.1.42.Final

#### v1.0.0：2019-3-30
*  ANetty初始版本


## 申明

#### 我这里只做保存,原项目地址是https://github.com/jenly1314/ANetty 

