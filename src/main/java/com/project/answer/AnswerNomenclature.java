package com.project.answer;

import com.project.integrated.entity.Nomenclature;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AnswerNomenclature extends Answer{

    private List<Nomenclature> nomenclatureList;

    public AnswerNomenclature(boolean result, String error) {
        super(result, error);
        this.nomenclatureList = new ArrayList<>();
    }

    public AnswerNomenclature(boolean result) {
        super(result);
        this.nomenclatureList = new ArrayList<>();
    }

    public void addNomenclature(Nomenclature nomenclature) {
        if(nomenclature == null) {
            return;
        }
        this.nomenclatureList.add(nomenclature);
    }
}