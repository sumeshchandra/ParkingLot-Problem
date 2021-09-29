package parkingLot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {

    @Test
    public void givenParkingLot_ThenShouldAbeToPark() {
        ParkingLotSystem parkinglotsystem = new ParkingLotSystem();
        Assertions.assertTrue(parkinglotsystem.park(new Object()));
    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnTrue(){
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        Object vehicle = new Object();
        parkingLotSystem.park(vehicle);
        boolean isUnParked = parkingLotSystem.unPark(vehicle);
        Assertions.assertTrue(isUnParked);
    }
}
