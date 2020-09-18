package com.bookshop.springboot.goods.domain.imagefile;

import com.bookshop.springboot.goods.domain.goods.Goods;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
//@Table(name="T_GOODS_DETAIL_IMAGE")
public class ImageFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_id;

    @ManyToOne
    @JoinColumn(name="GOODS_ID", nullable = false)
    private Goods goods;

    public void setGoods(Goods goods){
        this.goods = goods;
        goods.getImageList().add(this);
    }

    @Column(length = 50)
    private String fileName;
    @Column(length = 40)
    private String fileType;
    @Column(length = 20)
    private String reg_id;
}
