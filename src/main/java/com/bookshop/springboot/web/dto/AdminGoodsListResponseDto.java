package com.bookshop.springboot.web.dto;

import com.bookshop.springboot.domain.goods.Goods;
import com.bookshop.springboot.domain.imagefile.ImageFile;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
public class AdminGoodsListResponseDto {
    private Long goodsId;
    private String goodsTitle;
    private Integer goodsPrice;
    private Date goodsPublishedDate;
    private Integer    goodsSalesPrice;
    private List<ImageFile> imageList;

    public AdminGoodsListResponseDto(Goods entity) {
        this.goodsId = entity.getGoodsId();
        this.goodsTitle = entity.getGoodsTitle();
        this.goodsPrice = entity.getGoodsPrice();
        this.goodsPublishedDate = entity.getGoodsPublishedDate();
        this.goodsSalesPrice = entity.getGoodsSalesPrice();
        this.imageList = entity.getImageList();
    }
}
