package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class UserController {
    @Autowired
    private UserRepository productoRepository;

    @GetMapping
    public List<UserEntity> listarProductos() {
        return productoRepository.findAll();
    }

    // Otros métodos de controlador para crear, actualizar y eliminar productos
}
