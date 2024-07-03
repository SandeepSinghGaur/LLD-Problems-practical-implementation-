package parkingLot.service;

import parkingLot.Factory.SpotAssigningStrategyFactory;
import parkingLot.exception.GateNotFoundException;
import parkingLot.model.*;
import parkingLot.repository.GateRepository;
import parkingLot.repository.ParkingLotRepository;
import parkingLot.repository.TicketRepository;
import parkingLot.repository.VehicleRepository;
import parkingLot.strategy.SpotAssigningStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,VehicleRepository vehicleRepository,ParkingLotRepository parkingLotRepository,TicketRepository ticketRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(String vehicleNumber, VehicleType vehicleType, String vehicleOwnerName, Long gateId) throws Exception {
        // 1. Create a ticket obje
        // 2. Assign spot
        // 3. Return
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gate> gateOptional= gateRepository
                .findGateByID(gateId);


        if (gateOptional.isEmpty()) {
            throw new GateNotFoundException("Gate is Not present in DB");
        }

        Gate gate = gateOptional.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getCurrentOperator());

        Vehicle savedVehicle;

        Optional<Vehicle> vehicleOptional = vehicleRepository
                .getVehicleByNumber(vehicleNumber);

        if (vehicleOptional.isEmpty()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setNumber(vehicleNumber);
            vehicle.setOwnerName(vehicleOwnerName);

            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        } else {
            savedVehicle = vehicleOptional.get();
        }

        ticket.setVehicle(savedVehicle);

        SpotAssignmentStrategyType assignmentStrategyType = parkingLotRepository.getParkingLotForGate(
                gate
        ).getSpotAssignmentStrategyType();

        SpotAssigningStrategy spotAssignmentStrategy = SpotAssigningStrategyFactory.spotType(assignmentStrategyType);

        ticket.setAssignSpot(
                spotAssignmentStrategy.assignSpot(
                        gate, vehicleType
                )
        );

        // Check if vehicle in DB
        // 1. Yes
        //    -- get vehicle of database
        //    -- put in ticket object
        // 2. No
        //    -- create new vehicle
        //    -- save it to database
        //    -- put in ticket object
        ticket.setNumber(100);
        return ticketRepository.saveTicket(ticket);
    }
}
