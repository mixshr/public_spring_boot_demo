package com.project.integrated.service.serviceInt;

import com.project.answer.AnswerWarehouse;
import com.project.integrated.entity.Warehouse;

import java.util.ArrayList;
import java.util.UUID;

public interface WarehouseServiceInt {

    AnswerWarehouse save(Warehouse warehouse);

    AnswerWarehouse find(UUID id);

    AnswerWarehouse saveList(ArrayList<Warehouse> warehouseList);
}