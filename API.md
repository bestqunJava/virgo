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
    
#### 3 试题管理
* 请求方式: POST 
* 请求格式: Content-Type: application/json
* 响应格式: JSON
* URL: http://106.55.161.213:8099/virgo/subject/pool/list
* 请求参数说明

    | 字段 | 含义 | 
    | :-----| ----: |
    | page | 当前页* |
    | size      | 每页大小*  |
    | chapterId   | 章节ID    |
    | firstLevelId   | 一级知识点ID    |
    | secondLevelId   | 二级知识点ID    |
    | subjectType   | 试题类型    |
    | past   | 真题    |
    | subjectDegree   | 试题难度    |
    | source   | 试题来源    |
    | subjectId   | 相似题编号    |
    | subjectContent   | 试题内容    |  
    | startTime   | 开始时间 yyyy-MM-dd HH:mm:ss    |  
    | endTime   | 结束时间 yyyy-MM-dd HH:mm:ss    |  

* 请求参数示例: 
    ```json
      {
      "page": 1,
      "size": 10,
      "chapterId": "c122506638568456219",
      "firstLevelId": "b122506638568456219",
      "secondLevelId": "a122506638568456219",
      "subjectType": 1,
      "subjectDegree": 1,
      "source": 1,
      "subjectId": "122506638568456219",
      "subjectContent": "x",
      "startTime": "2020-07-09 14:20:13",
      "endTime": "2020-07-09 14:20:13"
      }
    ```
* 响应结果:
    ```json
      {
          "code": 0,
          "message": "success",
          "data": {
              "page": 1,
              "size": 10,
              "pages": 1,
              "total": 1,
              "list": [
                  {
                      "no": 1,
                      "subjectId": "122506638568456219",
                      "subjectType": {
                          "k": 1,
                          "v": "选择题"
                      },
                      "subjectContent": "用代入法解下列方程组&#xff0e;<br />\\((1)\\left \\{ {{\\begin{array}{ll} {y&#61;2x} \\\\ {3y&#43;2x&#61;8} \\end{array}}} \\right .\\) <br />\\((2)\\left \\{ {{\\begin{array}{ll} {x-3y&#61;5} \\\\ {2x&#43;y&#61;5} \\end{array}}} \\right .\\) <br />\\((3)\\left \\{ {{\\begin{array}{ll} {\\dfrac {x} {3}&#43;\\dfrac {y} {4}&#61;2} \\\\ {5x-y&#61;11} \\end{array}}} \\right .\\) <br />\\((4)\\left \\{ {{\\begin{array}{ll} {x&#43;1&#61;2y} \\\\ {3(x&#43;1)-2y&#61;1} \\end{array}}} \\right .\\)",
                      "createTime": "2020-07-09 14:20:13",
                      "subjectDegree": 1,
                      "past": 0
                  }
              ]
          }
      }
    ```
* 响应参数说明:

    | 字段 | 含义 | 
    | :-----| ----: |
    | code | 自定义code |
    | message      | success  |
    | -no   | 编号    |
    | -subjectId   | 试题ID    |
    | -subjectType   | 试题类型    |
    | -subjectContent   | 题干    |
    | -createTime   | 创建时间    |
    | -subjectDegree   | 难度 1,2,3,4,5    |
    | -past   | 真题 0否 1是    |

#### 4 试题删除
* 请求方式: GET 
* 请求格式: Content-Type: application/json
* 响应格式: JSON
* URL: http://106.55.161.213:8099/virgo/common/subject/delete?subjectId=122506638568456219
* 请求参数说明

    | 字段 | 含义 | 
    | :-----| ----: |
    | subjectId | 试题ID |

* 响应结果:
    ```json
     {
         "code": 0,
         "message": "success",
         "data": 1
     }
    ```
* 响应参数说明:

    | 字段 | 含义 | 
    | :-----| ----: |
    | code | 自定义code |
    | message      | success  |
    | data   | 影响行数    |
    
#### 5 编辑试题
* 请求方式: POST 
* 请求格式: Content-Type: application/json
* 响应格式: JSON
* URL: http://106.55.161.213:8099/virgo/subject/pool/edit
* 请求参数说明

    | 字段 | 含义 | 
    | :-----| ----: |
    | subjectId | 试题ID* |
    | chapterId | 章节ID |
    | firstLevelId | 一级知识点ID |
    | secondLevelId | 二级知识点ID |
    | subjectType | 试题类型 |
    | subjectDegree | 试题难度 |
    | source | 试题来源 |

