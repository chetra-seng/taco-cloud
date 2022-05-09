package sia.tacocloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "taco-cloud")
@Data
public class TacoConfig {
    private int pageSize = 20;
}
