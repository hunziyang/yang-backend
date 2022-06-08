package com.yang.portal.test.dto;

import com.yang.portal.test.entity.Test;
import lombok.Data;

@Data
public class StudentDTO {

    private Long id;
    private String name;
    private Integer age;
    private Test test;
}
