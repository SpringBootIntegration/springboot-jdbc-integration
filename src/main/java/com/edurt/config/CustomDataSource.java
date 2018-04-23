/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.edurt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * CustomDataSource <br/>
 * 描述 : CustomDataSource <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-04-21 下午10:05 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
@Configuration
public class CustomDataSource {

    @Value(value = "${custom.datasource.driver-class-name}")
    private String driverClassName;

    @Value(value = "${custom.datasource.url}")
    private String url;

    @Value(value = "${custom.datasource.username}")
    private String userName;

    @Value(value = "${custom.datasource.password}")
    private String password;

    @Bean
    @Primary
    @Description(value = "构建自定义的数据库数据源")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .url(url)
                .username(userName)
                .password(password)
                .build();
    }

//    @Bean
//    @Description(value = "简化代码, 简易注入数据源")
//    @ConfigurationProperties(prefix = "custom.datasource")
//    // 使用该方式有以下注意情况
//    // 1. 默认datasource中驱动默认为driver-class-name, 我们后边自定义的名称也必须为driver-class-name( custom.datasource.driver-class-name)
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }

    @Bean
    @Primary
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}