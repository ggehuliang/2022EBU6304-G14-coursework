package main.entity;

import java.util.List;

public class Person {
    private BaseInfoStruct baseInfo;
    private List<CheckinInfoStruct> checkinInfo;
    /**
     * @return the baseInfo
     */
    public BaseInfoStruct getBaseInfo() {
        return baseInfo;
    }
    /**
     * @param baseInfo the baseInfo to set
     */
    public void setBaseInfo(BaseInfoStruct baseInfo) {
        this.baseInfo = baseInfo;
    }
    /**
     * @return the checkinInfo
     */
    public List<CheckinInfoStruct> getCheckinInfo() {
        return checkinInfo;
    }
    /**
     * @param checkinInfo the checkinInfo to set
     */
    public void setCheckinInfo(List<CheckinInfoStruct> checkinInfo) {
        this.checkinInfo = checkinInfo;
    }

}
