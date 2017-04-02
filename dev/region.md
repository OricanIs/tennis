## 国家-国旗 省份-城市 接口
>所有的参数拼接在网址后面 <br>
>所有的返回结果都是json类型 <br>
>如果返回的 msg不在解析的范围内，直接输出reason，并终止操作<br>
>



### 获取所有国家
**url** `/region/getNations`

#### request

```js


```

#### response

```js
{
    "msg": "success",
    "reason":"success",
    "result": [
        {
            "image": "http://muxu.oss-cn-hangzhou.aliyuncs.com/china.png",
            "name": "中国",
            "id": 1
        },
        {
            "image": "http://muxu.oss-cn-hangzhou.aliyuncs.com/america.png",
            "name": "美国",
            "id": 2
        },
        {
            "image": "http://muxu.oss-cn-hangzhou.aliyuncs.com/argentina.png",
            "name": "阿根廷",
            "id": 3
        },
        {
            "image": "http://muxu.oss-cn-hangzhou.aliyuncs.com/australia.png",
            "name": "澳大利亚",
            "id": 4
        }
    ],
    "code": 0
}

```

### 获取一个国家的详情

**url** `/region/getNation`

#### request
```js
nationId=1  //required

```

#### response

```js
{
    "msg": "success",
    "reason":"success",
    "result": {
        "image": "http://muxu.oss-cn-hangzhou.aliyuncs.com/america.png",
        "name": "美国",
        "id": 2
    },
    "code": 0
}

```

### 获取所有省份
**url** `/region/getProvinces`

#### request

```js


```

#### response

```js

{
    "msg": "success",
    "reason":"success",
    "result": [
        {
            "name": "澳门特别行政区",
            "id": 3327,
            "type": "省"
        },
        {
            "name": "香港特别行政区",
            "id": 3305,
            "type": "省"
        },
        {
            "name": "台湾省",
            "id": 3231,
            "type": "省"
        },
        {
            "name": "新疆维吾尔自治区",
            "id": 3117,
            "type": "省"
        },
        {
            "name": "宁夏回族自治区",
            "id": 3089,
            "type": "省"
        },
        {
            "name": "青海省",
            "id": 3037,
            "type": "省"
        }
    ],
    "code": 0
}
```

### 获取省份下的所有城市
**url** `getCitys`

#### request
```js
provinceId=1  //required

```

#### response

```js
{
    "msg": "success",
    "reason":"success",
    "result": [
        {
            "name": "延庆县",
            "id": 17,
            "type": "区"
        },
        {
            "name": "密云县",
            "id": 16,
            "type": "区"
        },
        {
            "name": "平谷区",
            "id": 15,
            "type": "区"
        }
    ],
    "code": 0
}

```

 