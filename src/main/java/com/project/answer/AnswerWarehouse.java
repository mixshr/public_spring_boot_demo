package com.project.answer;

import com.project.integrated.entity.Warehouse;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AnswerWarehouse extends Answer{

    private List<Warehouse> warehouseList;

    public AnswerWarehouse(boolean result, String error) {
        super(result, error);
        this.warehouseList = new ArrayList<>();
    }

    public AnswerWarehouse(boolean result) {
        super(result);
        this.warehouseList = new ArrayList<>();
    }

    public void addWareHouse(Warehouse warehouse) {
        if (warehouse == null) {
            return;
        }
        this.warehouseList.add(warehouse);
    }
}