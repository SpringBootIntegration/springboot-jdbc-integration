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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * ArticleRepository <br/>
 * 描述 : ArticleRepository <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-04-12 下午11:28 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
@Component
public class ArticleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 创建文章
     *
     * @param bean 文章信息
     * @return 受影响的行数
     */
    public int create(ArticleBean bean) {
        String sql = "INSERT INTO article(title, description) VALUES (?, ?)";
        return jdbcTemplate.update(sql, bean.getTitle(), bean.getDescription());
    }

    /**
     * 修改文章
     *
     * @param bean 需要修改的文章信息
     * @return 受影响的行数
     */
    public int modfiy(ArticleBean bean) {
        String sql = "UPDATE article SET title=?, description = ? WHERE id = ?";
        return jdbcTemplate.update(sql, bean.getTitle(), bean.getDescription(), bean.getId());
    }

    public int delete(Integer id) {
        String sql = "DELETE FROM article WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

}