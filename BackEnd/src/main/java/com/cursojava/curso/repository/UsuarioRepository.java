package com.cursojava.curso.repository;

import com.cursojava.curso.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    public Optional<Usuario> findByCorreo(String correo);
}
