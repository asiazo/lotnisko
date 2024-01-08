package org.pwr.lotnisko.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.pwr.lotnisko.dto.TicketDto;
import org.pwr.lotnisko.model.Ticket;

@Mapper(componentModel = "spring")
public interface TicketMapper
{
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    Ticket toTicket(TicketDto dto);
}
