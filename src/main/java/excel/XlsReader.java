package excel;

import enums.StudyProfile;
import objects.Student;
import objects.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsReader {
    private static final Logger logger = Logger.getLogger(XlsReader.class.getName());

    private XlsReader() {
    }

    public static List<University> readUniversities() {
        List<University> universities = new ArrayList<>();
        try {
            logger.log(Level.INFO, "Start reading sheet Universities from Excel");
            FileInputStream file = new FileInputStream(new File("src\\main\\resources\\universityInfo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(1);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                University university = new University();
                universities.add(university);
                university.setId(row.getCell(0).getStringCellValue());
                university.setFullName(row.getCell(1).getStringCellValue());
                university.setShortName(row.getCell(2).getStringCellValue());
                university.setYearOfFoundation((int) row.getCell(3).getNumericCellValue());
                university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, row.getCell(4).getStringCellValue()));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading Excel", e);
        }
        logger.log(Level.INFO, "End of reading sheet Universities from Excel");
        return universities;
    }

    public static List<Student> readStudents() {
        List<Student> students = new ArrayList<>();
        try {
            logger.log(Level.INFO, "Start reading sheet Students from Excel");
            FileInputStream file = new FileInputStream(new File("src\\main\\resources\\universityInfo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Student student = new Student();
                students.add(student);
                student.setUniversityId(row.getCell(0).getStringCellValue());
                student.setFullName(row.getCell(1).getStringCellValue());
                student.setCurrentCourseNumber((int) row.getCell(2).getNumericCellValue());
                student.setAvgExamScore((float) row.getCell(3).getNumericCellValue());
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading Excel", e);
        }
        logger.log(Level.INFO, "End of reading sheet Students from Excel");
        return students;
    }
}