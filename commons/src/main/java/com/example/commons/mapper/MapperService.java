package com.example.commons.mapper;

public interface MapperService<E, D> {

    E toEntity(D dto);

    D toDto(E entity);

}
