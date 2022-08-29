package com.project.integrated.controller.entity;

import com.project.answer.AnswerQuantity;
import com.project.integrated.controller.controllerInt.QuantityControllerInt;
import com.project.integrated.entity.Quantity;
import com.project.integrated.service.QuantityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.UUID;

@Slf4j
@RestController("/quantity")
@AllArgsConstructor
public class QuantityController implements QuantityControllerInt {

    private final QuantityService quantityService;

    @Override
    @PostMapping("/quantity/set")
    public AnswerQuantity save(Quantity quantity) {
        return quantityService.save(quantity);
    }

    @Override
    @PostMapping("/quantity/setList")
    public AnswerQuantity saveArray(ArrayList<Quantity> array) {
        return quantityService.saveArray(array);
    }

    @Override
    @GetMapping("/quantity/find/{nomenclatureId}")
    public AnswerQuantity find(UUID nomenclatureId) {
        return quantityService.find(nomenclatureId);
    }

    @Override
    @GetMapping("/quantity/find/{nomenclatureId}/{warehouseId}")
    public AnswerQuantity find(UUID nomenclatureId, UUID warehouseId) {
        return quantityService.find(nomenclatureId, warehouseId);
    }

    @Override
    @GetMapping("/quantity/findAll")
    public AnswerQuantity findAll() {
        return quantityService.findAll();
    }

    @Override
    @GetMapping("/quantity/findAll/{warehouseId}")
    public AnswerQuantity findAll(UUID warehouseId) {
        return quantityService.findAll(warehouseId);
    }
}