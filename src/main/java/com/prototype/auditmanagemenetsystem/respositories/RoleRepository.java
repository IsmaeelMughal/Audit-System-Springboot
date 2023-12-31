package com.prototype.auditmanagemenetsystem.respositories;

import com.prototype.auditmanagemenetsystem.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity getRoleEntityByName(String name);
}
