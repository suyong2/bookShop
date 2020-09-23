package com.bookshop.springboot.domain.imagefile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {

    @Query(value = "select * from image_file " +
            "        where file_type!='main_image' " +
            "        and goods_id=:goodsId ", nativeQuery = true)
    List<ImageFile> selectGoodsDetailImage(@Param("goodsId") Long id);
}
