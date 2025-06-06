package com.jaspercode.banking_app.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Accounts")
@Entity
public class Account {

   @Id
   @GeneratedValue(strategy=GenerationType.UUID)
   private String id;

   @Column(name="account_holder_name")
   private String accountHolderName;
   private double balance;
   
   
}
