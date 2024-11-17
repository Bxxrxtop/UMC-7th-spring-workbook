package com.example.workbook.repository;

import com.example.workbook.domain.common.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
