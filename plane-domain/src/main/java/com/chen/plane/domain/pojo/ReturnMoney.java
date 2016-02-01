package com.chen.plane.domain.pojo;

public class ReturnMoney {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column return_money.RETURN_MONEY_ID
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    private Integer returnMoneyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column return_money.TICKET_ID
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    private Integer ticketId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column return_money.TICKET_RETURN_ID
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    private Integer ticketReturnId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column return_money.RETURN_MONEY_STATUE
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    private Integer returnMoneyStatue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column return_money.RETURN_MONEY_NUMBER
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    private String returnMoneyNumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column return_money.RETURN_MONEY_ID
     *
     * @return the value of return_money.RETURN_MONEY_ID
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    public Integer getReturnMoneyId() {
        return returnMoneyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column return_money.RETURN_MONEY_ID
     *
     * @param returnMoneyId the value for return_money.RETURN_MONEY_ID
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    public void setReturnMoneyId(Integer returnMoneyId) {
        this.returnMoneyId = returnMoneyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column return_money.TICKET_ID
     *
     * @return the value of return_money.TICKET_ID
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    public Integer getTicketId() {
        return ticketId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column return_money.TICKET_ID
     *
     * @param ticketId the value for return_money.TICKET_ID
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column return_money.TICKET_RETURN_ID
     *
     * @return the value of return_money.TICKET_RETURN_ID
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    public Integer getTicketReturnId() {
        return ticketReturnId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column return_money.TICKET_RETURN_ID
     *
     * @param ticketReturnId the value for return_money.TICKET_RETURN_ID
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    public void setTicketReturnId(Integer ticketReturnId) {
        this.ticketReturnId = ticketReturnId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column return_money.RETURN_MONEY_STATUE
     *
     * @return the value of return_money.RETURN_MONEY_STATUE
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    public Integer getReturnMoneyStatue() {
        return returnMoneyStatue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column return_money.RETURN_MONEY_STATUE
     *
     * @param returnMoneyStatue the value for return_money.RETURN_MONEY_STATUE
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    public void setReturnMoneyStatue(Integer returnMoneyStatue) {
        this.returnMoneyStatue = returnMoneyStatue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column return_money.RETURN_MONEY_NUMBER
     *
     * @return the value of return_money.RETURN_MONEY_NUMBER
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    public String getReturnMoneyNumber() {
        return returnMoneyNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column return_money.RETURN_MONEY_NUMBER
     *
     * @param returnMoneyNumber the value for return_money.RETURN_MONEY_NUMBER
     *
     * @mbggenerated Thu Jan 28 15:38:52 CST 2016
     */
    public void setReturnMoneyNumber(String returnMoneyNumber) {
        this.returnMoneyNumber = returnMoneyNumber;
    }

    @Override public String toString() {
        return "ReturnMoney{" +
                "returnMoneyId=" + returnMoneyId +
                ", ticketId=" + ticketId +
                ", ticketReturnId=" + ticketReturnId +
                ", returnMoneyStatue=" + returnMoneyStatue +
                ", returnMoneyNumber='" + returnMoneyNumber + '\'' +
                '}';
    }
}