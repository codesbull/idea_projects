package com.demo.dao;

import com.demo.vo.Express;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpressMapper {

    List<Express> getExpressInfo();

    List<Express> getStudentExpress(@Param("studentId") int studentId);

    void createExpress(@Param("studentId") int studentId, @Param("receiveDate") String receiveDate);
}
