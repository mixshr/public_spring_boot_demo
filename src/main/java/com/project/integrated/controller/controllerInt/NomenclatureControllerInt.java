package com.project.integrated.controller.controllerInt;

import com.project.answer.Answer;
import com.project.answer.AnswerNomenclature;
import com.project.integrated.entity.Nomenclature;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface NomenclatureControllerInt {

    AnswerNomenclature save(@RequestBody Nomenclature nomenclature);

    AnswerNomenclature find(@PathVariable UUID id);

    AnswerNomenclature saveList(@RequestBody ArrayList<Nomenclature> nomenclatureList);
}