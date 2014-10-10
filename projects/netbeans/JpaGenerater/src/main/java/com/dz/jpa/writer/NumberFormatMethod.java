/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.writer;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sz
 */
public class NumberFormatMethod implements TemplateMethodModelEx {

    @Override
    public Object exec(List arguments) throws TemplateModelException {
        String result = "";
        if (arguments != null && arguments.size() > 0 && arguments.get(0) != null && !"".equals(arguments.get(0))) {
            try {
                Number n = NumberFormat.getInstance().parse(arguments.get(0).toString());
                result = n.toString();
            } catch (ParseException ex) {
                Logger.getLogger(NumberFormatMethod.class.getName()).log(Level.SEVERE, null, ex);
                throw new TemplateModelException(ex);
            }
        }
        return result;
    }

}
