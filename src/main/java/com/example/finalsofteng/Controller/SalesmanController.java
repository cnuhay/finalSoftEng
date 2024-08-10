package com.example.finalsofteng.Controller;

import com.example.finalsofteng.Model.SalesSummary;
import com.example.finalsofteng.Model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SalesmanController {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");


    // Statik veri oluşturma
    private List<SalesSummary> getSampleSalesSummaries() {
        List<SalesSummary> summaries = new ArrayList<>();
        summaries.add(new SalesSummary("John Doe", 10, 5, 8));
        summaries.add(new SalesSummary("Jane Smith", 6, 9, 3));
        summaries.add(new SalesSummary("Mike Johnson", 3, 7, 5));
        return summaries;
    }

    private List<Transaction> getSampleTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try {
            transactions.add(new Transaction(1L, "John Doe", "Washing Machine", 3, DATE_FORMAT.parse("2024-08-10")));
            transactions.add(new Transaction(2L, "Jane Smith", "Refrigerator", 2, DATE_FORMAT.parse("2024-08-09")));
            transactions.add(new Transaction(3L, "Mike Johnson", "Music System", 1, DATE_FORMAT.parse("2024-08-08")));
        } catch (ParseException e) {
            e.printStackTrace(); // Hata ayıklama amacıyla, gerçek uygulamada loglama yapılmalı
        }
        return transactions;
    }

    // Sales Page
    @GetMapping("/sales")
    public String getSalesPage(Model model) {
        // Statik sales summary data
        List<SalesSummary> salesSummaries = getSampleSalesSummaries();
        model.addAttribute("salesSummaries", salesSummaries);

        // Statik transactions data
        List<Transaction> transactions = getSampleTransactions();
        model.addAttribute("transactions", transactions);

        return "sales";  // 'sales.html' şablonunu döndür
    }

    // Form'dan gelen veriyi işleme (Şimdilik sadece yönlendirme yapıyoruz)
    @PostMapping("/saveTransaction")
    public String saveTransaction(@ModelAttribute Transaction transaction) {
        // Şu an için kaydetme işlemi yapılmıyor, sadece sales sayfasına geri dönüyoruz
        return "redirect:/sales";
    }
}
