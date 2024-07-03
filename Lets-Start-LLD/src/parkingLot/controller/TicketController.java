package parkingLot.controller;

import parkingLot.dtos.IssueTicketRequestDto;
import parkingLot.dtos.IssueTicketResponseDto;
import parkingLot.dtos.ResponseStatus;
import parkingLot.model.Ticket;
import parkingLot.service.TicketService;

public class TicketController {

    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto request) throws Exception {
        IssueTicketResponseDto responseStatus = new IssueTicketResponseDto();
        Ticket ticket;
        try {
            ticket = this.ticketService.issueTicket(request.getNumber(), request.getVehicleType(), request.getOwnerName(), request.getGateId());
        } catch (Exception e) {
            responseStatus.setResponseStatus(ResponseStatus.FAILURE);
            responseStatus.setFailureReason(e.getMessage());
            throw new Exception(e.getMessage());
        }
        responseStatus.setTicket(ticket);
        return responseStatus;
    }
}
