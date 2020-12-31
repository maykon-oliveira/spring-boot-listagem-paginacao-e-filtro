package com.github.maykonoliveira.listagempaginacaoefiltro.service

import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Livro
import com.github.maykonoliveira.listagempaginacaoefiltro.repository.LivroRepository
import com.github.maykonoliveira.listagempaginacaoefiltro.service.criteria.LivroCriteria
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import java.util.*

@Service
class LivroService(private val livroRepository: LivroRepository) {
    fun findAllByCriteria(criteria: LivroCriteria, pageable: Pageable): Page<Livro> {
        val specification = createSpecification(criteria)
        return this.livroRepository.findAll(specification, pageable)
    }

    private fun createSpecification(criteria: LivroCriteria): Specification<Livro> {
        var specification = Specification.where<Livro>(null)

        if (Objects.nonNull(criteria.isbn)) {
            specification = specification.and(LivroCriteria.isbn(criteria.isbn!!))
        }

        if (Objects.nonNull(criteria.minDataLancamento)) {
            specification = specification.and(LivroCriteria.minDataLancamento(criteria.minDataLancamento!!))
        }

        if (Objects.nonNull(criteria.maxDataLancamento)) {
            specification = specification.and(LivroCriteria.maxDataLancamento(criteria.maxDataLancamento!!))
        }

        if (Objects.nonNull(criteria.minPreco)) {
            specification = specification.and(LivroCriteria.minPreco(criteria.minPreco!!))
        }

        if (Objects.nonNull(criteria.maxPreco)) {
            specification = specification.and(LivroCriteria.maxPreco(criteria.maxPreco!!))
        }

        if (Objects.nonNull(criteria.genero)) {
            specification = specification.and(LivroCriteria.genero(criteria.genero!!))
        }

        if (Objects.nonNull(criteria.autores)) {
            specification = specification.and(LivroCriteria.autores(criteria.autores!!))
        }

        return specification
    }
}