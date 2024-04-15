package com.example.commons.specification;

import com.example.commons.dto.FilterRequest;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<E> {

    Specification<E> build(FilterRequest filterRequest);
}
