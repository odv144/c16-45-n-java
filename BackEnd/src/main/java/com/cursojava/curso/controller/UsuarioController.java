package com.cursojava.curso.controller;

import com.cursojava.curso.dto.UsuarioDTO;
import com.cursojava.curso.entity.Usuario;
import com.cursojava.curso.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private UsuarioService usuarioService;


    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public UsuarioDTO crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crear(usuario);
    }

    @GetMapping("/por-correo")
    public UsuarioDTO getUsuario(@RequestParam String correo) {
        return usuarioService.getUsuario(correo);
    }

    @GetMapping
    public List<UsuarioDTO> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PutMapping("/por-correo")
    public UsuarioDTO update(@RequestParam String correo, @RequestBody Usuario usuario) {
        return usuarioService.update(correo, usuario);
    }

    @DeleteMapping("/por-correo")
    public String delete(@RequestParam String correo) {
        try {
            usuarioService.delete(correo);
            return "Usuario eliminado";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
