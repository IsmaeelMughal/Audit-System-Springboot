package com.prototype.auditmanagemenetsystem.respositories;

import com.prototype.auditmanagemenetsystem.models.RoleEntity;
import com.prototype.auditmanagemenetsystem.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmailAndPassword(String email, String password);
    List<UserEntity> findByRole(RoleEntity role);
}
