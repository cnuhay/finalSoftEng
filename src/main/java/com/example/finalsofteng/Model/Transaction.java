package com.example.finalsofteng.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private Long transactionId;
    private String salesmanName;
    private String itemType;
    private int salesAmount;
    private Date transactionDate;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    // Constructor
    public Transaction(Long transactionId, String salesmanName, String itemType, int salesAmount, Date transactionDate) {
        this.transactionId = transactionId;
        this.salesmanName = salesmanName;
        this.itemType = itemType;
        this.salesAmount = salesAmount;
        this.transactionDate = transactionDate;
    }

    // Getter ve Setter metodları
    public Long getTransactionId() { return transactionId; }
    public String getSalesmanName() { return salesmanName; }
    public String getItemType() { return itemType; }
    public int getSalesAmount() { return salesAmount; }
    public Date getTransactionDate() { return transactionDate; }

    public void setTransactionId(Long transactionId) { this.transactionId = transactionId; }
    public void setSalesmanName(String salesmanName) { this.salesmanName = salesmanName; }
    public void setItemType(String itemType) { this.itemType = itemType; }
    public void setSalesAmount(int salesAmount) { this.salesAmount = salesAmount; }
    public void setTransactionDate(Date transactionDate) { this.transactionDate = transactionDate; }

    // Format Date to String
    public String getFormattedTransactionDate() {
        return DATE_FORMAT.format(transactionDate);
    }

    // Parse String to Date
    public static Date parseDate(String dateStr) throws ParseException {
        return DATE_FORMAT.parse(dateStr);
    }
}
