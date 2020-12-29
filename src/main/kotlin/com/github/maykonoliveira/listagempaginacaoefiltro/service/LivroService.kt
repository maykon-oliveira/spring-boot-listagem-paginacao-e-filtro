package com.github.maykonoliveira.listagempaginacaoefiltro.service

import com.github.maykonoliveira.listagempaginacaoefiltro.repository.LivroRepository
import org.springframework.stereotype.Service

@Service
class LivroService(private val livroRepository: LivroRepository) {
}