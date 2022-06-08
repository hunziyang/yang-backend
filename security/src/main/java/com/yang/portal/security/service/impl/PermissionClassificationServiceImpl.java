package com.yang.portal.security.service.impl;

import com.yang.portal.security.entity.PermissionClassification;
import com.yang.portal.security.mapper.PermissionClassificationMapper;
import com.yang.portal.security.service.PermissionClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionClassificationServiceImpl implements PermissionClassificationService {

    @Autowired
    private PermissionClassificationMapper permissionClassificationMapper;

    @Override
    public List<PermissionClassification> getPermissionClassification() {
        return permissionClassificationMapper.selectList(null);
    }
}
