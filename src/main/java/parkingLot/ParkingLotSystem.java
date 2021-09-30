package parkingLot;

public class ParkingLotSystem {
    public ParkingLotSystem() {
    }

    private Object vehicle;

    public boolean park(Object vehicle) throws ParkingLotException {
        if (this.vehicle == null) {
            this.vehicle = vehicle;
            return true;
        }
        throw new ParkingLotException("Parking is filled");
    }

    public boolean unPark(Object vehicle) throws ParkingLotException{
        if (vehicle == null) return false;
        if (this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            return true;
        }
       throw new ParkingLotException("Vehicle is not parked");
    }

}
