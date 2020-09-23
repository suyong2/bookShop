package com.bookshop.springboot.web.dto;

import com.bookshop.springboot.domain.goods.Goods;
import com.bookshop.springboot.domain.imagefile.ImageFile;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class GoodsListResponseDto {
    private Long goodsId;
    private String goodsTitle;
    private Integer goodsPrice;
    private List<ImageFile> imageList;

    public GoodsListResponseDto(Goods entity) {
        this.goodsId = entity.getGoodsId();
        this.goodsTitle = entity.getGoodsTitle();
        this.goodsPrice = entity.getGoodsPrice();
        this.imageList = entity.getImageList();
    }
}
