package com.cmccarthyirl;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeKarateTests {

    @Test
    void testParallel() {
        Results results = Runner.path("classpath:com/cmccarthyirl").tags("~@ignore").parallel(5);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}