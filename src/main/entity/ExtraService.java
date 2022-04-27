package main.entity;

public class ExtraService {
    private int type; // 0为seat的，1为meal的

    private String label;

    private int price;

    private String classify; // meal特有字段

    private String imgName; // meal特有字段

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

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
     * @return the imgName
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * @param imgName the imgName to set
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    
}
