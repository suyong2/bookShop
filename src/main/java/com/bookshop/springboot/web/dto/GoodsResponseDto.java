package com.bookshop.springboot.web.dto;

import com.bookshop.springboot.domain.goods.Goods;

import javax.persistence.Column;

public class GoodsResponseDto {
    private Long goodsId;
    private String goodsTitle;
    private String goodsWriter;
    private Integer goodsPrice;
    private String goodsPublisher;
    private String goodsStatus;
    private String goodsIsbn;

    public GoodsResponseDto(Goods entity){
        this.goodsId = entity.getGoodsId();
        this.goodsTitle = entity.getGoodsTitle();
        this.goodsWriter = entity.getGoodsWriter();
        this.goodsPrice = entity.getGoodsPrice();
        this.goodsPublisher= entity.getGoodsPublisher();
        this.goodsStatus = entity.getGoodsStatus();
        this.goodsIsbn = entity.getGoodsIsbn();
    }
}
