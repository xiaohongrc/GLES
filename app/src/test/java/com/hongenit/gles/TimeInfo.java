package com.hongenit.gles;

/**
 * Created by hongenit on 18/2/26.
 */

public class TimeInfo {
    private final String mInfo;

    public TimeInfo(String info) {
        mInfo = info;
        jiXiong = findAttribute("吉凶：");
        shiZhu = findAttribute("时柱：");
        chongSha = findAttribute("冲煞：");
        shiYi = findAttribute("时宜：");
        shiJi = findAttribute("时忌：");
        jiShen = findAttribute("吉神：");
        xiongSha = findAttribute("凶煞：");
        caiXi = findAttribute("财喜：");
    }

    String findAttribute(String startStr) {
        int beginIndex = mInfo.indexOf(startStr);
        return mInfo.substring(beginIndex, mInfo.indexOf("\r\n", beginIndex));
    }

    /*
        "t7": "\r\n 吉凶：吉\r\n 时柱：壬辰(长流水)\r\n 冲煞：冲狗煞南\r\n 正冲：丙戌(1946 2006)\r\n
        时宜：订婚 嫁娶 安床 移徙 入宅 修造 安葬\r\n 时忌：造桥 乘船 赴任 出行 祭祀 祈福 斋醮 开光\r\n
        吉神：青龙\r\n 凶煞：建刑 不遇 路空\r\n 财喜：财神正南 喜神正南\r\n",
         */


    private String jiXiong;
    private String shiZhu;
    private String chongSha;
    private String shiYi;
    private String shiJi;
    private String jiShen;
    private String xiongSha;
    private String caiXi;


    public String getmInfo() {
        return mInfo;
    }

    public String getJiXiong() {
        return jiXiong;
    }

    public void setJiXiong(String jiXiong) {
        this.jiXiong = jiXiong;
    }

    public String getShiZhu() {
        return shiZhu;
    }

    public void setShiZhu(String shiZhu) {
        this.shiZhu = shiZhu;
    }

    public String getChongSha() {
        return chongSha;
    }

    public void setChongSha(String chongSha) {
        this.chongSha = chongSha;
    }

    public String getShiYi() {
        return shiYi;
    }

    public void setShiYi(String shiYi) {
        this.shiYi = shiYi;
    }

    public String getShiJi() {
        return shiJi;
    }

    public void setShiJi(String shiJi) {
        this.shiJi = shiJi;
    }

    public String getJiShen() {
        return jiShen;
    }

    public void setJiShen(String jiShen) {
        this.jiShen = jiShen;
    }

    public String getXiongSha() {
        return xiongSha;
    }

    public void setXiongSha(String xiongSha) {
        this.xiongSha = xiongSha;
    }

    public String getCaiXi() {
        return caiXi;
    }

    public void setCaiXi(String caiXi) {
        this.caiXi = caiXi;
    }
}
