package com.example.demo.mapper;


import com.example.demo.dto.QueryDto;
import com.example.demo.entity.Query;

public class QueryMapper {

    public static Query mapToQuery(QueryDto queryDto, Query query){
        query.setMentee_id(queryDto.getMentee_id());
        query.setMentor_id(queryDto.getMentor_id());
        query.setQuestion(queryDto.getQuestion());
        return query;
    }

    public static QueryDto mapToQueryDto(Query query, QueryDto queryDto){
        queryDto.setMentee_id(query.getMentee_id());
        queryDto.setMentor_id(query.getMentor_id());
        queryDto.setQuestion(query.getQuestion());
        queryDto.setAnswer(query.getAnswer());
        return queryDto;
    }
}
