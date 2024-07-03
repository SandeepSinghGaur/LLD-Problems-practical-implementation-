package parkingLot.dtos;

import parkingLot.model.VehicleType;

public class IssueTicketRequestDto {
    private String number;
    private VehicleType vehicleType;
    private String ownerName;
    private Long gateId;

    public IssueTicketRequestDto(String number, VehicleType vehicleType, String ownerName, Long gateId) {
        this.number = number;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
        this.gateId = gateId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }
}
