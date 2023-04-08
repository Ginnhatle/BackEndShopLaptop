package com.datn.app.core.dto;

import lombok.Data;

@Data
public class UserFindRequest {
    private String username;
    private String email;
}
