package com.project.integrated.repository.repositoryInt;

import com.project.answer.AnswerWarehouse;
import com.project.integrated.entity.Warehouse;

import java.util.ArrayList;
import java.util.UUID;

public interface WarehouseRepositoryInt {

    AnswerWarehouse save(Warehouse warehouse);

    AnswerWarehouse find(UUID id);

    AnswerWarehouse saveList(ArrayList<Warehouse> warehouseList);
}