package hu.zolkiss.vaadinuibuildersample.view.fixed;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import hu.zolkiss.vaadinuibuildersample.view.SimpleMessageView;
import hu.zolkiss.vaadinuibuildersample.view.VaadinUiBuilderMainView;

@Route(value = "home", layout = VaadinUiBuilderMainView.class)
@RouteAlias(value = "", layout = VaadinUiBuilderMainView.class)
public class Home extends SimpleMessageView {
    public Home() {
        super("HOME");
    }
}
