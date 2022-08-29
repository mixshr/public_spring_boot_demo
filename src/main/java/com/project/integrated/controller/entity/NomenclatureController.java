package com.project.integrated.controller.entity;

import com.project.answer.AnswerNomenclature;
import com.project.integrated.controller.controllerInt.NomenclatureControllerInt;
import com.project.integrated.entity.Nomenclature;
import com.project.integrated.service.NomenclatureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@Slf4j
@RestController("/nomenclature")
@AllArgsConstructor
public class NomenclatureController implements NomenclatureControllerInt {

    private final NomenclatureService nomenclatureService;

    @Override
    @PostMapping("/nomenclature/set")
    public AnswerNomenclature save(Nomenclature nomenclature) {
       return nomenclatureService.save(nomenclature);
    }

    @Override
    @PostMapping("/nomenclature/setlist")
    public AnswerNomenclature saveList(ArrayList<Nomenclature> nomenclatureList) {
        return nomenclatureService.saveList(nomenclatureList);
    }

    @Override
    @GetMapping("/nomenclature/find/{id}")
    public AnswerNomenclature find(@PathVariable UUID id) {
        return nomenclatureService.find(id);
    }
}