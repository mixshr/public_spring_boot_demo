package com.project.integrated.service.serviceInt;

import com.project.answer.AnswerNomenclature;
import com.project.integrated.entity.Nomenclature;

import java.util.ArrayList;
import java.util.UUID;

public interface NomenclatureServiceInt {

    AnswerNomenclature save(Nomenclature nomenclature);

    AnswerNomenclature find(UUID id);

    AnswerNomenclature saveList(ArrayList<Nomenclature> nomenclatureList);
}