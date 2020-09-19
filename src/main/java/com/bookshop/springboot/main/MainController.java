package com.bookshop.springboot.main;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshop.springboot.common.base.BaseController;
import com.bookshop.springboot.goods.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@EnableAspectJAutoProxy
public class MainController extends BaseController {

    private final GoodsService goodsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("goodsMap", goodsService.listGoods());
        return "index";
    }
}