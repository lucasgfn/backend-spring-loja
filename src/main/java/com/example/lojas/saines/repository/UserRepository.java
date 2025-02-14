package com.example.lojas.saines.repository;

import com.example.lojas.saines.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
