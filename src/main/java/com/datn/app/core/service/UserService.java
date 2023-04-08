package com.datn.app.core.service;

import com.datn.app.core.dto.ChangePasswordRequest;
import com.datn.app.core.dto.UserFindRequest;
import com.datn.app.core.entity.User;
import com.datn.app.core.service.base.ServiceCore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;
import java.util.Map;

public interface UserService extends ServiceCore<User, Long> {
    User findByEmail(String email);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception;

    User findByUsername(String username);

    Map<String, String> changePassword(ChangePasswordRequest request);

    ResponseEntity<String> uploadFile(MultipartFile file, Principal principal);

    List<User> findByUsernameOrEmail(UserFindRequest userFindRequest);
}
