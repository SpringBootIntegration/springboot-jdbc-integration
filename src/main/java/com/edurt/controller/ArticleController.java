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

import java.util.List;

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

    @RequestMapping(value = "/batch/save", method = RequestMethod.POST)
    int batchSave(@RequestBody List<ArticleBean> beans) {
        return service.batchSave(beans);
    }

    @RequestMapping(value = "/batch/modfiy", method = RequestMethod.PUT)
    int batchModfiy(@RequestBody List<ArticleBean> beans) {
        return service.batchModfiy(beans);
    }

    @RequestMapping(value = "/batch/delete", method = RequestMethod.DELETE)
    int batchDelete(@RequestBody List<Integer> ids) {
        return service.batchDelete(ids);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    List<ArticleBean> all() {
        return service.findAll();
    }

    @RequestMapping(value = "info/{id}", method = RequestMethod.GET)
    ArticleBean one(@PathVariable Integer id) {
        return service.findOne(id);
    }

}