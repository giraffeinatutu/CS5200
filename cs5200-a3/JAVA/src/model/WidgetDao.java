package model;
import entities.*;
import java.util.*;

public interface WidgetDao {
	int createWidgetForPage(int pageId, Widget widget);
	Collection<Widget> findAllWidgets();
	Widget findWidgetById(int widgetId);
	Collection<Widget> findWidgetsForPage(int pageId);
	int updateWidget(int widgetId, Widget widget);
	int deleteWidget(int widgetId);
}
