package com.xadmin.admin.controller.rest;


import com.xadmin.admin.constants.Urls;
import com.xadmin.common.util.ConvertUtil;
import com.xadmin.framework.base.controller.BaseController;
import com.xadmin.framework.vo.ResponseVo;
import com.xadmin.support.core.entity.Dept;
import com.xadmin.support.core.service.IDeptService;
import com.xadmin.support.core.vo.response.DeptVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 部门信息 前端控制器
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@RestController
@RequestMapping(Urls.DEPT_MODULE)
@Api(value = "部门信息相关", tags = "部门信息相关")
public class DeptController extends BaseController<IDeptService, Dept> {

    @RequestMapping(value = Urls.DEPT_LIST, method = RequestMethod.GET)
    @ApiOperation(value = "获取树状结构部门列表", notes = "获取指定用户的部门列表")
    @RequiresPermissions("dept:view")
    public ResponseVo<List<DeptVo>> getDepts(){
        List<DeptVo> treeDepts = bizService.getTreeDepts();
        return new ResponseVo<>(treeDepts);
    }

    @RequestMapping(value = Urls.DEPT_LIST_BY_USER, method = RequestMethod.GET)
    @ApiOperation(value = "获取指定用户的部门列表", notes = "获取指定用户的部门列表")
    public ResponseVo<List<Dept>> getUserRoles(@PathVariable("userId") Long userId){
        List<Dept> userDepts = bizService.getUserDepts(userId);
        return new ResponseVo<>(userDepts);
    }

    @RequestMapping(value = Urls.DEPT_USER_BIND, method = RequestMethod.PUT)
    @ApiOperation(value = "设置用户所属部门", notes = "设置用户所属部门")
    public ResponseVo userDeptBind(@PathVariable("userId") Long userId, @ApiParam(value = "所属的部门ID,多个以英文逗号分隔", required = true) @RequestParam(value = "deptIds") String deptIds){
        List<Long> deptIdList = ConvertUtil.splitStr2LongList(deptIds, ",");
        bizService.bindUserDept(userId, deptIdList);
        return new ResponseVo<>();
    }

}

