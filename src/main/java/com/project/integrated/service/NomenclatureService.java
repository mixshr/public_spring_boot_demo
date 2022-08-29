package com.project.integrated.service;

import com.project.answer.AnswerNomenclature;
import com.project.integrated.entity.Nomenclature;
import com.project.integrated.repository.NomenclatureRepository;
import com.project.integrated.service.serviceInt.NomenclatureServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class NomenclatureService implements NomenclatureServiceInt {

    private final NomenclatureRepository nomenclatureRepository;

    @Override
    public AnswerNomenclature save(Nomenclature nomenclature) {
        return nomenclatureRepository.save(nomenclature);
    }

    @Override
    public AnswerNomenclature find(UUID id) {
        return nomenclatureRepository.find(id);
    }

    @Override
    public AnswerNomenclature saveList(ArrayList<Nomenclature> nomenclatureList) {
        return nomenclatureRepository.saveList(nomenclatureList);
    }
}