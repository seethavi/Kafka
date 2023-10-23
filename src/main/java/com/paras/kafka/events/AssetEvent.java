package com.paras.kafka.events;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AssetEvent {
    private String assetID;
    private long lattitude;
    private long longitude;
    private boolean isConstrained;
    
}
