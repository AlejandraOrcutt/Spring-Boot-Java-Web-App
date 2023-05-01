package com.promineoFinal.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineoFinal.exception.ResourceNotFoundException;
import com.promineoFinal.model.Instrument;
import com.promineoFinal.repository.InstrumentRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class InstrumentServiceImpl implements InstrumentService {
  private InstrumentRepository instrumentRepository;


  public InstrumentServiceImpl(InstrumentRepository instrumentRepository) {
    this.instrumentRepository = instrumentRepository; 
  }
  
  // Get all instruments
  @Override
  public List<Instrument> getAllInstruments() {
    return instrumentRepository.findAll();
  }

  // Delete Instrument by Id
  @Override
  public Instrument deleteInstrumentById(Long instrumentId) {
    Optional<Instrument> optionalInstrument = instrumentRepository.findById(instrumentId);
    if (optionalInstrument.isPresent()) {
      Instrument instrument = optionalInstrument.get();
      instrumentRepository.deleteById(instrumentId);
      return instrument;
    } else {
      throw new ResourceNotFoundException("Instrument", "Id", instrumentId);
    }
  }
  
  // Update instrument by Id
  @Override
  public Instrument updateInstrumentById(Long instrumentId, Instrument instrument) {
    Optional<Instrument> optionalInstrument = instrumentRepository.findById(instrumentId);
    if (optionalInstrument.isPresent()) {
      Instrument existingInstrument = optionalInstrument.get();
      existingInstrument.setName(instrument.getName());
    
      // Update other fields as needed
      instrumentRepository.save(existingInstrument);
      return existingInstrument;
    } else {
      throw new ResourceNotFoundException("Instrument", "Id", instrumentId);
    }
  }

  // Get instrument by Id
  @Override
  public Instrument getInstrumentById(Long instrumentId) {
    Optional<Instrument> optionalInstrument = instrumentRepository.findById(instrumentId);
    if (optionalInstrument.isPresent()) {
      return optionalInstrument.get();
    } else {
      throw new ResourceNotFoundException("Instrument", "Id", instrumentId);
    }
  }

  @Override
  public Instrument saveInstrument(Instrument instrument) {
    // Save the instrument using the instrumentRepository
    return instrumentRepository.save(instrument); 
  }
  
}