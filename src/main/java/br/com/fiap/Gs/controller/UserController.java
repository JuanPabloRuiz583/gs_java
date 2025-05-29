package br.com.fiap.Gs.controller;

import br.com.fiap.Gs.dto.UserCreateDTO;
import br.com.fiap.Gs.dto.UserDTO;
import br.com.fiap.Gs.model.UserRole;
import br.com.fiap.Gs.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.Gs.model.User;
import br.com.fiap.Gs.repository.UserRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioService usuarioService;




//metodo para criar usuario com senha criptografada
   // @PostMapping
    //@Operation(summary = "Cria um novo usuário com a senha criptografada", description = "Cria um usuário com nome, email, senha e role(ADMIN ou USER).")
    //public User create(@RequestBody @Valid UserCreateDTO dto) {
      //  User user = User.builder()
        //        .nome(dto.getNome())
          //      .email(dto.getEmail())
            //    .password(passwordEncoder.encode(dto.getPassword()))
              //  .role(dto.getRole())
               // .build();
        //return repository.save(user);
   // }


    @PostMapping
    @Operation(summary = "Cria um novo usuário com a senha criptografada", description = "Cria um usuário com nome, email, senha e role(ADMIN ou USER).")
    public ResponseEntity<User> create(@RequestBody @Valid UserCreateDTO dto) {
        User user = User.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole())
                .build();
        User savedUser = repository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }


    //metodos de crud para usuario
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }



    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @Valid @RequestBody UserDTO dto) {
        UserDTO updatedUsuario = usuarioService.update(id, dto);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }


}