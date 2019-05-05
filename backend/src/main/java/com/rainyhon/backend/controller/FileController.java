package com.rainyhon.backend.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rainyhon.common.service.FileService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.vo.ResultVo;

@RestController
@RequestMapping("file")
public class FileController {

	@Value("${sls.FILE_PATH}")
	private String filePath;

	@Autowired
	private FileService fileService;

	// TODO
	@PostMapping("fileUpload")
	@ResponseBody
	public ResultVo fileUpload(@RequestParam("fileName") MultipartFile multipartFile) {
		if (multipartFile.isEmpty()) {
			return ResultVo.fail("文件不能为空！");
		}

		// 用UUID重新命名上传的文件
		String fileId = CommonUtil.getUUID();
		String fileName = multipartFile.getOriginalFilename();
		String newFileName = fileId + "." + getSuffix(fileName);
		File destFile = new File(filePath + "/" + newFileName);

		if (!destFile.getParentFile().exists()) { // 判断文件父目录是否存在
			destFile.getParentFile().mkdir();
		}

		try {
			multipartFile.transferTo(destFile); // 保存文件

			com.rainyhon.common.model.File file = new com.rainyhon.common.model.File();
			file.setId(fileId);
			file.setOldFileName(fileName);
			file.setSuffix(getSuffix(fileName));
			file.setStoreFileName(newFileName);
			file.setCrtDate(CommonUtil.getCurrentTime());
			fileService.add(file);

			return ResultVo.ok(newFileName);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return ResultVo.fail("文件上传失败！");
		}
	}

	private String getSuffix(String fileName) {
		String[] names = fileName.split("\\.");
		return names[names.length - 1];
	}

}
