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
package com.edurt.controller;

import com.edurt.bean.ArticleBean;
import com.edurt.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ArticleController <br/>
 * 描述 : ArticleController <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-04-12 下午11:42 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
@RestController
@RequestMapping(value = "article")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    int create(@RequestBody ArticleBean bean) {
        return service.create(bean);
    }

    @RequestMapping(value = "modfiy", method = RequestMethod.PUT)
    int modfiy(@RequestBody ArticleBean bean) {
        return service.modfiy(bean);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    int delete(@PathVariable Integer id) {
        return service.delete(id);
    }

}