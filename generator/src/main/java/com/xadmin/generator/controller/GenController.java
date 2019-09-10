package com.xadmin.generator.controller;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.xadmin.framework.vo.ResponseVo;
import com.xadmin.generator.config.GeneratorConfig;
import com.xadmin.generator.entity.TableInfo;
import com.xadmin.generator.service.ITableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/gen")
@ApiIgnore
@Api(value = "代码生成器", tags = "代码生成器")
public class GenController {
    @Autowired
    private GeneratorConfig generatorConfig;
    @Autowired
    private ITableService tableService;

    @RequestMapping(value = "/include", method = RequestMethod.POST)
    @ApiOperation(value = "根据指定表名自动生成对应代码", notes = "根据指定表名自动生成对应代码")
    public ResponseVo includeGen(
            @ApiParam(required = true, value = "需要生成的表名,多个以逗号分隔") @RequestBody  String tableInclude){

        String[] tableIncludeArray = splitStr2StrArray(tableInclude, ",");

        AutoGenerator config = generatorConfig.getConfig();
        StrategyConfig strategy = config.getStrategy();
        strategy.setInclude(tableIncludeArray);
        config.execute();

        return ResponseVo.ok();
    }

    @RequestMapping(value = "/exclude", method = RequestMethod.POST)
    @ApiOperation(value = "根据排除的表名自动生成对应代码", notes = "根据排除的表名自动生成对应代码")
    public ResponseVo excludeGen(
            @ApiParam(required = true, value = "需要排除的表名,多个以逗号分隔") @RequestBody String tableExclude){

        String[] tableExcludeArray = splitStr2StrArray(tableExclude, ",");

        AutoGenerator config = generatorConfig.getConfig();
        StrategyConfig strategy = config.getStrategy();
        strategy.setExclude(tableExcludeArray);
        config.execute();

        return ResponseVo.ok();
    }

    @RequestMapping(value = "/tables", method = RequestMethod.GET)
    @ApiOperation(value = "根据条件获取数据库表信息列表", notes = "根据条件获取数据库表信息列表")
    public ResponseVo<List<TableInfo>> tableList(
            TableInfo tableInfo){

        List<TableInfo> tableInfos = tableService.selectTableList(tableInfo);

        return new ResponseVo<>(tableInfos);
    }

    public static String[] splitStr2StrArray(String content, String splitChar) {
        if(StringUtils.isEmpty(content)){
            return new String[]{};
        }

        String[] split = content.split(splitChar);
        return split;
    }
}
