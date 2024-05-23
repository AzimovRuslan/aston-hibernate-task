package io.aston.hibernatetask.mapper;

public interface IMapper<E, D> {
    E toEntity(D d);
    D toDto(E e);
}
