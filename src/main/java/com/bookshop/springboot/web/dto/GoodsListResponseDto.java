package com.bookshop.springboot.web.dto;

import com.bookshop.springboot.domain.goods.Goods;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class GoodsListResponseDto {
    private Long goodsId;
    private String goodsTitle;
    private String goodsWriter;
    private Integer goodsPrice;
    private String goodsPublisher;
    private String goodsStatus;
    private LocalDateTime modifiedDate;
    private Integer index;
    public void setIndex(Integer index){
        this.index = index;
    }
    public GoodsListResponseDto(Goods entity) {
        this.goodsId = entity.getGoodsId();
        this.goodsTitle = entity.getGoodsTitle();
        this.goodsWriter = entity.getGoodsWriter();
        this.goodsPrice = entity.getGoodsPrice();
        this.goodsPublisher= entity.getGoodsPublisher();
        this.goodsStatus = entity.getGoodsStatus();
        this.modifiedDate = entity.getModifiedDate();
    }
}
