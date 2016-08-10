package com.koshenya.koshenyablog.util;

import com.koshenya.koshenyablog.data.persistance.Comment;

import java.text.SimpleDateFormat;
import java.util.Collection;

/**
 * Created by sony on 7/5/2016.
 */
public class BackendHtmlGenerator {

    private static final String COMMENT_MAIN_OL =
            "<ol class=\"comments first_level\">\n" +
            "%s\n" +
            "</ol>";

    private static final String COMMENT_INNER_OL =
            "<ol class=\"comments\">\n" +
            "%s\n" +
            "</ol>\n";

    private static final String COMMENT_LI =
        "<li>\n" +
        "  <a name=\"c%d\"></a>" +
        "  <div class=\"comment_box commentbox2\">\n" +
        "    <div class=\"gravatar\">\n" +
        "      <img src=\"../../resources/images/avator.png\" alt=\"author 4\" />\n" +
        "    </div>\n" +
        "    <div class=\"comment_text\">\n" +
        "      <div class=\"comment_author\">%s<span class=\"date\">%s</span><span class=\"time\">%s</span></div>\n" +
        "      <p>%s</p>\n" +
        "      <div class=\"reply\"><a href=\"#c\" onclick=\"commentReplyClick(%d)\">Reply</a></div>\n" +
        "    </div>\n" +
        "    <div class=\"cleaner\"></div>\n" +
        "  </div>\n" +
        "</li>\n";

    public static String getHtmlForCommentsSection(Collection<Comment> comments) {
        StringBuffer html = new StringBuffer();
        commentsTreeWalk(comments, html);

        String resultHtml = String.format(COMMENT_MAIN_OL, html);

        return resultHtml;
    }

    private static void commentsTreeWalk(Collection<Comment> comments, StringBuffer html) {
        comments.stream().forEach(
                (action) -> {
                    html.append(
                        String.format(COMMENT_LI,
                            action.getId(),
                            action.getName(),
                            new SimpleDateFormat("dd-MM-yyyy").format(action.getCreated()),
                            new SimpleDateFormat("HH:mm").format(action.getCreated()),
                            action.getText(),
                            action.getId()
                        )
                    );

                    if (!action.getChildComments().isEmpty()) {
                        StringBuffer innerLi = new StringBuffer();
                        commentsTreeWalk(action.getChildComments(), innerLi);
                        html.append(String.format(COMMENT_INNER_OL, innerLi.toString()));
                    }
                }
        );
    }

}
