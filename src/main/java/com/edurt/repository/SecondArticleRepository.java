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
package com.edurt.repository;

import com.edurt.bean.ArticleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * SecondArticleRepository <br/>
 * 描述 : SecondArticleRepository <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-04-23 下午11:09 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
@Component
public class SecondArticleRepository {

    @Autowired
    // 在需要第二个jdbcTemplate的地方, 我们注入的时候需要使用关键词进行标识使用哪个数据源
    @Qualifier(value = "secondJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public int create(ArticleBean bean) {
        String sql = "INSERT INTO article(title, description) VALUES (?, ?)";
        return jdbcTemplate.update(sql, bean.getTitle(), bean.getDescription());
    }

}