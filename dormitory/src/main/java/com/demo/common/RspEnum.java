package com.demo.common;

public enum RspEnum {

    SUCCESSFUL("成功", 0),

    LOGIN_PARA_NOT_NULL("用户名或密码不能为空", 401000),

    LOGIN_ERROR("用户名或密码错误", 401001),

    NUMBER_ERROR("学号错误", 401002),

    NAME_ERROR("姓名错误", 401003),

    DORMITORY_ERROR("宿舍号错误", 401004),

    PARA_NOT_NULL("参数不能为空", 401002),

    PARA_ERROR("参数错误", 401003),

    ACCOUNT_LEN_ERROR("账号长度应为10位", 401004),

    ACCOUNT_EXISTED("账号已存在", 401005),

    ACCOUNT_NOT_EXISTED("账号不存在", 401006),

    PASSWORD_ERROR("原密码不正确", 401007),

    SELECT_COURSE_LIMIT_ERROR("所选课程超过3门或总学分数超过5，", 401008),


    REGISTER_ERROR("注册失败", 501000),

    QUERY_STUDENT_INFO_ERROR("查询学生信息失败", 501001),

    QUERY_EXPRESS_INFO_ERROR("查询快递信息失败", 501002),

    QUERY_REPAIR_INFO_ERROR("查询报修信息失败", 501003),

    QUERY_LATE_BACK_INFO_ERROR("查询夜归信息失败", 501004),

    QUERY_LEAVE_SCHOOL_INFO_ERROR("查询离校信息失败", 501005),

    CHANGE_PASSWORD_ERROR("修改密码失败", 501006),

    CREATE_EXPRESS_INFO_ERROR("发布快递信息失败", 501007),

    CREATE_REPAIR_INFO_ERROR("发布报修信息失败", 501008),

    CREATE_LATE_BACK_ERROR("添加夜归信息失败", 501009),

    UPDATE_REPAIR_INFO_ERROR("更新报修信息失败", 501010),

    DELETE_LEAVE_SCHOOL_INFO_ERROR("删除离校信息失败", 501011),

    DEL_ACCOUNT_ERROR("删除学生账号失败", 501001),

    DEL_COURSE_ERROR("删除课程失败", 501002),

    UPDATE_COURSE_ERROR("修改课程失败", 501003),

    CREATE_COURSE_ERROR("新增课程失败", 501004),

    SELECT_COURSE_ERROR("选课失败", 501005),

    INPUT_COURSE_ERROR("学生录入个人信息失败", 501006),;

    private String msg;

    private int code;

    RspEnum(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
