package hu.zolkiss.vaadinuibuildersample.view.fixed;

import com.vaadin.flow.router.Route;
import hu.zolkiss.vaadinuibuildersample.view.SimpleMessageView;
import hu.zolkiss.vaadinuibuildersample.view.VaadinUiBuilderMainView;

@Route(value = "builder/menu", layout = VaadinUiBuilderMainView.class)
public class MenuBuilderView extends SimpleMessageView {
    public MenuBuilderView() {
        super("Menu Builder (W.I.P.)");
    }
}
