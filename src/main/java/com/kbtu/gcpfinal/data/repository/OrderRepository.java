package com.kbtu.gcpfinal.data.repository;

import com.kbtu.gcpfinal.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
