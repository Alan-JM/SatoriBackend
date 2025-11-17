package com.example.demo.model.converter;

import com.example.demo.model.enums.Rol;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RolConverter implements AttributeConverter<Rol, String> {

    @Override
    public String convertToDatabaseColumn(Rol rol) {
        return rol != null ? rol.getValue() : null;
    }

    @Override
    public Rol convertToEntityAttribute(String dbValue) {
        return dbValue != null ? Rol.fromValue(dbValue) : null;
    }
}