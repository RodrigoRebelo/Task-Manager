package com.neff.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractModel implements Model{

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id;


    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }
}
