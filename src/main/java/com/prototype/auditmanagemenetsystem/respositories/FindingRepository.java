package com.prototype.auditmanagemenetsystem.respositories;

import com.prototype.auditmanagemenetsystem.models.FindingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FindingRepository extends JpaRepository<FindingEntity, Integer> {
}
