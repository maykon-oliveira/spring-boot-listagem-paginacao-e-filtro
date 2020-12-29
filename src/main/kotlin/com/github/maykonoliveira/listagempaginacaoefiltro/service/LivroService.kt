package com.github.maykonoliveira.listagempaginacaoefiltro.service

import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Livro
import com.github.maykonoliveira.listagempaginacaoefiltro.repository.LivroRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class LivroService(private val livroRepository: LivroRepository) {
    fun findAll(pageable: Pageable): Page<Livro> {
        return this.livroRepository.findAll(pageable)
    }
}