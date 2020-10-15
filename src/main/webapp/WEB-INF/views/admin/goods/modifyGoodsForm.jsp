<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"
isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="goods"  value="${goodsMap.goods}"  />
<c:set var="imageFileList"  value="${goodsMap.imageFileList}"  />

<c:choose>
	<c:when test='${not empty goods.goodsStatus}'>
		<script>
window.onload=function()
{
	init();
}

function init(){
	var frm_mod_goods=document.frm_mod_goods;
	var h_goodsStatus=frm_mod_goods.h_goodsStatus;
	var goodsStatus=h_goodsStatus.value;
	var select_goodsStatus=frm_mod_goods.goodsStatus;
	 select_goodsStatus.value=goodsStatus;
}
</script>
	</c:when>
</c:choose>
<script type="text/javascript">
function fn_modify_goods(goodsId, attribute){
	var frm_mod_goods=document.frm_mod_goods;
	var value="";
	if(attribute=='goodsSort'){
		value=frm_mod_goods.goodsSort.value;
	}else if(attribute=='goodsTitle'){
		value=frm_mod_goods.goodsTitle.value;
	}else if(attribute=='goodsWriter'){
		value=frm_mod_goods.goodsWriter.value;   
	}else if(attribute=='goodsPublisher'){
		value=frm_mod_goods.goodsPublisher.value;
	}else if(attribute=='goodsPrice'){
		value=frm_mod_goods.goodsPrice.value;
	}else if(attribute=='goodsSalesPrice'){
		value=frm_mod_goods.goodsSalesPrice.value;
	}else if(attribute=='goodsPoint'){
		value=frm_mod_goods.goodsPoint.value;
	}else if(attribute=='goodsPublishedDate'){
		value=frm_mod_goods.goodsPublishedDate.value;
	}else if(attribute=='goods_page_total'){
		value=frm_mod_goods.goods_page_total.value;
	}else if(attribute=='goodsIsbn'){
		value=frm_mod_goods.goodsIsbn.value;
	}else if(attribute=='goodsDeliveryPrice'){
		value=frm_mod_goods.goodsDeliveryPrice.value;
	}else if(attribute=='goodsDeliveryDate'){
		value=frm_mod_goods.goodsDeliveryDate.value;
	}else if(attribute=='goodsStatus'){
		value=frm_mod_goods.goodsStatus.value;
	}else if(attribute=='goodsContentsOrder'){
		value=frm_mod_goods.goodsContentsOrder.value;
	}else if(attribute=='goodsWriterIntro'){
		value=frm_mod_goods.goodsWriterIntro.value;
	}else if(attribute=='goodsIntro'){
		value=frm_mod_goods.goodsIntro.value;
	}else if(attribute=='publisher_comment'){
		value=frm_mod_goods.publisher_comment.value;
	}else if(attribute=='recommendation'){
		value=frm_mod_goods.recommendation.value;
	}

	$.ajax({
		type : "post",
		async : false, //false인 경우 동기식으로 처리한다.
		url : "${contextPath}/admin/goods/modifyGoodsInfo.do",
		data : {
			goodsId:goodsId,
			attribute:attribute,
			value:value
		},
		success : function(data, textStatus) {
			if(data.trim()=='mod_success'){
				alert("상품 정보를 수정했습니다.");
			}else if(data.trim()=='failed'){
				alert("다시 시도해 주세요.");
			}

		},
		error : function(data, textStatus) {
			alert("에러가 발생했습니다."+data);
		},
		complete : function(data, textStatus) {
			//alert("작업을완료 했습니다");

		}
	}); //end ajax
}



  function readURL(input,preview) {
	//  alert(preview);
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#'+preview).attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
  }

  function fn_addFile(){
	  let cnt= $('input[type="file"]').length;
	  $("#d_file").append("<br>"+"<input  type='file' name='detail_image"+cnt+"' id='detail_image"+cnt+"'  onchange=readURL(this,'previewImage"+cnt+"') />");
	  $("#d_file").append("<img  id='previewImage"+cnt+"'   width=200 height=200  />");
  }

  function modifyImageFile(fileId,goodsId, imageId,fileType){
    // alert(fileId);
	  var form = $('#FILE_FORM')[0];
      var formData = new FormData(form);
      formData.append("fileName", $('#'+fileId)[0].files[0]);
      formData.append("goodsId", goodsId);
      formData.append("imageId", imageId);
      formData.append("fileType", fileType);

      $.ajax({
        url: '${contextPath}/admin/goods/modifyGoodsImageInfo.do',
        processData: false,
        contentType: false,
        data: formData,
        type: 'POST',
	      success: function(result){
	         alert("이미지를 수정했습니다!");
	       }
      });
  }

  function addNewImageFile(fileId,goodsId, fileType){
	   //  alert(fileId);
		  var form = $('#FILE_FORM')[0];
	      var formData = new FormData(form);
	      formData.append("uploadFile", $('#'+fileId)[0].files[0]);
	      formData.append("goodsId", goodsId);
	      formData.append("fileType", fileType);

	      $.ajax({
	          url: '${contextPath}/admin/goods/addNewGoodsImage.do',
	                  processData: false,
	                  contentType: false,
	                  data: formData,
	                  type: 'post',
	                  success: function(result){
	                      alert("이미지를 수정했습니다!");
	                  }
	          });
	  }

  function deleteImageFile(goodsId,imageId,imageFileName,trId){
	var tr = document.getElementById(trId);

      	$.ajax({
    		type : "post",
    		async : true, //false인 경우 동기식으로 처리한다.
    		url : "${contextPath}/admin/goods/removeGoodsImage.do",
    		data: {goodsId:goodsId,
     	         imageId:imageId,
     	         imageFileName:imageFileName},
    		success : function(data, textStatus) {
    			alert("이미지를 삭제했습니다!!");
                tr.style.display = 'none';
    		},
    		error : function(data, textStatus) {
    			alert("에러가 발생했습니다."+textStatus);
    		},
    		complete : function(data, textStatus) {
    			//alert("작업을완료 했습니다");

    		}
    	}); //end ajax
  }

  function deleteImg(obj){
  	$(obj).parents('tr').remove();
  }
