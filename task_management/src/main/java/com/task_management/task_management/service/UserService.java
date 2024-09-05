package com.task_management.task_management.service;

import com.task_management.task_management.Dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authentification",url = "http://localhost:5001")
public interface UserService {
    @GetMapping("/api/user/profile")
    public UserDto getUserProfile (@RequestHeader("Authorization") String jwt);
}
