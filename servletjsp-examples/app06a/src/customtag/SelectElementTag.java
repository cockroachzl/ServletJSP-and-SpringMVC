package customtag;
import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectElementTag extends SimpleTagSupport {
    private String[] countries = {"Australia", "Brazil", "China", "United States" };

    public void doTag() throws IOException, JspException {
        JspContext jspContext = getJspContext();
        JspWriter out = jspContext.getOut();
        out.print("<select>\n");
        for (int i=0; i<countries.length; i++) {
            getJspContext().setAttribute("value", countries[i]);
            getJspContext().setAttribute("text", countries[i]);
            getJspBody().invoke(null);
        }
        out.print("</select>\n");
    }
}
