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
    | subjectIds   | 试题ID数组    |  
    | divide   | 是否划分归类试题 0 未划分  1 划分    |  


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
      "endTime": "2020-07-09 14:20:13",
      "divide": 1
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
    | subjectIds | 试题ID数组* |
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
* URL: http://106.55.161.213:8099/virgo/chapter/insert?chapterName=乌龙茶
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

#### 12 添加试卷
* 请求方式: POST 
* 请求格式: Content-Type: application/json
* 响应格式: JSON
* URL: http://106.55.161.213:8099/virgo/paper/insert
* 请求参数说明:

    | 字段 | 含义 | 
    | :-----| ----: |
    | paperName | 试卷名称 |
    | sortArray      | 排序数组  |
    | subjectIds   | 试题id集合    |
    | beginTime   | 开始考试时间    |
    | choiceRemark   | 选择题备注    |
    | answerRemark   | 解答题备注    |
    | fillBlankRemark   | 填空题备注    |

* 请求参数: 
    ```json
        {
        "paperName": "124687378093703189",
        "sortArray": "{1,2,3}",
        "subjectIds": ["122871767210401810","122872896681934895", "123547847445450813"],
        "beginTime": "2020-07-12 11:01:37",
        "choiceRemark": "a",
        "answerRemark": "b",
        "fillBlankRemark": "c"
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
    
#### 13 试卷管理
* 请求方式: POST 
* 请求格式: Content-Type: application/json
* 响应格式: JSON
* URL: http://106.55.161.213:8099/virgo/paper/list
* 请求参数说明

    | 字段 | 含义 | 
    | :-----| ----: |
    | page | 当前页* |
    | size      | 每页大小*  |
    | paperName   | 试卷名称    |
    | startTime   | 开始时间 yyyy-MM-dd HH:mm:ss    |  
    | endTime   | 结束时间 yyyy-MM-dd HH:mm:ss    |  
    | examStartTime   | 考试开始时间 yyyy-MM-dd HH:mm:ss    |  
    | examEndTime   | 考试结束时间 yyyy-MM-dd HH:mm:ss    |  
* 请求参数示例: 
    ```json
      {
      "page": 1,
      "size": 10
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
                      "id": 5,
                      "paperName": "124687378093703189",
                      "sortArray": "{1,2,3}",
                      "beginTime": "2020-07-12 11:01:37",
                      "createTime": "2020-07-20 16:11:57"
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
    | -paperName   | 试卷名称    |
    | -sortArray   | 排序json    |
    | -beginTime   | 考试时间    |
    | -createTime   | 创建时间    |


#### 14 试卷内容
* 请求方式: GET 
* 请求格式: Content-Type: application/json
* 响应格式: JSON
* URL: http://106.55.161.213:8099/virgo/paper/subjects?id=5
* 请求参数说明: id: 试卷ID 
* 响应结果:
    ```json
    {
        "code": 0,
        "message": "success",
        "data": {
            "paperName": "124687378093703189",
            "sortArray": "{1,2,3}",
            "subjects": {
                "0": [
                    {
                        "id": null,
                        "subjectId": "122871767210401810",
                        "subjectType": 0,
                        "chapterId": null,
                        "firstLevelId": null,
                        "secondLevelId": null,
                        "subjectContent": "用代入法解下列方程组&#xff0e;<br />\\((1)\\left \\{ {{\\begin{array}{ll} {y&#61;2x} \\\\ {3y&#43;2x&#61;8} \\end{array}}} \\right .\\) <br />\\((2)\\left \\{ {{\\begin{array}{ll} {x-3y&#61;5} \\\\ {2x&#43;y&#61;5} \\end{array}}} \\right .\\) <br />\\((3)\\left \\{ {{\\begin{array}{ll} {\\dfrac {x} {3}&#43;\\dfrac {y} {4}&#61;2} \\\\ {5x-y&#61;11} \\end{array}}} \\right .\\) <br />\\((4)\\left \\{ {{\\begin{array}{ll} {x&#43;1&#61;2y} \\\\ {3(x&#43;1)-2y&#61;1} \\end{array}}} \\right .\\)",
                        "referenceContent": "\\((1)\\left \\{ {{\\begin{array}{ll} {y&#61;2x\\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, ①} \\\\ {3y&#43;2x&#61;8\\, \\, \\, \\, \\, \\, ②} \\end{array}}} \\right .\\) <br />把①代入②得&#xff1a;6x&#43;2x&#61;8<br />∴x&#61;1,代入①得&#xff1a;y&#61;2<br />\\(\\therefore \\left \\{ {{\\begin{array}{ll} {x&#61;1} \\\\ {y&#61;2} \\end{array}}} \\right .\\) <br />\\((2)\\left \\{ {{\\begin{array}{ll} {x-3y&#61;5\\, \\, \\, \\, \\, \\, ①} \\\\ {2x&#43;y&#61;5\\, \\, \\, \\, \\, \\, ②} \\end{array}}} \\right .\\) <br />由①得&#xff1a;x&#61;5&#43;3y ③<br />代入②得&#xff1a;2(5&#43;3y)&#43;y&#61;5<br />\\(\\therefore y&#61;-\\dfrac {5} {7}\\) &#xff0c;代入③得&#xff1a; <br />\\(x&#61;\\dfrac {20} {7}\\) <br />\\(\\therefore \\left \\{ {{\\begin{array}{ll} {x&#61;\\dfrac {20} {7}} \\\\ {y&#61;-\\dfrac {5} {7}} \\end{array}}} \\right .\\) <br />\\((3)\\left \\{ {{\\begin{array}{ll} {\\dfrac {x} {3}&#43;\\dfrac {y} {4}&#61;2\\, \\, \\, \\, \\, \\, \\, \\, \\, ①} \\\\ {5x-y&#61;11\\, \\, \\, \\, \\, \\, \\, ②} \\end{array}}} \\right .\\) <br />由②得&#xff1a;y&#61;5x-11 ③<br />代入①得&#xff1a;4x&#43;3(5x-11)&#61;24<br />∴x&#61;3&#xff0c;代入③得&#xff1a;y&#61;4<br />\\(\\therefore \\left \\{ {{\\begin{array}{ll} {x&#61;3} \\\\ {y&#61;4} \\end{array}}} \\right .\\) <br />\\((4)\\left \\{ {{\\begin{array}{ll} {x&#43;1&#61;2y\\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, ①} \\\\ {3(x&#43;1)-2y&#61;1\\, \\, \\, \\, \\, \\, \\, \\, \\, \\, \\, ②} \\end{array}}} \\right .\\) <br />由①得&#xff1a;x&#61;2y-1&#xff0c;代入②得&#xff1a;<br />\\(\\therefore y&#61;\\dfrac {1} {4}\\) &#xff0c;代入x&#61;2y-1得&#xff1a; <br />\\(x&#61;-\\dfrac {1} {2}\\) <br />\\(\\therefore \\left \\{ {{\\begin{array}{ll} {x&#61;-\\dfrac {1} {2}} \\\\ {y&#61;\\dfrac {1} {4}} \\end{array}}} \\right .\\)",
                        "analysisContent": "本题考查了用代入消元法解二元一次方程组&#xff0c;变化代入是用代入法解二元一次方程组最关键的一步&#xff0c;在进行代入计算时&#xff0c;要注意及时添加括号&#xff0e;",
                        "subjectDegree": 1,
                        "past": 0,
                        "source": 0,
                        "state": 0,
                        "createTime": "2020-07-10T14:31:06"
                    },
                    {
                        "id": null,
                        "subjectId": "123547847445450813",
                        "subjectType": 0,
                        "chapterId": null,
                        "firstLevelId": null,
                        "secondLevelId": null,
                        "subjectContent": "<span class=\"wjdu-NO-znyin\"></span>如图，在四棱柱\\(ABCD-A_{1}B_{1}C_{1}D_{1}\\)中，侧棱\\(A_{1}A⊥\\)底面\\(ABCD\\)，\\(AB⊥AC\\)，\\(AB=1\\)，\\(AC=AA_{1}=2\\)，\\(AD=CD= \\sqrt{5} \\)，且点\\(M\\)和\\(N\\)分别为\\(B_{1}C\\)和\\(D_{1}D\\)的中点． <p style=\"text-indent:21.75pt;\"><img h=\"158px\" height=\"158\" src=\"http://nos.netease.com/yd-searchq/da955b09-993c-432d-a12f-514af565a93f.jpg\" style=\"line-height: 1.42857;\" v:shapes=\"图片_x0020_6\" w=\"177px\" width=\"177\"></p> <p>&nbsp;&nbsp;&nbsp; \\((1)\\)求证：\\(MN/\\!/\\)平面\\(ABCD\\)；</p> <p>&nbsp;&nbsp;&nbsp; \\((2)\\)求二面角\\(D_{1}-AC-B_{1}\\)的正弦值；</p> <p>&nbsp;&nbsp;&nbsp; \\((3)\\)设\\(E\\)为棱\\(A_{1}B_{1}\\)上的点，若直线\\(NE\\)和平面\\(ABCD\\)所成角的正弦值为\\(\\dfrac{1}{3} \\)，求线段\\(A_{1}E\\)的长．</p>",
                        "referenceContent": "<div>  <div>   <div>    <p>如图，以\\(A\\)为原点建立空间直角坐标系，</p>    <p>依题意可得\\(A(0,0,0)\\)，\\(B(0,1,0)\\)，\\(C(2,0,0)\\)，\\(D(1,-2,0)\\)，\\(A_{1}(0,0,2)\\)，\\(B_{1}(0,1,2)\\)，\\(C_{1}(2,0,2)\\)，\\(D_{1}(1,-2,2)\\)．</p>    <p>又因为\\(M\\)，\\(N\\)分别为\\(B_{1}C\\)和\\(D_{1}D\\)的中点，</p>    <p>所以\\(M(1, \\dfrac{1}{2} \\)&nbsp;，\\(1)\\)，\\(N(1,-2,1)\\)．</p>    <p><img height=\"157\" shapes=\"_x0000_i1106\" src=\"http://nos.netease.com/yd-searchq/cc3009e1-9b22-4ce5-b803-3792da959a0e.jpg\" width=\"185\"></p>    <p>\\((1)\\)证明：依题意，可得\\(\\overset{→}{n} =(0,0,1)\\)为平面\\(ABCD\\)的一个法向量，\\( \\overset{→}{MN}=\\left(0,- \\dfrac{5}{2},0\\right) \\)，</p>    <p>由此可得\\(\\overset{→}{MN}· \\overset{→}{n}=0 \\)．</p>    <p>又因为直线\\(MN\\;⊄面ABCD \\)&nbsp;，</p>    <p>所以\\(MN/\\!/\\)平面\\(ABCD\\)．</p>    <p>\\((2) \\overset{→}{A{D}_{1}}=\\left(1,-2,2\\right), \\overset{→}{AC}=\\left(2,0,0\\right) \\)，</p>    <p>设\\(\\overset{→}{{n}_{1}} =(x_{1},y_{1},z_{1})\\)为平面\\(ACD_{1}\\)的一个法向量，</p>    <p>则\\(\\begin{cases} \\overset{→}{{n}_{1}}· \\overset{→}{A{D}_{1}}=0 \\\\ \\overset{→}{{n}_{1}}· \\overset{→}{AC}=0\\end{cases} \\)即\\(\\begin{cases}{x}_{1}-2{y}_{1}+2{z}_{1}=0 \\\\ 2{x}_{1}=0\\end{cases} \\)，</p>    <p>不妨设\\({z}_{1} =1\\)，可得\\(\\overset{→}{{n}_{1}} =(0,1,1)\\)．</p>    <p>设\\(\\overset{→}{{n}_{2}} =(x_{2},y_{2},z_{2})\\)为平面\\(ACB_{1}\\)的一个法向量，</p>    <p>则\\(\\begin{cases} \\overset{→}{{n}_{2}}· \\overset{¯}{A{B}_{1}}=0 \\\\ \\overset{→}{{n}_{2}}· \\overset{¯}{AC}=0\\end{cases} \\)</p>    <p>又\\(\\overset{→}{A{B}_{1}}=\\left(0,1,2\\right) \\)&nbsp;，所以\\(\\begin{cases}{y}_{2}+2{z}_{2}=0 \\\\ 2{x}_{2}=0\\end{cases} \\)，</p>    <p>不妨设\\({z}_{2} =1\\)，可得\\(\\overset{→}{{n}_{2}} =(0,-2,1)\\)．</p>    <p>因此有\\(\\cos \\left &lt; \\overset{→}{{n}_{1}}, \\overset{→}{{n}_{2}}\\right &gt; = \\dfrac{ \\overset{→}{{n}_{1}}· \\overset{→}{{n}_{2}}}{\\left| \\overset{→}{{n}_{1}}\\right| \\overset{→}{\\left|{n}_{2}\\right|}}=- \\dfrac{ \\sqrt{10}}{10} \\)，</p>    <p>于是\\(\\sin \\left &lt; \\overset{→}{{n}_{1}}, \\overset{→}{{n}_{2}}\\right &gt; = \\dfrac{3 \\sqrt{10}}{10} \\)，</p>    <p>所以，二面角\\(D_{1}—AC—B_{1}\\)的正弦值为\\(\\dfrac{3 \\sqrt{10}}{10} \\)&nbsp;．</p>    <p>\\((3)\\)依题意，可设\\(\\overset{→}{{A}_{1}E}=λ \\overset{→}{{A}_{1}{B}_{1}} \\)&nbsp;，其中\\(λ∈[0,1]\\)，</p>    <p>则\\(E(0,λ,2)\\)，从而\\(\\overset{→}{NE}=\\left(-1,λ+2,1\\right) \\)&nbsp;．</p>    <p>又\\(n=(0,0,1)\\)为平面\\(ABCD\\)的一个法向量，由已知，得</p>    <p>\\(\\left|\\cos \\left &lt; \\overset{→}{NE}, \\overset{→}{n}\\right &gt; \\right|= \\dfrac{\\left| \\overset{→}{NE}· \\overset{→}{n}\\right|}{\\left| \\overset{→}{NE}\\right|\\left| \\overset{→}{n}\\right|} \\)</p>    <p>\\(= \\dfrac{1}{ \\sqrt{{\\left(-1\\right)}^{2}+{\\left(λ+2\\right)}^{2}+{1}^{2}}}= \\dfrac{1}{3} \\)&nbsp;，</p>    <p>整理得\\(λ^{2}+4λ-3=0\\)，解得\\(λ=-2± \\sqrt{7} \\)&nbsp;．</p>    <p>又因为\\(λ∈[0,1]\\)，所以\\(λ= \\sqrt{7}-2 \\)&nbsp;．</p>    <p>所以线段\\(A_{1}E\\)的长为\\(\\sqrt{7}-2 \\)&nbsp;．</p>   </div>  </div> </div>",
                        "analysisContent": "<div>  <p>本题考查了平面的法向量<span lang=\"EN-US\">，</span>利用空间向量判定线面垂直、平行关系，利用利用空间向量求线线、线面、面面的夹角和空间向量的模、夹角与距离求解问题<span lang=\"EN-US\">．     <o:p></o:p></span></p>  <p><span lang=\"EN-US\">\\((1)\\)</span>利用平面的法向量概念得平面<span lang=\"EN-US\">\\(ABCD\\)</span>的法向量\\( \\overset{→}{n}=\\left(0,0,1\\right) \\)，再利用空间向量判定线面平行得结论；<span lang=\"EN-US\">     <o:p></o:p></span></p>  <p><span lang=\"EN-US\">\\((2)\\)</span>利用平面的法向量概念得平面<span lang=\"EN-US\">\\(ACD\\)</span>\\( _{1} \\)和平面<span lang=\"EN-US\">\\(ACB\\)</span>\\( _{1} \\)的一个法向量，再利用利用空间向量求面面的夹角得结论；<span lang=\"EN-US\">     <o:p></o:p></span></p>  <p><span lang=\"EN-US\">\\((3)\\)</span>利用空间向量求线面的夹角，再利用空间向量的模得结论<span lang=\"EN-US\">．</span></p> </div>",
                        "subjectDegree": 1,
                        "past": 0,
                        "source": 0,
                        "state": 1,
                        "createTime": "2020-07-12T11:17:36"
                    }
                ],
                "1": [
                    {
                        "id": null,
                        "subjectId": "122872896681934895",
                        "subjectType": 1,
                        "chapterId": null,
                        "firstLevelId": null,
                        "secondLevelId": null,
                        "subjectContent": "下图是两个相同的直角三角形叠在一起&#xff0c;求阴影部分的面积。(单位&#xff1a;厘米)<br /><img src=\"http://nos.netease.com/yd-searchq/1aeb55c1-0fbe-421a-8bad-c719f9ef06f4.gif\" />",
                        "referenceContent": "如图&#xff1a;<br /><img src=\"http://nos.netease.com/yd-searchq/659649eb-28e1-4cab-947d-c79b986052da.jpg\" /><br />12-3&#61;9(厘米)<br />(12&#43;9)×6÷2<br />&#61;21×6÷2<br />&#61;126÷2<br />&#61;63(平方厘米)<br />答&#xff1a;阴影部分的面积是63平方厘米。",
                        "analysisContent": "【解题方法提示】<br />如图&#xff0c;通过观察可知&#xff0c;图1的面积&#43;图2的面积&#61;图2的面积&#43;图3的面积&#xff0c;由此得出图3的面积&#61;图1的面积&#xff1b;<br /><img src=\"http://nos.netease.com/yd-searchq/fce6ca1a-95a3-40e6-90c2-0219da97e35d.jpg\" /><br />要求图3的面积&#xff0c;只需要求出图1的面积&#xff0c;图1是一个梯形&#xff0c;它的上底是12厘米与3厘米的差&#xff0c;下底是12厘米&#xff0c;高是6厘米&#xff1b;<br />最后根据梯形的面积计算公式求出图1的面积&#xff0c;也就求出了图3的面积&#xff0c;据此解答即可。",
                        "subjectDegree": 1,
                        "past": 0,
                        "source": 0,
                        "state": 1,
                        "createTime": "2020-07-10T14:35:36"
                    }
                ]
            }
        }
    }
    ```
* 响应参数说明:

    | 字段 | 含义 | 
    | :-----| ----: |
    | code | 自定义code |
    | message      | success  |
    | -paperName   | 试卷名称    |
    | -sortArray   | 试卷排序    |
    | -subjects   | 试题信息同试题列表字段（按照试题类型分组，渲染需结合sortArray的顺序进行）  |





