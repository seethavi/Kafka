package com.paras.kafka.events;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor
@ToString
public class LightningEvent {
	private String message;
    private long timestamp;
    private long voltage;
    private long longitude;
    private long lattitude;
}