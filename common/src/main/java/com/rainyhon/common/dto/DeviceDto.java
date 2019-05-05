package com.rainyhon.common.dto;

import com.rainyhon.common.model.Device;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DeviceDto extends Device {

    /**
     * 设备位置
     */
    private String deviceLocation;

}
