package com.yang.portal.test.dto;

import com.yang.portal.test.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class TestDTO {
    private Long id;
    private String name;
    private List<Student> students;
}
