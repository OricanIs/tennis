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

### 填入比赛成绩

**url** `/match/`

#### request

#### response


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
