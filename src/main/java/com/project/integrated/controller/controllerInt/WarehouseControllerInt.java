package com.project.integrated.controller.controllerInt;

import com.project.answer.AnswerWarehouse;
import com.project.integrated.entity.Warehouse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.UUID;

public interface WarehouseControllerInt {

    AnswerWarehouse save(@RequestBody Warehouse warehouse);

    AnswerWarehouse find(@PathVariable UUID id);

    AnswerWarehouse saveList(@RequestBody ArrayList<Warehouse> warehouseList);
}