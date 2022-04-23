package devtobil.springconfigproperties.springconfigproperties.resourceloader;

import java.io.InputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(classes = ResourceLoaderTest.TestApplication.class)
public class ResourceLoaderTest {

  @Autowired
  private TestApplication.SampleResource sampleResource;

  @Test
  public void testResourceLoader() throws Exception {
    Assertions.assertEquals("ini merupakan file untuk implementasi resource loader", sampleResource.getText().trim());
    log.info(sampleResource.getText().trim());
  }

  @SpringBootApplication
  public static class TestApplication {

    @Component
    public static class SampleResource implements ResourceLoaderAware {

      @Setter
      private ResourceLoader resourceLoader;

      public String getText() throws Exception {
        Resource resource = resourceLoader.getResource("classpath:/text/resource.txt");
        try (InputStream inputStream = resource.getInputStream()) {
          return new String(inputStream.readAllBytes());
        }
      }

    }

  }

}
