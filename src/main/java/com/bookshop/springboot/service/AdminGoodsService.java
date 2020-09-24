package com.bookshop.springboot.service;

import com.bookshop.springboot.domain.goods.GoodsRepository;
import com.bookshop.springboot.domain.imagefile.ImageFileRepository;
import com.bookshop.springboot.web.dto.AdminGoodsListResponseDto;
import com.bookshop.springboot.web.dto.GoodsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminGoodsService {
    private final GoodsRepository goodsRepository;
    private final ImageFileRepository imagesRepository;

    @Transactional(readOnly = true)
    public List<AdminGoodsListResponseDto> listNewGoods(Map condMap){
        String beginDate=(String)condMap.get("beginDate");
        String endDate=(String)condMap.get("endDate");
        System.out.println(beginDate+", "+endDate);
        return goodsRepository.selectNewGoodsList(beginDate, endDate).stream()
                .map(AdminGoodsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
