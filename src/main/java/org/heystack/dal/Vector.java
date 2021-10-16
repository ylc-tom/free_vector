package org.heystack.dal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import javax.annotation.concurrent.Immutable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@ToString
@Immutable
@NoArgsConstructor
@Slf4j
public class Vector implements Persisted {
    private double[] data;
    private int dimension;
    @NonNull
    private Map<String, String> tags;

    public Vector(double[] data, Map<String, String> tags) {
        this.data = data;
        this.dimension = data.length;
        this.tags = tags;
    }

    public Vector(String encodedString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Vector delegate = objectMapper.readValue(encodedString, Vector.class);
            this.data = delegate.getData();
            this.dimension = delegate.getDimension();
            this.tags = delegate.getTags();
        } catch (JsonProcessingException e) {
            log.error("", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public String encode() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error("", e);
            throw new RuntimeException(e);
        }
    }
}
