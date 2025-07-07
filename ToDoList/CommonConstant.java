import java.awt.*;

public class CommonConstant {
    public static final Dimension dim_size=new Dimension(540,760);
    public static final Dimension taskpanel=new Dimension(dim_size.width-30,dim_size.height-175);
    public static final Dimension button=new Dimension(dim_size.width,50);
    public static final Dimension taskField=new Dimension((int)(taskpanel.width * 0.80),50);
    public static final Dimension checkBox=new Dimension((int)(taskField.width*.05),50);
    public static final Dimension Delete=new Dimension((int)(taskField.width*.12),50);
}
