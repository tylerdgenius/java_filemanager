// Repository
package com.metrobuzz.filemanager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metrobuzz.filemanager.Model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Long> {
    UserModel findByPublicId(String publicId);
}
