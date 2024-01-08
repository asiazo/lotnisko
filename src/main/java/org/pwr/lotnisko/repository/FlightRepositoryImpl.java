package org.pwr.lotnisko.repository;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.pwr.lotnisko.dto.FlightDto;
import org.pwr.lotnisko.mapper.FlightMapper;
import org.pwr.lotnisko.model.Flight;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightRepositoryImpl implements FlightRepository {

    // TODO: CHECK IF ANY OF THOSE MAPPERS WORK
    private final ModelMapper modelMapper = new ModelMapper();
    private final FlightMapper flightMapper  = Mappers.getMapper(FlightMapper.class);

    private final List<Flight> flights = new ArrayList<>();

    @Override
    public boolean addFlight(FlightDto flightDto) {
        flights.add(flightMapper.toFlight(flightDto));
        return true;
    }

    @Override
    public boolean removeFlight(FlightDto flightDto) {
        flights.remove(flightMapper.toFlight(flightDto));
        return true;
    }

    @Override
    public FlightDto editFlight(FlightDto flightDto) {
        return flightDto;
    }
}
