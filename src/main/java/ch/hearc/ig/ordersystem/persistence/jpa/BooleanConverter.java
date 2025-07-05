package ch.hearc.ig.ordersystem.persistence.jpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BooleanConverter implements AttributeConverter<Boolean, String> {

  @Override
  public String convertToDatabaseColumn(Boolean value) {
    return Boolean.TRUE.equals(value) ? "T" : "F";
  }

  @Override
  public Boolean convertToEntityAttribute(String s) {
    return s.equalsIgnoreCase("T");
  }
}
