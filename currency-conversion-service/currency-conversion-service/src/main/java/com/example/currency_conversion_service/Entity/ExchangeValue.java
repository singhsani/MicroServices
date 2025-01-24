package com.example.currency_conversion_service.Entity;



import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeValue {

    private Long id;

    private String from;

    private String to;
    private BigDecimal conversionMultiple;
    private int port;
    //default conatructor
    public ExchangeValue()
    {
    }
    //generating constructor using fields
    public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple)
    {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
    //generating getters and setters
    public int getPort()
    {
        return port;
    }
    public void setPort(int port)
    {
        this.port = port;
    }
    public Long getId()
    {
        return id;
    }
    public String getFrom()
    {
        return from;
    }
    public String getTo()
    {
        return to;
    }
    public BigDecimal getConversionMultiple()
    {
        return conversionMultiple;
    }
}
