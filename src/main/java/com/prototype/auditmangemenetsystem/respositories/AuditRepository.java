package com.prototype.auditmangemenetsystem.respositories;

import com.prototype.auditmangemenetsystem.models.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<AuditEntity, Integer> {
}