package parkingLot.strategy;

import parkingLot.model.Gate;
import parkingLot.model.ParkingLot;
import parkingLot.model.VehicleType;

public interface SpotAssigningStrategy {
    public ParkingLot assignSpot(Gate gate, VehicleType vehicleType);
}
