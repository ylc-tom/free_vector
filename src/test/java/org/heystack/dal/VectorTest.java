package org.heystack.dal;

import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class VectorTest {
    @Test
    void dummyVector_toString_correctness() {
        Vector vector = new Vector(new double[] {1.2d, 2.3d, 4.5d}, Collections.emptyMap());
        log.info("vector={}", vector);
        Assertions.assertNotNull(vector);
    }

    @Test
    void dummyVector_encodeAndDecode_correctness() {
        Map<String, String> tags = Maps.newHashMap();
        tags.put("a", "1");
        tags.put("b", "2");
        Vector vector = new Vector(new Vector(new double[] {1.2d, 2.3d, 4.5d}, tags).encode());
        Assertions.assertEquals(3, vector.getData().length);
        Assertions.assertEquals(3, vector.getDimension());
        Assertions.assertEquals(2, vector.getTags().size());
    }
}
