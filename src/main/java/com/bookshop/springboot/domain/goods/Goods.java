package com.bookshop.springboot.domain.goods;

import com.bookshop.springboot.domain.BaseTimeEntity;
import com.bookshop.springboot.domain.imagefile.ImageFile;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Column(length = 50)
    private String goodsIsbn;

//    @Column(precision = 10, scale = 0)
//    private Integer    goodsPoint;
//
//    @Temporal(TemporalType.DATE)
//    private Date goodsPublishedDate;
//
//    @Column(precision = 5, scale = 0)
//    private Integer    goodsTotalPage;
//
//    @Column(precision = 10, scale = 0)
//    private Integer    goodsSalesPrice;
//
//    @Column(length = 2000)
//    private String goodsIntro;
//
//    @Column(length = 2000)
//    private String goodsWriterIntro;
//
//    @Column(columnDefinition = "TEXT")
//    private String goodsContentsOrder;
//
//    @Column(length = 2000)
//    private String goodsPublisherComment;
//
//    @Column(length = 2000)
//    private String goodsRecommendation;
//    @Transient
//    private String fileName;


    @OneToMany(mappedBy = "goods", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ImageFile> imageList = new ArrayList<ImageFile>();

    @Builder
    public Goods(String goodsTitle, String goodsWriter, Integer goodsPrice,
                 String goodsPublisher, String goodsStatus, String goodsIsbn
//                 ,Integer goodsPoint, Date goodsPublishedDate, Integer goodsTotalPage,
//                 Integer goodsSalesPrice, String goodsIntro, String goodsWriterIntro,
//                 String goodsContentsOrder, String goodsPublisherComment, String goodsRecommendation
    ) {
        this.goodsTitle = goodsTitle;
        this.goodsWriter = goodsWriter;
        this.goodsPrice = goodsPrice;
        this.goodsPublisher= goodsPublisher;
        this.goodsStatus = goodsStatus;
        this.goodsIsbn = goodsIsbn;
//        this.fileName=fileName;
//        this.goodsPoint = goodsPoint;
//        this.goodsPublishedDate = goodsPublishedDate;
//        this.goodsTotalPage= goodsTotalPage;
//        this.goodsSalesPrice=goodsSalesPrice;
//        this.goodsIntro=goodsIntro;
//        this.goodsWriterIntro=goodsWriterIntro;
//        this.goodsContentsOrder=goodsContentsOrder;
//        this.goodsPublisherComment=goodsPublisherComment;
//        this.goodsRecommendation=goodsRecommendation;
    }

    public void update(String goodsTitle, String goodsWriter, Integer goodsPrice,
                       String goodsPublisher, String goodsStatus, String goodsIsbn
//            ,Integer goodsPoint, Date goodsPublishedDate, Integer goodsTotalPage,
//                       Integer goodsSalesPrice, String goodsIntro, String goodsWriterIntro,
//                       String goodsContentsOrder, String goodsPublisherComment, String goodsRecommendation
////            ,String goodsFileName
    ) {
        this.goodsTitle = goodsTitle;
        this.goodsWriter = goodsWriter;
        this.goodsPrice = goodsPrice;
        this.goodsPublisher= goodsPublisher;
        this.goodsStatus = goodsStatus;
        this.goodsIsbn = goodsIsbn;
//        this.goodsPoint = goodsPoint;
//        this.goodsPublishedDate = goodsPublishedDate;
//        this.goodsTotalPage= goodsTotalPage;
//        this.goodsSalesPrice=goodsSalesPrice;
//        this.goodsIntro=goodsIntro;
//        this.goodsWriterIntro=goodsWriterIntro;
//        this.goodsContentsOrder=goodsContentsOrder;
//        this.goodsPublisherComment=goodsPublisherComment;
//        this.goodsRecommendation=goodsRecommendation;
//        this.fileName=fileName;
    }

//    @Column(length = 50)
//    private String goodsSort;

//    @Column(length = 10)
//    private String goodsDeliveryPrice;
//
//    private Date goodsDeliveryDate;

}
