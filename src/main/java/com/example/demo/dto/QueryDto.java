package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QueryDto {
    private Long mentee_id;
    private Long mentor_id;
    private String question;
    private String answer;
}
