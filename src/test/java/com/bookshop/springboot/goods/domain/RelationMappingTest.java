package com.bookshop.springboot.goods.domain;

import com.bookshop.springboot.goods.domain.goods.Goods;
import com.bookshop.springboot.goods.domain.goods.GoodsRepository;
import com.bookshop.springboot.goods.domain.imagefile.ImageFile;
import com.bookshop.springboot.goods.domain.imagefile.ImageFileRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationMappingTest {
    @Autowired
    private GoodsRepository goodsRepo;

    @Autowired
    private ImageFileRepository imageFileRepo;

    @After
    public void cleanup() {
        goodsRepo.deleteAll();
    }

    @Test
    public void testTwoWayMapping() {
        //given
        String fileName = "Hello world";
        String goodsTitle = "Hello";

        Goods goods = new Goods();
        goods.setGoods_title(goodsTitle);

        for (int i=0; i<3; i++){
            ImageFile img = new ImageFile();
            img.setGoods(goods);
            img.setFileName(fileName+i);
        }
        goodsRepo.save(goods);

        //when
        List<Goods> goodsList = goodsRepo.findAll();
        List<ImageFile> imageList = imageFileRepo.findAll();

        //then
        Goods good= goodsList.get(0);
        assertThat(good.getGoods_title()).isEqualTo(goodsTitle);
        List<ImageFile> list = good.getImageList();
        assertThat(list.size()).isEqualTo(3);

        for(int i=0; i<list.size();i++){
            ImageFile image = imageList.get(i);
            assertThat(image.getFileName()).isEqualTo(fileName+i);
        }

        for (int i=0; i<imageList.size(); i++){
            ImageFile image = imageList.get(i);
            assertThat(image.getGoods().getGoods_id()).isEqualTo(goods.getGoods_id());
            assertThat(image.getFileName()).isEqualTo(fileName+i);
        }
    }


}
