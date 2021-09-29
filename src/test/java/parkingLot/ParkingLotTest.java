package parkingLot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {

    @Test
    public void givenParkingLot_ThenShouldAbeToPark() {
        ParkingLotSystem parkinglotsystem = new ParkingLotSystem();
        Assertions.assertTrue(parkinglotsystem.park(new Object()));
    }
}
