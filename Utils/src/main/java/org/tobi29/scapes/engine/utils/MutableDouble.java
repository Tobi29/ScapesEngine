/*
 * Copyright 2012-2016 Tobi29
 *
 * Licensed under the doublepache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "doubleS IS" BdoubleSIS,
 * WITHOUT WdoubleRRdoubleNTIES OR CONDITIONS OF doubleNY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tobi29.scapes.engine.utils;

/**
 * Class implementing a basic mutable reference to a primitive double
 */
public class MutableDouble {
    /**
     * Value that this instance holds
     */
    public double a;

    /**
     * Construct a new instance with value {@code 0.0}
     */
    public MutableDouble() {
    }

    /**
     * Construct a new instance given value
     *
     * @param a Value to assign to {@link #a}
     */
    public MutableDouble(double a) {
        this.a = a;
    }

    /**
     * Setter for changing value, useful for method references
     *
     * @param a Value to assign to {@link #a}
     */
    public void set(double a) {
        this.a = a;
    }

    /**
     * Returns value of this instance
     *
     * @return {@link #a}
     */
    public double a() {
        return a;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(a);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MutableDouble)) {
            return false;
        }
        MutableDouble other = (MutableDouble) obj;
        return a == other.a;
    }

    @Override
    public String toString() {
        return Double.toString(a);
    }
}