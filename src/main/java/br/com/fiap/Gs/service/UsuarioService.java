package br.com.fiap.Gs.service;

import br.com.fiap.Gs.dto.UserCreateDTO;
import br.com.fiap.Gs.dto.UserDTO;
import br.com.fiap.Gs.exception.DuplicateResourceException;
import br.com.fiap.Gs.exception.ResourceNotFoundException;
import br.com.fiap.Gs.model.User;
import br.com.fiap.Gs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> new UserDTO(user.getId(), user.getNome(), user.getEmail(), user.getPassword()))
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com ID " + id + " não encontrado"));
        return new UserDTO(user.getId(), user.getNome(), user.getEmail(), user.getPassword());
    }

    public UserDTO create(UserCreateDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateResourceException("O email " + dto.getEmail() + " já está em uso");
        }

        User user = User.builder()
                .id(null)
                .nome(dto.getNome())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        user = userRepository.save(user);
        return new UserDTO(user.getId(), user.getNome(), user.getEmail(), null);
    }


}