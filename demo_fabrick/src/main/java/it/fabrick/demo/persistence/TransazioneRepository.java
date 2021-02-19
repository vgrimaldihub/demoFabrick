package it.fabrick.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.fabrick.demo.domain.Transazione;

@Repository
public interface TransazioneRepository extends JpaRepository<Transazione, String> {

	

}
