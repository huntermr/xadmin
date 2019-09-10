package com.xadmin.generator.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "gen")
@PropertySource(value = { "classpath:generator.yml" })
public class GeneratorConfig {
    @Value("${author}")
    private String author;
    @Value("${outputPath}")
    private String outputPath;
    @Value("${mapperPath}")
    private String mapperPath;
    @Value("${vuePath}")
    private String vuePath;
    @Value("${sqlPath}")
    private String sqlPath;
    @Value("${dbUser}")
    private String dbUser;
    @Value("${dbPwd}")
    private String dbPwd;
    @Value("${dbUrl}")
    private String dbUrl;
    @Value("${packageName}")
    private String packageName;
    @Value("${packagePath}")
    private String packagePath;
    @Value("${commonPackageName}")
    private String commonPackageName;
    @Value("${moduleName}")
    private String moduleName;
    @Value("${tablePrefix}")
    private String tablePrefix;
    @Value("${apiVersion}")
    private String apiVersion;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public String getMapperPath() {
        return mapperPath;
    }

    public void setMapperPath(String mapperPath) {
        this.mapperPath = mapperPath;
    }

    public String getVuePath() {
        return vuePath;
    }

    public void setVuePath(String vuePath) {
        this.vuePath = vuePath;
    }

    public String getSqlPath() {
        return sqlPath;
    }

    public void setSqlPath(String sqlPath) {
        this.sqlPath = sqlPath;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPwd() {
        return dbPwd;
    }

    public void setDbPwd(String dbPwd) {
        this.dbPwd = dbPwd;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getCommonPackageName() {
        return commonPackageName;
    }

    public void setCommonPackageName(String commonPackageName) {
        this.commonPackageName = commonPackageName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public AutoGenerator getConfig(){
        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy
        // mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outputPath);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setAuthor(author);
        gc.setSwagger2(true);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(dbUser);
        dsc.setPassword(dbPwd);
        dsc.setUrl(dbUrl);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(tablePrefix);// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
//        strategy.setInclude(tableInclude); // 需要生成的表
//        strategy.setExclude(tableExclude); // 排除生成的表
        strategy.setVersionFieldName("version");

        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(new TableFill("ct", FieldFill.INSERT));
        tableFills.add(new TableFill("ut", FieldFill.INSERT_UPDATE));
        strategy.setTableFillList(tableFills);

        strategy.setLogicDeleteFieldName("is_del");

        strategy.setRestControllerStyle(true);

        // 自定义实体父类
        strategy.setSuperEntityClass(commonPackageName + ".BaseModel");
        // 自定义实体，公共字段
//         strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        strategy.setSuperServiceClass(commonPackageName + ".BaseService");
        // 自定义 service 实现类父类
        strategy.setSuperServiceImplClass(commonPackageName + ".BaseServiceImpl");
        // 自定义 controller 父类
        strategy.setSuperControllerClass(commonPackageName + ".BaseController");
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName);
        pc.setModuleName(moduleName);
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                String baseController = commonPackageName + ".BaseRestController";
                Map<String, Object> map = new HashMap<>();
                map.put("abc", baseController);
                map.put("apiVersion", apiVersion);
                this.setMap(map);
            }
        };

        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return mapperPath + tableInfo.getEntityName() + ".xml";
            }
        });

//        // 调整 restcontroller 生成目录演示
//        focList.add(new FileOutConfig("/templates/restcontroller.java.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//
//                return outputPath + "/" + packagePath + File.separator + moduleName + File.separator + "controller" + File.separator + "Rest" + tableInfo.getControllerName() + ".java";
//            }
//        });

//        // 调整 html 生成目录演示
//        focList.add(new FileOutConfig("/templates/add.html.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return MAPPER_PATH + tableInfo.getEntityName().toLowerCase() + "_add.html";
//            }
//        });

        // 调整 vue 生成目录演示
        focList.add(new FileOutConfig("/templates/vue/view.vue.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return vuePath + "views/" + tableInfo.getEntityName().toLowerCase() + "/" + tableInfo.getEntityName() + "View.vue";
            }
        });
        focList.add(new FileOutConfig("/templates/vue/CreateForm.vue.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return vuePath + "views/" + tableInfo.getEntityName().toLowerCase() + "/" + "CreateForm.vue";
            }
        });
        focList.add(new FileOutConfig("/templates/vue/api.js.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return vuePath + "api/" + tableInfo.getEntityName().toLowerCase() + ".js";
            }
        });

        // 调整 sql 生成目录演示
        focList.add(new FileOutConfig("/templates/resource.sql.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return sqlPath + tableInfo.getEntityName().toLowerCase() + ".sql";
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        tc.setController("/templates/controller.java.vm");
        mpg.setTemplate(tc);

        return mpg;
    }
}
