package com.promineoFinal.service;

import java.util.List;
import com.promineoFinal.model.Instrument;

public interface InstrumentService {

    List<Instrument> getAllInstruments();

    Instrument deleteInstrumentById(Long instrumentId);

    Instrument updateInstrumentById(Long instrumentId, Instrument instrument);

    Instrument getInstrumentById(Long instrumentId);

    Instrument saveInstrument(Instrument instrument);

}