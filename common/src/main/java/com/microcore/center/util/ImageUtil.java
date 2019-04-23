package com.microcore.center.util;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 *
 */
public class ImageUtil {

	/**
	 * 对图片裁剪，并把裁剪完的新图片保存
	 * 剪切点坐标 x y;
	 * 剪切点宽度 width height
	 */
	public static byte[] cut(byte[] buffer, int x, int y, int width, int height) {
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);
		ImageInputStream imageInputStream = null;

		try {
			// 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。
			// 参数：formatName - 包含非正式格式名称 (例如 "jpeg" 或 "tiff")等 。
			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("jpeg");
			ImageReader reader = it.next();
			// 获取图片流
			imageInputStream = ImageIO.createImageInputStream(byteArrayInputStream);
			// iis:读取源。true:只向前搜索
			// 将它标记为 ‘只向前搜索’。
			// 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader
			// 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
			reader.setInput(imageInputStream, true);
			// 描述如何对流进行解码的类
			// 用于指定如何在输入时从 Java Image I/O
			// 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件
			// 将从其 ImageReader 实现的 getDefaultReadParam 方法中返回
			// ImageReadParam 的实例。
			ImageReadParam param = reader.getDefaultReadParam();
			// 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
			// 的左上顶点的坐标(x，y)、宽度和高度可以定义这个区域。
			Rectangle rect = new Rectangle(x, y, width, height);
			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);
			// 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将
			// 它作为一个完整的 BufferedImage 返回。
			BufferedImage bi = reader.read(0, param);

			// 保存新图片
			// ImageIO.write(bi, "jpg", new File(subpath));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bi, "jpg", baos);
			baos.flush();

			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (byteArrayInputStream != null) {
				try {
					byteArrayInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (imageInputStream != null) {
				try {
					imageInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return new byte[] {};
	}

}

