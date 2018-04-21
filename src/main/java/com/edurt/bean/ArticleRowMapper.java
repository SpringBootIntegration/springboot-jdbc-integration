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
package com.edurt.bean;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ArticleRowMapper <br/>
 * 描述 : ArticleRowMapper <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-04-21 下午9:57 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
public class ArticleRowMapper implements RowMapper<ArticleBean> {

    // 主要用户对查询到的数据库信息转化为我们所使用的JAVA Bean文件(java实体类)
    @Override
    public ArticleBean mapRow(ResultSet resultSet, int i) throws SQLException {
        ArticleBean bean = new ArticleBean();
        bean.setId(resultSet.getInt("id"));
        bean.setTitle(resultSet.getString("title"));
        bean.setDescription(resultSet.getString("description"));
        return bean;
    }

}