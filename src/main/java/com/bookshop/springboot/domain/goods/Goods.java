package com.bookshop.springboot.domain.goods;

import com.bookshop.springboot.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Goods extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goodsId;

    @Column(length = 100)
    private String goodsTitle;

    @Column(length = 50)
    private String goodsWriter;

    @Column(precision = 10, scale = 0)
    private Integer goodsPrice;

    @Column(length = 50)
    private String goodsPublisher;

    @Column(length = 50)
    private String goodsStatus;

    @Builder
    public Goods(String goodsTitle, String goodsWriter, Integer goodsPrice,
                 String goodsPublisher, String goodsStatus) {
        this.goodsTitle = goodsTitle;
        this.goodsWriter = goodsWriter;
        this.goodsPrice = goodsPrice;
        this.goodsPublisher= goodsPublisher;
        this.goodsStatus = goodsStatus;
    }

    public void update(String goodsTitle, String goodsWriter, Integer goodsPrice,
                       String goodsPublisher, String goodsStatus) {
        this.goodsTitle = goodsTitle;
        this.goodsWriter = goodsWriter;
        this.goodsPrice = goodsPrice;
        this.goodsPublisher= goodsPublisher;
        this.goodsStatus = goodsStatus;
    }

//    @Column(length = 50)
//    private String goodsSort;
//
//    @Column(precision = 10, scale = 0)
//    private Integer    goodsSalesPrice;
//
//    @Column(precision = 10, scale = 0)
//    private Integer    goodsPoint;
//
//    private Date goodsPublishedDate;
//
//    @Column(precision = 5, scale = 0)
//    private Integer    goodsTotalPage;
//
//    @Column(length = 50)
//    private String goodsIsbn;
//
//    @Column(length = 10)
//    private String goodsDeliveryPrice;
//
//    private Date goodsDeliveryDate;
//
//    @Transient
//    private String goodsFileName;
//

//
//    @Column(length = 2000)
//    private String goodsWriterIntro;
//
//    @Column(columnDefinition = "TEXT")
//    private String goodsContentsOrder;
//
//    @Column(length = 2000)
//    private String goodsIntro;
//
//    @Column(length = 2000)
//    private String goodsPublisherComment;
//
//    @Column(length = 2000)
//    private String goodsRecommendation;

    //    @OneToMany(mappedBy = "goods", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<ImageFile> imageList = new ArrayList<ImageFile>();

}
