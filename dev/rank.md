## 	排行榜

>	级别总分类
>>ENTRY_LEVEL(1, "entry", "入门", 0)	<br>
	PRIMARY_LEVEL(2, "primary", "初级", 300)<br>
	MIDDLE_LEVEL(3, "middle", "中级", 450)<br>
	SENIOR_LEVEL(4, "senior", "高级", 750)<br>
	EXPERT_LEVEL(5, "master", "专家", 1000)<br>
>>
>
>

### 获取排行榜
**url** `rank/rankList`
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