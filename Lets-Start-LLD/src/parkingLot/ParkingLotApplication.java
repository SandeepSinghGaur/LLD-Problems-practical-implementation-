package parkingLot;

import parkingLot.controller.TicketController;
import parkingLot.dtos.IssueTicketRequestDto;
import parkingLot.model.VehicleType;
import parkingLot.repository.GateRepository;
import parkingLot.repository.ParkingLotRepository;
import parkingLot.repository.TicketRepository;
import parkingLot.repository.VehicleRepository;
import parkingLot.service.TicketService;

public class ParkingLotApplication {
    public static void main(String[] args) throws Exception {
        // topological order
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, parkingLotRepository, ticketRepository);
        TicketController ticketController = new TicketController(ticketService);
        IssueTicketRequestDto requestDto = new IssueTicketRequestDto("KA01JX5432", VehicleType.BIKE,"Sandeep",1L);
        ticketController.issueTicket(requestDto);

    }
}
