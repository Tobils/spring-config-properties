package devtobil.springconfigproperties.springconfigproperties;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import lombok.var;

public class ResourceTest {

  @Test
  public void testResource() throws IOException {
    var resource = new ClassPathResource("/text/sample.txt");

    System.out.println(resource.getFile());

    Assertions.assertNotNull(resource);
    Assertions.assertTrue(resource.exists());
    Assertions.assertNotNull(resource.getFile());
  }

}
