package com.project.integrated.controller.pages;

import com.project.answer.AnswerQuantity;
import com.project.datanomenclature.Data;
import com.project.datanomenclature.DataNomenclature;
import com.project.integrated.entity.Quantity;
import com.project.integrated.service.QuantityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class PageController {

    private final QuantityService quantityService;

    @GetMapping
    public String map(@RequestParam(name="name", required=false) String name, Model model) {
       /* List quantityList = quantityService.findAll();
        model.addAttribute("name", name);
        model.addAttribute("quantityList", quantityList);*/
        AnswerQuantity answerQuantity = quantityService.findAll();

        model.addAttribute("dataNomenclature", answerQuantity);
        return "map";
    }
}