package com.project.integrated.controller.entity;

import com.project.answer.AnswerWarehouse;
import com.project.integrated.controller.controllerInt.WarehouseControllerInt;
import com.project.integrated.entity.Warehouse;
import com.project.integrated.service.WarehouseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@Slf4j
@RestController("warehouse")
@AllArgsConstructor
public class WarehouseController implements WarehouseControllerInt {

    private final WarehouseService warehouseService;

    @Override
    @PostMapping("/warehouse/set")
    public AnswerWarehouse save(Warehouse warehouse) {
        return warehouseService.save(warehouse);
    }

    @Override
    @PostMapping("/warehouse/setList")
    public AnswerWarehouse saveList(ArrayList<Warehouse> warehouseList) {
        return warehouseService.saveList(warehouseList);
    }

    @Override
    @GetMapping("/warehouse/find/{id}")
    public AnswerWarehouse find(@PathVariable UUID id) {
        return warehouseService.find(id);
    }
}