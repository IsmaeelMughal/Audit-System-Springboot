package com.prototype.auditmangemenetsystem.respositories;

import com.prototype.auditmangemenetsystem.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
