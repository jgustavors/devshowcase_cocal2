package br.com.cocal_2.devshowcase.repository;

import br.com.cocal_2.devshowcase.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
