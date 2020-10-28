package com.example.demo.pojo.model;

import lombok.Data;

/**
 * @author
 * @date 2020/9/27
 **/
@Data
public class LoginArgs {
    private String username;
    private String password;
    private String staffId;
    private String staffName;
}
