package com.xadmin.framework.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xadmin.framework.base.BaseModel;
import com.xadmin.framework.base.BaseService;
import com.xadmin.framework.constants.Urls;
import com.xadmin.framework.vo.PageRequest;
import com.xadmin.framework.vo.ResponseVo;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public class BaseController<Biz extends BaseService, Entity extends BaseModel> {

    @Autowired
    protected Biz bizService;

    @RequestMapping(value = Urls.BASE_ADD, method = RequestMethod.POST)
    @ApiOperation(value = "(自动生成)添加", notes = "添加")
    @ResponseBody
    public ResponseVo add(Entity entity) {
        bizService.save(entity);
        return new ResponseVo();
    }

    @RequestMapping(value = Urls.BASE_GET, method = RequestMethod.GET)
    @ApiOperation(value = "(自动生成)根据id获取数据", notes = "根据id获取数据")
    @ResponseBody
    public ResponseVo<Entity> get(@PathVariable Serializable id) {
        return new ResponseVo<>((Entity) bizService.getById(id));
    }

    @RequestMapping(value = Urls.BASE_UPDATE, method = RequestMethod.PUT)
    @ApiOperation(value = "(自动生成)根据id更新数据", notes = "根据id更新数据")
    @ResponseBody
    public ResponseVo update(Entity entity) {
        bizService.updateById(entity);
        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.BASE_DELETE, method = RequestMethod.DELETE)
    @ApiOperation(value = "(自动生成)根据id删除数据", notes = "根据id删除数据")
    @ResponseBody
    public ResponseVo remove(@PathVariable Serializable id) {
        bizService.removeById(id);
        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.BASE_LIST, method = RequestMethod.GET)
    @ApiOperation(value = "(自动生成)获取列表", notes = "获取列表")
    @ResponseBody
    public ResponseVo<List<Entity>> all(Entity entity) {
        return new ResponseVo<>(bizService.list(new QueryWrapper(entity)));
    }

    @RequestMapping(value = Urls.BASE_PAGE_LIST, method = RequestMethod.GET)
    @ApiOperation(value = "(自动生成)分页获取列表", notes = "分页获取列表")
    @ResponseBody
    public ResponseVo<IPage<Entity>> list(PageRequest pageRequest, Entity entity) {
        //查询列表数据
        IPage<Entity> page = bizService.page(
                new Page(pageRequest.getPageNum(), pageRequest.getPageSize()),
                new QueryWrapper(entity)
        );

        return new ResponseVo<>(page);
    }
}