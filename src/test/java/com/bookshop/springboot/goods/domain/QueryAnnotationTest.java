package com.bookshop.springboot.goods.domain;

import java.util.Arrays;
import java.util.List;

import com.bookshop.springboot.goods.domain.goods.Goods;
import com.bookshop.springboot.goods.domain.goods.GoodsRepository;
import com.bookshop.springboot.goods.domain.imagefile.ImageFile;
import com.bookshop.springboot.goods.domain.imagefile.ImageFileRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryAnnotationTest {
	@Autowired
	private ImageFileRepository imageRepo;
	@Autowired
	private GoodsRepository goodsRepo;

	@After
	public void cleanup() {
		imageRepo.deleteAll();
	}
//
	@Test
	public void testQueryAnnotationTest1() {
		String goodsStatus = "Hello";
		Goods goods = new Goods(); // 상품생성
		goods.setGoods_status(goodsStatus);
		ImageFile img = new ImageFile();
		img.setGoods(goods);
		img.setFileType("main_image");
		goodsRepo.save(goods);

		List<ImageFile> imageList = imageRepo.queryAnnotationTest1(goodsStatus);

	    System.out.println("검색 결과");
	    for (ImageFile image : imageList) {
			System.out.println("---> " + image.toString());
	    }
	}
}
