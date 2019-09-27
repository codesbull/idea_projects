package com.demo.dao;

import com.demo.bean.Dormitory;
import org.apache.ibatis.annotations.Param;

public interface DormitoryMapper {

    Dormitory findDormitory(@Param("dormitoryNumber") String dormitoryNumber);
}
