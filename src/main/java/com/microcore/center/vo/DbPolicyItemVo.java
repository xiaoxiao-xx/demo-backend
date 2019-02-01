package com.microcore.center.vo;

import com.microcore.center.model.DbPolicyEncrypt;
import com.microcore.center.model.DbPolicyItem;
import com.microcore.center.model.DbPolicyTemplate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DbPolicyItemVo extends DbPolicyItem {

	private List<DbPolicyEncrypt> policyEncryptList = new ArrayList<>();

	private List<DbPolicyTemplate> policyTemplateList = new ArrayList<>();

}
