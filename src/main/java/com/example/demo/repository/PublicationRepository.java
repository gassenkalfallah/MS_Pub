package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Publication;

@Repository
@RepositoryRestController
public interface PublicationRepository extends JpaRepository<Publication,Long>{
	Publication findByTitre(String titre);
	List<Publication>findByTitreStartingWith(String caractere);
	Publication findByLien(String lien);
	List<Publication> findByType(String type);

}
