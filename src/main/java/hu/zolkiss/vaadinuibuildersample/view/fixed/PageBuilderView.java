package hu.zolkiss.vaadinuibuildersample.view.fixed;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import hu.zolkiss.uibuilder.api.annotation.PageComponent;
import hu.zolkiss.uibuilder.api.page.PageReflectionHelper;
import hu.zolkiss.uibuilder.api.page.descriptor.ElementDescriptor;
import hu.zolkiss.uibuilder.api.util.Pair;
import hu.zolkiss.vaadinuibuildersample.view.VaadinUiBuilderMainView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Route(value = "builder/page", layout = VaadinUiBuilderMainView.class)
public class PageBuilderView extends VerticalLayout {
  private final Map<PageComponent.Category, List<Pair<PageComponent, Class<ElementDescriptor>>>> pageComponents;

  public PageBuilderView(@Autowired PageReflectionHelper pageReflectionHelper) {
    setSizeFull();
    pageComponents = pageReflectionHelper.getPageComponents();
    Accordion categories = new Accordion();
    categories.setWidth("10%");
    categories.setMaxWidth("200px");

    Arrays.stream(PageComponent.Category.values()).forEach(category -> {
      AccordionPanel panel = new AccordionPanel(category.getVisibleName(), createValues(pageComponents, category));
      panel.addThemeVariants(DetailsVariant.FILLED);
      categories.add(panel);
    });

    add(categories);
  }

  private Component createValues(Map<PageComponent.Category, List<Pair<PageComponent, Class<ElementDescriptor>>>> pageComponents, PageComponent.Category category) {
    return new VerticalLayout(
        pageComponents.getOrDefault(category, new ArrayList<>()).stream()
            .map(comp -> new Label(comp.getFirst().name()))
            .toArray(Label[]::new)
    );
  }
}