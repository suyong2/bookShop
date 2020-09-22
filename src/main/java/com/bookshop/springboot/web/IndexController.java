package com.bookshop.springboot.web;

import com.bookshop.springboot.service.GoodsService;
import com.bookshop.springboot.web.dto.GoodsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final GoodsService goodsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("goodsMap", goodsService.listGoods());
        return "main";
    }

//    @GetMapping("/goods/update/{id}")
//    public String goodsUpdate(@PathVariable Long id, Model model) {
//        GoodsResponseDto dto = goodsService.findById(id);
//        model.addAttribute("good", dto);
//
//        return "goods-update";
//    }

    @GetMapping("/goods/save")
    public String goodsSave() {
        return "goods-save";
    }

}
