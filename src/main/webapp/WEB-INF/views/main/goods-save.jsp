<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"	isELIgnored="false"
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>  

<div id="ad_main_banner">
	<ul class="bjqs">	 	
	  <li><img width="775" height="145" src="${contextPath}/resources/image/main_banner01.jpg"></li>
		<li><img width="775" height="145" src="${contextPath}/resources/image/main_banner02.jpg"></li>
		<li><img width="775" height="145" src="${contextPath}/resources/image/main_banner03.jpg"></li> 
	</ul>
</div>
<h1>상품 등록</h1>

<div class="col-md-12">
    <div class="col-md-4">
        <form>
            <div class="form-group">
                <label for="title">제품이름</label>
                <input class="form-control" id="goods_title" name="goods_title" type="text" size="40" />
            </div>
            <div class="form-group">
                <label for="author"> 저자 </label>
                <input class="form-control" id="goods_writer" name="goods_writer" type="text" size="40" />
            </div>
            <div class="form-group">
                <label for="content"> 출판사 </label>
                <input class="form-control" id= "goods_publisher" name="goods_publisher" type="text" size="40" />
            </div>
            <div class="form-group">
                <label for="content"> 제품정가 </label>
                <input class="form-control" id= "goods_price" name="goods_price" type="text" size="40" />
            </div>
            <div class="form-group">
                <label for="content"> 제품종류 </label>
                <select class="form-control" id= "goods_status" name="goods_status">
                    <option value="bestseller"  >베스트셀러</option>
                    <option value="steadyseller" >스테디셀러</option>
                    <option value="newbook" selected >신간</option>
                    <option value="on_sale" >판매중</option>
                    <option value="buy_out" >품절</option>
                    <option value="out_of_print" >절판</option>
                </select>
            </div>
        </form>
        <a href="/" role="button" class="btn btn-secondary">취소</a>
        <button type="button" class="btn btn-primary" id="btn-save">등록</button>
    </div>
</div>
<script src="${contextPath}/resources/js/app/index.js"></script>
   
   