package devtobil.springconfigproperties.springconfigproperties.configurattionproperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import devtobil.springconfigproperties.springconfigproperties.properties.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest(classes = ConfigurationPropertiesTest.TestApplication.class)
@Slf4j
public class ConfigurationPropertiesTest {

  @SpringBootApplication
  @EnableConfigurationProperties({
      ApplicationProperties.class /** autobinding */
  })
  public static class TestApplication {
  }

  @Autowired
  private ApplicationProperties properties;

  @Test
  void testConfigurationProperties() {
    Assertions.assertEquals("Learn Spring Boot Config Properties", properties.getName());
    Assertions.assertEquals(1, properties.getVersion());
    Assertions.assertEquals(false, properties.isProductionMode());

    log.info(properties.getName());
    log.info("version {}", properties.getVersion());
    log.info("mode {}", properties.isProductionMode());

  }
}
