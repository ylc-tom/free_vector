package org.heystack.vector.dal;

import com.google.common.base.Preconditions;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Vector {
    private double[][] data;
    private int horizonLen;
    private int verticalLen;

    public Vector(double[][] data, int horizonLen, int verticalLen) {
        this.data = data;
        this.horizonLen = horizonLen;
        this.verticalLen = verticalLen;

        Preconditions.checkArgument(data.length == horizonLen, "Data issue of (%s, %s)", data.length, horizonLen);
        for (double[] column : data) {
            Preconditions.checkArgument(column.length == verticalLen, "Data issue of (%s, %s)", column.length, verticalLen);
        }
    }
}
