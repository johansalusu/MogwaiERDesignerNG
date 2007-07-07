/**
 * Mogwai ERDesigner. Copyright (C) 2002 The Mogwai Project.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package de.mogwai.erdesignerng.visual.cells;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Map;

import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.DefaultPort;
import org.jgraph.graph.GraphConstants;

import de.mogwai.erdesignerng.model.Table;

public class TableCell extends DefaultGraphCell implements ModelCell<Table> {

	public TableCell(Table aTable) {
		super(aTable);

		GraphConstants.setBounds(getAttributes(), new Rectangle2D.Double(20,
				20, 40, 20));
		GraphConstants.setGradientColor(getAttributes(), Color.orange);
		GraphConstants.setOpaque(getAttributes(), true);
		GraphConstants.setAutoSize(getAttributes(), true);
		GraphConstants.setEditable(getAttributes(), true);
		DefaultPort thePort = new DefaultPort();
		add(thePort);
	}

	public void transferAttributesToProperties(Map aAttributes) {

		Table theTable = (Table) getUserObject();
		Rectangle2D theBounds = GraphConstants.getBounds(aAttributes);
		String theLocation = ((int) theBounds.getX()) + ":"
				+ ((int) theBounds.getY());
		theTable.setProperty(Table.PROPERTY_LOCATION, theLocation);
	}

	public void transferPropertiesToAttributes(Table aObject) {

		Point2D thePoint = TransferHelper.createPoint2DFromString(aObject
				.getProperty(aObject.PROPERTY_LOCATION));
		if (thePoint != null) {
			GraphConstants.setBounds(getAttributes(), new Rectangle2D.Double(
					thePoint.getX(), thePoint.getY(), -1, -1));
		}
	}
}