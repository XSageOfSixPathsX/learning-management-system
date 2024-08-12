package com.example.demo.repository;

//import com.example.demo.controller.User;
import com.example.demo.dto.QueryDto;
import com.example.demo.entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QueryRepository extends JpaRepository<Query,Long> {

    List<Query> findByMenteeId(Long menteeId);
    List<Query> findByMentorId(Long mentorId);
    Optional<Query> findByMenteeIdAndMentorId(Long menteeId, Long mentorId);
}
