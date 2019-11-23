package com.zwc.base.constant;

/**
 * @ClassName BaseServiceConstants
 * @Desc TODO   常量类
 * @Date 2019/7/26 15:27
 * @Version 1.0
 */
public class BaseServiceConstants {

    /**
     * 是否删除
     */
    public static class IS_DELETE {
        /**
         * 未删除
         */
        public static final Integer NO = 0;
        /**
         * 已删除
         */
        public static final Integer YES = 1;
    }

    /**
     * 是否同步
     */
    public static class IS_SYNC {
        /**
         * 未同步
         */
        public static final Integer NO = 0;
        /**
         * 已同步
         */
        public static final Integer YES = 1;
    }

    /*
     * @ClassName BaseServiceConstants
     * @Desc TODO   客户端回调信息
     * @Date 2019/8/9 13:51
     * @Version 1.0
     */
    public static class ACK_CALLBACK {
        /**
         * 成功
         */
        public static final String SUCCESS = "success";
        /**
         * 失败
         */
        public static final String FAIL = "fail";
    }

}
