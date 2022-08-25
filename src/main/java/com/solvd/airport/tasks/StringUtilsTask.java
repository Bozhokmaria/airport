package com.solvd.airport.tasks;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class StringUtilsTask {

    private static final Logger LOGGER = LogManager.getLogger(StringUtilsTask.class);

    public static void main(String[] args) {

        try {
            StringUtilsTask stringUtilsTask = new StringUtilsTask();

            File myFile = stringUtilsTask.getFile("files/electric-plane.txt");
            String text = FileUtils.readFileToString(myFile, Charsets.toCharset(StandardCharsets.UTF_8));
            LOGGER.info("Counted amount of words -  " + StringUtils.countMatches(text, "Viswanathan"));
        } catch (Exception exception){
            LOGGER.error(exception);
        }
    }

    private File getFile(String name) {
        URL url = this.getClass()
                .getClassLoader()
                .getResource(name);

        if (url == null) {
            throw new IllegalArgumentException(name + " is not found");
        }

        File file = new File(url.getFile());
        return file;
    }
}
