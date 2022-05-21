package devtobil.springconfigproperties.springconfigproperties.profileproperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import lombok.Getter;

@SpringBootTest(classes = ProfilePropertiesTest.TestApplication.class)
@ActiveProfiles({
    "production",
    "test"
})
public class ProfilePropertiesTest {

  @SpringBootApplication
  public static class TestApplication {

    @Getter
    @Component
    public static class ProfileProperties {

      @Value("{profile.default}")
      private String defaultFile;

      @Value("{profile.production}")
      private String productionFile;

      @Value("{profile.test}")
      private String testFile;

    }
  }

  @Autowired
  private TestApplication.ProfileProperties profileProperties;

  @Test
  void testProfileFiles() {
    Assertions.assertEquals("Default", profileProperties.getDefaultFile());
    Assertions.assertEquals("Production", profileProperties.getProductionFile());
    Assertions.assertEquals("Test", profileProperties.getTestFile());

  }

}
