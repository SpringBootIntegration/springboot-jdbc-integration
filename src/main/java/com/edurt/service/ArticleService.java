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
package com.edurt.service;

import com.edurt.bean.ArticleBean;

import java.util.List;

/**
 * ArticleService <br/>
 * 描述 : ArticleService <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-04-12 下午11:32 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
public interface ArticleService {

    int create(ArticleBean bean);

    int modfiy(ArticleBean bean);

    int delete(Integer id);

    int batchSave(final List<ArticleBean> beans);

    int batchModfiy(final List<ArticleBean> beans);

    int batchDelete(final List<Integer> ids);

    List<ArticleBean> findAll();

    ArticleBean findOne(Integer id);

}