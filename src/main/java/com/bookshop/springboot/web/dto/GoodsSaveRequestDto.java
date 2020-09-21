package com.bookshop.springboot.web.dto;

import com.bookshop.springboot.domain.goods.Goods;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.Date;

@Getter
@NoArgsConstructor
public class GoodsSaveRequestDto {
    private String goodsTitle;
    private String goodsWriter;
    private Integer goodsPrice;
    private String goodsPublisher;
    private String goodsStatus;

    @Builder
    public GoodsSaveRequestDto(String goodsTitle, String goodsWriter, Integer goodsPrice,
                               String goodsPublisher, String goodsStatus) {
        this.goodsTitle = goodsTitle;
        this.goodsWriter = goodsWriter;
        this.goodsPrice = goodsPrice;
        this.goodsPublisher = goodsPublisher;
        this.goodsStatus = goodsStatus;
    }

    public Goods toEntity() {
        return Goods.builder()
                .goodsTitle(goodsTitle)
                .goodsWriter(goodsWriter)
                .goodsPrice(goodsPrice)
                .goodsPublisher(goodsPublisher)
                .goodsStatus(goodsStatus)
                .build();
    }
}
