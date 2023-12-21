package com.prototype.auditmanagemenetsystem.respositories;

import com.prototype.auditmanagemenetsystem.models.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<AuditEntity, Integer> {
}
