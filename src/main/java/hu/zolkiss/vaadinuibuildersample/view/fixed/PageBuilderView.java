package hu.zolkiss.vaadinuibuildersample.view.fixed;

import com.vaadin.flow.router.Route;
import hu.zolkiss.vaadinuibuildersample.view.SimpleMessageView;
import hu.zolkiss.vaadinuibuildersample.view.VaadinUiBuilderMainView;

@Route(value = "builder/page", layout = VaadinUiBuilderMainView.class)
public class PageBuilderView extends SimpleMessageView {
    public PageBuilderView() {
        super("Page Builder (W.I.P.)");
    }
}