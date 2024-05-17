package com.enviro.assessment.grad001.SiyandaCele.model;

import jakarta.persistence.*;
import lombok.*;

@Entity  //Mark waste category as an entity
@Table(name = "WasteCategory")  //Create a table called "Waste categories", e.g Plastic, Paper, Glass, Organic, Fabric,etc.
@Getter
@Setter
@ToString
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Autogenerate the waste category's ID
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WasteCategory(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public WasteCategory() {
    }
}