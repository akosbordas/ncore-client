package com.github.akosbordas.ncore;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class TestBase {

    protected String readHtml(String name) throws IOException {
        return IOUtils.toString(this.getClass().getResourceAsStream(name), "UTF-8");

    }

}
