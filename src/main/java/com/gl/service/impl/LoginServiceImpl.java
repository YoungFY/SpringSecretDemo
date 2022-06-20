package com.gl.service.impl;


import com.gl.service.LoginService;
import com.gl.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    public String Login(String username) {
        //authenticationManagerBean 进行用户认证
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken("username", "passw0rd");
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        //如果认证没有通过,则返回提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("认证未通过");
        }
        //如果认证通过，通过username role isremember 生成jwt
        String token = JwtTokenUtils.createToken("username", "admin", true);
        //把完整的用户信息存入到redis当中,userId作为Key/token作为key
        return token;
    }

}
