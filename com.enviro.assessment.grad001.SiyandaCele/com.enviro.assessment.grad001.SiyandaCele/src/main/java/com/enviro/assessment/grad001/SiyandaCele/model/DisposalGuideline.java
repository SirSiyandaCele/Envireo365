package com.enviro.assessment.grad001.SiyandaCele.model;
import lombok.*;

import jakarta.persistence.*;
@Entity  //Mark waste category as an entity
@Table(name = "DisposalGuideline")  //Create a table called "Waste categories", e.g Plastic, Paper, Glass, Organic, Fabric,etc.
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Autogenerate the waste category's ID
    private long id;
    private String name;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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
    public DisposalGuideline(long id, String name, String description ) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public DisposalGuideline() {
    }

}
