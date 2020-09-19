package com.bookshop.springboot.goods.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bookshop.springboot.goods.domain.goods.Goods;
import com.bookshop.springboot.goods.domain.goods.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class GoodsService{
	private final GoodsRepository goodsRepository;

//	public Map<String,List<GoodsVO>> listGoods() throws Exception {
//		Map<String,List<GoodsVO>> goodsMap=new HashMap<String,List<GoodsVO>>();
//		List<GoodsVO> goodsList=goodsDAO.selectGoodsList("bestseller");
//		goodsMap.put("bestseller",goodsList);
//		goodsList=goodsDAO.selectGoodsList("newbook");
//		goodsMap.put("newbook",goodsList);
//
//		goodsList=goodsDAO.selectGoodsList("steadyseller");
//		goodsMap.put("steadyseller",goodsList);
//		return goodsMap;
//	}

	@Transactional(readOnly = true)
	public Map<String,List<Goods>> listGoods() {

		Map<String,List<Goods>> goodsMap=new HashMap<String,List<Goods>>();
//		List<Goods> goodsList=goodsRepository.selectGoodsList("bestseller");
//		goodsMap.put("bestseller",goodsList);
//		goodsList=goodsRepository.selectGoodsList("newbook");
//		goodsMap.put("newbook",goodsList);
//
//		goodsList=goodsRepository.selectGoodsList("steadyseller");
//		goodsMap.put("steadyseller",goodsList);
		return goodsMap;
	}
}
