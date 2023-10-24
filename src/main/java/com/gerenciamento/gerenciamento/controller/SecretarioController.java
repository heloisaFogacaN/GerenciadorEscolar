package com.gerenciamento.gerenciamento.controller;


import com.gerenciamento.gerenciamento.Service.SecretarioService;
import com.gerenciamento.gerenciamento.Service.UsuarioService;
import com.gerenciamento.gerenciamento.model.Secretario;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/secretario")
@AllArgsConstructor
public class SecretarioController{
    private SecretarioService usuarioService;

    @GetMapping("/{id}")
    public Secretario buscarSecretario(@PathVariable Integer id) throws SQLException {
        return (Secretario) usuarioService.buscarUsuario(id);
    }

    @GetMapping
    public Collection buscarTodos() throws SQLException {
        return usuarioService.buscarTodos();
    }

    @DeleteMapping
    public void remover(@RequestParam Integer id) throws SQLException {
        usuarioService.remover(id);
    }

    @PostMapping
    public void inserir(@RequestBody Secretario secretario){
        usuarioService.salvar(secretario);
    }

    @PutMapping
    public void atualizar(@RequestBody Secretario secretario){
        usuarioService.salvar(secretario);
    }
}
