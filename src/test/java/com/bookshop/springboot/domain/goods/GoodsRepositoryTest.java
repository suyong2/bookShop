package com.bookshop.springboot.domain.goods;

import com.bookshop.springboot.domain.goods.Goods;
import com.bookshop.springboot.domain.goods.GoodsRepository;
import com.bookshop.springboot.domain.imagefile.ImageFile;
import com.bookshop.springboot.domain.imagefile.ImageFileRepository;
import com.bookshop.springboot.web.dto.GoodsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsRepositoryTest {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private ImageFileRepository imagesRepository;

    @After
    public void cleanup() {
        imagesRepository.deleteAll();
        goodsRepository.deleteAll();
    }

    @Test
    public void 상품등록_불러오기() {
        //given
        String goodsTitle = "Hello";
        String goodsWriter = "world";
        String fileName = "testFile";

        Goods goods = new Goods();
        goods.update(goodsTitle, goodsWriter, null,null, null);
        goodsRepository.save(goods);

        for (int i=0; i<3; i++){
            ImageFile img = new ImageFile();
            img.update(fileName, null, null, goods);
            imagesRepository.save(img);
        }

//        //when
//        List<Goods> goodsList = goodsRepository.findAll();
//        List<ImageFile> imageList = imagesRepository.findAll();
//
//        //then
//        goods = goodsList.get(0);
//        assertThat(goods.getGoodsTitle()).isEqualTo(goodsTitle);
//        assertThat(goods.getGoodsWriter()).isEqualTo(goodsWriter);
//
//        for (int i=0;i<imageList.size();i++){
//            ImageFile image = imageList.get(i);
//            assertThat(image.getFileName()).isEqualTo(fileName+i);
//            assertThat(image.getGoods()).isEqualTo(goods);
//        }

    }

//    @Test
//    @Transactional
//    public void 상품등록_수정하기() {
//        //given
//        Goods savedGoods= goodsRepository.save(Goods.builder()
//                .goodsTitle("Hello")
//                .goodsWriter("world")
//                .build());
//
//        Long id = savedGoods.getGoodsId();
//        String expectedTitle = "Hello2";
//        String expectedWriter = "world2";
//
//        Goods goods = goodsRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id=" + id));
//
//        goods.update(expectedTitle, expectedWriter, null, null, null);
//
//        List<Goods> all = goodsRepository.findAll();
//        assertThat(all.get(0).getGoodsTitle()).isEqualTo(expectedTitle);
//        assertThat(all.get(0).getGoodsWriter()).isEqualTo(expectedWriter);
//    }
//
//    @Test
//    public void BaseTimeEntity_등록() {
//        //given
//        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
//        String goodsTitle = "Hello";
//
//        goodsRepository.save(Goods.builder()
//                .goodsTitle("Hello")
//                .goodsWriter("world")
//                .build());
//
//        //when
//        List<Goods> goodsList = goodsRepository.findAll();
//
//        //then
//        Goods goods = goodsList.get(0);
//
//        System.out.println(">>>>>>>>> createDate=" + goods.getCreatedDate() + ", modifiedDate=" + goods.getModifiedDate());
//
//        assertThat(goods.getCreatedDate()).isAfter(now);
//        assertThat(goods.getModifiedDate()).isAfter(now);
//    }
}
