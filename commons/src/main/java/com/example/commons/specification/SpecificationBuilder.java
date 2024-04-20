package com.example.commons.specification;

import com.example.commons.dto.FilterRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

public interface SpecificationBuilder<E> {

    Specification<E> build(@Nullable FilterRequest filterRequest);
}
