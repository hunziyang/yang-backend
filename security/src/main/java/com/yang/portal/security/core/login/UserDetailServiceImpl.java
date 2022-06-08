package com.yang.portal.security.core.login;

import com.yang.portal.core.CoreConstant;
import com.yang.portal.security.entity.Permission;
import com.yang.portal.security.entity.Role;
import com.yang.portal.security.entity.User;
import com.yang.portal.security.mapper.PermissionMapper;
import com.yang.portal.security.mapper.RoleMapper;
import com.yang.portal.security.mapper.UserMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getOneByUsernameAndIsDelete(username, CoreConstant.IS_DELETE);
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("user not exist");
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();
        List<Role> roleList = roleMapper.getAllByUserIdAndIsDelete(user.getId(), CoreConstant.IS_DELETE);
        roleList.forEach(role ->
                simpleGrantedAuthorityList.add(new SimpleGrantedAuthority(role.getCode()))
        );
        List<Permission> permissionList = permissionMapper.getAllByUserIdAndIsDelete(user.getId(), CoreConstant.IS_DELETE);
        permissionList.forEach(permission ->
                simpleGrantedAuthorityList.add(new SimpleGrantedAuthority(permission.getCode()))
        );
        return LoginUserDetail.builder()
                .userId(user.getId())
                .username(username)
                .nickName(user.getNickname())
                .password(user.getPassword())
                .phone(user.getPhone())
                .salt(user.getSalt())
                .isLocked(user.getIsLocked())
                .authorities(simpleGrantedAuthorityList)
                .build();
    }
}
