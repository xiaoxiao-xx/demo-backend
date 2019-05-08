package com.rainyhon.common.service;

import com.rainyhon.common.mapper.GuestMapper;
import com.rainyhon.common.model.Guest;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.rainyhon.common.constant.Constants.DELETE_STATUS_YES;

@Service
@Transactional(rollbackFor = Exception.class)
public class GuestService {

	@Autowired
	private GuestMapper guestMapper;

	public ResultVo addGuest(Guest guest) {
		String id = CommonUtil.getUUID();
		guest.setId(id);
		EntityUtils.setCreateAndUpdateInfo(guest);
		guestMapper.insert(guest);
		return ResultVo.ok();
	}

	public ResultVo delete(String id) {
		Guest guest = new Guest();
		guest.setId(id);
		guest.setDelStatus(DELETE_STATUS_YES);
		guestMapper.updateByPrimaryKeySelective(guest);
		return ResultVo.ok();
	}

	public ResultVo batchDelete(List<String> idList) {
		if (CommonUtil.isEmpty(idList)) {
			return ResultVo.ok();
		}

		idList.forEach(this::delete);

		return ResultVo.ok();
	}

}
