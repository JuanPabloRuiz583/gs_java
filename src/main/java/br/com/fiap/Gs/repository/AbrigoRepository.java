package br.com.fiap.Gs.repository;


import br.com.fiap.Gs.model.Abrigo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {
    Page<Abrigo> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}