package devtobil.springconfigproperties.springconfigproperties.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties("application")
public class ApplicationProperties {

  private String name;

  private Integer version;

  private boolean productionMode;

}
