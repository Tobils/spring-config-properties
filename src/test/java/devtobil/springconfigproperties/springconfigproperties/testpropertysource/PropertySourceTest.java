package devtobil.springconfigproperties.springconfigproperties.testpropertysource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@TestPropertySources({
    @TestPropertySource("classpath:/test.properties")
})
@SpringBootTest(classes = PropertySourceTest.TestApplication.class)
public class PropertySourceTest {

  @SpringBootApplication
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

    Assertions.assertEquals("Sample Project Test", sampleProperties.getName());
    Assertions.assertEquals(1, sampleProperties.getVersion());
  }

}
