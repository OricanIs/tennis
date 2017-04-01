## 用户端
>所有的参数拼接在网址后面 
>所有的返回结果都是json类型
>


### 获取我的资料
**url** `/user/myInfo`
#### request
```js


```

#### response
```js
{
	 "code": 0,
    "msg": "success", 	//success 成功;needLogin 需要登录 ;
    "result": {
        "city": "东城区",
        "level": "入门",
        "nation": "中国",
        "playhand": "左手",
        "sex": "男",
        "mobile": "13122210065",
        "weight": "110",
        "avatar": "headimage",
        "playWay": "双反",
        "singleWinningRate": 0,
        "birthYear": "1121221111",
        "integral": 201,
        "provice": "北京市",
        "name": "orican",
        "rank": 0,
        "id": 1,
        "state": "正常",
        "age": 11,
        "canChanllage": false,
        "gamesCount": 0,
        "height": "170",
        "nationFlag": "http://muxu.oss-cn-hangzhou.aliyuncs.com/china.png",
        "teamWinningRate": 0
    }
  
}

``` 

### 更新用户信息
**url** `/user/update`
#### request
```js

age=19		
aveter=imageurl
city=2
province=1
forehand=0
height=69
weight=79
name=orican
sex=1
nation=1
nation_flay=url

```
#### response

```js
{
    "msg": "success",
    "result": "",
    "code": 0
}

```

### 查看其他用户信息
**url** `/user/otherUserinfo`
#### request
```js
	id=1  //required
```
#### response

```js
{
    "msg": "success",
    "result": {
        "city": "东城区",
        "level": "入门",
        "nation": "中国",
        "playhand": "右手",
        "sex": "女",
        "mobile": "131XXXX0065",
        "weight": "79",
        "avatar": "headimage",
        "playWay": "双反",
        "singleWinningRate": 0,
        "birthYear": "1121221111",
        "integral": 201,
        "provice": "北京市",
        "name": "orican",
        "rank": 0,
        "id": 1,
        "state": "正常",
        "age": 19,
        "canChanllage": false,
        "gamesCount": 0,
        "height": "69",
        "nationFlag": "http://muxu.oss-cn-hangzhou.aliyuncs.com/china.png",
        "teamWinningRate": 0
    },
    "code": 0
}

```



