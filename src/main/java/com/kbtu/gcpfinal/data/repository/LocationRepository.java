package com.kbtu.gcpfinal.data.repository;

import com.kbtu.gcpfinal.data.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
