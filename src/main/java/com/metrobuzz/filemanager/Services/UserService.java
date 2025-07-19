// Service
package com.metrobuzz.filemanager.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metrobuzz.filemanager.Model.UserModel;
import com.metrobuzz.filemanager.Repository.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepository) {
        this.userRepo = userRepository;
    }

    public UserModel getUser(String userPublicId) {
        try {
            return userRepo.findByPublicId(userPublicId);
        } catch (Exception exception) {
            return null;
        }
    }

    public List<UserModel> getAllUsers() {
        return userRepo.findAll();
    }
}
