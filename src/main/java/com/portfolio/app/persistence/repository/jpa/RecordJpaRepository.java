package com.portfolio.app.persistence.repository.jpa;

import com.portfolio.app.persistence.model.RecordId;
import com.portfolio.app.persistence.model.Record;
import com.portfolio.app.persistence.repository.RecordRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordJpaRepository extends RecordRepository, JpaRepository<Record, RecordId> {
}
