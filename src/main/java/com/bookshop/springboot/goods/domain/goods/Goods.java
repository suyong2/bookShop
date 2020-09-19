package com.bookshop.springboot.goods.domain.goods;

import com.bookshop.springboot.goods.domain.imagefile.ImageFile;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "imageList")
@Entity
//@Table(name="T_SHOPPING_GOODS")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goods_id;

    @Column(length = 100)
    private String goods_title;

    @Column(length = 50)
    private String goods_writer;

    @Column(precision = 10, scale = 0)
    private Integer    goods_price;

    @Column(length = 50)
    private String goods_publisher;

    @Column(length = 50)
    private String goods_sort;

    @Column(precision = 10, scale = 0)
    private Integer    goods_sales_price;

    @Column(precision = 10, scale = 0)
    private Integer    goods_point;

    private Date goods_published_date;

    @Column(precision = 5, scale = 0)
    private Integer    goods_total_page;

    @Column(length = 50)
    private String goods_isbn;

    @Column(length = 10)
    private String goods_delivery_price;

    private Date goods_delivery_date;

    @Transient
    private String goods_fileName;

    @Column(length = 50)
    private String goods_status;

    @Column(length = 2000)
    private String goods_writer_intro;

    @Column(columnDefinition = "TEXT")
    private String goods_contents_order;

    @Column(length = 2000)
    private String goods_intro;

    @Column(length = 2000)
    private String goods_publisher_comment;

    @Column(length = 2000)
    private String goods_recommendation;

    @OneToMany(mappedBy = "goods", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ImageFile> imageList = new ArrayList<ImageFile>();
}
