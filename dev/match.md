## 比赛
>所有的参数拼接在网址后面 <br>
>所有的返回结果都是json类型 <br>
>如果返回的 msg不在解析的范围内，直接输出reason，并终止操作<br>
>


### 获取排行
**url** `match/rankList`
#### request

```js
province=0	
city=0
level=0	
pageSize=20
page=1

```

#### response

```js
{
    "msg": "success",
    "reason":"success",
    "result": {
        "pageCount": 1,
        "pageNo": 1,
        "pageSize": 20,
        "currentPage": 1,
        "totalCount": 3,
        "results": [
            {
                "city": 2,
                "cityStr": "东城区",
                "integral": 220,
                "provice": 1,
                "userId": 3,
                "provinceStr": "北京市",
                "username": "orican2"
            },
            {
                "city": 2,
                "cityStr": "东城区",
                "integral": 210,
                "provice": 1,
                "userId": 2,
                "provinceStr": "北京市",
                "username": "orican1"
            },
            {
                "city": 2,
                "cityStr": "东城区",
                "integral": 201,
                "provice": 1,
                "userId": 1,
                "provinceStr": "北京市",
                "username": "orican"
            }
        ]
    },
    "code": 0
}

```

### 创建比赛
**url** `match/create`
#### request
```js
matchType=0 					//required  0挑战；1擂台台
playWay=0						//required 0单打 1双打
challengeMainUser=1			//
challengeMinUser=2			//
startTime=1491129554		//required
endTime=1491133154			//required
integral=10					//擂台赛必填
matchProvince=上海市			//required
matchCity=奉贤区				//required
matchAddr=上海应用技术学院	//required
defenderMainUser=3			//擂台
deferderMinUser=0			
	
```

#### resonse
```jd
{
    "msg": "success",
    "result": "",
    "reason": "success",
    "code": 0
}

```

### 应战列表

**url** `/match/pendingMatchs`

#### request
>
>解释 ：playWay：0 返回结果minUser为null 不需要解析 ，playWay：1 minUser不为null
>

```js
playWay=0  //0 单打 1 双打  required

```

#### response
```js

//结果1
{
    "msg": "success",
    "result": [],
    "reason": "success",
    "code": 0
}

//结果2
{
    "msg": "success",
    "result": [
        {
            "minUser": null,
            "startTime": "2017-04-02 20:58",
            "endTime": "2017-04-02 19:39",
            "id": 7,
            "mainUser": {
                "level": "初级",
                "integral": 301,
                "name": "orican",
                "rank": 0,
                "avatar": "http://b.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=f0c5c08030d3d539c16807c70fb7c566/8ad4b31c8701a18bbef9f231982f07082838feba.jpg",
                "id": 1,
                "winRate": 0,
                "nationFlag": "http://muxu.oss-cn-hangzhou.aliyuncs.com/china.png"
            },
            "playWay": 0
        }
    ],
    "reason": "success",
    "code": 0
}

//结果3
{
    "msg": "success",
    "result": [
        {
            "minUser": {
                "level": "初级",
                "integral": 310,
                "name": "orican1",
                "rank": 0,
                "avatar": "http://muxu.oss-cn-hangzhou.aliyuncs.com/user/5366d0160924ab18d9105e4432fae6cd7b890bba.jpg",
                "id": 2,
                "winRate": 0,
                "nationFlag": "http://muxu.oss-cn-hangzhou.aliyuncs.com/china.png"
            },
            "startTime": "2017-04-02 20:58",
            "endTime": "2017-04-02 19:39",
            "id": 7,
            "mainUser": {
                "level": "初级",
                "integral": 301,
                "name": "orican",
                "rank": 0,
                "avatar": "http://muxu.oss-cn-hangzhou.aliyuncs.com/user/5366d0160924ab18d9105e4432fae6cd7b890bba.jpg",
                "id": 1,
                "winRate": 0,
                "nationFlag": "http://muxu.oss-cn-hangzhou.aliyuncs.com/china.png"
            },
            "playWay": 1
        }
    ],
    "reason": "success",
    "code": 0
}


```

### 查看比赛

**url** `/match/matchInfo`

#### request
```js
id=7			//required

```

#### response
```js
{
    "msg": "success",
    "result": {
        "city": "奉贤区",
        "matchType": 0,
        "chMainUser": {
            "level": "初级",
            "integral": 201,
            "name": "orican",
            "rank": 0,
            "id": 1,
            "winRate": 0,
            "nationFlag": "image"
        },
        "deMinUser": null,
        "chMinUser": {
            "level": "初级",
            "integral": 210,
            "name": "orican1",
            "rank": 0,
            "id": 2,
            "winRate": 0,
            "nationFlag": "image"
        },
        "chScore": 0,
        "camp": "ch",
        "deMainUser": {
            "level": "初级",
            "integral": 220,
            "name": "orican2",
            "rank": 0,
            "id": 3,
            "winRate": 0,
            "nationFlag": "image"
        },
        "playWay": 1,
        "province": "上海市",
        "deScore": 0,
        "startTime": "2017-04-02 20:58",
        "endTime": "2017-04-02 19:39",
        "state": 0,
        "addr": "上海应用技术学院"
    },
    "reason": "success",
    "code": 0
}

```

### 确认比赛

**url** `/match/confirm`

#### request
```js
	id=1
	partnerId=2 //单打不需要上传，如果是双打，那么上传同伴的id

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

### 输入比赛成绩

**url** `/match/fillScore`

#### request	
```js
id =1						//required
chScore = 7				//required
deScore = 8				//required

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

### 我的比赛列表

**url** `/match/myMatchs`

#### request
```js
state = 0 		//0待确认   1比赛中 2 比赛完成
page = 1
pageSize =20

```


#### response
```js
{
    "msg": "success",
    "result": {
        "pageCount": 1,
        "pageNo": 1,
        "pageSize": 10,
        "currentPage": 1,
        "totalCount": 2,
        "results": [
            {
                "matchCity": "奉贤区",
                "challengeMinUser": 0,
                "matchAddr": "上海应用技术学院",
                "matchType": 0,
                "challengeMainUser": 2,
                "challengeScore": 0,
                "deferderMinUser": 0,
                "playWay": 0,
                "defenderMainUser": 1,
                "createTime": 1491144182,
                "defenderScore": 0,
                "integral": 10,
                "matchProvince": "上海市",
                "startTime": 1491129554,
                "endTime": 1491133154,
                "id": 8,
                "state": 0
            },
            {
                "matchCity": "奉贤区",
                "challengeMinUser": 2,
                "matchAddr": "上海应用技术学院",
                "matchType": 0,
                "challengeMainUser": 1,
                "challengeScore": 0,
                "deferderMinUser": 0,
                "playWay": 1,
                "defenderMainUser": 3,
                "createTime": 1491137902,
                "defenderScore": 0,
                "integral": 10,
                "matchProvince": "上海市",
                "startTime": 1491129554,
                "endTime": 1491133154,
                "id": 7,
                "state": 0
            }
        ]
    },
    "reason": "success",
    "code": 0
}

```


