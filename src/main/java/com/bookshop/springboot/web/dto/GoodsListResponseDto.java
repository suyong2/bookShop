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
    private String goodsWriter;
    private Integer goodsPrice;
    private String goodsPublisher;
    private String goodsStatus;
    private String goodsIsbn;
    private LocalDateTime modifiedDate;
    private List<ImageFile> imageList;

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
        this.goodsIsbn = entity.getGoodsIsbn();
        this.modifiedDate = entity.getModifiedDate();
        this.imageList = entity.getImageList();
    }
}
