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

    @Test
    public void givenNoVehicle_whenUnParkingVehicle_shouldReturnFalse() throws ParkingLotException {
        parkingLotSystem.park(new Object());
        boolean unParked = parkingLotSystem.unPark(vehicle);
        Assertions.assertFalse(unParked);
    }

    @Test
    public void givenAVehicle_WhenNotFUll_ThenShouldReturnTrue() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        boolean checkFull = parkingLotSystem.checkParkingLotFull();
        Assertions.assertTrue(checkFull);
    }

    @Test
    public void givenALot_WhenFull_ThenShouldReturnTrue() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        parkingLotSystem.unPark(vehicle);
        boolean checkEmpty = parkingLotSystem.checkParkingLotFull();
        Assertions.assertFalse(checkEmpty);
    }

    @Test
    public void givenWhenParkingLotIsFull_ThenShouldRedirectToSecurityStaff() {
        try {
            parkingLotSystem.park(vehicle);
            if (parkingLotSystem.checkParkingLotFull()) {
                throw new ParkingLotSignal("PARKING LOT IS FULL");
            }
        } catch (ParkingLotException | ParkingLotSignal signal) {
            Assertions.assertEquals("PARKING LOT IS FULL", signal.getMessage());
        }
    }

    @Test
    public void givenWhenParkingLotHasSpace_ThenInformToOwner() throws ParkingLotException {
        try {
            parkingLotSystem.park(vehicle);
            if (parkingLotSystem.checkParkingLotFull()) {
                throw new ParkingLotSignal("ALLOWED TO PARK");
            }
        } catch (ParkingLotSignal signal) {
            Assertions.assertEquals("ALLOWED TO PARK", signal.getMessage());
        }

    }
}






