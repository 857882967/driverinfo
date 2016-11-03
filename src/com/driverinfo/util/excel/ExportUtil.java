package com.driverinfo.util.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.driverinfo.entity.EntityDriver;
import com.driverinfo.oldHibernateModel.User;


public class ExportUtil {

	
	// 导出user
	public static void ExportExcel(String[] titles, ArrayList<User> list, ServletOutputStream outputStream) {
		// 创建一个workbook 对应一个excel应用文件
		XSSFWorkbook workBook = new XSSFWorkbook();
		// 在workbook中添加一个sheet,对应Excel文件中的sheet
		// Sheet名称，可以自定义中文名称
		XSSFSheet sheet = workBook.createSheet("用户信息");
		ExportInternalUtil exportUtil = new ExportInternalUtil(workBook, sheet);
		XSSFCellStyle headStyle = exportUtil.getHeadStyle();
		XSSFCellStyle bodyStyle = exportUtil.getBodyStyle();
		// 构建表头
		XSSFRow headRow = sheet.createRow(0);
		XSSFCell cell = null;

		// 输出标题
		for (int i = 0; i < titles.length; i++) {
			cell = headRow.createCell(i);
			cell.setCellStyle(headStyle);
			cell.setCellValue(titles[i]);
		}
		// 构建表体数据
		for (int j = 0; j < list.size(); j++) {
			XSSFRow bodyRow = sheet.createRow(j + 1);
			User user = list.get(j);

			cell = bodyRow.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(user.getId());

			cell = bodyRow.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(user.getName());

			cell = bodyRow.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(user.getCname());

			cell = bodyRow.createCell(3);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(user.getCreator());

			cell = bodyRow.createCell(4);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(user.getUpdatetime());
		}

		try {
			workBook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 导出EntityDriver
	public static void ExportDriverExcel(String[] titles, List<EntityDriver> list, ServletOutputStream outputStream) {

		// 创建一个workbook 对应一个excel应用文件
		XSSFWorkbook workBook = new XSSFWorkbook();
		// 在workbook中添加一个sheet,对应Excel文件中的sheet
		// Sheet名称，可以自定义中文名称
		XSSFSheet sheet = workBook.createSheet("司机信息");
		ExportInternalUtil exportUtil = new ExportInternalUtil(workBook, sheet);
		XSSFCellStyle headStyle = exportUtil.getHeadStyle();
		XSSFCellStyle bodyStyle = exportUtil.getBodyStyle();
		// 构建表头
		XSSFRow headRow = sheet.createRow(0);
		XSSFCell cell = null;

		// 输出标题
		for (int i = 0; i < titles.length; i++) {
			cell = headRow.createCell(i);
			cell.setCellStyle(headStyle);
			cell.setCellValue(titles[i]);
		}

		// 构建表体数据
		for (int j = 0; j < list.size(); j++) {
			XSSFRow bodyRow = sheet.createRow(j + 1);
			EntityDriver driver = list.get(j);

			cell = bodyRow.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(j + 1);

			cell = bodyRow.createCell(1);
			cell.setCellStyle(bodyStyle);
		//	cell.setCellValue(driver.getChp());

			cell = bodyRow.createCell(2);
			cell.setCellStyle(bodyStyle);
		//	cell.setCellValue(driver.getSjname());

			cell = bodyRow.createCell(3);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(driver.getZgzh());

			cell = bodyRow.createCell(4);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(driver.getSfzh());

			cell = bodyRow.createCell(5);
			cell.setCellStyle(bodyStyle);
		//	cell.setCellValue(driver.getSjzz());

			cell = bodyRow.createCell(6);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(driver.getLxdh());

			cell = bodyRow.createCell(7);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(driver.getCompany());

			cell = bodyRow.createCell(8);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(driver.getUpdateTime());

		}

		try {
			workBook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
