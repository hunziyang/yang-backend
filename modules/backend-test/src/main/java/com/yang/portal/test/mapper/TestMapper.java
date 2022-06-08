package com.yang.portal.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.portal.test.dto.TestDTO;
import com.yang.portal.test.entity.Test;
import org.apache.ibatis.annotations.Param;

/**
 * (Test)表数据库访问层
 *
 * @author Tommy.Wang
 * @since 2022-06-16 23:29:15
 */
public interface TestMapper extends BaseMapper<Test> {
    Test getTestByIdAndName(@Param("id") Long id,@Param("name") String name);
    TestDTO getStudentList(@Param("id")Long id);
}

