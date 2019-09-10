package com.xadmin.admin.controller.rest;


import com.xadmin.admin.constants.Urls;
import com.xadmin.common.util.ConvertUtil;
import com.xadmin.framework.base.controller.BaseController;
import com.xadmin.framework.vo.ResponseVo;
import com.xadmin.support.core.entity.Post;
import com.xadmin.support.core.service.IPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 岗位信息 前端控制器
 * </p>
 *
 * @author Ht
 * @since 2019-07-16
 */
@RestController
@RequestMapping("/v1/post")
@Api(value = "岗位信息相关", tags = "岗位信息相关")
public class PostController extends BaseController<IPostService, Post> {

    @RequestMapping(value = Urls.DEPT_LIST_BY_USER, method = RequestMethod.GET)
    @ApiOperation(value = "获取指定用户的岗位列表", notes = "获取指定用户的岗位列表")
    public ResponseVo<List<Post>> getUserRoles(@PathVariable("userId") Long userId){
        List<Post> userDepts = bizService.getUserPosts(userId);
        return new ResponseVo<>(userDepts);
    }

    @RequestMapping(value = Urls.DEPT_USER_BIND, method = RequestMethod.PUT)
    @ApiOperation(value = "设置用户所属岗位", notes = "设置用户所属岗位")
    public ResponseVo userPostBind(@PathVariable("userId") Long userId, @ApiParam(value = "所属的岗位ID,多个以英文逗号分隔", required = true) @RequestParam(value = "postIds") String postIds){
        List<Long> postIdList = ConvertUtil.splitStr2LongList(postIds, ",");
        bizService.bindUserPost(userId, postIdList);
        return new ResponseVo<>();
    }
}

