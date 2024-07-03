package parkingLot.Factory;

import parkingLot.model.SpotAssignmentStrategyType;
import parkingLot.strategy.NearestSpotAssigningStrategy;
import parkingLot.strategy.SpotAssigningStrategy;

public class SpotAssigningStrategyFactory {

    public static SpotAssigningStrategy spotType(SpotAssignmentStrategyType spotAssignmentStrategyType) throws Exception {
        switch (spotAssignmentStrategyType) {
            case NearestSpotAssigningStrategy:
                return new NearestSpotAssigningStrategy();

            default:
                throw new Exception("Passed Correct spotAssignmentStrategyType");
        }
    }
}
