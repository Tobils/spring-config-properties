package devtobil.springconfigproperties.springconfigproperties.applicationProperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(classes = ApplicationPropetiesTest.TestAppplication.class)
public class ApplicationPropetiesTest {

  @Autowired
  private Environment environment;

  @Test
  public void testApplicationProperties() {
    String message = environment.getProperty("application.name");
    log.info(message);
    Assertions.assertEquals("Learn Spring Boot Config Properties", message);
  }

  /**
   * check os environment: printenv
   */
  @Test
  public void testEnvironment() {
    String java_home = environment.getProperty("SHELL");
    log.info("SHELL {}", java_home);
  }

  @SpringBootApplication
  public static class TestAppplication {

  }

}
