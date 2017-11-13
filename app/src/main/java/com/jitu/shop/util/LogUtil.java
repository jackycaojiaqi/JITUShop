package com.jitu.shop.util;

import android.util.Log;

/**
 * Created by huangjianfeng on 2017/7/2.
 */

public class LogUtil {

    //可以全局控制是否打印log日志
    private static boolean isPrintLog = true;
    private static final int LOG_MAXLENGTH = 3000;
    private static final String DEFAULT_TAG = "This is Log";
    private static final String DEFAULT_NULL = "Message is Null";
    private static final String line = "------------------------------------------------";
    private static final String SUFFIX = ".java";

    public static void init(boolean isPrint) {
        isPrintLog = isPrint;
    }

    public static void v(Object msg) {
        if (isPrintLog) {
            if (msg == null) {
                v(DEFAULT_TAG, DEFAULT_NULL);
            } else {
                v(DEFAULT_TAG, msg);
            }
        }
    }

    public static void d(Object msg) {
        if (isPrintLog) {
            if (msg == null) {
                d(DEFAULT_TAG, DEFAULT_NULL);
            } else {
                d(DEFAULT_TAG, msg);
            }
        }
    }

    public static void i(Object msg) {
        if (isPrintLog) {
            if (msg == null) {
                i(DEFAULT_TAG, DEFAULT_NULL);
            } else {
                i(DEFAULT_TAG, msg);
            }
        }
    }

    public static void w(Object msg) {
        if (isPrintLog) {
            if (msg == null) {
                w(DEFAULT_TAG, DEFAULT_NULL);
            } else {
                w(DEFAULT_TAG, msg);
            }
        }
    }

    public static void e(Object msg) {
        if (isPrintLog) {
            if (msg == null) {
                e(DEFAULT_TAG, DEFAULT_NULL);
            } else {
                e(DEFAULT_TAG, msg);
            }
        }
    }

    public static void v(String tag, Object msg) {
        if (isPrintLog) {
            Log.v(DEFAULT_TAG, getHeaderString());
            if (msg == null) {
                Log.v(tag, DEFAULT_NULL);
            } else {
                String tip = String.valueOf(msg);
                int strLength = tip.length();
                int start = 0;
                int end = LOG_MAXLENGTH;
                for (int i = 0; i < 100; i++) {
                    if (strLength > end) {
                        Log.v(tag, tip.substring(start, end));
                        start = end;
                        end = end + LOG_MAXLENGTH;
                    } else {
                        Log.v(tag, tip.substring(start, strLength));
                        break;
                    }
                }
            }
        }
    }


    public static void d(String tag, Object msg) {
        if (isPrintLog) {
            Log.d(DEFAULT_TAG, getHeaderString());
            if (msg == null) {
                Log.d(tag, DEFAULT_NULL);
            } else {
                String tip = String.valueOf(msg);
                int strLength = tip.length();
                int start = 0;
                int end = LOG_MAXLENGTH;
                for (int i = 0; i < 100; i++) {
                    if (strLength > end) {
                        Log.d(tag, tip.substring(start, end));
                        start = end;
                        end = end + LOG_MAXLENGTH;
                    } else {
                        Log.d(tag, tip.substring(start, strLength));
                        break;
                    }
                }
            }
        }
    }


    public static void i(String tag, Object msg) {
        if (isPrintLog) {
            Log.i(DEFAULT_TAG, getHeaderString());
            if (msg == null) {
                Log.i(tag, DEFAULT_NULL);
            } else {
                String tip = String.valueOf(msg);
                int strLength = tip.length();
                int start = 0;
                int end = LOG_MAXLENGTH;
                int size = strLength / LOG_MAXLENGTH;
                for (int i = 0; i < 100; i++) {
                    if (strLength > end) {
                        Log.i(tag, tip.substring(start, end));
                        start = end;
                        end = end + LOG_MAXLENGTH;
                    } else {
                        Log.i(tag, tip.substring(start, strLength));
                        break;
                    }
                }
            }
        }
    }


    public static void w(String tag, Object msg) {
        if (isPrintLog) {
            Log.w(DEFAULT_TAG, getHeaderString());
            if (msg == null) {
                Log.w(tag, DEFAULT_NULL);
            } else {
                String tip = String.valueOf(msg);
                int strLength = tip.length();
                int start = 0;
                int end = LOG_MAXLENGTH;
                for (int i = 0; i < 100; i++) {
                    if (strLength > end) {
                        Log.w(tag, tip.substring(start, end));
                        start = end;
                        end = end + LOG_MAXLENGTH;
                    } else {
                        Log.w(tag, tip.substring(start, strLength));
                        break;
                    }
                }
            }
        }
    }


    public static void e(String tag, Object msg) {
        if (isPrintLog) {
            Log.e(DEFAULT_TAG, getHeaderString());
            if (msg == null) {
                Log.e(tag, DEFAULT_NULL);
            } else {
                String tip = String.valueOf(msg);
                int strLength = tip.length();
                int start = 0;
                int end = LOG_MAXLENGTH;
                for (int i = 0; i < 100; i++) {
                    if (strLength > end) {
                        Log.e(tag, tip.substring(start, end));
                        start = end;
                        end = end + LOG_MAXLENGTH;
                    } else {
                        Log.e(tag, tip.substring(start, strLength));
                        break;
                    }
                }
            }
        }
    }

    private static String getHeaderString() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        StackTraceElement targetElement = stackTrace[5];
        String className = targetElement.getClassName();
        String[] classNameInfo = className.split("\\.");
        if (classNameInfo.length > 0) {
            className = classNameInfo[classNameInfo.length - 1] + SUFFIX;
        }

        if (className.contains("$")) {
            className = className.split("\\$")[0] + SUFFIX;
        }

        int lineNumber = targetElement.getLineNumber();

        if (lineNumber < 0) {
            lineNumber = 0;
        }

        String headString = line + "[ (" + className + ":" + lineNumber + ")" + " ]" + line;

        return headString;
    }
}