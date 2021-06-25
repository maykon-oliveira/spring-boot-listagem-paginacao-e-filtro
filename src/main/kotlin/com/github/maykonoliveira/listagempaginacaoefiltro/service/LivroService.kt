package com.github.maykonoliveira.listagempaginacaoefiltro.service

import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Livro
import com.github.maykonoliveira.listagempaginacaoefiltro.repository.LivroRepository
import com.github.maykonoliveira.listagempaginacaoefiltro.service.criteria.CriteriaSpecification
import com.github.maykonoliveira.listagempaginacaoefiltro.service.criteria.LivroCriteria
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import java.util.*

@Service
class LivroService(private val livroRepository: LivroRepository) {
    fun findAllByCriteria(criteria: CriteriaSpecification<Livro>, pageable: Pageable): Page<Livro> {
        val specification = criteria.toSpecification()
        return this.livroRepository.findAll(specification, pageable)
    }
}
