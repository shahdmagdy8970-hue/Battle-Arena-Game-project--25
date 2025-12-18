package com.example.battlearena.models;

public enum FighterType {
    MARIAM("Mariam"),
    ALAA("Alaa"),
    SALMA("Salma"),
    SHAHD("Shahd"),
    REWAN("Rewan"),
    HADEER("Hadeer");

    private final String displayName;

    FighterType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}