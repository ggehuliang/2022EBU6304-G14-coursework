package main.entity;

import java.util.List;

public class SeatPlanStruct {
    private String classify;

    private String seatNo;

    private List<String> extraService;

    /**
     * @return the classify
     */
    public String getClassify() {
        return classify;
    }

    /**
     * @param classify the classify to set
     */
    public void setClassify(String classify) {
        this.classify = classify;
    }

    /**
     * @return the seatNo
     */
    public String getSeatNo() {
        return seatNo;
    }

    /**
     * @param seatNo the seatNo to set
     */
    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    /**
     * @return the extraService
     */
    public List<String> getExtraService() {
        return extraService;
    }

    /**
     * @param extraService the extraService to set
     */
    public void setExtraService(List<String> extraService) {
        this.extraService = extraService;
    }

    
}
