package com.demo.dao;

import com.demo.vo.LateBack;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LateBackMapper {

    List<LateBack> getLateBackInfo();

    void createLateBack(@Param("studentId") int studentId, @Param("lateBackTime") String lateBackTime,
                        @Param("reason") String reason);
}
