package br.com.cocal_2.devshowcase.controller;

import br.com.cocal_2.devshowcase.dto.ProfileRequestDTO;
import br.com.cocal_2.devshowcase.dto.ProfileResponseDTO;
import br.com.cocal_2.devshowcase.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> criar(@RequestBody @Valid ProfileRequestDTO dto) {
        ProfileResponseDTO salvo = profileService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponseDTO> buscarPorId(@PathVariable Long id) {
        ProfileResponseDTO profile = profileService.buscarPorId(id);
        return ResponseEntity.ok(profile);
    }
}
