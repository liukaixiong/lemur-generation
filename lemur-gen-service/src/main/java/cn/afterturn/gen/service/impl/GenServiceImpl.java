/**
 * Copyright 2013-2017 JueYue (qrb.jueyue@gmail.com)
 *   
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.afterturn.gen.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.afterturn.common.util.FileUtil;
import cn.afterturn.gen.model.TemplateEntity;
import cn.afterturn.gen.service.IGenService;

/**
 * 
 * @author JueYue
 * 2017年4月23日
 */
@Service("genService")
public class GenServiceImpl implements IGenService {
    
    @Override
    public List<String> loadTemplateFile(List<TemplateEntity> templateList) {
        List<String> list = new ArrayList<>();
        for (TemplateEntity  templateEntity: templateList) {
            list.add(getTemplateFile(templateEntity));
        }
        return list;
    }

    private String getTemplateFile(TemplateEntity templateEntity) {
        return FileUtil.readToString(templateEntity.getTemplatePath(), "UTF-8");
    }

}
