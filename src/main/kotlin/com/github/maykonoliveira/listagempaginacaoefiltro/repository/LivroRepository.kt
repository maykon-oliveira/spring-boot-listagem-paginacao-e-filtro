package com.github.maykonoliveira.listagempaginacaoefiltro.repository

import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Livro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface LivroRepository : JpaRepository<Livro, Long>, JpaSpecificationExecutor<Livro>