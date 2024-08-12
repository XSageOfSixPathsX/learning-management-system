package com.example.demo.service;

import com.example.demo.dto.QueryDto;
import com.example.demo.dto.QueryUpdateDto;

import java.util.List;

public interface IQueryService {
    void createQuery(QueryDto queryDto);
    List<QueryDto> fetchQueryOfMentee(Long menteeId);
    List<QueryDto> fetchQueryOfMentor(Long menteeId);
    QueryDto fetchUniqueQuery(Long menteeId,Long mentorId);
    void updateAnswerOFQuery(QueryUpdateDto queryUpdateDto);
}
