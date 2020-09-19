package com.bookshop.springboot.goods.domain.goods;

import com.bookshop.springboot.goods.domain.imagefile.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
//    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
//    List<Goods> selectGoodsList(String goodsStatus);




//    @Query(value = "select t.* " +
//            "          from(" +
//            "select g.* , i.fileName from goods g, imagefile i" +
//            "        where g.goods_id=i.goods_id " +
//            "        and i.filetype='main_image'" +
//            "        and g.goods_status=:searchKeyword) ", nativeQuery = true)
//    List<Goods> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
}
