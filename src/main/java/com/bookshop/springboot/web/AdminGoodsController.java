package com.bookshop.springboot.web;

import com.bookshop.springboot.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class AdminGoodsController {

    private final GoodsService goodsService;

    @Value("${resources.uri_path:}")
    private String resourcesUriPath;

    @GetMapping("/admin/goods/adminGoodsMain")
    public String goodsSave() {
        return "adminGoodsMain";
    }
}
