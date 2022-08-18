package com.seven.forum.controller.lhj;

import com.github.pagehelper.PageInfo;
import com.seven.forum.entity.lhj.UserCommentEntity;
import com.seven.forum.entity.lhj.UserDynamicEntity;
import com.seven.forum.service.lhj.UserDynamicService;
import com.seven.forum.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.IntConsumer;

@Controller
@RequestMapping("/dynamic")
@CrossOrigin(value = {"http://127.0.0.1:8848"},
        methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST},
        allowCredentials = "false")
public class UserDynamicController {

    private static final String FILE_DIRECTORY = "D:\\A-learn\\A-TeamProject\\seven-forum\\seven-forum-controller\\src\\main\\resources\\static\\image";

    @Autowired
    private UserDynamicService dynamicService;

    //��ʾ��and��ע���˷��Ķ�̬
    @RequestMapping("/followUserDynamic")
    @ResponseBody
    public ResponseVO listDynamic(@RequestParam(defaultValue = "1") Integer pageNum,Integer pageSize,Integer userId){
        List<UserDynamicEntity> userDynamicEntities = dynamicService.listFollowUserDynamic(pageNum, pageSize, userId);
        PageInfo<UserDynamicEntity> pageInfo = new PageInfo<>(userDynamicEntities,3);
        return  new ResponseVO(200,"ok",pageInfo);
    }
    @RequestMapping("/listHotDynamic")
    @ResponseBody
    public ResponseVO listHotDynamic(){
        List<UserDynamicEntity> hotDynamic = dynamicService.listHotDynamic();
        return new ResponseVO(200,"ok",hotDynamic);
    }

    @RequestMapping("/listComment")
    @ResponseBody
    //��ʾ�ö�̬�µ���������
    public ResponseVO listComment(Integer pageNum,@RequestParam(defaultValue = "4") Integer pageSize,Integer dynamicId){
        List<UserCommentEntity> userCommentEntities = dynamicService.listCommentByDynamicId(pageNum,pageSize,dynamicId);
        PageInfo<UserCommentEntity> pageInfo = new PageInfo<>(userCommentEntities,3);
        return new ResponseVO(200,"ok",pageInfo);
    }

    @RequestMapping("/commentDynamic")
    @ResponseBody
    //���۶�̬
    public String commentDynamic(Integer userId, Integer dynamicId, String commentContent,@RequestParam(defaultValue = "1") Integer commentStatus){
        dynamicService.commentDynamicWithAddCommentCount(userId,dynamicId,commentContent,commentStatus);
        return "comment done";
    }

    @RequestMapping("/replyComment")
    @ResponseBody
    //�ظ�����
    public String replyComment(Integer userId,Integer dynamicId,String commentContent,Integer replyUserId,@RequestParam(defaultValue = "1")Integer commentStatus){
       dynamicService.replyUserWithAddCommentCount(userId,dynamicId,commentContent,replyUserId,commentStatus);
        return "reply done";
    }

    @PostMapping("/releaseDynamic")
    @ResponseBody
    @CrossOrigin
    //������̬
    public String releaseDynamic(@RequestParam(value = "userId") Integer userId, String dynamicContent, MultipartFile[] myFiles){
        String filename;
        String newFilename;
        String ext;
        if (myFiles!=null){
            for (MultipartFile myFile : myFiles) {
                filename =  myFile.getOriginalFilename();
                newFilename = UUID.randomUUID().toString();
                ext = filename.substring(filename.lastIndexOf("."));
                dynamicContent+="<img src='"+FILE_DIRECTORY+newFilename+ext+"'/>";
                Path path = FileSystems.getDefault().getPath(FILE_DIRECTORY,newFilename + ext);
                try {
                    myFile.transferTo(path);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        dynamicService.releaseDynamic(userId,dynamicContent);
        return "release done";
    }

    @RequestMapping("/likeDynamic")
    @ResponseBody
    //��̬����
    public String likeDynamic(Integer likeObjId, Integer userId, @RequestParam(defaultValue = "1") Integer likeStatus, Integer dynamicId){
        Integer status = dynamicService.checkDynamicLike(likeObjId, userId);
        if (status==null){
            dynamicService.likeDynamicAndAddLikeCount(likeObjId,userId,likeStatus,dynamicId);
            return "insert done";
        }else {
            //ȡ������
            if (status==1){
                dynamicService.cancelDynamicLikeAndReduceLikeCount(likeObjId,userId,dynamicId);
                return "cancel";
            }
            //ȡ�����޺��ֵ���
            if (status==0){
                dynamicService.dynamicLikeAgainAfterCancelLikeAndAddLikeCount(likeObjId,userId,dynamicId);
                return "after cancel";
            }
        }
        return "like dynamic done";
    }


    @RequestMapping("/likeComment")
    @ResponseBody
    //���۵���
    public String likeComment(Integer likeObjId, Integer userId, @RequestParam(defaultValue = "1") Integer likeStatus, Integer commentId){
        Integer status = dynamicService.checkCommentLike(likeObjId, userId);
        if (status==null){
            //����
            dynamicService.likeCommentAndAddLikeCount(likeObjId,userId,likeStatus,commentId);
            return "insert done";
        }else {
            //ȡ������
            if (status==1){
                dynamicService.cancelCommentLikeAndReduceLikeCount(likeObjId,userId,commentId);
                return "cancel";
            }
            //ȡ�����ֵ���
            if (status==0){
                dynamicService.commentLikeAgainAfterCancelLikeAndAddLikeCommentCount(likeObjId,userId,commentId);
                return "after cancel";
            }
        }
        return "like comment done";
    }

    public static void main(String[] args) {
        System.out.println(as(88));

    }
    public  static  char as(int grade){
        return  grade >= 90 ? 'A' : grade <=89 && grade >=60 ? 'B' : 'C';
    }






}
