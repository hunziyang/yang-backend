package com.yang.portal.security.core.login;

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
import java.util.stream.Collectors;

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
        User user = userMapper.getUserByUsername(username);
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("user not exist");
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();
        List<String> roleCodeList = roleMapper.getRoleCodesByUserId(user.getId());
        roleCodeList.forEach(code ->
                simpleGrantedAuthorityList.add(new SimpleGrantedAuthority(code))
        );
        List<String> permissionCodeList = permissionMapper.getPermissionCodesByUserId(user.getId()).stream().distinct().collect(Collectors.toList());
        permissionCodeList.forEach(code ->
                simpleGrantedAuthorityList.add(new SimpleGrantedAuthority(code))
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
