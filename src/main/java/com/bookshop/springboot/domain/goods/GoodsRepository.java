package com.bookshop.springboot.domain.goods;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {

//    @Query(value = "select g.* from goods g, image_file d " +
//            "        where g.goods_id=d.goods_id " +
//            "        and d.file_type='main_image' " +
//            "        and goods_status=:goodsStatus " +
//            "            order by g.created_date desc  limit 15", nativeQuery = true)
//    List<Goods> selectGoodsList(@Param("goodsStatus") String goodsStatus);

    @Query("select g from Goods g, ImageFile d " +
            "        where g.goodsId=d.goods.goodsId " +
            "        and d.fileType='main_image' " +
            "        and g.goodsStatus=:goodsStatus " +
            "            order by g.createdDate desc ")
    List<Goods> selectGoodsList(@Param("goodsStatus") String goodsStatus);

    @Query("select g from Goods g, ImageFile d " +
            "        where g.goodsId=d.goods.goodsId " +
            "        and d.fileType='main_image' " +
            "        and g.goodsId=:goodsId ")
    Goods selectGoodsDetail(@Param("goodsId") Long id);

    @Query(value = "select  * from goods " +
            "where  created_date  between :beginDate and :endDate " +
            "order by created_date desc", nativeQuery = true)
    List<Goods> selectNewGoodsList(@Param("beginDate") String beginDate,
                                   @Param("endDate") String endDate);


}
