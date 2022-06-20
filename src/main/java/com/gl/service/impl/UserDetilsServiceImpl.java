package com.gl.service.impl;

import com.gl.Entry.LoginUser;
import com.gl.Entry.User;
import com.gl.utils.JwtTokenUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetilsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //查询用户信息
        User user = new User();
        user.setUserId(100L);
        user.setUsername("zhangsan");
        user.setPassword("123456");
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户不存在！");
        }
        //查询用户的权限信息


        //把数据封装成userDetils
        return new LoginUser(user);
    }
}
