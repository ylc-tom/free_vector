package org.heystack.dal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class VectorTest {
    @Test
    void dummyVector_toString_correctness() {
        Vector vector = new Vector(new double[][] {
            new double[] {1.2d, 2.3d, 4.5d},
            new double[] {8.0d, 0.1d, 0.3d},
        }, 2, 3);
        log.info("vector={}", vector);
    }

    @Test
    void invalidVector_toString_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            new Vector(new double[][] {
                new double[] {1.2d, 2.3d, 4.5d},
                new double[] {0.1d, 0.3d},
            }, 2, 3);
        });
    }
}
