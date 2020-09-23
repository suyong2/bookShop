package com.bookshop.springboot.domain.goods;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {

    @Query(value = "select t.* " +
            "          from ( " +
            "select g.*, d.file_name from goods g, image_file d " +
            "        where g.goods_id=d.goods_id " +
            "        and d.file_type='main_image' " +
            "        and goods_status=:goodsStatus " +
            "            order by g.created_date desc)  t limit 15", nativeQuery = true)
    List<Goods> selectGoodsList(@Param("goodsStatus") String goodsStatus);

    @Query(value = "select g.*, d.file_name from goods g, image_file d " +
            "        where g.goods_id=d.goods_id " +
            "        and d.file_type='main_image' " +
            "        and g.goods_id=:goodsId ", nativeQuery = true)
    Goods selectGoodsDetail(@Param("goodsId") Long id);



}
