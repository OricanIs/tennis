## 用户端
>所有的参数拼接在网址后面  <br>
>所有的返回结果都是json类型 <br>
>如果返回的 msg不在解析的范围内，直接输出reason，并终止操作 <br>
><font color=red>***新增接口</font>
>1 获取我的伙伴 <br>
>2 保存我的伙伴 <br>
>3 删除我的伙伴 <br>
>


### 获取我的伙伴

**url** `/user/myPartners`
#### request
```js
openid=orican 

```

#### response
```js
{
    "msg": "success",
    "result": [
        {
            "birthday": 1121221111,
            "backhand": 1,
            "city": 796,
            "level": 2,
            "nation": 1,
            "registerTime": 1121221111,
            "openid": "orican1",
            "sex": 2,
            "mobile": "13122210064",
            "weight": 110,
            "avatar": "http://muxu.oss-cn-hangzhou.aliyuncs.com/user/5366d0160924ab18d9105e4432fae6cd7b890bba.jpg",
            "pinyin": "orican1",
            "province": 795,
            "integral": 385,
            "name": "orican1",
            "id": 2,
            "age": 11,
            "forehand": 1,
            "height": 170,
            "nationFlag": "http://muxu.oss-cn-hangzhou.aliyuncs.com/china.png",
            "status": 0
        }
    ],
    "reason": "success",
    "code": 0
}
```

### 保存我的伙伴

**url** `/user/savePartner`
#### request
```js
partnerId=3&openid=orican //partnerId 为我的伙伴列表中用户id

```

#### response
```js
	{
    "msg": "success",
    "reason": "success",
    "code": 0
}

```
### 删除我的伙伴

**url** `/user/delPartner`
#### request
```js
partnerId=3&openid=orican  //partnerId 为我的伙伴列表中用户id

```

#### response
```js
	{
    "msg": "success",
    "reason": "success",
    "code": 0
}

```




### 微信登陆验证

**url** `/user/login`
#### request
```js

	code:1sfsdfsdfsfsfsfsd

```

#### response
```js
	{
    "msg": "success",
    "result": {
        "birthday": 0,
        "backhand": 0,
        "city": 0,
        "level": 0,
        "nation": 0,
        "registerTime": 1491233464,
        "openid": "otOAZ0W6LmqT9v8JknEKd9xGAWNQ",
        "sex": 0,
        "mobile": "",
        "weight": 0,
        "avatar": "",
        "pinyin": "",
        "province": 0,
        "integral": 0,
        "name": "",
        "id": 0,
        "age": 0,
        "forehand": 0,
        "height": 0,
        "nationFlag": "",
        "status": 0
    },
    "reason": "success",
    "code": 0
}

```

### 获取我的资料
**url** `/user/myInfo`
#### request
```js


```

#### response
```js
{
	 "code": 0,
    "msg": "success", 	//success 成功;needLogin 需要登录；needRegister 去完善资料 
    "reason": "success",
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
backhand=1	
height=69
weight=79
name=orican
sex=1					//0 未知 1女 2男
nation=1
nation_flay=url
status=1 			//status  0 正常 ；1 休息
mobile=13122210065
level
```

#### response

```js
{
    "msg": "success",
    "result": "",
    "reason": "success",
    "code": 0
}

```

### 查看其他用户信息
**url** `/user/otherUserinfo`
#### request
```js
	id=1  //required
	matchId =1 //非必需，通过查看比赛详情页面查看用户信息，那么matchId是必须的
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
    "reason": "success",
    "code": 0
}
```

### 通过手机号查找到其他人
>
>主要用于双打比赛中添加比赛伙伴用
>

**url** `/user/findPartner`

#### request

```js

mobile=13122210065

```

#### response
```js
{
    "msg": "success",
    "result": {
        "mobil": "13122210065",
        "name": "orican",
        "avatar": "headimage",
        "id": 1
    },
    "reason": "success",
    "code": 0
}
```

### 个人中心

**url** `/user/center`

#### request

```js


```

#### response
```js

{
    "msg": "success",
    "result": {
        "integral": 201,
        "rank": 0,
        "avatar": "headimage",
        "id": 1,
        "status": 0,
        "username": "orican"
    },
    "reason": "success",
    "code": 0
}

```

### 获取用户信息（用于更改信息）

**url** `/user/updateInfo`

#### request

```js


```

#### response
```js

{
    "msg": "success",
    "result": {
        "birthday": 1121221111,
        "backhand": 1,
        "city": 796,
        "level": 2,
        "nation": 1,
        "registerTime": 1121221111,
        "openid": "orican",
        "sex": 1,
        "mobile": "13122210065",
        "weight": 89,
        "avatar": "http://muxu.oss-cn-hangzhou.aliyuncs.com/user/5366d0160924ab18d9105e4432fae6cd7b890bba.jpg",
        "pinyin": "orican",
        "province": 795,
        "integral": 301,
        "name": "orican",
        "id": 1,
        "age": 19,
        "forehand": 0,
        "height": 169,
        "nationFlag": "http://muxu.oss-cn-hangzhou.aliyuncs.com/china.png",
        "status": 0
    },
    "reason": "success",
    "code": 0
}
```
updateInfo

