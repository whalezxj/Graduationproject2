package com.example.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author User
 * @date 2020/8/26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("User")
public class User implements Serializable {
    @ApiModelProperty("id")
    private int id;
    @ApiModelProperty("username")
    private String username;
    @ApiModelProperty("password")
    private String password;
    @ApiModelProperty("mail")
    private String mail;
    @ApiModelProperty("phone")
    private String phone;
    @ApiModelProperty("gender")
    private String gender;
    @ApiModelProperty("status")
    private String status;
}
