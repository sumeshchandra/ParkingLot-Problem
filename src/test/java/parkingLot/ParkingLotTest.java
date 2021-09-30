package parkingLot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    ParkingLotSystem parkingLotSystem = null;
    Object vehicle = null;

    @BeforeEach
    public void setUp() throws Exception {
        parkingLotSystem = new ParkingLotSystem();
        vehicle = new Object();
    }

    @Test
    public void givenAVehicle_WhenParked_ThenShouldAbeToPark() throws ParkingLotException {
        boolean isParked = parkingLotSystem.park(new Object());
        Assertions.assertTrue(isParked);
    }

    @Test
    public void givenAVehicle_WhenAlreadyParked_ShouldReturnFalse() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        boolean isPark = parkingLotSystem.park(new Object());
        Assertions.assertFalse(isPark, "False");
    }

    @Test
    public void givenAVehicle_WhenUnParked_ThenShouldReturnTrue() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        boolean isUnParked = parkingLotSystem.unPark(vehicle);
        Assertions.assertTrue(isUnParked);
    }

    @Test
    public void givenAVehicle_WhenParked_ThenShouldReturnTrue() {
        boolean isParked = false;
        try {
            isParked = parkingLotSystem.park(vehicle);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(isParked);
    }

    @Test
    public void given2Vehicle_WhenParked_ThenShouldReturnTrue() {
        parkingLotSystem = new ParkingLotSystem();
        try {
            Assertions.assertTrue(parkingLotSystem.park(new Object()));
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenParkingLotWithOneCapacity_WhenWePark_ThenShouldBeAbleToPark() {
        ParkingLotSystem parkingLot = new ParkingLotSystem();
        try {
            Assertions.assertTrue(parkingLot.park(new Object()));
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

}






