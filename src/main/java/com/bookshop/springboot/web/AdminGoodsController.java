package com.bookshop.springboot.web;

import com.bookshop.springboot.service.AdminGoodsService;
import com.bookshop.springboot.service.GoodsService;
import com.bookshop.springboot.web.common.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class AdminGoodsController extends BaseController {

    private final AdminGoodsService goodsService;

    @Value("${resources.uri_path:}")
    private String resourcesUriPath;

    @GetMapping("/goods/adminGoodsMain")
    public String goodsSave(@RequestParam Map<String, String> dateMap, Model model) {

        String fixedSearchPeriod = dateMap.get("fixedSearchPeriod");
        String section = dateMap.get("section");
        String pageNum = dateMap.get("pageNum");
        String beginDate=null,endDate=null;

        String [] tempDate=calcSearchPeriod(fixedSearchPeriod).split(",");
        beginDate=tempDate[0];
        endDate=tempDate[1];
        dateMap.put("beginDate", beginDate);
        dateMap.put("endDate", endDate);

        Map<String,Object> condMap=new HashMap<>();
        if(section== null) {
            section = "1";
        }
        condMap.put("section",section);
        if(pageNum== null) {
            pageNum = "1";
        }
        condMap.put("pageNum",pageNum);
        condMap.put("beginDate",beginDate);
        condMap.put("endDate", endDate);

        model.addAttribute("newGoodsList", goodsService.listNewGoods(condMap));
        return "adminGoodsMain";
    }
}
