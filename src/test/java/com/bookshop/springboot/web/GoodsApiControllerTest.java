package com.bookshop.springboot.web;

import com.bookshop.springboot.domain.goods.Goods;
import com.bookshop.springboot.domain.goods.GoodsRepository;
import com.bookshop.springboot.web.dto.GoodsSaveRequestDto;
import com.bookshop.springboot.web.dto.GoodsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoodsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private GoodsRepository goodsRepository;

    @After
    public void tearDown() throws Exception {
        goodsRepository.deleteAll();
    }

    @Test
    public void Goods_등록된다() throws Exception {
        //given
        String goodsTitle = "Hello";
        String goodsWriter = "world";
        GoodsSaveRequestDto requestDto = GoodsSaveRequestDto.builder()
                .goodsTitle(goodsTitle)
                .goodsWriter(goodsWriter)
                .build();

        String url = "http://localhost:" + port + "/api/v1/goods";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Goods> all = goodsRepository.findAll();
        assertThat(all.get(0).getGoodsTitle()).isEqualTo(goodsTitle);
        assertThat(all.get(0).getGoodsWriter()).isEqualTo(goodsWriter);
    }

    @Test
    public void Goods_수정된다() throws Exception {
        //given
        Goods goods = new Goods();
        goods.update("Hello", "world", null,null, null);
        Goods savedGoods = goodsRepository.save(goods);

        Long updateId = savedGoods.getId();
        String expectedTitle = "Hello2";
        String expectedWriter = "world2";

        GoodsUpdateRequestDto requestDto = GoodsUpdateRequestDto.builder()
                .goodsTitle(expectedTitle)
                .goodsWriter(expectedWriter)
                .build();

        String url = "http://localhost:" + port + "/api/v1/goods/" + updateId;

        HttpEntity<GoodsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url,
                HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Goods> all = goodsRepository.findAll();
        assertThat(all.get(0).getGoodsTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getGoodsWriter()).isEqualTo(expectedWriter);
    }

}
