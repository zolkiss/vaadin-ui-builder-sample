package hu.zolkiss.vaadinuibuildersample.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import hu.zolkiss.vaadinuibuildersample.view.fixed.Home;
import hu.zolkiss.vaadinuibuildersample.view.fixed.MenuBuilderView;
import hu.zolkiss.vaadinuibuildersample.view.fixed.PageBuilderView;

import static hu.zolkiss.vaadinuibuildersample.util.NavigationHelper.navigateTo;

@Theme(value = Lumo.class, variant = Lumo.DARK)
public class VaadinUiBuilderMainView extends VerticalLayout implements RouterLayout {

    public VaadinUiBuilderMainView() {
        setSizeFull();
        setPadding(false);
        add(createMenuBar());
        add(createFooter());
    }

    private static HorizontalLayout createFooter() {
        HorizontalLayout footerLayout = new HorizontalLayout();
        footerLayout.setWidthFull();
        footerLayout.setDefaultVerticalComponentAlignment(Alignment.START);
        footerLayout.add(new H1("Epic Footer Layout"));
        return footerLayout;
    }

    private static MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.addItem(new Icon(VaadinIcon.HOME), event -> event.getSource().getUI().ifPresent(ui -> ui.navigate(Home.class)));
        createBuilderMenus(menuBar);
        return menuBar;
    }

    private static void createBuilderMenus(MenuBar menuBar) {
        MenuItem builderMenu = menuBar.addItem("Editors");
        builderMenu.getSubMenu().addItem("Menu editor", event -> navigateTo(event, MenuBuilderView.class));
        builderMenu.getSubMenu().addItem("Page editor", event -> navigateTo(event, PageBuilderView.class));
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        if (content instanceof Component) {
            Component componentContent = (Component) content;
            addComponentAtIndex(1, componentContent);
            if (componentContent instanceof HasSize) {
                ((HasSize) componentContent).setSizeFull();
            }
        }
    }
}
