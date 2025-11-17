package com.example.demo.model.enums;

public enum Rol {
    JEFE("1"),
    ADMINISTRADOR("2"),
    OPERADOR("3");

    private final String value;

    Rol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Rol fromValue(String value) {
        for (Rol r : Rol.values()) {
            if (r.value.equals(value)) {
                return r;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + value);
    }
}