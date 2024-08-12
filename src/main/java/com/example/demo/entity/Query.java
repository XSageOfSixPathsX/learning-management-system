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
    private Long queryId;

    @Column(name = "mentee_id", nullable = false)
    private Long menteeId;

    @Column(name = "mentor_id", nullable = false)
    private Long mentorId;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;
}


