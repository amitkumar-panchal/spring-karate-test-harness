package cmccarthyirl.config;

import cmccarthyirl.StartLocalServer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {KarateContextConfiguration.class, StartLocalServer.class})
@SpringBootTest
public class AbstractTestDefinition {
}