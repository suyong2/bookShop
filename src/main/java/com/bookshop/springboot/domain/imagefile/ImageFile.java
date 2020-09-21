package com.bookshop.springboot.domain.imagefile;

import com.bookshop.springboot.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
//@Table(name="T_GOODS_DETAIL_IMAGE")
public class ImageFile extends BaseTimeEntity implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_id;

//    @OneToOne
//    @JoinColumn(name="GOODS_ID", nullable = false)
//    private Goods goods;
//
//    public void setGoods(Goods goods){
//        this.goods = goods;
//        goods.getImageList().add(this);
//    }

    @Column(length = 50)
    private String fileName;
    @Column(length = 40)
    private String fileType;
    @Column(length = 20)
    private String reg_id;
}
