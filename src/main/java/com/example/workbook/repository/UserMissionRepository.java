package com.example.workbook.repository;

import com.example.workbook.domain.common.Mission;
import com.example.workbook.domain.enums.MissionStatus;
import com.example.workbook.domain.mapping.UserMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByUserIdAndMissionIdAndStatus(Long userId, Long missionId, MissionStatus status);
    Page<UserMission> findByUserIdAndStatus(Long userId, MissionStatus missionStatus, Pageable pageable);

}
