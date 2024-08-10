package com.example.demo.repository;

//import com.example.demo.controller.User;
import com.example.demo.entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QueryRepository extends JpaRepository<Query,Long> {
// Optional<Query> findByEmail(String email); // findBy - select * from, Email - where email = argument, table - User, Long - PK
}
