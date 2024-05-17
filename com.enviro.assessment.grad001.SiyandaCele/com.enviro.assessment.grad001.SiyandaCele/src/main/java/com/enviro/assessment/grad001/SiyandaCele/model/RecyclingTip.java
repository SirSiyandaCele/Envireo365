package com.enviro.assessment.grad001.SiyandaCele.model;

import lombok.*;

import jakarta.persistence.*;

@Entity  //Mark waste category as an entity
@Table(name = "RecyclingTip")  //Create a table called "Recycling Tips", e.g Plastic Tips, Paper Tips, Glass Tips, Organic Tips, Fabric Tips,etc.
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Autogenerate the waste category's ID
    private long id;
    private String name;
    private String description;

    public String getTip() {
        return description;
    }

    public void setTip(String description) {
        this.description = description;
    }



    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public RecyclingTip(long id, String name, String description ) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public RecyclingTip() {
    }


}