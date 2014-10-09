/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa;

/**
 *
 * @author sz
 */
public class Cache {

    static class CacheHolder {

        public static Cache instance = new Cache();
    }

    public static Cache getInstance() {
        return CacheHolder.instance;
    }

    private Cache() {

    }

    private ISetting setting;

    private IAdvancedSetting advancedSetting;

    public ISetting getSetting() {
        return setting;
    }

    public void setSetting(ISetting setting) {
        this.setting = setting;
    }

    public IAdvancedSetting getAdvancedSetting() {
        return advancedSetting;
    }

    public void setAdvancedSetting(IAdvancedSetting advancedSetting) {
        this.advancedSetting = advancedSetting;
    }

}
