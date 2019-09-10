package com.xadmin.admin.controller.rest;


import com.xadmin.admin.constants.Urls;
import com.xadmin.common.util.ConvertUtil;
import com.xadmin.framework.base.controller.BaseController;
import com.xadmin.framework.vo.ResponseVo;
import com.xadmin.support.core.entity.UserGroup;
import com.xadmin.support.core.service.IUserGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 用户组 前端控制器
 * </p>
 *
 * @author Ht
 * @since 2019-07-29
 */
@RestController
@RequestMapping("/v1/userGroup")
@Api(value = "用户组相关", tags = "用户组相关")
public class UserGroupController extends BaseController<IUserGroupService, UserGroup> {

    @RequestMapping(value = Urls.USER_GROUP_BIND, method = RequestMethod.PUT)
    @ApiOperation(value = "绑定组内用户,多个以逗号分隔", notes = "绑定组内用户,多个以逗号分隔")
    @ResponseBody
    public ResponseVo bindUsers(@PathVariable Long groupId, @RequestParam(value = "userIds") String userIds) {
        List<Long> userIdList = ConvertUtil.splitStr2LongList(userIds, ",");
        bizService.bindUsers(groupId, userIdList);
        return new ResponseVo();
    }

    @RequestMapping(value = Urls.USER_GROUP_ROLE_BIND, method = RequestMethod.PUT)
    @ApiOperation(value = "绑定用户组对应的角色,多个以逗号分隔", notes = "绑定用户组对应的角色,多个以逗号分隔")
    @ResponseBody
    public ResponseVo bindRoles(@PathVariable Long groupId, @RequestParam(value = "roleIds") String roleIds) {
        List<Long> roleIdList = ConvertUtil.splitStr2LongList(roleIds, ",");
        bizService.bindRoles(groupId, roleIdList);
        return new ResponseVo();
    }
}

