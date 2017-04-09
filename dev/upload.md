### 上传图片

### 上传图片接口

**url** `/upload/upload`

#### request
```js
		//上传文件 上传文件的name：file	Content-Type: image/jpeg
		//例如；Content-Disposition: form-data; name="file";filename="a05e46cf9b9fdd4b34701ab5fdcc3f14.jpg" Content-Type: image/jpeg



```


#### response
```js

{
    "msg": "success",		//success 成功 uploadErr 上传失败
    "result": "http://goushubao.oss-cn-qingdao.aliyuncs.com/images/14917533210033.jpg",
    "reason": "success",
    "code": 0
}

```