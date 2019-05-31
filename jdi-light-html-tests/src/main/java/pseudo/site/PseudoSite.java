package pseudo.site;

import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import pseudo.site.pages.*;
import pseudo.site.sections.CustomSection;
import pseudo.site.sections.ExtendedSection;
import pseudo.site.sections.Header;
import pseudo.site.sections.LocatorsSection;


public class PseudoSite {
    public static Header header;
    @UI(".customSectionUI")
    public static CustomSection customSectionUI;
    public static CustomSection customSection;
    @UI(".extendedSectionUI")
    public static ExtendedSection extendedSectionUI;
    public static ExtendedSection extendedSection;
    public static LocatorsSection locatorsSection;
    @Url("pagewithurl.com")
    public static PageWithURL pageWithURL;
    @Url("/pagewithurl.com")
    public static PageWithURL slashPageWithURL;
    @Title("Page with Title")
    public static PageWithTitle pageWithTitle;
    @Url("pagewithboth.com")
    @Title("Page with both")
    public static PageWithBoth pageWithBoth;
    public static PageWithoutBoth pageWithoutBoth;
    @Frame("iframe")
    public static CustomIFrame iframe;
}
