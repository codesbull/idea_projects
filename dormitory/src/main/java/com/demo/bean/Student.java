package com.demo.bean;

public class Student {

    private Integer studentId;

    private String studentNumber;

    private String studentPassword;

    private String studentName;

    private String studentPhone;

    private Integer sex;

    private Integer collegeId;

    private Integer professionId;

    private Integer grade;

    private String clazz;

    private Integer studentDormitoryId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Integer getStudentDormitoryId() {
        return studentDormitoryId;
    }

    public void setStudentDormitoryId(Integer studentDormitoryId) {
        this.studentDormitoryId = studentDormitoryId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                ", sex=" + sex +
                ", collegeId=" + collegeId +
                ", professionId=" + professionId +
                ", grade=" + grade +
                ", clazz='" + clazz + '\'' +
                ", studentDormitoryId=" + studentDormitoryId +
                '}';
    }
}
