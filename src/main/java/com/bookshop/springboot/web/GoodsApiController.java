package com.bookshop.springboot.web;

import com.bookshop.springboot.domain.goods.Goods;
import com.bookshop.springboot.service.GoodsService;
import com.bookshop.springboot.web.dto.GoodsResponseDto;
import com.bookshop.springboot.web.dto.GoodsSaveRequestDto;
import com.bookshop.springboot.web.dto.GoodsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class GoodsApiController {
//    private final GoodsService goodsService;

//    @DeleteMapping("/api/v1/goods/{id}")
//    public Long delete(@PathVariable Long id) {
//        goodsService.delete(id);
//        return id;
//    }

//    @PostMapping("/api/v1/goods")
//    public Long save(@RequestBody GoodsSaveRequestDto requestDto) {
//        return goodsService.save(requestDto);
//    }

//    @PutMapping("/api/v1/goods/{id}")
//    public Long update(@PathVariable Long id, @RequestBody GoodsUpdateRequestDto requestDto) {
//        return goodsService.update(id, requestDto);
//    }
//
//    @GetMapping("/api/v1/goods/{id}")
//    public GoodsResponseDto findById(@PathVariable Long id) {
//        return goodsService.findById(id);
//    }
}
