package com.example.project.converter;

public interface Converter <D, E>{
    E convertToEntity(D dto);
}
