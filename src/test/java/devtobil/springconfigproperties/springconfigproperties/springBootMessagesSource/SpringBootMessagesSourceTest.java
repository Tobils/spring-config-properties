package devtobil.springconfigproperties.springconfigproperties.springBootMessagesSource;

import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import devtobil.springconfigproperties.springconfigproperties.resourceloader.ResourceLoaderTest.TestApplication;
import devtobil.springconfigproperties.springconfigproperties.springBootMessagesSource.SpringBootMessagesSourceTest.TestApplication.SampleSource;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(classes = SpringBootMessagesSourceTest.TestApplication.class)
public class SpringBootMessagesSourceTest {

  @Autowired
  private SampleSource sampleResource;

  @Test
  public void testHello() {
    log.info(sampleResource.helloTobil(Locale.ENGLISH));
    log.info(sampleResource.helloTobil(new Locale("in_ID")));
    Assertions.assertEquals("Hello Tobil", sampleResource.helloTobil(Locale.ENGLISH));
    Assertions.assertEquals("Halo Tobil", sampleResource.helloTobil(new Locale("in_ID")));
  }

  @SpringBootApplication
  public static class TestApplication {

    @Component
    public static class SampleSource implements MessageSourceAware {

      @Setter
      private MessageSource messageSource;

      public String helloTobil(Locale locale) {
        return messageSource.getMessage("hello", new Object[] { "Tobil" }, locale);
      }

    }
  }

}
