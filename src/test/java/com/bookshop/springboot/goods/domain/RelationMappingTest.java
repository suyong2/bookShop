package com.bookshop.springboot.goods.domain;

import com.bookshop.springboot.goods.domain.goods.Goods;
import com.bookshop.springboot.goods.domain.goods.GoodsRepository;
import com.bookshop.springboot.goods.domain.imagefile.ImageFile;
import com.bookshop.springboot.goods.domain.imagefile.ImageFileRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationMappingTest {
    private Logger logger = LoggerFactory.getLogger(RelationMappingTest.class);

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

        Goods goods = new Goods(); // 상품생성
        goods.setGoods_title(goodsTitle);

        for (int i=0; i<3; i++){ // 그 상품에 들어가는 이미지 생성.
            ImageFile img = new ImageFile();
            img.setGoods(goods);
            img.setFileName(fileName+i);
        }
        goodsRepo.save(goods); // 상품저장시 이미지도 같이 저장.

        //when
        List<Goods> goodsList = goodsRepo.findAll();
        for (Goods good: goodsList){
            logger.debug("------------"+good.toString());
        }

        List<ImageFile> imageList = imageFileRepo.findAll();
        for (ImageFile image: imageList){
            logger.debug("------------"+image.toString());
        }
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
