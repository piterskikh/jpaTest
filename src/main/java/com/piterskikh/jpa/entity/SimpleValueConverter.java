package com.piterskikh.jpa.entity;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SimpleValueConverter implements AttributeConverter<SimpleValue, String> {

    @Override
    public String convertToDatabaseColumn(SimpleValue attribute) {
        return attribute.getValue();
    }

    @Override
    public SimpleValue convertToEntityAttribute(String dbData) {
        return new SimpleValue(dbData);
    }
}
