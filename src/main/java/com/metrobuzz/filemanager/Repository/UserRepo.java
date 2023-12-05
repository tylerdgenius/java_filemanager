package com.metrobuzz.filemanager.Repository;

import com.metrobuzz.filemanager.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel, Long> {
    UserModel findByPublicId(String publicId);
}
