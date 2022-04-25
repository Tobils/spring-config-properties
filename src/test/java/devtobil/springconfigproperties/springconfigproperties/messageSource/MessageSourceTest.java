package devtobil.springconfigproperties.springconfigproperties.messageSource;

import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageSourceTest {

  private ApplicationContext applicationContext;

  private MessageSource messageSource;

  @BeforeEach
  public void setUp() {
    applicationContext = new AnnotationConfigApplicationContext(TestApplication.class);
    messageSource = applicationContext.getBean(MessageSource.class);
  }

  @Test
  public void testDefaultLocale() {
    String message = messageSource.getMessage("hello", new Object[] { "Tobil" }, Locale.ENGLISH);
    Assertions.assertEquals("Hello Tobil", message);
    log.info(message);
  }

  @Test
  public void testIndonesianLocale() {
    String message = messageSource.getMessage("hello", new Object[] { "Tobil" }, new Locale("in_ID"));
    log.info(message);
    Assertions.assertEquals("Halo Tobil", message);
  }

  /**
   * spring boot application
   */
  @SpringBootApplication
  public static class TestApplication {
    @Bean
    public MessageSource messageSource() {
      ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
      messageSource.setBasename("my");
      return messageSource;
    }
  }

}
