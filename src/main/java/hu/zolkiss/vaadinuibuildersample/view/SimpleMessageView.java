package hu.zolkiss.vaadinuibuildersample.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class SimpleMessageView extends VerticalLayout {
    public SimpleMessageView(String visibleText) {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        setSizeFull();
        add(new H1(visibleText));
    }
}
