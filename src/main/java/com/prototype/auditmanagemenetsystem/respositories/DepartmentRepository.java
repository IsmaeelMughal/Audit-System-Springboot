package com.prototype.auditmanagemenetsystem.respositories;

import com.prototype.auditmanagemenetsystem.models.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
}
