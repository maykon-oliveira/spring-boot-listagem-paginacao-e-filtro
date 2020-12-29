package com.github.maykonoliveira.listagempaginacaoefiltro.controller

import com.github.maykonoliveira.listagempaginacaoefiltro.service.LivroService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/livros")
class LivroController(private val livroService: LivroService) {
}