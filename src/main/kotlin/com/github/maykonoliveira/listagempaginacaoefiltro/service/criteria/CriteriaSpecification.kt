package com.github.maykonoliveira.listagempaginacaoefiltro.service.criteria

import org.springframework.data.jpa.domain.Specification

interface CriteriaSpecification<T> {
    fun toSpecification(): Specification<T>
}
