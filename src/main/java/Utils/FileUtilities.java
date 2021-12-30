package Utils;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtilities {
    public static String createExcelFileForRaceEvent(int numberOfTeams, int numberOfRowers, int numberOfErgs, String eventName, int length, int splits, String folderName) throws IOException {
        //workbook and sheet creation;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Race Data");
        //border cell style creation -> we want them red and glowy
        CellStyle styleForBorderCells = workbook.createCellStyle();
        styleForBorderCells.setFillBackgroundColor(IndexedColors.RED.getIndex());
        styleForBorderCells.setFillForegroundColor(IndexedColors.RED.getIndex());
        styleForBorderCells.setFillPattern((short)2);
        styleForBorderCells.setFillPattern(CellStyle.BIG_SPOTS);


        int j = 0;
        //info rows creation
        XSSFRow infoLabelsRow = sheet.createRow(j++); // creating first row with info labels
        int ilRowCol = 0;
        infoLabelsRow.createCell(ilRowCol++).setCellValue("Race event name");
        infoLabelsRow.createCell(ilRowCol++).setCellValue("Race distance");
        infoLabelsRow.createCell(ilRowCol++).setCellValue("Number of splits");
        infoLabelsRow.createCell(ilRowCol++).setCellValue("Number of ergs");
        infoLabelsRow.createCell(ilRowCol++).setCellValue("Number of Teams");
        infoLabelsRow.createCell(ilRowCol++).setCellValue("Number of Rowers");

        XSSFRow infoDataRow = sheet.createRow(j++); // creating row with data labels
        int idRowCol = 0;
        infoDataRow.createCell(idRowCol++).setCellValue(eventName);
        infoDataRow.createCell(idRowCol++).setCellValue(length);
        infoDataRow.createCell(idRowCol++).setCellValue(splits);
        infoDataRow.createCell(idRowCol++).setCellValue(numberOfErgs);
        infoDataRow.createCell(idRowCol++).setCellValue(numberOfTeams);
        infoDataRow.createCell(idRowCol++).setCellValue(numberOfRowers);

        //creating first border row manually;
        XSSFRow row = sheet.createRow(j++);
        row.createCell(0).setCellValue("Team Name");
        row.getCell(0).setCellStyle(styleForBorderCells);
        row.createCell(1).setCellValue("Team Abbreviation");
        row.getCell(1).setCellStyle(styleForBorderCells);


        int i = 2;
        for (i = 2; i < numberOfRowers+2; i++) {
            row.createCell(i).setCellValue("Rower_".concat(String.valueOf(i-1)));
            row.getCell(i).setCellStyle(styleForBorderCells);
        }
        row.createCell(i).setCellValue("######");
        row.getCell(i).setCellStyle(styleForBorderCells);

        //creating border next to data cells;
        for (; j < numberOfTeams+3; j++) {
            sheet.createRow(j);
            sheet.getRow(j).createCell(numberOfRowers+2).setCellValue("#######");
            sheet.getRow(j).getCell(numberOfRowers+2).setCellStyle(styleForBorderCells);
        }
        XSSFRow lastDataRow = sheet.createRow(j++);
        for (int k = 0; k < numberOfRowers+3; k++) {
            lastDataRow.createCell(k).setCellValue("########");
            lastDataRow.getCell(k).setCellStyle(styleForBorderCells);
        }

        //comment creation
        XSSFDrawing drawing = sheet.createDrawingPatriarch();
        XSSFClientAnchor anchor = drawing.createAnchor(0,0,0,0,numberOfRowers+3,numberOfTeams+1,numberOfRowers+7,numberOfTeams+5);
        XSSFComment cmt = drawing.createCellComment(anchor);
        cmt.setVisible(true);
        cmt.setString("You may only edit inside the red border. Please add team names, team abbreviations and rower names.\n You will use this file to create .rac files later");



        //making columns fit the text
        for (int k = 0; k < numberOfRowers + 2; k++) {
            sheet.autoSizeColumn(k);
        }

        //Create file system using specific name
        FileOutputStream out = new FileOutputStream(new File(folderName.concat(eventName).concat(".xlsx")));

        //write operation workbook using file out object
        workbook.write(out);
        return eventName;
    }
}
