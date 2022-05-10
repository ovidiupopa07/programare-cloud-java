package com.unitbv.stereotype.repository;

import com.unitbv.stereotype.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Integer, User> {
}
