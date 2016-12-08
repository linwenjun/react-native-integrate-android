## 一，参数说明

page: String 

说明，需要跳转的页面

data: String

说明:可以为空字符串,需要解析为json

| 参数   | 类型     | 说明                               | 必须   |
| ---- | ------ | -------------------------------- | ---- |
| page | String | 需要跳转的页面 /ViewController/Activity | 是    |
| data | String | 此页面需要的参数,没有数据时可以为空字符串            | 是    |



## 二，React Native 页面列表(待完善)

| 页面   | page     | data |
| ---- | -------- | ---- |
| 首页   | Home     | ""   |
| 分类   | Category | ""   |
|      |          |      |







## 三，代码示例

### React Native 跳转至原生 Android 

以下为Java代码中作为Module开放给React-native，被react-native调用，在此函数中，应根据page和data的不同，而进行跳转

```java
package com.jnexpert.rnbridge;

...

public class JNIntentModule extends ReactContextBaseJavaModule {
  @ReactMethod
  public void goNative(String page, String data) {
	// 以下逻辑为android接受到参数后自己实现跳转逻辑		
  	getCurrentActivity().startActivity(new Intent(getCurrentActivity(), MainActivity.class));
  	getCurrentActivity().finish();
  	getCurrentActivity().overridePendingTransition(0, 0);
  }  
}
  
```



### Android 跳转至 React Native

```java
// 在任意地方，可以用如下代码跳转
Intent intent = new Intent();
// 
intent.setClass(getApplicationContext(), com.jnexpert.rnbridge.MainActivity.class);
intent.putExtra("page", "Main");
intent.putExtra("data", "{\"id\":1}");
startActivity(intent);
finish();
overridePendingTransition(0, 0);
```



### React Native 跳转至原生 iOS

```ob
// JNIntentModule.m 文件中

#import "JNIntentModule.h"

@implementation JNIntentModule

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(goNative:(NSString *)page data:(NSString *)data)
{
	// 此处 iOS 接受到参数并且进行跳转
    NSLog(@"Pretending to create an event %@ at %@", name, location);
}

@end

```



### iOS 跳转至 React Native

```
// 在任意地方利用如下代码跳转
// 连接 http://localhost:8081/index.ios.bundle?platform=ios 需要 在 RN 项目下 运行 npm start

- (void)goDemoReactNative {
    NSURL *jsCodeLocation = [NSURL
                             URLWithString:@"http://localhost:8081/index.ios.bundle?platform=ios"];
    
    RCTRootView *rootView =
    [[RCTRootView alloc] initWithBundleURL : jsCodeLocation
                         moduleName        : @"JNProject"
                         initialProperties :
     @{
       @"page" : @"Main",
       @"data" : @"{\"id\": 1}"		// 此处为 json 字符串
      }
                          launchOptions    : nil];
    UIViewController *vc = [[UIViewController alloc] init];
    vc.view = rootView;
    _window.rootViewController = vc;
}
```

