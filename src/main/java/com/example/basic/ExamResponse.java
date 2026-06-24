package com.example.basic;

import java.util.List;

import com.example.basic.model.User;

import lombok.Data;

@Data
public class ExamResponse {
    private int count;
    private List<User> list;
}
