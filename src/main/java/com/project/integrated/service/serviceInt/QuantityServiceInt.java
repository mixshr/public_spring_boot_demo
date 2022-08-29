package com.project.integrated.service.serviceInt;

import com.project.answer.AnswerQuantity;
import com.project.integrated.entity.Quantity;

import java.util.List;
import java.util.UUID;

public interface QuantityServiceInt {

    AnswerQuantity save(Quantity quantity);

    AnswerQuantity saveArray(List<Quantity> array);

    AnswerQuantity find(UUID nomenclatureId);

    AnswerQuantity find(UUID nomenclatureId, UUID warehouseId);

    AnswerQuantity findAll();

    AnswerQuantity findAll(UUID warehouseId);
}