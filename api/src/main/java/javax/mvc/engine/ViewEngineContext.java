/*
 * Copyright (c) 2015 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2016-2018 JSR 371 expert group and contributors
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */
package javax.mvc.engine;

import javax.mvc.Models;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import java.io.OutputStream;
import java.util.Locale;

/**
 * <p>Contextual data used by a {@link javax.mvc.engine.ViewEngine} to process a view.
 * This includes the view name, the models instance and the request and response
 * objects from the container, among other data.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @author Christian Kaltepoth
 * @see javax.mvc.engine.ViewEngine
 * @since 1.0
 */
public interface ViewEngineContext {

    /**
     * Returns the view.
     *
     * @return the view.
     */
    String getView();

    /**
     * Returns the models instance needed to process the view.
     *
     * @return the models instance.
     */
    Models getModels();

    /**
     * Returns the request locale resolved for the current request.
     *
     * @return the request locale
     */
    Locale getLocale();

    /**
     * Returns the HTTP request object from the container. The type of the request object
     * depends on the environment. In a servlet environment you can use this method to get
     * the <code>HttpServletRequest</code> object.
     *
     * @param type The expected type of the HTTP request object.
     * @param <T>  The expected type of the HTTP request object
     * @return HTTP request object.
     */
    <T> T getRequest(Class<T> type);

    /**
     * <p>Returns the HTTP response object from the container. The type of the response object
     * depends on the environment. In a servlet environment you can use this method to get
     * the <code>HttpServletResponse</code> object.</p>
     *
     * <p>Please note that you should generally prefer using {@link #getOutputStream()}
     * and {@link #getResponseHeaders()} to write the result of processing the view, because
     * these methods are guaranteed to work in all supported environments.</p>
     *
     * @param type The expected type of the HTTP response object.
     * @param <T>  The expected type of the HTTP request object
     * @return HTTP response object.
     */
    <T> T getResponse(Class<T> type);

    /**
     * Get the mutable response headers multivalued map. This map can be modified
     * to change the HTTP response headers. Please note that changing the map will only have
     * an effect on the headers if modifications are performed before data is written
     * to the output stream obtained from {@link #getOutputStream()}.
     *
     * @return mutable multivalued map of response headers.
     */
    MultivaluedMap<String, Object> getResponseHeaders();

    /**
     * The output stream which should be used to write the result of processing a view.
     *
     * @return The output stream
     */
    OutputStream getOutputStream();

    /**
     * The media type to use for the response. Please note that {@link ViewEngine}
     * implementations should respect the <i>charset</i> parameter of the media type when
     * writing data to the output stream obtained from {@link #getOutputStream()}.
     *
     * @return The media type
     */
    MediaType getMediaType();

    /**
     * Returns the {@link javax.ws.rs.core.UriInfo} instance containing information
     * about the current request URI.
     *
     * @return the URI info for the current request.
     * @see javax.ws.rs.core.UriInfo
     */
    UriInfo getUriInfo();

    /**
     * Returns the {@link javax.ws.rs.container.ResourceInfo} instance containing
     * information about the controller method matched in the current request.
     *
     * @return the resource info for the current request.
     * @see javax.ws.rs.container.ResourceInfo
     */
    ResourceInfo getResourceInfo();

    /**
     * Returns the application's configuration. The configuration provides access
     * to properties such as {@link javax.mvc.engine.ViewEngine#VIEW_FOLDER}, which
     * view engines must use to locate views.
     *
     * @return application's configuration.
     * @see javax.ws.rs.core.Configuration
     */
    Configuration getConfiguration();
}
