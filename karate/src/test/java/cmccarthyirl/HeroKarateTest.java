package cmccarthyirl;

import cmccarthyirl.config.AbstractTestDefinition;
import com.intuit.karate.junit5.Karate;


class HeroKarateTest extends AbstractTestDefinition {
    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }
}