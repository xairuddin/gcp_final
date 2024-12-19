package com.kbtu.gcpfinal.data.repository;

import com.kbtu.gcpfinal.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
