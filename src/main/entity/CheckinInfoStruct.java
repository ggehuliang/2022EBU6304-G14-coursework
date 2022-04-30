package main.entity;

import java.util.Date;

public class CheckinInfoStruct {

    private String bookingNo;
    
    private String flightNo;
    
    private Date date;
    
    private boolean checkinFinished;
    
    private SeatPlanStruct seatPlan;
    
    private MealPlanStruct mealPlan;
    
    private PaymentStruct payment;

    /**
     * @return the bookingNo
     */
    public String getBookingNo() {
        return bookingNo;
    }

    /**
     * @param bookingNo the bookingNo to set
     */
    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the checkinFinished
     */
    public boolean isCheckinFinished() {
        return checkinFinished;
    }

    /**
     * @param checkinFinished the checkinFinished to set
     */
    public void setCheckinFinished(boolean checkinFinished) {
        this.checkinFinished = checkinFinished;
    }

    /**
     * @return the seatPlan
     */
    public SeatPlanStruct getSeatPlan() {
        return seatPlan;
    }

    /**
     * @param seatPlan the seatPlan to set
     */
    public void setSeatPlan(SeatPlanStruct seatPlan) {
        this.seatPlan = seatPlan;
    }

    /**
     * @return the mealPlan
     */
    public MealPlanStruct getMealPlan() {
        return mealPlan;
    }

    /**
     * @param mealPlan the mealPlan to set
     */
    public void setMealPlan(MealPlanStruct mealPlan) {
        this.mealPlan = mealPlan;
    }

    /**
     * @return the payment
     */
    public PaymentStruct getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(PaymentStruct payment) {
        this.payment = payment;
    }
    
    
}
