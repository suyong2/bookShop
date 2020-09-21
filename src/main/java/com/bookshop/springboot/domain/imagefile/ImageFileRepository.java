package com.bookshop.springboot.domain.imagefile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {
//    @Query("SELECT i FROM ImageFile i WHERE i.fileType='main_image' " +
//            "and i.goods.goods_status = :searchKeyword ")
//    List<ImageFile> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
}
