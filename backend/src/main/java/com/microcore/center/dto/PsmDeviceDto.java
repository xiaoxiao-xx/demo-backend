package com.microcore.center.dto;

import com.microcore.center.model.PsmDevice;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PsmDeviceDto extends PsmDevice {

    /**
     * 设备位置
     */
    private String deviceLocation;

}
