package main.entity;

import java.util.List;

public class MealPlanStruct {
    private String classify;

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
