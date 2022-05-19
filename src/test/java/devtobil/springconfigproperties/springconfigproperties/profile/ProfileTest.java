package devtobil.springconfigproperties.springconfigproperties.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(classes = ProfileTest.TestApplication.class)
@ActiveProfiles({ "production" })
@Slf4j
public class ProfileTest {

  @SpringBootApplication
  public static class TestApplication {

    public interface SayHello {
      String say(String name);
    }

    @Component
    @Profile({ "local" })
    public static class SayHelloLocal implements SayHello {

      @Override
      public String say(String name) {
        return "Hello " + name + " from local";
      }
    }

    @Component
    @Profile({ "production" })
    public static class SayHelloProduction implements SayHello {

      @Override
      public String say(String name) {
        return "Hello " + name + " from production";
      }
    }

  }

  @Autowired
  private TestApplication.SayHello sayHello;

  @Test
  void testProfile() {
    Assertions.assertEquals("Hello Tobil from production", sayHello.say("Tobil"));

    String response = sayHello.say("suhada");
    log.info(response);
  }

}
