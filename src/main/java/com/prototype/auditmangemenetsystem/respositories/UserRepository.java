package com.prototype.auditmangemenetsystem.respositories;

import com.prototype.auditmangemenetsystem.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
