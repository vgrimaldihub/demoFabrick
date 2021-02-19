package it.fabrick.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fabrick.demo.domain.Transazione;
import it.fabrick.demo.dto.TransazioneDto;
import it.fabrick.demo.persistence.TransazioneRepository;
import it.fabrick.demo.util.mapper.TransazioneMapper;

@Service
public class TransazioniService {
	
	@Autowired
	private TransazioneMapper transazioneMapper;
	
	@Autowired
	private TransazioneRepository transazioneRepository;

	public void insertTransazioni(TransazioneDto transazioneDto) {
		Transazione transazioneEntity = transazioneMapper.convertToEntity(transazioneDto);
		System.out.println("transazione entity:" + transazioneEntity.toString());
		transazioneRepository.save(transazioneEntity);
	}
	
}
