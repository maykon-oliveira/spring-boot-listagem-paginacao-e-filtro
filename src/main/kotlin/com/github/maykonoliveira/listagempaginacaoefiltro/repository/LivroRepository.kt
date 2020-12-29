package com.github.maykonoliveira.listagempaginacaoefiltro.repository

import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Livro
import org.springframework.data.jpa.repository.JpaRepository

interface LivroRepository : JpaRepository<Livro, Long> {
}