* 响应结果:
    ```json
     {
         "code": 0,
         "message": "success",
         "data": 1
     }
    ```
* 响应参数说明:

    | 字段 | 含义 | 
    | :-----| ----: |
    | code | 自定义code |
    | message      | success  |
    | data   | 影响行数    |

#### 6 章节列表
* 请求方式: GET 
* 请求格式: Content-Type: application/json
* 响应格式: JSON
* URL: http://106.55.161.213:8099/virgo/chapters
* 请求参参数: 无
* 响应结果:
    ```json
     {
         "code": 0,
         "message": "success",
         "data": [
             {
                 "k": "1",
                 "v": "数学"
             }
         ]
     }
    ```
* 响应参数说明:

    | 字段 | 含义 | 
    | :-----| ----: |
    | code | 自定义code |
    | message      | success  |
    | data   | k,v   |


#### 7 一级知识点
* 请求方式: GET 
* 请求格式: Content-Type: application/json
* 响应格式: JSON
* URL: http://106.55.161.213:8099/virgo/level/first/list
* 请求参参数: chapterId: 章节ID
* 响应结果:
    ```json
    {
        "code": 0,
        "message": "success",
        "data": [
            {
                "k": "1",
                "v": "一级知识点"
            }
        ]
    }
    ```
* 响应参数说明:

    | 字段 | 含义 | 
    | :-----| ----: |
    | code | 自定义code |
    | message      | success  |
    | data   | k,v   |

#### 8 二级知识点
* 请求方式: GET 
* 请求格式: Content-Type: application/json
* 响应格式: JSON
* URL: http://106.55.161.213:8099/virgo/level/second/list
* 请求参数: firstLevelId: 一级知识点ID
* 响应结果:
    ```json
    {
        "code": 0,
        "message": "success",
        "data": [
            {
                "k": "1",
                "v": "二级知识点"
            }
        ]
    }
    ```
* 响应参数说明:

    | 字段 | 含义 | 
    | :-----| ----: |
    | code | 自定义code |
    | message      | success  |
    | data   | k,v   |
    
#### 9 添加章节
* 请求方式: GET 
* 请求格式: Content-Type: application/json
* 响应格式: JSON
* URL: http://106.55.161.213:8099/virgo/chapter/inser?chapterName=乌龙茶
* 请求参数: chapterName: 章节名称
* 响应结果:
    ```json
     {
         "code": 0,
         "message": "success",
         "data": 1
     }
    ```
* 响应参数说明:

    | 字段 | 含义 | 
    | :-----| ----: |
    | code | 自定义code |
    | message      | success  |
    | data   | 影响行数    |
    
#### 10 添加一级知识点
* 请求方式: POST 
* 请求格式: Content-Type: application/json
* 响应格式: JSON
* URL: http://106.55.161.213:8099/virgo/level/first/insert
* 请求参数: chapterId: 章节ID, firstLevelName: 一级知识点名称
    ```json
        {
        "chapterId": "124684610746449994",
        "firstLevelName": "菊花茶"
        }
    ```
* 响应结果:
    ```json
     {
         "code": 0,
         "message": "success",
         "data": 1
     }
    ```
* 响应参数说明:

    | 字段 | 含义 | 
    | :-----| ----: |
    | code | 自定义code |
    | message      | success  |
    | data   | 影响行数    |
    
#### 11 添加二级知识点
* 请求方式: POST 
* 请求格式: Content-Type: application/json
* 响应格式: JSON
* URL: http://106.55.161.213:8099/virgo/level/second/insert
* 请求参数: firstLevelId: 一级知识点ID, secondLevelName: 二级知识点名称
    ```json
        {
        "firstLevelId": "124687378093703189",
        "secondLevelName": "屁屁"
        }
    ```
* 响应结果:
    ```json
     {
         "code": 0,
         "message": "success",
         "data": 1
     }
    ```
* 响应参数说明:

    | 字段 | 含义 | 
    | :-----| ----: |
    | code | 自定义code |
    | message      | success  |
    | data   | 影响行数    |







