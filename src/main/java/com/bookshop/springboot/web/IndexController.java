package com.bookshop.springboot.web;

import com.bookshop.springboot.service.GoodsService;
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
        model.addAttribute("goods", goodsService.listGoods());
        return "index";
    }

    @GetMapping("/goods/save")
    public String goodsSave() {
        return "goods-save";
    }

//    @GetMapping("/goods/update/{id}")
//    public String goodsUpdate(@PathVariable Long id, Model model) {
//        PostsResponseDto dto = postsService.findById(id);
//        model.addAttribute("post", dto);
//
//        return "posts-update";
//    }
}
