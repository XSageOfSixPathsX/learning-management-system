package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "query")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "query_id")
    private Long query_id;

    @Column(name = "mentee_id")
    private Long mentee_id;

    @Column(name = "mentor_id")
    private Long mentor_id;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;
}


