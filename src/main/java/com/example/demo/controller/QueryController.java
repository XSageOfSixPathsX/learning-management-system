package com.example.demo.controller;

import com.example.demo.dto.QueryDto;
import com.example.demo.dto.QueryUpdateDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.service.IQueryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/query")
@AllArgsConstructor

public class QueryController {

    private IQueryService iQueryService;

    // Put your question on database
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createQuery(@RequestBody QueryDto queryDto){
        iQueryService.createQuery(queryDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto("Query Successfully Created",HttpStatus.CREATED));
    }

    // All queries on the basis of menteeID
    @GetMapping("/menteeId")
    public ResponseEntity<List<QueryDto>> fetchQueryOfMentee(@RequestParam Long menteeId){
        List<QueryDto> queryDto = iQueryService.fetchQueryOfMentee(menteeId);
//        System.out.println("QueryDto " + queryDto.size());
        return ResponseEntity.status(HttpStatus.OK)
                .body(queryDto);
    }

    // All queries on the basis of mentorID
    @GetMapping("/mentorId")
    public ResponseEntity<List<QueryDto>> fetchQueryOfMentor(@RequestParam Long mentorId){
        List<QueryDto> queryDto = iQueryService.fetchQueryOfMentor(mentorId);
//        System.out.println("QueryDto " + queryDto.size());
        return ResponseEntity.status(HttpStatus.OK)
                .body(queryDto);
    }

    // Get query of a particular pair of menteeId and mentorId
    @GetMapping("/uniqueQuery/{menteeId}/{mentorId}")
    public ResponseEntity<QueryDto> fetchUniqueQuery(@PathVariable Long menteeId, @PathVariable Long mentorId)
    {
        QueryDto queryDto=iQueryService.fetchUniqueQuery(menteeId,mentorId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(queryDto);
    }

    // Now give the answer of query on the basis of question
    @PutMapping("/answerQuery")
    public ResponseEntity<ResponseDto> updateAnswerOfQuery(@RequestBody QueryUpdateDto queryUpdateDto){
        iQueryService.updateAnswerOFQuery(queryUpdateDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto("Query Solved",HttpStatus.OK));
    }

}
