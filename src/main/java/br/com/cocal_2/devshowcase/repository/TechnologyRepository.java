package br.com.cocal_2.devshowcase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cocal_2.devshowcase.model.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {
	
}