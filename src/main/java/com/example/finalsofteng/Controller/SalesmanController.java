package com.example.finalsofteng.Controller;

import com.example.finalsofteng.Entity.SalesmanEntity;
import com.example.finalsofteng.Service.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class SalesmanController {
    //github link: https://github.com/cnuhay/finalSoftEng
    @Autowired
    private SalesmanService salesmanService;

    @GetMapping("/sales")
    public String getSalesPage(Model model) {
        List<SalesmanEntity> transactions = salesmanService.getAllTransactions();
        model.addAttribute("transactions", transactions);

        model.addAttribute("currentDate", LocalDate.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Prepare sales summary data
        Map<String, Map<String, Integer>> salesSummaryMap = new HashMap<>();
        for (SalesmanEntity transaction : transactions) {
            String salesmanName = transaction.getSalesmanName();
            String itemType = transaction.getItemType();
            int amount = transaction.getSalesAmount();

            salesSummaryMap
                    .computeIfAbsent(salesmanName, k -> new HashMap<>())
                    .merge(itemType, amount, Integer::sum);
        }

        List<Map<String, Object>> salesSummaries = salesSummaryMap.entrySet().stream()
                .map(entry -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("salesmanName", entry.getKey());
                    map.put("washingMachineSales", entry.getValue().getOrDefault("Washing Machine", 0));
                    map.put("refrigeratorSales", entry.getValue().getOrDefault("Refrigerator", 0));
                    map.put("musicSystemSales", entry.getValue().getOrDefault("Music System", 0));
                    return map;
                })
                .collect(Collectors.toList());

        model.addAttribute("salesSummaries", salesSummaries);

        List<Map<String, Object>> formattedTransactions = transactions.stream()
                .map(transaction -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("transactionId", transaction.getTransactionId());
                    map.put("salesmanName", transaction.getSalesmanName());
                    map.put("itemType", transaction.getItemType());
                    map.put("salesAmount", transaction.getSalesAmount());
                    map.put("transactionDate", transaction.getTransactionDate().format(formatter));
                    return map;
                })
                .collect(Collectors.toList());

        model.addAttribute("formattedTransactions", formattedTransactions);

        return "sales"; // 'sales.html' şablonunu döndür
    }

    @PostMapping("/saveTransaction")
    public String saveTransaction(@ModelAttribute SalesmanEntity salesmanEntity) {
        salesmanService.saveTransaction(salesmanEntity);
        return "redirect:/sales";
    }
    @GetMapping("/editTransaction/{id}")
    public String editTransaction(@PathVariable("id") Long id, Model model) {
        SalesmanEntity transaction = salesmanService.getTransactionById(id);
        model.addAttribute("transaction", transaction);
        return "edit-transaction"; // 'edit-transaction.html' şablonunu döndür
    }

    @PostMapping("/updateTransaction")
    public String updateTransaction(@ModelAttribute SalesmanEntity transaction) {
        salesmanService.updateTransaction(transaction);
        return "redirect:/sales"; // Güncellenmiş verilerle Sales sayfasına dön
    }
    @PostMapping("/deleteTransaction")
    public String deleteTransaction(@RequestParam Long transactionId) {
        salesmanService.deleteTransaction(transactionId);
        return "redirect:/sales";
    }
}
