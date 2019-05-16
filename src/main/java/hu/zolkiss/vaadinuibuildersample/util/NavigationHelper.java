package hu.zolkiss.vaadinuibuildersample.util;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;

public interface NavigationHelper {
    static void navigateTo(ClickEvent<? extends Component> event, Class<? extends Component> navigationClass) {
        event.getSource().getUI().ifPresent(ui -> ui.navigate(navigationClass));
    }
}
