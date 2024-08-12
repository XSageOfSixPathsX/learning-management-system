package com.example.demo.service.impl;

import com.example.demo.dto.QueryDto;
import com.example.demo.dto.QueryUpdateDto;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.entity.Query;
import com.example.demo.mapper.QueryMapper;
import com.example.demo.repository.QueryRepository;
import com.example.demo.service.IQueryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QueryService implements IQueryService {

    private QueryRepository queryRepository;

    @Override
    public void createQuery(QueryDto queryDto) {

        Query query = QueryMapper.mapToQuery(queryDto , new Query());

        queryRepository.save(query); // INSERT INTO QUERY VALUES(mentee_id,mentor_id,question)
    }

    @Override
    public List<QueryDto> fetchQueryOfMentee(Long menteeId){
        List<Query> queries = queryRepository.findByMenteeId(menteeId);

//        System.out.println("Query " + queries.size());

        if (queries.isEmpty()) {
            throw new ResourceNotFoundException("Query", "menteeId", menteeId);
        }

        List<QueryDto>queryDto =  queries.stream()
                .map(query -> QueryMapper.mapToQueryDto(query, new QueryDto()))
                .collect(Collectors.toList());

//        System.out.println("QueryDto " + queries.size());
        return queryDto;
    }

    @Override
    public List<QueryDto> fetchQueryOfMentor(Long mentorId){
        List<Query> queries = queryRepository.findByMentorId(mentorId);

//        System.out.println("Query " + queries.size());

        if (queries.isEmpty()) {
            throw new ResourceNotFoundException("Query", "mentorId", mentorId);
        }

        List<QueryDto>queryDto =  queries.stream()
                .map(query -> QueryMapper.mapToQueryDto(query, new QueryDto()))
                .collect(Collectors.toList());

//        System.out.println("QueryDto " + queries.size());
        return queryDto;
    }

    @Override
    public QueryDto fetchUniqueQuery(Long menteeId, Long mentorId)
    {
        Query query=queryRepository.findByMenteeIdAndMentorId(menteeId,mentorId).orElseThrow(
                ()-> new ResourceNotFoundException("Query","menteeId and mentorId",menteeId+" and "+mentorId)
        );
        return QueryMapper.mapToQueryDto(query,new QueryDto());
    }

    @Override
    public void updateAnswerOFQuery(QueryUpdateDto queryUpdateDto)
    {
        Long menteeId = queryUpdateDto.getMenteeId();
        Long mentorId = queryUpdateDto.getMentorId();
        String answer = queryUpdateDto.getAnswer();
        Query query = queryRepository.findByMenteeIdAndMentorId(menteeId, mentorId)
                .orElseThrow(() -> new ResourceNotFoundException("Query", "menteeId and mentorId", menteeId + " and " + mentorId));

        query.setAnswer(answer);
        queryRepository.save(query);
    }
;
}
