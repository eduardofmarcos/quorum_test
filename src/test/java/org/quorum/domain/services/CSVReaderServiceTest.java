package org.quorum.domain.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
class CSVReaderServiceTest {

  @Inject
  CSVReaderService csvReaderService;

  @Test
  void testReadCSVWithCorruptedFile() {
    String corruptedFilePath = "src/test/resources/corrupted.csv";

    createCorruptedCSV(corruptedFilePath);

    RuntimeException exception = assertThrows(RuntimeException.class, () -> {
      csvReaderService.readCSV(corruptedFilePath, TestModel.class);
    });

    Assertions.assertTrue(exception.getMessage().contains("Error reading CSV file"));
  }

  private void createCorruptedCSV(String filePath) {
    try {
      Path path = Paths.get(filePath);
      Files.createDirectories(path.getParent());
      Files.write(path, "id,name\n1,John\n2,Mary\ninvalid_row".getBytes());
    } catch (Exception e) {
      throw new RuntimeException("Failed to create corrupted CSV file for testing.", e);
    }
  }

  public static class TestModel {

    private int id;
    private String name;

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}