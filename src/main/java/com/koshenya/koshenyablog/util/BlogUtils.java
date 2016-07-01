package com.koshenya.koshenyablog.util;

import java.util.regex.*;

/**
 * Created by sony on 6/30/2016.
 */
public class BlogUtils {

    public final static String IMAGE_PLACEHOLDER = "<img src='getImage/%d' width=50 height=50 />";

    public static String processMessageText(String text) {

        Pattern pattern = Pattern.compile("\\{\\bImage:\\d+\\}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {

            // get the image id
            int twodotsIdx = matcher.group().indexOf(":");
            int lastBraceIdx = matcher.group().lastIndexOf("}");
            int imageId = 0;
            try {
                imageId = Integer.valueOf(matcher.group().substring(twodotsIdx+1, lastBraceIdx));
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            System.out.println(matcher.group() + ", " + imageId);

            if (imageId > 0)
                text = text.replace(matcher.group(), String.format(IMAGE_PLACEHOLDER, imageId));
        }
        return text;
    }
}
