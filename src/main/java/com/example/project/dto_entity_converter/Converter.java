package com.example.project.dto_entity_converter;

public interface Converter <D, E>{
    E convertToEntity(D dto);
}
