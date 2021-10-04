package parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {

    private int actualCapacity;
    private List vehicles;
    private List<ParkingLotObserver> observers;
    private AirportSecurity security;

    public ParkingLotSystem(int capacity) {
        this.observers = new ArrayList<>();
        this.vehicles = new ArrayList();
        this.actualCapacity = capacity;
    }

    public void registerParkingLotObserver(ParkingLotObserver observer) {
        this.observers.add(observer);
    }

    public void setCapacity(int capacity) {
        this.actualCapacity = capacity;
    }

    public boolean checkParkingLotFull() {
        return this.vehicles != null;
    }

    public boolean park(Object vehicle) throws ParkingLotException {
        if (this.vehicles.size() == this.actualCapacity) {
            for (ParkingLotObserver observer : observers ) {
                observer.capacityIsFull();
            }
            throw new ParkingLotException("Parking is filled");
        }
        if (this.isVehicleParked(vehicle))
            throw new ParkingLotException("Vehicle Already Parked");
        this.vehicles.add(vehicle);
        return true;
    }

    public boolean isVehicleParked(Object vehicle) {
        if (this.vehicles.contains((vehicle)))
            return true;
        return false;
    }

    public boolean unPark(Object vehicle) throws ParkingLotException {
        if (vehicle == null) return false;
        if (this.vehicles.contains(vehicle)) {
            this.vehicles.remove(vehicle);
            return true;
        }
        throw new ParkingLotException("Vehicle is not parked");
    }

}
