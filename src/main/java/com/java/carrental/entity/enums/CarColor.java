package com.java.carrental.entity.enums;

public enum CarColor {
    BLACK ("Czarny"),
    WHITE ("Biały"),
    SILVER ("Srebrny"),
    GREEN ("Zielony"),
    BLUE ("Niebieski")  ;

    private final String name;


    CarColor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
