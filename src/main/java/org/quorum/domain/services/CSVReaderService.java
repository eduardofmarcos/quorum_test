package org.quorum.domain.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Service for reading CSV files and mapping their contents to Java objects. Utilizes OpenCSV for
 * parsing and mapping.
 */
@ApplicationScoped
public class CSVReaderService {

  /**
   * Reads a CSV file and maps its contents to a list of objects of the specified class type.
   *
   * @param filePath the path to the CSV file
   * @param clazz    the class type to map the CSV rows to
   * @param <T>      the type parameter corresponding to the class type
   * @return a list of objects mapped from the CSV file
   * @throws RuntimeException if an error occurs while reading or parsing the CSV file
   */
  public <T> List<T> readCSV(String filePath, Class<T> clazz) {
    try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
      CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
          .withType(clazz)
          .withIgnoreLeadingWhiteSpace(true)
          .build();
      return csvToBean.parse();
    } catch (Exception e) {
      throw new RuntimeException("Error reading CSV file: " + filePath, e);
    }
  }
}