package main.entity;

import java.util.List;

public class Flight {

    private String flightNo;

    private String plane;

    private String from;

    private String to;

    private String departureTime;

    private String arrivalTime;

    private String time;

    private List<String> occupiedSeat;

    private List<String> availableExtraSeat;

    private List<String> availableMeal;

    /**
     * @return the flightNo
     */
    public String getFlightNo() {
        return flightNo;
    }

    /**
     * @param flightNo the flightNo to set
     */
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    /**
     * @return the plane
     */
    public String getPlane() {
        return plane;
    }

    /**
     * @param plane the plane to set
     */
    public void setPlane(String plane) {
        this.plane = plane;
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the departureTime
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * @param departureTime the departureTime to set
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * @return the arrivalTime
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the occupiedSeat
     */
    public List<String> getOccupiedSeat() {
        return occupiedSeat;
    }

    /**
     * @param occupiedSeat the occupiedSeat to set
     */
    public void setOccupiedSeat(List<String> occupiedSeat) {
        this.occupiedSeat = occupiedSeat;
    }

    /**
     * @return the availableExtraSeat
     */
    public List<String> getAvailableExtraSeat() {
        return availableExtraSeat;
    }

    /**
     * @param availableExtraSeat the availableExtraSeat to set
     */
    public void setAvailableExtraSeat(List<String> availableExtraSeat) {
        this.availableExtraSeat = availableExtraSeat;
    }

    /**
     * @return the availableMeal
     */
    public List<String> getAvailableMeal() {
        return availableMeal;
    }

    /**
     * @param availableMeal the availableMeal to set
     */
    public void setAvailableMeal(List<String> availableMeal) {
        this.availableMeal = availableMeal;
    }

    
}
