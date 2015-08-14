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
package at.chrl.webapps;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import com.vaadin.server.VaadinServlet;

import at.chrl.spring.config.AbstractWebAppInitializer;
import at.chrl.spring.config.ApplicationConfig;
import at.chrl.spring.config.WebMvcConfig;
import at.chrl.webapps.vaadin.GlobeUI;
import ru.xpoft.vaadin.SpringUIProvider;
import ru.xpoft.vaadin.SpringVaadinServlet;

/**
 * @author Vinzynth
 * 14.08.2015 - 22:59:05
 *
 */
public class WebglobeInitializer extends AbstractWebAppInitializer {

	/**
	 * {@inheritDoc}
	 * @see at.chrl.spring.config.AbstractWebAppInitializer#registerOtherVaadinServlet(javax.servlet.ServletContext)
	 */
	@Override
	protected void registerOtherVaadinServlet(ServletContext servletContext) {
		VaadinServlet vaadinServlet = new SpringVaadinServlet();
		ServletRegistration.Dynamic vaadinServletRegistration = servletContext.addServlet("Globe", vaadinServlet);
		vaadinServletRegistration.setInitParameter("ui", GlobeUI.class.getName());
		vaadinServletRegistration.setInitParameter("UIProvider", SpringUIProvider.class.getName());
		vaadinServletRegistration.setLoadOnStartup(1);
		vaadinServletRegistration.addMapping("/globe/*");
		vaadinServletRegistration.addMapping("/VAADIN/*");
		vaadinServletRegistration.setAsyncSupported(true);
	}

	/**
	 * {@inheritDoc}
	 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses()
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{ SpringConfig.class , ApplicationConfig.class};
	}
	
	/**
	 * {@inheritDoc}
	 * @see at.chrl.spring.config.AbstractWebAppInitializer#getServletConfigClasses()
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{ WebMvcConfig.class, SpringConfig.class };
	}

}
