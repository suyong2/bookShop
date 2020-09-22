package com.bookshop.springboot.service;

import com.bookshop.springboot.domain.goods.Goods;
import com.bookshop.springboot.domain.goods.GoodsRepository;
import com.bookshop.springboot.web.dto.GoodsListResponseDto;
import com.bookshop.springboot.web.dto.GoodsResponseDto;
import com.bookshop.springboot.web.dto.GoodsSaveRequestDto;
import com.bookshop.springboot.web.dto.GoodsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GoodsService {
    private final GoodsRepository goodsRepository;

//    @Transactional
//    public Long save(GoodsSaveRequestDto requestDto) {
//        return goodsRepository.save(requestDto.toEntity()).getGoodsId();
//    }

//    @Transactional
//    public void delete (Long id) {
//        Goods goods = goodsRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id=" + id));
//
//        goodsRepository.delete(goods);
//    }
//
//    @Transactional
//    public Long update(Long id, GoodsUpdateRequestDto requestDto) {
//        Goods goods = goodsRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id=" + id));
//        goods.update(requestDto.getGoodsTitle(), requestDto.getGoodsWriter(),
//                requestDto.getGoodsPrice(), requestDto.getGoodsPublisher(), requestDto.getGoodsStatus());
//
//        return id;
//    }
//
//    public GoodsResponseDto findById(Long id) {
//        Goods entity = goodsRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id=" + id));
//        return new GoodsResponseDto(entity);
//    }

    @Transactional(readOnly = true)
    public Map<String,List<GoodsListResponseDto>> listGoods() {

        Map<String,List<GoodsListResponseDto>> goodsMap= new HashMap<>();
        Pageable paging = PageRequest.of(0, 15);
        String[] kinds = {"bestseller", "newbook", "steadyseller"};
        List<GoodsListResponseDto> goodsList=null;

        for (int i=0; i<kinds.length; i++){
            goodsList=goodsRepository.selectGoodsList(kinds[i], paging).stream()
                    .map(GoodsListResponseDto::new)
                    .collect(Collectors.toList());
            for (int j=0; j<goodsList.size(); j++){
                GoodsListResponseDto dto = goodsList.get(j);
                dto.setIndex(j+1);
            }
            goodsMap.put(kinds[i], goodsList);
        }

        return goodsMap;
    }

}
