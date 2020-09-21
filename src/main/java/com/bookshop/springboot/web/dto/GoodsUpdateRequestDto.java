package com.bookshop.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GoodsUpdateRequestDto {
    private String goodsTitle;
    private String goodsWriter;
    private Integer goodsPrice;
    private String goodsPublisher;
    private String goodsStatus;

    @Builder
    public GoodsUpdateRequestDto(String goodsTitle, String goodsWriter, Integer goodsPrice,
                                 String goodsPublisher, String goodsStatus) {
        this.goodsTitle = goodsTitle;
        this.goodsWriter = goodsWriter;
        this.goodsPrice = goodsPrice;
        this.goodsPublisher = goodsPublisher;
        this.goodsStatus = goodsStatus;
    }
}
