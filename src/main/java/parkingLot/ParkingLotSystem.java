package parkingLot;

public class ParkingLotSystem {
    public ParkingLotSystem() {
    }

    private Object vehicle;

    public boolean park(Object vehicle) {
        if (this.vehicle != null) {
            this.vehicle = vehicle;
            return true;
        }
        return false;
    }

    public boolean unPark(Object vehicle) {
        if (vehicle == null) return false;
        if (this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            return true;
        }
        return false;
    }
}
