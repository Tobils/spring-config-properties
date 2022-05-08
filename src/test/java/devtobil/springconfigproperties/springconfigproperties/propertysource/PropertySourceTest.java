package devtobil.springconfigproperties.springconfigproperties.propertysource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(classes = PropertySourceTest.TestApplication.class)
public class PropertySourceTest {

  @SpringBootApplication
  @PropertySources({
      @PropertySource("classpath:/sample.properties")
  })
  public static class TestApplication {

    @Component
    @Getter
    public static class SampleProperties {

      @Value("${sample.name}")
      private String name;

      @Value("${sample.version}")
      private Integer version;
    }
  }

  @Autowired
  private TestApplication.SampleProperties sampleProperties;

  @Test
  void testPropertySource() {
    log.info(sampleProperties.getName());
    log.info("{}", sampleProperties.getVersion());

    Assertions.assertEquals("Sample Project", sampleProperties.getName());
    Assertions.assertEquals(1, sampleProperties.getVersion());
  }

}
