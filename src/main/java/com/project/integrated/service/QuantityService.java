package com.project.integrated.service;

import com.project.answer.AnswerQuantity;
import com.project.integrated.entity.Quantity;
import com.project.integrated.repository.QuantityRepository;
import com.project.integrated.service.serviceInt.QuantityServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class QuantityService implements QuantityServiceInt {

    private final QuantityRepository quantityRepository;


    @Override
    public AnswerQuantity save(Quantity quantity) {
        List<Quantity> quantityList = find(quantity.getNomenclature()).getQuantityList();

        for (Quantity quantityObj:quantityList) {
            quantityObj.setQuantity(quantity.getQuantity());
            quantity = quantityObj;
        }

        return quantityRepository.save(quantity);
    }

    @Override
    public AnswerQuantity saveArray(List<Quantity> array) {

        List<Quantity> quantityList = findAll().getQuantityList();
        int index = 0;
        for (Quantity quantity:array) {
            for (Quantity quantityObj:quantityList) {
                if(quantity.equals(quantityObj)) {
                    quantityObj.setQuantity(quantity.getQuantity());
                    array.set(index, quantityObj);
                }
            }
            index++;
        }

        return quantityRepository.saveArray(array);
    }

    @Override
    public AnswerQuantity find(UUID nomenclatureId) {
        return quantityRepository.find(nomenclatureId);
    }

    @Override
    public AnswerQuantity find(UUID nomenclatureId, UUID warehouseId) {
        return quantityRepository.find(nomenclatureId, warehouseId);
    }

    @Override
    public AnswerQuantity findAll() {
        return quantityRepository.findAll();
    }

    @Override
    public AnswerQuantity findAll(UUID warehouseId) {
        return quantityRepository.findAll(warehouseId);
    }
}