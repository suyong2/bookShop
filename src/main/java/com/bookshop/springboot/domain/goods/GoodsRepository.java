package com.bookshop.springboot.domain.goods;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    @Query("SELECT g FROM Goods g where g.goodsStatus = :goodsStatus ORDER BY g.createdDate DESC")
    List<Goods> selectGoodsList(@Param("goodsStatus") String goodsStatus, Pageable paging);
}
