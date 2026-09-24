package br.com.cocal_2.devshowcase.service;

import br.com.cocal_2.devshowcase.dto.ProfileRequestDTO;
import br.com.cocal_2.devshowcase.dto.ProfileResponseDTO;
import br.com.cocal_2.devshowcase.model.Profile;
import br.com.cocal_2.devshowcase.repository.ProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Transactional
    public ProfileResponseDTO criar(ProfileRequestDTO dto) {
        Profile profile = new Profile();
        profile.setName(dto.getName());
        profile.setBio(dto.getBio());
        profile.setGithubUsername(dto.getGithubUsername());
        profile.setAvatarUrl(dto.getAvatarUrl());
        profile.setLinkedinUrl(dto.getLinkedinUrl());

        Profile saved = profileRepository.save(profile);
        return new ProfileResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public ProfileResponseDTO buscarPorId(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Perfil não encontrado com o ID: " + id));
        return new ProfileResponseDTO(profile);
    }
}
