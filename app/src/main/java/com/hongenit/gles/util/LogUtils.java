package com.hongenit.gles.util;

import android.util.Log;

/**
 * Created by ZN_mager on 2016/5/9.
 */
public class LogUtils {
    public static final boolean WILL_LOG = true;

    public static void e(String tag, String message, boolean force) {
        if (WILL_LOG || force) {
            Log.e(tag, message);
        }
    }

    public static void d(String tag, String message, boolean force) {
        if (WILL_LOG || force) {
            Log.d(tag, message);
        }
    }

    public static void i(String tag, String message, boolean force) {
        if (WILL_LOG || force) {
            Log.i(tag, message);
        }
    }

    public static void v(String tag, String message, boolean force) {
        if (WILL_LOG || force) {
            Log.v(tag, message);
        }
    }

    public static void w(String tag, String message, boolean force) {
        if (WILL_LOG || force) {
            Log.w(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (WILL_LOG) {
            Log.e(tag, message);
        }
    }

    public static void d(String tag, String message) {
        if (WILL_LOG) {
            Log.d(tag, message);
        }
    }

    public static void i(String tag, String message) {
        if (WILL_LOG) {
            Log.i(tag, message);
        }
    }

    public static void v(String tag, String message) {
        if (WILL_LOG) {
            Log.v(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (WILL_LOG) {
            Log.w(tag, message);
        }
    }

    public static void hong(String message) {
        if (WILL_LOG) {
            Log.i("xiaohong", message);
        }
    }

    public static void jw(String message) {
        if (WILL_LOG) {
            Log.i("jinwei", message);
        }
    }


    /**
     * -- 以下打印日志方法的目的是为了省去设置TAG名称的麻烦，传入this对象即可显示该对象名。 --
     */

    public static void e(Object object, String message) {
        if (WILL_LOG) {
            Log.e(object.getClass().getSimpleName(), message);
        }
    }

    public static void d(Object object, String message) {
        if (WILL_LOG) {
            Log.d(object.getClass().getSimpleName(), message);
        }
    }

    public static void i(Object object, String message) {
        if (WILL_LOG) {
            Log.i(object.getClass().getSimpleName(), message);
        }
    }

    public static void v(Object object, String message) {
        if (WILL_LOG) {
            Log.v(object.getClass().getSimpleName(), message);
        }
    }

    public static void w(Object object, String message) {
        if (WILL_LOG) {
            Log.w(object.getClass().getSimpleName(), message);
        }
    }

}
