package com.project.answer;

import com.project.integrated.entity.Quantity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AnswerQuantity extends Answer{

    private List<Quantity> quantityList;

    public AnswerQuantity(boolean result, String error) {
        super(result, error);
        this.quantityList = new ArrayList<>();
    }

    public AnswerQuantity(boolean result) {
        super(result);
        this.quantityList = new ArrayList<>();
    }

    public void addQuantity(Quantity quantity) {
        if (quantity == null) {
            return;
        }
        this.quantityList.add(quantity);
    }
}