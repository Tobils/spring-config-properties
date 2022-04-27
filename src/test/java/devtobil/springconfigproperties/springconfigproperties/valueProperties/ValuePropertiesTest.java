package devtobil.springconfigproperties.springconfigproperties.valueProperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(classes = ValuePropertiesTest.TestApplicationProperties.class)
public class ValuePropertiesTest {

  @Autowired
  private TestApplicationProperties.ApplicationProperties applicationProperties;

  @Test
  public void testValue() {
    log.info("app-name \t\t\t {}", applicationProperties.getName());
    log.info("app-version \t\t {}", applicationProperties.getVersion());
    log.info("app-isProd \t\t {}", applicationProperties.isProductionMode());

    Assertions.assertEquals("Learn Spring Boot Config Properties", applicationProperties.getName());
    Assertions.assertEquals(1, applicationProperties.getVersion());
    Assertions.assertEquals(false, applicationProperties.isProductionMode());
  }

  @SpringBootApplication
  public static class TestApplicationProperties {

    @Component
    @Getter
    public static class ApplicationProperties {

      private static final String $_APPLICATION_NAME = "${application.name}";
      private static final String $_APPLICATION_VERSION = "${application.version}";
      private static final String $_APPLICATION_PRODUCTION_MODE = "${application.production-mode}";

      @Value($_APPLICATION_NAME)
      private String name;

      @Value($_APPLICATION_VERSION)
      private Integer version;

      @Value($_APPLICATION_PRODUCTION_MODE)
      private boolean productionMode;
    }
  }

}
