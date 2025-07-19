package com.metrobuzz.filemanager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrobuzz.filemanager.Model.UserModel;
import com.metrobuzz.filemanager.Services.UserService;
import com.metrobuzz.filemanager.Utils.ApiResponse;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ApiResponse entryPage() {
        try {
            List<UserModel> users = userService.getAllUsers();
            return ApiResponse.success("Users retrieved successfully", users);
        } catch (Exception exception) {
            return ApiResponse.error("Error retrieving users", 500, null);
        }
    }
}
