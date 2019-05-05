package com.rainyhon.task.job.v2.policy.entity;

import com.rainyhon.common.model.Face;
import com.rainyhon.common.model.Material;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 记录
 *
 * @author leizhenyang
 * @date 2019.05.01
 */
@Data
@AllArgsConstructor
public class Record {

    private String userName;

    private Face face;

    private Material material;

}
