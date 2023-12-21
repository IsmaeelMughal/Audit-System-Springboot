package com.prototype.auditmangemenetsystem.respositories;

import com.prototype.auditmangemenetsystem.models.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
}
