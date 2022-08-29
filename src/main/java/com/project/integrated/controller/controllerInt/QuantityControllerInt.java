package com.project.integrated.controller.controllerInt;

import com.project.answer.AnswerQuantity;
import com.project.integrated.entity.Quantity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.UUID;

public interface QuantityControllerInt {

    AnswerQuantity save(@RequestBody Quantity quantity);

    AnswerQuantity saveArray(@RequestBody ArrayList<Quantity> array);

    AnswerQuantity find(@PathVariable UUID nomenclatureId);

    AnswerQuantity find(@PathVariable UUID nomenclatureId,@PathVariable UUID warehouseId);

    AnswerQuantity findAll();

    AnswerQuantity findAll(@PathVariable UUID warehouseId);
}