package hu.zolkiss.vaadinuibuildersample.view.fixed;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.*;
import hu.zolkiss.vaadinuibuildersample.view.SimpleMessageView;
import hu.zolkiss.vaadinuibuildersample.view.VaadinUiBuilderMainView;

import javax.servlet.http.HttpServletResponse;

@Route(value = "404", layout = VaadinUiBuilderMainView.class)
public class PageNotFoundView extends SimpleMessageView implements HasErrorParameter<NotFoundException> {
    public PageNotFoundView() {
        super("404 - Page not found");
    }

    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<NotFoundException> parameter) {
        add(new H1("(" + event.getLocation().getPath() + ")"));
        add(new Button("Go home", new Icon(VaadinIcon.HOME),
                buttonClickEvent -> buttonClickEvent.getSource().getUI().ifPresent(ui ->
                        ui.getPage().executeJs("window.location.replace('home');"))));
        return HttpServletResponse.SC_NOT_FOUND;
    }
}
