package com.accunity.reusable.model;

import com.adobe.cq.sightly.WCMUse;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;
import com.day.cq.wcm.foundation.Navigation;
import java.io.IOException;
import java.io.PrintWriter;


public class GrandMenuComponent extends WCMUse{
    private PrintWriter out;
    public PrintWriter getOut() {
        return out;
    }
    public void setOut(PrintWriter out) {
        this.out = out;
    }
    @Override
    public void activate() throws Exception {
        setOut(getResponse().getWriter());
        if(getProperties().get("category", String.class).equals("automatic"))
            automaticNavigationList();
        else
            manualNavigationList(getOut());
    }
    public void manualNavigationList(PrintWriter out) {
        //need to implement
    }
    public void automaticNavigationList() {
        try {
            Page page = getPageManager().getPage(getProperties().get("path").toString());
            Integer depth = getProperties().get("depth", Integer.class);
            drawNavigationList(getOut(), page,depth);
        } catch (IOException exception) {
            out.print(exception.getMessage());
        }
    }
    public void drawNavigationList(PrintWriter out, Page page,Integer depth ) throws IOException {
        Navigation navigation = new Navigation(page, 0, new PageFilter(), depth);
        out.print("<div class=\"topnav\">\n" +
                "    <div class=\"left_curve\">\n" +
                "        <div class=\"right_curve\">\n" +
                "            <ul id=\"topnav\">");

        for (Navigation.Element e : navigation) {
            switch (e.getType()) {
                case NODE_OPEN:
                    out.print("<ul>");
                    break;
                case ITEM_BEGIN:
                    if (e.hasChildren())
                        out.println("<li class='noleaf'><a href = '" + e.getPath() + ".html' class=''>" + e.getTitle() + "</a>");
                    else
                        out.println("<li><a href = '" + e.getPath() + ".html' class=''>" + e.getTitle() + "</a>");
                    break;
                case ITEM_END:
                    out.print("</li>");
                    break;
                case NODE_CLOSE:
                    out.print("</ul>");
                    break;
            }
        }
        out.println("<li class=\"sep1\">&nbsp;</li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>");
    }
}
