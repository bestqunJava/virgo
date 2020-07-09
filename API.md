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
  
#### 2 试题详情
* 请求方式: GET 
* 请求格式: Content-Type: application/json
* 响应格式: JSON 
* URL: http://106.55.161.213:8099/virgo/subject/pool?subjectId=122506638568456219
* 请求参数: subjectId: 试题ID
* 响应结果:
    ```json
     {
         "code": 0,
         "message": "success",
         "data": {
             "subjectId": "122506638568456219",
             "subjectType": {
                 "k": 1,
                 "v": "选择题"
             },
             "chapter": {
                 "k": "1",
                 "v": "数学"
             },
             "firstLevel": {
                 "k": "1",
                 "v": "一级知识点"
             },
             "secondLevel": {
                 "k": "1",
                 "v": "二级知识点"
             },
             "subjectContent": "用代入法解下列方程组&#xff0e;<br />\\((1)\\left \\{ {{\\begin{array}{ll} {y&#61;2x} \\\\ {3y&#43;2x&#61;8} \\end{array}}} \\right .\\) <br />\\((2)\\left \\{ {{\\begin{array}{ll} {x-3y&#61;5} \\\\ {2x&#43;y&#61;5} \\end{array}}} \\right .\\) <br />\\((3)\\left \\{ {{\\begin{array}{ll} {\\dfrac {x} {3}&#43;\\dfrac {y} {4}&#61;2} \\\\ {5x-y&#61;11} \\end{array}}} \\right .\\) <br />\\((4)\\left \\{ {{\\begin{array}{ll} {x&#43;1&#61;2y} \\\\ {3(x&#43;1)-2y&#61;1} \\end{array}}} \\right .\\)",
             "referenceContent": "\\((1)\\left \\{ {{\\begin{array}{ll} {y&#61;2x\\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, ①} \\\\ {3y&#43;2x&#61;8\\, \\, \\, \\, \\, \\, ②} \\end{array}}} \\right .\\) <br />把①代入②得&#xff1a;6x&#43;2x&#61;8<br />∴x&#61;1,代入①得&#xff1a;y&#61;2<br />\\(\\therefore \\left \\{ {{\\begin{array}{ll} {x&#61;1} \\\\ {y&#61;2} \\end{array}}} \\right .\\) <br />\\((2)\\left \\{ {{\\begin{array}{ll} {x-3y&#61;5\\, \\, \\, \\, \\, \\, ①} \\\\ {2x&#43;y&#61;5\\, \\, \\, \\, \\, \\, ②} \\end{array}}} \\right .\\) <br />由①得&#xff1a;x&#61;5&#43;3y ③<br />代入②得&#xff1a;2(5&#43;3y)&#43;y&#61;5<br />\\(\\therefore y&#61;-\\dfrac {5} {7}\\) &#xff0c;代入③得&#xff1a; <br />\\(x&#61;\\dfrac {20} {7}\\) <br />\\(\\therefore \\left \\{ {{\\begin{array}{ll} {x&#61;\\dfrac {20} {7}} \\\\ {y&#61;-\\dfrac {5} {7}} \\end{array}}} \\right .\\) <br />\\((3)\\left \\{ {{\\begin{array}{ll} {\\dfrac {x} {3}&#43;\\dfrac {y} {4}&#61;2\\, \\, \\, \\, \\, \\, \\, \\, \\, ①} \\\\ {5x-y&#61;11\\, \\, \\, \\, \\, \\, \\, ②} \\end{array}}} \\right .\\) <br />由②得&#xff1a;y&#61;5x-11 ③<br />代入①得&#xff1a;4x&#43;3(5x-11)&#61;24<br />∴x&#61;3&#xff0c;代入③得&#xff1a;y&#61;4<br />\\(\\therefore \\left \\{ {{\\begin{array}{ll} {x&#61;3} \\\\ {y&#61;4} \\end{array}}} \\right .\\) <br />\\((4)\\left \\{ {{\\begin{array}{ll} {x&#43;1&#61;2y\\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, ①} \\\\ {3(x&#43;1)-2y&#61;1\\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, ②} \\end{array}}} \\right .\\) <br />由①得&#xff1a;x&#61;2y-1&#xff0c;代入②得&#xff1a;<br />\\(\\therefore y&#61;\\dfrac {1} {4}\\) &#xff0c;代入x&#61;2y-1得&#xff1a; <br />\\(x&#61;-\\dfrac {1} {2}\\) <br />\\(\\therefore \\left \\{ {{\\begin{array}{ll} {x&#61;-\\dfrac {1} {2}} \\\\ {y&#61;\\dfrac {1} {4}} \\end{array}}} \\right .\\)",
             "analysisContent": "本题考查了用代入消元法解二元一次方程组&#xff0c;变化代入是用代入法解二元一次方程组最关键的一步&#xff0c;在进行代入计算时&#xff0c;要注意及时添加括号&#xff0e;",
             "subjectDegree": 1,
             "past": null
         }
     }
    ```
* 响应参数说明:

    | 字段 | 含义 | 
    | :-----| ----: |
    | subjectId | 试题ID |
    | subjectType      | 试题类型  |
    | chapter   | 章节    |
    | firstLevel   | 一级知识点    |
    | secondLevel   | 二级知识点    |
    | subjectContent   | 题干    |
    | referenceContent   | 参考答案    |
    | analysisContent   | 解析内容    |
    | subjectDegree   | 试题难度 (1,2,3,4,5星)   |
   
#### 3 试题类型
* 请求方式: GET 
* 请求格式: Content-Type: application/json
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



