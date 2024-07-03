package parkingLot.repository;

import parkingLot.model.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public  class GateRepository {
    //  private Database database;
    private Map<Long, Gate> gates = new TreeMap<>();

    public Optional<Gate> findGateByID(Long id){

        //  database.execute("select * from gate ")
        if (gates.containsKey(id)) {
            return Optional.of(gates.get(id));
        }

        return Optional.empty();
    }
}
