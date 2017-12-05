package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import entities.*;
import utils.ConnectMe;

public class WidgetDaoImp implements WidgetDao {

	@Override
	public int createWidgetForPage(int pageId, Widget widget) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<Widget> findAllWidgets() {
		final String FIND_ALL_WIDGET = "SELECT * FROM Widget;";
		Collection<Widget> widgets = new LinkedList<Widget>();
		try {
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(FIND_ALL_WIDGET);
			ResultSet rs = m.pstmt.executeQuery();
			while(rs.next()) {
				Widget w = new Widget();
				w.setId(rs.getInt("id"));
				w.setName(rs.getString("name"));
				w.setWidth(rs.getInt("width"));
				w.setHeight(rs.getInt("height"));
				w.setCssclass(rs.getString(""));
				w.setCssstyle(rs.getString(""));
				w.setText(rs.getString("text"));
				w.setOrder(rs.getInt("order"));
				w.setType(rs.getString("type"));
				widgets.add(w);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return widgets;
	}

	@Override
	public Widget findWidgetById(int widgetId) {
		final String FIND_WIDGET_ID = "SELECT * FROM Widget WHERE id = ?";
		int i = widgetId;
		Widget w = new Widget();
		try {
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(FIND_WIDGET_ID);
			m.pstmt.setInt(1, i);
			ResultSet rs = m.pstmt.executeQuery();		
			w.setId(rs.getInt("id"));
			w.setName(rs.getString("name"));
			w.setWidth(rs.getInt("width"));
			w.setHeight(rs.getInt("height"));
			w.setCssclass(rs.getString(""));
			w.setCssstyle(rs.getString(""));
			w.setText(rs.getString("text"));
			w.setOrder(rs.getInt("order"));
			w.setType(rs.getString("type"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return w;
		}

	@Override
	public Collection<Widget> findWidgetsForPage(int pageId) {
		final String FIND_ALL_WIDGET_ID = "SELECT * FROM Widget WHERE page_id = ?";
		Collection<Widget> widgets = new LinkedList<Widget>();
		int i = pageId;
		try {
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(FIND_ALL_WIDGET_ID);
			m.pstmt.setInt(1, i);
			ResultSet rs = m.pstmt.executeQuery();
			while(rs.next()) {
				Widget w = new Widget();
				w.setId(rs.getInt("id"));
				w.setName(rs.getString("name"));
				w.setWidth(rs.getInt("width"));
				w.setHeight(rs.getInt("height"));
				w.setCssclass(rs.getString(""));
				w.setCssstyle(rs.getString(""));
				w.setText(rs.getString("text"));
				w.setOrder(rs.getInt("order"));
				w.setType(rs.getString("type"));
				w.setPage_id(rs.getInt("page_id"));
				widgets.add(w);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return widgets;
		}

	@Override
	public int updateWidget(int widgetId, Widget widget) {
		int i = widgetId;
		Widget w = new Widget();
		try {
			String UPDATE_WIDGET = "UPDATE Widget SET id = ?, name = ?, width = ?, "
					+ "height = ?, cssClass = ?, cssStyle = ?, text = ?, order = ?, "
					+ "type = ?, url = ?, shareable = ?, expandable = ?, src = ?, "
					+ "size = ?, html = ?, page_id = ?) WHERE id = ?";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(UPDATE_WIDGET);
			m.pstmt.setInt(1, i);
			m.pstmt.setObject(2, w);
			m.pstmt.executeQuery();
			m.pstmt.close();
			m.conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteWidget(int widgetId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
