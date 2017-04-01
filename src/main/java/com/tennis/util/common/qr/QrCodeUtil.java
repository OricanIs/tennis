package com.tennis.util.common.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: quchiba
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/1/2
 * @Description:
 */
public class QrCodeUtil
{
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;


	public static BufferedImage toBufferedImage(BitMatrix matrix)
	{
		int           width  = matrix.getWidth();
		int           height = matrix.getHeight();
		BufferedImage image  = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}


	public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException
	{
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, file))
		{
			throw new IOException("Could not write an image of format " + format + " to " + file);
		}
	}

	public static BufferedImage getImage(String strContent)
	{

		MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

		Map hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

		BitMatrix bitMatrix;
		try
		{
			bitMatrix = multiFormatWriter.encode(strContent, BarcodeFormat.QR_CODE, 400, 400, hints);
		} catch (Exception e)
		{
			return null;
		}

		BufferedImage bufferedImage = toBufferedImage(bitMatrix);

		return bufferedImage;

	}

	public static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException
	{
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, stream))
		{
			throw new IOException("Could not write an image of format " + format);
		}
	}

}
