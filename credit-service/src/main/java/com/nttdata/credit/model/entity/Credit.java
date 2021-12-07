package com.nttdata.credit.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("credit")
public class Credit {
    @Id
    private String id;
    private double amount;
    private double payment;
    private Customer customer;
    private String status;

    private Acquisition acquisition;
}
