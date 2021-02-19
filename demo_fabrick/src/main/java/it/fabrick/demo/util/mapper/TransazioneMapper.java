package it.fabrick.demo.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.fabrick.demo.domain.Transazione;
import it.fabrick.demo.dto.TransazioneDto;

@Component
public class TransazioneMapper {
	
	@Autowired
	private ModelMapper mapper;

	public Transazione convertToEntity(TransazioneDto dto) {
		Transazione entity = mapper.map(dto, Transazione.class);
		entity.setTransactionId(dto.getTransactionId());
		entity.setOperationId(dto.getOperationId());
		entity.setAccountingDate(dto.getAccountingDate());
		entity.setAmount(dto.getAmount());	
		entity.setCurrency(dto.getCurrency());	
		entity.setDescription(dto.getDescription());	
		entity.setValueDate(dto.getValueDate());	
		return entity;
	}
}
