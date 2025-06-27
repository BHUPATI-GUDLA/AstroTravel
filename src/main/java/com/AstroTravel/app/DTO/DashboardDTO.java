package com.AstroTravel.app.DTO;

import lombok.*;

@Data
@Builder
public class DashboardDTO {

    // Order details
    private String orderId;
    private String orderCreateTime;

    // Payer details
    private String payerCountryCode;
    private String payerEmailAddress;
    private String payerFirstName;
    private String payerLastName;
    private String payerId;

    // Purchase Unit
    private String currencyCode;
    private String amount;

    // Payee details
    private String payeeEmailAddress;
    private String merchantId;

    // Transaction status
    private String transactionStatus;

    // User form input
    private String userFirstName;
    private String userLastName;
    private String userContactNumber;
    private String birthDate;
    private String birthMonth;
    private String birthYear;

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(String orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getPayerCountryCode() {
        return payerCountryCode;
    }

    public void setPayerCountryCode(String payerCountryCode) {
        this.payerCountryCode = payerCountryCode;
    }

    public String getPayerEmailAddress() {
        return payerEmailAddress;
    }

    public void setPayerEmailAddress(String payerEmailAddress) {
        this.payerEmailAddress = payerEmailAddress;
    }

    public String getPayerFirstName() {
        return payerFirstName;
    }

    public void setPayerFirstName(String payerFirstName) {
        this.payerFirstName = payerFirstName;
    }

    public String getPayerLastName() {
        return payerLastName;
    }

    public void setPayerLastName(String payerLastName) {
        this.payerLastName = payerLastName;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayeeEmailAddress() {
        return payeeEmailAddress;
    }

    public void setPayeeEmailAddress(String payeeEmailAddress) {
        this.payeeEmailAddress = payeeEmailAddress;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserContactNumber() {
        return userContactNumber;
    }

    public void setUserContactNumber(String userContactNumber) {
        this.userContactNumber = userContactNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }
}
