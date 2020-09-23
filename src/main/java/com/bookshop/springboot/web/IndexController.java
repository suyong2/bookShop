package com.bookshop.springboot.web;

import com.bookshop.springboot.service.GoodsService;
import com.bookshop.springboot.web.dto.GoodsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@RequiredArgsConstructor
@Controller
public class IndexController {

//    private final GoodsService goodsService;
//
//    @Value("${resources.uri_path:}")
//    private String resourcesUriPath;

//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("goodsMap", goodsService.listGoods());
//        model.addAttribute("resourcesUriPath", resourcesUriPath);
//        return "main";
//    }
//
//    @GetMapping("/goods/detail/{id}")
//    public String goodsDetail(@PathVariable Long id, Model model) {
//        Map goodsMap= goodsService.goodsDetail(id);
//        model.addAttribute("goodsMap", goodsMap);
//
//        return "goodsDetail";
//    }

//    @GetMapping("/goods/save")
//    public String goodsSave() {
//        return "goods-save";
//    }

}
