package com.rainyhon.common.vo;

import com.rainyhon.common.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserVo extends User {

	private List<String> roleIdList;

}
