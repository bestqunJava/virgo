package com.virgo.hw.bean.enums;


import com.google.common.collect.ImmutableList;

public enum SubjectTypeEnum {
    /**
     * 课程类型
     */
    COMPLETION(0, "填空题"),
    CHOICE_QUESTION(1, "选择题"),
    ANSWER_QUESTION(2, "解答题"),
    ;

    private Integer code;

    private String msg;

    SubjectTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static SubjectTypeEnum getEnum(Integer code) {
        SubjectTypeEnum result = null;
        SubjectTypeEnum[] var2 = values();
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            SubjectTypeEnum userStateEnum = var2[var4];
            if (userStateEnum.getCode().equals(code)) {
                result = userStateEnum;
                break;
            }
        }

        return result;
    }

    public static final ImmutableList<SubjectTypeEnum> SUBJECT_TYPE_ENUMS = ImmutableList.of(SubjectTypeEnum.COMPLETION,
            SubjectTypeEnum.CHOICE_QUESTION, SubjectTypeEnum.ANSWER_QUESTION);

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
