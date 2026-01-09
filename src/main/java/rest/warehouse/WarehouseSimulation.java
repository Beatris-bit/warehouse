package rest.warehouse;

import org.springframework.stereotype.Service;
import rest.model.WarehouseData;

@Service
public class WarehouseSimulation {

    public WarehouseData getData(String id) {
        WarehouseData data = new WarehouseData();
        data.setWarehouseID(id);
        return data;
    }
}
