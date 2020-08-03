package com.foxminded.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SystemOutputStream {
    private final ByteArrayOutputStream output;

    public SystemOutputStream() {
        output = new ByteArrayOutputStream();
    }

    public void great() {
        System.setOut(new PrintStream(output));
    }

    //possible name destroy
    public void setNull() {
        System.setOut(null);
    }

    public String getOutputAsString() {
        return output.toString();
    }
}
