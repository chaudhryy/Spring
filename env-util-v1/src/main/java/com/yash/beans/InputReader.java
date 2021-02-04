package com.yash.beans;

import org.jline.reader.LineReader;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class InputReader {

    private static final Character DEFAULT_MASK = '*';

    private Character mask = '*';

    @Lazy
    private LineReader lineReader;


    public String prompt(String prompt) {
        return prompt(prompt, true);
    }

    public String prompt(String prompt, boolean echo) {
        String answer;
        if (echo) {
            answer = lineReader.readLine(prompt + ": ");
        } else {
            answer = lineReader.readLine(prompt + ": ", mask);
        }
        return answer;
    }
}
