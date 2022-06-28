package com.xzt;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.sun.javafx.PlatformUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Author hl
 * @Date 2020/6/5
 * @Description: TODO
 */
public class CodeGenerator {
    /**
     * 代码生成位置
     */
    public static final String PARENT_NAME = "com.xzt.ts";

    /**
     * modular 名字
     */
    public static final String MODULAR_NAME = "";

    /**
     * 基本路径
     */
    public static final String SRC_MAIN_JAVA = "src/main/java/";

    /**
     * 作者
     */
    public static final String AUTHOR = "xzt";

    /**
     * 是否是 rest 接口
     */
    private static final boolean REST_CONTROLLER_STYLE = true;

//    jdbcUrl: jdbc:mysql://172.16.200.192:3306/new_gbw_insurance?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true
//    username: root
//    password: DhvUGkENahLUwCh@1
    public static final String JDBC_MYSQL_URL = "jdbc:mysql://172.16.200.192:3306/cngongbao_old_gongbaowang?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
    public static final String JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD = "DhvUGkENahLUwCh@1";


    public static void main(String[] args) {
//        String moduleName = scanner("模块名");
//        String[] tableName = scanner("表名，多个英文逗号分割").split(",");
//        String tablePrefix = scanner("表前缀(无前缀输入#)").replaceAll("#", "");
        String moduleName = "gbw";
        String[] tableName = new String[]{"order_info"};
        String tablePrefix = "";

        autoGenerator(moduleName, tableName, tablePrefix);
    }

    public static void autoGenerator(String moduleName, String[] tableName, String tablePrefix) {
        System.out.println("--开始--");
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        new AutoGenerator()
                .setGlobalConfig(getGlobalConfig())
                .setDataSource(getDataSourceConfig())
                .setPackageInfo(getPackageConfig(moduleName))
                .setStrategy(getStrategyConfig(tableName, tablePrefix))
                .setCfg(getInjectionConfig(moduleName))
//                .setTemplate(getTemplateConfig())
                .setTemplate(templateConfig)
                .setTemplateEngine(new VelocityTemplateEngine())
                .execute();
    }

    private static String getDateTime() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDate.format(formatter);
    }

    private static InjectionConfig getInjectionConfig(final String moduleName) {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map map = new HashMap();
                map.put("dateTime", getDateTime());
                setMap(map);
                final String projectPath = System.getProperty("user.dir");
                List<FileOutConfig> fileOutConfigList = new ArrayList<FileOutConfig>();
                // 自定义配置会被优先输出
                fileOutConfigList.add(new FileOutConfig("/templates/mapper.xml.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        // 自定义输出文件名，如果entity设置了前后缀，此次注意xml的名称也会跟着发生变化
                        return projectPath + "/src/main/resources/mapper/" +
                                moduleName + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                    }
                });
                setFileOutConfigList(fileOutConfigList);
            }
        };
    }


    private static StrategyConfig getStrategyConfig(String[] tableName, String tablePrefix) {
        return new StrategyConfig()
                .setEntityLombokModel(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableName)
                .setRestControllerStyle(REST_CONTROLLER_STYLE)
                .setEntityBuilderModel(true)
//                .setControllerMappingHyphenStyle(false)
                .setEntityTableFieldAnnotationEnable(true)
                .setTablePrefix(tablePrefix + "_");
    }

    private static PackageConfig getPackageConfig(String moduleName) {
        return new PackageConfig()
//                .setModuleName(moduleName)
                .setParent(PARENT_NAME)
                .setMapper("mapper." + moduleName)
                .setService("service." + moduleName)
                .setServiceImpl("service.impl." + moduleName)
                .setController("controller." + moduleName)
                .setEntity("entity." + moduleName);
    }

    private static DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig()
                .setUrl(JDBC_MYSQL_URL)
                .setDriverName(JDBC_DRIVER_NAME)
                .setUsername(JDBC_USERNAME)
                .setPassword(JDBC_PASSWORD);
    }

    private static GlobalConfig getGlobalConfig() {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/" + MODULAR_NAME + SRC_MAIN_JAVA;
        if (PlatformUtil.isWindows()) {
            filePath = filePath.replaceAll("/+|\\\\+", "\\\\");
        } else {
            filePath = filePath.replaceAll("/+|\\\\+", "/");
        }
        return new GlobalConfig()
                .setOutputDir(filePath)
                .setDateType(DateType.ONLY_DATE)
//                .setIdType(IdType.ASSIGN_UUID)
                .setAuthor(AUTHOR)
                .setBaseColumnList(true)
                .setEnableCache(false)
                .setBaseResultMap(true)
                .setOpen(false);
    }

    private static TemplateConfig getTemplateConfig() {
        return new TemplateConfig()
                .setController("/templates/controller.java.vm")
                .setService("/templates/service.java.vm")
                .setServiceImpl("/templates/serviceImpl.java.vm")
                .setEntity("/templates/entity.java.vm")
                .setMapper("/templates/mapper.java.vm")
                .setXml("/templates/mapper.xml.vm");
    }

    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("please input scanner" + tip + " : ");
        System.out.println(sb.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (ipt.isEmpty()) {
                throw new MybatisPlusException("please input the correct " + tip + ". ");
            }
            return ipt;
        }
        return null;
    }
}