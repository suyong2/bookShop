package com.bookshop.springboot.web;

import com.bookshop.springboot.domain.goods.Goods;
import com.bookshop.springboot.service.AdminGoodsService;
import com.bookshop.springboot.service.GoodsService;
import com.bookshop.springboot.web.common.base.BaseController;
import com.bookshop.springboot.web.dto.GoodsResponseDto;
import com.bookshop.springboot.web.dto.GoodsSaveRequestDto;
import com.bookshop.springboot.web.dto.GoodsUpdateRequestDto;
import com.bookshop.springboot.web.dto.ImagesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class GoodsApiController extends BaseController {
    private final GoodsService goodsService;
    private final AdminGoodsService adminGoodsService;
    private final String div = System.getProperty("file.separator");

    @DeleteMapping("/api/v1/goods/{id}")
    public Long delete(@PathVariable Long id) {
        adminGoodsService.delete(id);
        return id;
    }

    @PostMapping("/api/v1/goods")
    public Long save(MultipartHttpServletRequest request, GoodsSaveRequestDto requestDto) throws Exception{

        System.out.println("save시 : "+requestDto);
        request.setCharacterEncoding("utf-8");
        List<ImagesSaveRequestDto> imageFileList =upload(request);
        System.out.println("save시 : "+imageFileList);
        if(imageFileList!= null && imageFileList.size()!=0) {
//            for(ImagesSaveRequestDto imageFileVO : imageFileList) {
//                imageFileVO.setRegId(reg_id);
//            }
            requestDto.setImageList(imageFileList);

        }
        String imageFileName=null;
        Long goodsId = adminGoodsService.save(requestDto);
        try {
            if(imageFileList!=null && imageFileList.size()!=0) {
                for(ImagesSaveRequestDto imageFileVO:imageFileList) {
                    imageFileName = imageFileVO.getFileName();
                    File srcFile =
                            new File(CURR_IMAGE_REPO_PATH+div+"temp"+div+imageFileName);
                    File destDir =
                            new File(CURR_IMAGE_REPO_PATH+div+goodsId);
                    FileUtils.moveFileToDirectory(srcFile, destDir,true);
                }
            }
        }catch(Exception e) {
            if(imageFileList!=null && imageFileList.size()!=0) {
                for(ImagesSaveRequestDto imageFileVO:imageFileList) {
                    imageFileName = imageFileVO.getFileName();
                    File srcFile =
                            new File(CURR_IMAGE_REPO_PATH+div+"temp"+div+imageFileName);
                    srcFile.delete();
                }
            }
            e.printStackTrace();
        }
        return goodsId;
    }

    @PutMapping("/api/v1/goods/{id}")
    public Long update(@PathVariable Long id, MultipartHttpServletRequest request,
                       GoodsUpdateRequestDto requestDto) throws Exception {
        System.out.println("update시 : "+requestDto);
        request.setCharacterEncoding("utf-8");

        List<ImagesSaveRequestDto> imageFileList =upload(request);
        System.out.println("update시 : "+imageFileList);
        if(imageFileList!= null && imageFileList.size()!=0) {
//            for(ImagesSaveRequestDto imageFileVO : imageFileList) {
//                imageFileVO.setRegId(reg_id);
//            }
            requestDto.setImageList(imageFileList);
        }
        String imageFileName=null;
        try {
            if(imageFileList!=null && imageFileList.size()!=0) {
                for(ImagesSaveRequestDto imageFileVO : imageFileList) {
                    imageFileName = imageFileVO.getFileName();
                    if (imageFileName!= null && !imageFileName.equals("")){
                        File srcFile =
                                new File(CURR_IMAGE_REPO_PATH+div+"temp"+div+imageFileName);
                        File destDir =
                                new File(CURR_IMAGE_REPO_PATH+div+id);
                        FileUtils.moveFileToDirectory(srcFile, destDir,true);
                    }
                }
            }
        }catch(Exception e) {
            if(imageFileList!=null && imageFileList.size()!=0) {
                for(ImagesSaveRequestDto imageFileVO:imageFileList) {
                    imageFileName = imageFileVO.getFileName();
                    File srcFile =
                            new File(CURR_IMAGE_REPO_PATH+div+"temp"+div+imageFileName);
                    srcFile.delete();
                }
            }
            e.printStackTrace();
        }
        return adminGoodsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/goods/{id}")
    public GoodsResponseDto findById(@PathVariable Long id) {
        return goodsService.findById(id);
    }
}
