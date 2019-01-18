package com.piterskikh.jpa.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ZipCodeConverter implements AttributeConverter<ZipCode, String> {

    @Override
    public String convertToDatabaseColumn(ZipCode attribute) {
        return attribute.getValue();
    }

    @Override
    public ZipCode convertToEntityAttribute(String s) {
        if (s.length() == 5)
            return new GermanZipCode(s);
        else if (s.length() == 4)
            return new SwissZipCode(s);

        throw new IllegalArgumentException("Unsupported zipcode " + s);
    }
}
