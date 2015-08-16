/**
 * This file is part of ChRL Util Collection.
 * 
 * ChRL Util Collection is free software: you can redistribute it and/or
 * modify  it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * ChRL Util Collection is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with ChRL Util Collection.
 * If not, see <http://www.gnu.org/licenses/>.
 */
package at.chrl.webapps.vaadin;

import java.util.Collection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import at.chrl.nutils.CollectionUtils;
import at.chrl.nutils.Rnd;
import at.chrl.vaadin.webglobe.Webglobe;

/**
 * @author Vinzynth
 * 14.08.2015 - 23:07:54
 *
 */
@Title("ChRL Webglobe")
@Component("ui")
@Scope(value = "prototype")
@PreserveOnRefresh
public class GlobeUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
	 */
	@Override
	protected void init(VaadinRequest request) {
		
		Webglobe webglobe = new Webglobe("/webglobe/world.jpg");;
		
		Collection<double[]> data = CollectionUtils.newList();
		for (int i = 0; i < 10_000; i++) {
			data.add(new double[]{(double) Rnd.get(-90, 90), (double) Rnd.get(-180, 180), Rnd.nextDouble()});
		}
		
		webglobe.addData(data.toArray(new double[][]{}));
		
		setContent(webglobe);
		
	}

}