</script>

</HEAD>
<BODY>
<form id="fileForm" name="frm_mod_goods"  method=post enctype="multipart/form-data" >
	<input type="hidden" id="id" value="${goods.goodsId}">
	<DIV class="clear"></DIV>
	<!-- 내용 들어 가는 곳 -->
	<DIV id="container">
		<UL class="tabs">
			<li><A href="#tab1">상품정보</A></li>
			<li><A href="#tab2">상품목차</A></li>
			<li><A href="#tab3">상품저자소개</A></li>
			<li><A href="#tab4">상품소개</A></li>
			<li><A href="#tab5">출판사 상품 평가</A></li>
			<li><A href="#tab6">추천사</A></li>
			<li><A href="#tab7">상품이미지</A></li>
		</UL>
		<DIV class="tab_container">
			<DIV class="tab_content" id="tab1">
				<table >
					<tr >
						<td >상품이름</td>
						<td><input name="goodsTitle" type="text" size="40"  value="${goods.goodsTitle }"/></td>
					</tr>

					<tr>
						<td >저자</td>
						<td><input name="goodsWriter" type="text" size="40" value="${goods.goodsWriter }" /></td>

					</tr>
					<tr>
						<td >출판사</td>
						<td><input name="goodsPublisher" type="text" size="40" value="${goods.goodsPublisher }" /></td>

					</tr>
					<tr>
						<td >상품정가</td>
						<td><input name="goodsPrice" type="text" size="40" value="${goods.goodsPrice }" /></td>

					</tr>

					<tr>
						<td >상품판매가격</td>
						<td><input name="goodsSalesPrice" type="text" size="40" value="${goods.goodsSalesPrice }" /></td>

					</tr>


					<tr>
						<td >상품출판일</td>
						<td>
							<input  name="goodsPublishedDate"  type="date"  value="${goods.goodsPublishedDate }" />
						</td>

					</tr>

					<tr>
						<td >ISBN</td>
						<td><input name="goodsIsbn" type="text" size="40" value="${goods.goodsIsbn }" /></td>

					</tr>


					<tr>
						<td >상품종류</td>
						<td>
							<select name="goodsStatus">
								<option value="bestseller"  >베스트셀러</option>
								<option value="steadyseller" >스테디셀러</option>
								<option value="newbook" >신간</option>
								<option value="on_sale" >판매중</option>
								<option value="buy_out"  selected>품절</option>
								<option value="out_of_print" >절판</option>
							</select>
							<input  type="hidden" name="h_goodsStatus" value="${goods.goodsStatus }"/>
						</td>
					</tr>
					<tr>
						<td colspan=3>
							<br>
						</td>
					</tr>
				</table>
			</DIV>
			<DIV class="tab_content" id="tab2">
				<h4>책목차</h4>

			</DIV>
			<DIV class="tab_content" id="tab3">
				<H4>상품 저자 소개</H4>
				<P>

				</P>
			</DIV>
			<DIV class="tab_content" id="tab4">
				<H4>상품소개</H4>
				<P>

				</P>
			</DIV>
			<DIV class="tab_content" id="tab5">
				<H4>출판사 상품 평가</H4>
				<P>

				</P>
			</DIV>
			<DIV class="tab_content" id="tab6">
				<H4>추천사</H4>

			</DIV>
			<DIV class="tab_content" id="tab7">
				<!--				<form id="FILE_FORM" method="post" enctype="multipart/form-data"  >-->
				<h4>상품이미지</h4>
				<table>
					<tr>
						<c:forEach var="item" items="${imageFileList }"  varStatus="itemNum">
							<c:choose>
								<c:when test="${item.fileType=='main_image' }">
					<tr>
						<td>메인 이미지</td>
						<td>
							<input type="file"  id="main_image"  name="main_image"  onchange="readURL(this,'preview${itemNum.count}');" />
							<input type="hidden"  name="imageId" value="${item.imageId}"  />
							<br>
						</td>
						<td>
							<img  id="preview${itemNum.count }"   width=200 height=200 src="${resourcesUriPath}/${goods.goodsId }/${item.fileName}" />
						</td>
						<td>
							&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<br>
						</td>
					</tr>
					</c:when>
					<c:otherwise>
						<tr  id="${itemNum.count-1}">
							<td>상세 이미지${itemNum.count-1 }</td>
							<td>
								<input type="file" name="detail_image${itemNum.count-1 }"  id="detail_image${itemNum.count-1 }"   onchange="readURL(this,'preview${itemNum.count}');" />
								<%-- <input type="text" id="imageId${itemNum.count }"  value="${item.fileName }" disabled  /> --%>
								<input type="hidden"  name="imageId" value="${item.imageId }"  />
								<br>
							</td>
							<td>
								<img  id="preview${itemNum.count }"   width=200 height=200 src="${resourcesUriPath}/${goods.goodsId }/${item.fileName}" />
							</td>
							<!--								<td>-->
							<!--									&nbsp;&nbsp;&nbsp;&nbsp;-->
							<!--								</td>-->
							<!--								<td>-->
							<!--									<input  type="button" value="삭제"  onClick="deleteImg(this);"/>-->
							<!--								</td>-->
						</tr>
						<tr>
							<td>
								<br>
							</td>
						</tr>
					</c:otherwise>
					</c:choose>
					</c:forEach>
					<tr align="center">
						<td colspan="3">
							<div id="d_file">
								<%-- <img  id="preview${itemNum.count }"   width=200 height=200 src="${contextPath}/down.do?goodsId=${item.goodsId}&fileName=${item.fileName}" /> --%>
							</div>
						</td>
					</tr>
					<tr>
						<td align=center colspan=2>

							<input   type="button" value="이미지파일추가하기"  onClick="fn_addFile()"  />
						</td>
					</tr>
				</table>
				<!--				</form>-->
			</DIV>
			<div class="clear"></div>
			<center>
				<table>
					<tr>
						<td align=center>
							<!--   <input  type="submit" value="상품 등록하기"> -->
							<!--				  <input  type="button" value="상품 등록하기"  onClick="fn_add_new_goods(this.form)">-->
							<a href="/admin/goods/main" role="button" class="btn btn-secondary">취소</a>
							<button type="button" class="btn btn-primary" id="btn-update">수정 완료</button>
							<button type="button" class="btn btn-danger" id="btn-delete">삭제</button>
						</td>
					</tr>
				</table>
			</center>

</form>