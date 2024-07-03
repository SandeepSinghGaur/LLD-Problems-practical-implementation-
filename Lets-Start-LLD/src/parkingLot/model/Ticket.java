package parkingLot.model;

import java.util.Date;

public class Ticket extends BaseModel{
    private int number;
    private Date entryTime;
    private Vehicle vehicle;
    private ParkingLot assignSpot;
    private Gate generatedAt;
    private Operator generatedBy;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingLot getAssignSpot() {
        return assignSpot;
    }

    public void setAssignSpot(ParkingLot assignSpot) {
        this.assignSpot = assignSpot;
    }

    public Gate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Gate generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }
}
