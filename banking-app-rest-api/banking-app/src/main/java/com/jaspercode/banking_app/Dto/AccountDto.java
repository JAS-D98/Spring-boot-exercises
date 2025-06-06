package com.jaspercode.banking_app.Dto;

// import lombok.AllArgsConstructor;
// import lombok.Data;

// @Data
// @AllArgsConstructor
// public class AccountDto {
//     private String id;
//     private String accountHolderName;
//     private String balance;
// }

public record AccountDto(String id, String accountHolderName, double balance){
}