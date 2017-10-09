package com.applecoffee.devtools.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zm.
 */

public class CheckUtils {
    /**
     * 检测是否是邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
