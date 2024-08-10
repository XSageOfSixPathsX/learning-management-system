package com.example.demo.service.impl;

import com.example.demo.dto.QueryDto;
import com.example.demo.entity.Query;
import com.example.demo.mapper.QueryMapper;
import com.example.demo.repository.QueryRepository;
import com.example.demo.service.IQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QueryService implements IQueryService {

    private QueryRepository queryRepository;

    @Override
    public void createQuery(QueryDto queryDto) {
//        String email = userDto.getEmail();
//
//        Optional<Query> foundUser = userRepository.findByEmail(email);

//        System.out.println(foundUser);
//        if (foundUser.isPresent()) {
//            throw new UserAlreadyExistException("User already exists for given query id" + email);
//        }

        Query query = QueryMapper.mapToQuery(queryDto , new Query());

        // GET - CONVERT TO QueryDTO, SAVE - CONVERT TO query

        queryRepository.save(query); // INSERT INTO QUERY VALUES(mentee_id,mentor_id,question)

    }

}
