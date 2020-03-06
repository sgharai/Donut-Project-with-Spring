package com.march2.march2spring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Donut {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private boolean frosted;
    private Type DonutType;

    public Donut(long id, String name, boolean frosted, Type donutType) {
        this.id = id;
        this.name = name;
        this.frosted = frosted;
        DonutType = donutType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFrosted() {
        return frosted;
    }

    public void setFrosted(boolean frosted) {
        this.frosted = frosted;
    }

    public Type getDonutType() {
        return DonutType;
    }

    public void setDonutType(Type donutType) {
        DonutType = donutType;
    }

    public Donut(){};
}
