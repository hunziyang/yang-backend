package com.yang.portal.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.portal.test.dto.StudentDTO;
import com.yang.portal.test.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {

    StudentDTO getStudentDTO(@Param("id") Long id);

    List<Student> getStudentByTestId(@Param("testId") Long testId);
}
