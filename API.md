# API #
#### 1 拍照搜题
* 请求方式: POST 
* 请求格式: 表单
* 响应格式: JSON
* URL: http://106.55.161.213:8099/virgo/subject/pool/collect
* 请求参数: 
     > file: 所选文件
* 响应结果:
    ```json
           {
               "code": 0,
               "message": "success",
               "data": "122506638568456219"
           }
    ```
* 响应参数说明:

    | 字段 | 含义 | 
    | :-----| ----: |
    | code | 0 成功 |
    | message      | message    |
    | data   | 试题ID    |
  
   
#### 2 试题类型
* 请求方式: GET 
* 请求格式: JSON
* 响应格式: JSON
* URL: http://106.55.161.213:8099/virgo/common/subject/types
* 请求参数: 无
* 响应结果:
    ```json
      {
          "code": 0,
          "message": "success",
          "data": [
              {
                  "k": 0,
                  "v": "填空题"
              },
              {
                  "k": 1,
                  "v": "选择题"
              },
              {
                  "k": 2,
                  "v": "解答题"
              }
          ]
      }
    ```
* 响应参数说明:

    | 字段 | 含义 | 
    | :-----| ----: |
    | code | 自定义code |
    | message      | success  |
    | data   | 影响行数    |
    | k   | key    |
    | v   | value    |



