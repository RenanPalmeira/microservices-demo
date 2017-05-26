package com.renanpalmeira.jinjava.utility;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class IdentityEntitiesTemplateUtility {

    /**
     * Get entities in template
     * @param template
     * @return
     */
    public List<String> getEntitiesTemplate(String template)
    {
        List<String> allMatches = new ArrayList<>();

        Matcher match = Pattern.compile("\\{\\{ ?([a-zA-Z0-9\'\"\\|\\.\\[\\]\\_ ]+) ?\\}\\}").matcher(template);

        String[] entity;

        while (match.find()) {
            entity = match.group()
                    .replaceAll("\\{\\{|\\}\\}", "")
                    .trim()
                    .split("\\.");

            if (entity.length == 0)
            {
                continue;
            }

            allMatches.add(entity[0]);
        }

        return allMatches;
    }
}