package com.luxnet.testTask.models;

import javax.persistence.*;

@Entity
public class Position {

    @Id
    private Long id;
    private String name;

    public Position() {
    }

    public Position(Long positionId, String name) {
        this.id = positionId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
