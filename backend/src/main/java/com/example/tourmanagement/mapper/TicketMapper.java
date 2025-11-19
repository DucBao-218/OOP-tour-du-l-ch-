package com.example.tourmanagement.mapper;

import com.example.tourmanagement.dto.TicketDTO;
import com.example.tourmanagement.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mapping(target = "tourName", source = "departureDate.tour.name")
    @Mapping(target = "startLocation", source = "departureDate.tour.startLocation")
    @Mapping(target = "destination", source = "departureDate.tour.destination")
    @Mapping(target = "departureDate", source = "departureDate.departureDay")
    @Mapping(target = "customerName", source = "customer.representativeName")
    @Mapping(target = "identityType", source = "customer.documentType")
    @Mapping(target = "identityNumber", source = "customer.documentNumber")
    @Mapping(target = "phone", source = "customer.phone")
    @Mapping(target = "email", source = "customer.email")
    @Mapping(target = "address", source = "customer.address")
    @Mapping(target = "pricePerPerson", source = "departureDate.price")
    @Mapping(target = "totalAmount", expression = "java(ticket.getDepartureDate().getPrice() * 1)") 
    // nếu có số lượng người thì thay 1 bằng ticket.getNumberOfPeople()
    TicketDTO toDTO(Ticket ticket);
}
