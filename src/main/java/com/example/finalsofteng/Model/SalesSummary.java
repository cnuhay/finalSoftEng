package com.example.finalsofteng.Model;

public class SalesSummary {
    private String salesmanName;
    private int washingMachineSales;
    private int refrigeratorSales;
    private int musicSystemSales;

    // Constructor, Getter ve Setter metodları
    public SalesSummary(String salesmanName, int washingMachineSales, int refrigeratorSales, int musicSystemSales) {
        this.salesmanName = salesmanName;
        this.washingMachineSales = washingMachineSales;
        this.refrigeratorSales = refrigeratorSales;
        this.musicSystemSales = musicSystemSales;
    }

    // Getter ve Setter metodları burada yer alacak
    public String getSalesmanName() { return salesmanName; }
    public int getWashingMachineSales() { return washingMachineSales; }
    public int getRefrigeratorSales() { return refrigeratorSales; }
    public int getMusicSystemSales() { return musicSystemSales; }

    public void setSalesmanName(String salesmanName) { this.salesmanName = salesmanName; }
    public void setWashingMachineSales(int washingMachineSales) { this.washingMachineSales = washingMachineSales; }
    public void setRefrigeratorSales(int refrigeratorSales) { this.refrigeratorSales = refrigeratorSales; }
    public void setMusicSystemSales(int musicSystemSales) { this.musicSystemSales = musicSystemSales; }
}
