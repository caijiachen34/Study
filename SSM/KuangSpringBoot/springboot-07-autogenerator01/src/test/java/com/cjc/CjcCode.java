package com.cjc;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.ArrayList;
import java.util.Date;

public class CjcCode {
    public static void main(String[] args) {
        //构建代码生成器对象
        AutoGenerator generator = new AutoGenerator();
        //配置策略

        //1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //获取项目路径
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor("cjc");
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(false);
        globalConfig.setServiceName("%sService"); //去service前缀
        globalConfig.setIdType(IdType.ID_WORKER);
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setSwagger2(true);
        generator.setGlobalConfig(globalConfig);

        //2.设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/cc1?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("cjc89684550");
        dsc.setDbType(DbType.MYSQL);
        generator.setDataSource(dsc);

        //3.包的配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("blog");
        packageConfig.setParent("com.cjc");
        packageConfig.setEntity("pojo");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setController("controller");
        generator.setPackageInfo(packageConfig);

        //4.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("user");  //映射表名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setLogicDeleteFieldName("deleted");
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill modifyTime = new TableFill("modify_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(modifyTime);
        strategy.setTableFillList(tableFills);
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true); //restFul驼峰命名
        strategy.setControllerMappingHyphenStyle(true);
        generator.setStrategy(strategy);


        generator.execute();
    }
}
