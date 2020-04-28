package com.wonders.bigdata.utils;

import java.util.UUID;

/**
 * <p>  Created by LXL on 2017/11/21  </p>
 */
public class UUIDUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
