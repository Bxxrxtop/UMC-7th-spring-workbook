package com.example.workbook.repository;

import com.example.workbook.domain.common.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
