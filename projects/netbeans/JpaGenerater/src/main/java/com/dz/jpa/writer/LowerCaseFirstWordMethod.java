/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.writer;

import com.dz.jpa.utils.SysUtils;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import java.util.List;

/**
 *
 * @author sz
 */
public class LowerCaseFirstWordMethod implements TemplateMethodModelEx {

    @Override
    public Object exec(List arguments) throws TemplateModelException {
        String result = "";
        if (arguments != null && arguments.size() > 0 && arguments.get(0) != null && !"".equals(arguments.get(0))) {
            result = SysUtils.toLowerCaseFirstOne(arguments.get(0).toString());
        }
        return result;
    }

}
