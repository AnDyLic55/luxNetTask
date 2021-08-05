package com.luxnet.testTask.models;

import javax.persistence.*;

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long positionId;
    private String name;

    public Position() {
    }

    public Position(String name) {
        this.name = name;
    }

    public Long getId() {
        return positionId;
    }

    public void setId(Long id) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
