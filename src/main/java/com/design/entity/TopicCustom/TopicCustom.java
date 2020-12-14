package com.design.entity.TopicCustom;

import com.design.entity.Topic;
import com.fasterxml.jackson.annotation.JsonFormat;
//import com.iustu.entity.Blog;

import java.util.Date;

public class TopicCustom extends Topic {
    private String courseName;
    private String semesterName;
    private String teacherName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

//    @Override
//    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
//    public Date getCreateDate() {
//        return super.getCreateDate();
//    }
//
//    @Override
//    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
//    public Date getUpdateDate() {
//        return super.getUpdateDate();
//    }
}
