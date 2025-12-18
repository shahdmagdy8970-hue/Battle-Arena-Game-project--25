package com.example.battlearena.models;

public class FighterFactory {
    public static com.example.battlearena.models.Fighter createFighter(FighterType type, double x, double y) {
        switch (type) {
            case MARIAM:
                return new Mariem(x, y);
            case ALAA:
                return new Alaa(x, y);
            case SALMA:
                return new Salma(x, y);
            case SHAHD:
                return new Shahd(x, y);
            case REWAN:
                return new Rewan(x, y);
            case HADEER:
                return new Hadeer(x, y);
            default:
                return new Mariem(x, y);
        }
    }
}