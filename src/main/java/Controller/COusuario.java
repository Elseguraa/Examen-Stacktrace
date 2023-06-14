/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dto.usuarioDTO;
import Entity.usuario;
import Service.SEusuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = {"http://localhost:4200"})
public class COusuario {
    private final SEusuario usuarioService;
    
    @Autowired
    public COusuario(SEusuario usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<usuario> crearUsuario(@RequestBody usuarioDTO usuarioDTO) {
        usuario nuevoUsuario = usuarioService.crearUsuario(usuarioDTO);
        if (nuevoUsuario != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<usuario> actualizarUsuario(@PathVariable int id, @RequestBody usuarioDTO usuarioDTO) {
        usuario usuarioActualizado = usuarioService.actualizarUsuario(id, usuarioDTO);
        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<usuario> obtenerUsuarioPorId(@PathVariable int id) {
        usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<usuario> obtenerUsuarioPorDni(@PathVariable String dni) {
        usuario usuario = usuarioService.obtenerUsuarioPorDni(dni);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<List<usuario>> obtenerUsuariosPorApellido(@PathVariable String apellido) {
        List<usuario> usuarios = usuarioService.obtenerUsuariosPorApellido(apellido);
        if (!usuarios.isEmpty()) {
            return ResponseEntity.ok(usuarios);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<usuario> obtenerUsuarioPorEmail(@PathVariable String email) {
        usuario usuario = usuarioService.obtenerUsuarioPorEmail(email);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/numero/{numero}")
    public ResponseEntity<usuario> obtenerUsuarioPorNumero(@PathVariable String numero) {
        usuario usuario = usuarioService.obtenerUsuarioPorNumero(numero);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    
 }
    
}
