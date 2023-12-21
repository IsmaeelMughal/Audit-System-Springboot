package com.prototype.auditmangemenetsystem.respositories;

import com.prototype.auditmangemenetsystem.models.FindingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FindingRepository extends JpaRepository<FindingEntity, Integer> {
}
