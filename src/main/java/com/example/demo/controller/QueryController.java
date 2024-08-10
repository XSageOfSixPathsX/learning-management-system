package com.example.demo.controller;

import com.example.demo.dto.QueryDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.service.IQueryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/query")
@AllArgsConstructor

public class QueryController {

    private IQueryService iQueryService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@RequestBody QueryDto queryDto){
        iQueryService.createQuery(queryDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto("Query Successfully Created",HttpStatus.CREATED));
    }


}
