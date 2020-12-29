package com.github.maykonoliveira.listagempaginacaoefiltro.controller

import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Livro
import com.github.maykonoliveira.listagempaginacaoefiltro.service.LivroService
import com.github.maykonoliveira.listagempaginacaoefiltro.service.criteria.LivroCriteria
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/livros")
class LivroController(private val livroService: LivroService) {
    @GetMapping
    fun list(pageable: Pageable, criteria: LivroCriteria): Page<Livro> {
        return this.livroService.findAllByCriteria(criteria, pageable)
    }
}