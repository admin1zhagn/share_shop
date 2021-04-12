package com.cloud.order.utils;

import java.util.Random;

/**
 * @description 类描述：随机编码产生工具
 */
public class RandomUtil {

    /**
     * @description 从英文字母和数字中产生随机编码
     * @param number
     *            几位
     * @return 产生的随机编码
     */
    public static String getRandomByCharAndNum(Integer number) {
        String source = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rom = new Random();
        StringBuffer sb = new StringBuffer(100);
        for (int i = 0; i < number; i++) {
            int num = rom.nextInt(source.length());
            sb.append(source.charAt(num));
        }
        return sb.toString();
    }
    
    /**
     * @description 从数字中产生随机编码
     * @param number
     *            几位
     * @return 产生的随机编码
     */
    public static String getRandomByNum(Integer number) {
        String source = "0123456789";
        Random rom = new Random();
        StringBuffer sb = new StringBuffer(100);
        for (int i = 0; i < number; i++) {
            int num = rom.nextInt(source.length());
            sb.append(source.charAt(num));
        }
        return sb.toString();
    }
}
