package com.lieyan.Service;

import org.apache.commons.lang3.StringUtils;

public class CheckUtil {
    /**
     *
     * @param args
     * @return
     */
    public static boolean checkNulls(String... args) {

        if (args.length == 0) {
            return true;
        }

        for (String str : args) {
            if (StringUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }
}