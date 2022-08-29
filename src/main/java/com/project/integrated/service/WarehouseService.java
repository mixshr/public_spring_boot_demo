package com.project.integrated.service;

import com.project.answer.AnswerWarehouse;
import com.project.integrated.entity.Warehouse;
import com.project.integrated.repository.WarehouseRepository;
import com.project.integrated.service.serviceInt.WarehouseServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WarehouseService implements WarehouseServiceInt {

    private final WarehouseRepository warehouseRepository;

    @Override
    public AnswerWarehouse save(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public AnswerWarehouse find(UUID id) {
        return warehouseRepository.find(id);
    }

    @Override
    public AnswerWarehouse saveList(ArrayList<Warehouse> warehouseList) {
        return warehouseRepository.saveList(warehouseList);
    }
}