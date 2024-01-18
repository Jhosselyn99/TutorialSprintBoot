package com.djl.controller;

import com.djl.domain.Usuario;
import com.djl.dto.UsuarioDTO;
import com.djl.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping("/")
    public ResponseEntity<?> insertUsuario(@RequestBody UsuarioDTO usuarioDTO){
      Usuario usuario=new Usuario();
      usuario.setNombre(usuarioDTO.getNombre());
      usuario.setCorreo(usuarioDTO.getCorreo());
      usuario.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
      usuario.setCelular (usuarioDTO.getCelular());
      Usuario newUsuario = usuarioRepository.save(usuario);
      return ResponseEntity.ok(newUsuario);

    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsuarios(){
        List<Usuario> usuarios= usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);

    }

    @PutMapping("/{uid}")
    public ResponseEntity<?> updatedUsuario(@RequestBody UsuarioDTO usuarioDTO, @PathVariable(name="uid") Integer uid){
        Usuario usuario=usuarioRepository.findById(uid).orElseThrow();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setCelular(usuarioDTO.getCelular());

        Usuario updatedUsuario= usuarioRepository.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<?> getUsuarioById(@PathVariable(name="uid") Integer uid){
        Usuario usuario=usuarioRepository.findById(uid).orElseThrow();
        return ResponseEntity.ok(usuario);
    }
    @DeleteMapping("/{uid}")
    public ResponseEntity<?> deleteUsuarioById(@PathVariable(name="uid") Integer uid){
        Usuario usuario=usuarioRepository.findById(uid).orElseThrow();
        usuarioRepository.delete(usuario);
        return ResponseEntity.ok("Usuario eliminado");
    }



}
