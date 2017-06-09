package fr.ibformation.batailleNavale;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("fr.ibformation.batailleNavale.models")
@ComponentScan
public class ConfiguationJPA {

}
