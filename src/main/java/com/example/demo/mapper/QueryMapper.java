package com.example.demo.mapper;


import com.example.demo.dto.QueryDto;
import com.example.demo.entity.Query;

public class QueryMapper {

    public static Query mapToQuery(QueryDto queryDto, Query query){
        query.setMenteeId(queryDto.getMenteeId());
        query.setMentorId(queryDto.getMentorId());
        query.setQuestion(queryDto.getQuestion());
        return query;
    }

    public static QueryDto mapToQueryDto(Query query, QueryDto queryDto){
        queryDto.setMenteeId(query.getMenteeId());
        queryDto.setMentorId(query.getMentorId());
        queryDto.setQuestion(query.getQuestion());
        queryDto.setAnswer(query.getAnswer());
        return queryDto;
    }
}
