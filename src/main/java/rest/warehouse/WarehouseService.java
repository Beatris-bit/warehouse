package rest.warehouse;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import rest.model.WarehouseData;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseSimulation simulation;

    public WarehouseData getWarehouseData(String id) {
        return simulation.getData(id);
    }
}
