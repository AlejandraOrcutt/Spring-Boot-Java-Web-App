package com.promineoFinal.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineoFinal.model.Instrument;
import com.promineoFinal.model.Student;
import com.promineoFinal.service.InstrumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/musical_groups/instruments")
@Api(value = "InstrumentController", tags = { "Instruments" })
public class InstrumentController {

    private InstrumentService instrumentService;

    public InstrumentController(InstrumentService instrumentService) {
        super();
        this.instrumentService = instrumentService;
    }

    @GetMapping
    @ApiOperation(value = "Get all instruments", notes = "Get a list of all instruments")
    public List<String> getAllInstruments() {
        // Return a list of allowed instrument names
        return Arrays.asList("violin", "viola", "cello");
    }

    @GetMapping("/{instrument_id}")
    @ApiOperation(value = "Get instrument by ID", notes = "Get instrument details by ID")
    public ResponseEntity<Instrument> getInstrumentById(
            @PathVariable("instrument_id") @ApiParam(value = "Instrument ID", example = "1") Long instrumentId) {
        // Retrieve instrument by ID from the service
        Instrument instrument = instrumentService.getInstrumentById(instrumentId);
        if (instrument == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(instrument, HttpStatus.OK);
    }

    
    @PostMapping("/instrument")
    @ApiOperation(value = "Create an instrument", notes = "Create a new instrument")
    public ResponseEntity<Instrument> saveInstrument(@RequestBody Instrument instrument) {
        // Save the instrument object and retrieve the saved instrument with the generated instrumentId
        Instrument savedInstrument = instrumentService.saveInstrument(instrument);
        // Return the saved instrument object in the response with HttpStatus.CREATED status
        return new ResponseEntity<>(savedInstrument, HttpStatus.CREATED);
    }
  
    @PutMapping("/{instrument_id}")
    @ApiOperation(value = "Update instrument by ID", notes = "Update instrument details by ID")
    public ResponseEntity<Instrument> updateInstrumentById(
            @PathVariable("instrument_id") @ApiParam(value = "Instrument ID", example = "1") Long instrumentId,
            @RequestBody Instrument instrument) {
        Instrument updatedInstrument = instrumentService.updateInstrumentById(instrumentId, instrument);
        if (updatedInstrument == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedInstrument, HttpStatus.OK);
    }

    @DeleteMapping("/{instrument_id}")
    @ApiOperation(value = "Delete instrument by ID", notes = "Delete instrument by ID")
    public ResponseEntity<Void> deleteInstrumentById(
            @PathVariable("instrument_id") @ApiParam(value = "Instrument ID", example = "1") Long instrumentId) {
        boolean deleted = instrumentService.deleteInstrumentById(instrumentId) != null;
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}