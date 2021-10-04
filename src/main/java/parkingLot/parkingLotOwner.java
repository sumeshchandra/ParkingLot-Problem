package parkingLot;

public class parkingLotOwner implements ParkingLotObserver {
    private boolean isFullCapacity;

    public void capacityIsFull() {
        isFullCapacity = true;
    }

    public boolean isCapacityFull() {
        return this.isFullCapacity;
    }
}
