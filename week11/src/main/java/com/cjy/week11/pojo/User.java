package com.cjy.week11.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String username;
    private String password;
    private int sex;
    private String phone_num;
    private String email;
    private Timestamp create_time;
    private Timestamp upgrade_time;

}
