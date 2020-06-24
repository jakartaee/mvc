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
package javax.mvc;

import javax.mvc.security.Csrf;
import javax.mvc.security.Encoders;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Locale;
import java.util.Map;

/**
 * <p>This class provides contextual information such as context and application
 * paths as well as access to the JAX-RS application configuration object.
 * In addition, it provides access to the security-related beans {@link
 * javax.mvc.security.Csrf} and {@link javax.mvc.security.Encoders}.</p>
 *
 * <p>Implementations of this class are injectable, must be
 * {@link javax.enterprise.context.RequestScoped} and accessible from EL using
 * the name {@code mvc}. For example, the CSRF token name and value can be
 * accessed in EL using the expressions {@code mvc.csrf.name} and {@code
 * mvc.csrf.token}, respectively.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @see javax.ws.rs.core.Configuration
 * @since 1.0
 */
public interface MvcContext {

    /**
     * Get the JAX-RS application configuration object. All application-defined properties
     * are accessible via this object.
     *
     * @return the configuration object.
     */
    Configuration getConfig();

    /**
     * <p>Get the application's base path which is defined as the concatenation of context
     * and application paths. It follows that the value returned by this method always
     * starts with a slash but never ends with one.</p>
     *
     * @return the application's base path.
     */
    String getBasePath();

    /**
     * Get the CSRF object.
     *
     * @return the CSRF object.
     */
    Csrf getCsrf();

    /**
     * Get the built-in encoders.
     *
     * @return instance of encoders.
     */
    Encoders getEncoders();

    /**
     * Returns the locale of the current request.
     *
     * @return The request locale
     */
    Locale getLocale();

    /**
     * <p>Creates an URI to be matched by a controller method. This is aimed primarily
     * for use in view rendering technologies to avoid duplicating the values of the
     * {@link javax.ws.rs.Path} annotations.</p>
     *
     * <p>The controller method can either be identified by the simple name of the controller class
     * and the method name separated by '#' (MyController#myMethod) <em>or</em> by the value
     * of the {@link UriRef} annotation.</p>
     *
     * <p>The created URI includes context- and application path.</p>
     *
     * <p>This method assumes that there is no parameter in the URI-template.</p>
     *
     * <p>For example in JSP:</p>
     * <pre><code>${mvc.uri('MyController#myMethod')}</code></pre>
     *
     * @param identifier for the controller method.
     * @return the constructed URI including context- and application path.
     */
    URI uri(String identifier);

    /**
     * <p>Creates an URI to be matched by a controller method. This is aimed primarily
     * for use in view rendering technologies to avoid duplicating the values of the
     * {@link javax.ws.rs.Path} annotations.</p>
     *
     * <p>The controller method can either be identified by the simple name of the controller class
     * and the method name separated by '#' (MyController#myMethod) <em>or</em> by the value
     * of the {@link UriRef} annotation.</p>
     *
     * <p>The created URI includes context- and application path.</p>
     *
     * <p>Any {@link javax.ws.rs.PathParam}, {@link javax.ws.rs.QueryParam}
     * and {@link javax.ws.rs.MatrixParam} which could apply for given target
     * method will be replaced if a matching key is found in the supplied Map.
     * Please note that the map must contain values for all path parameters
     * as they are required for building the URI. All other parameters are optional.</p>
     * 
     * <p>For example in JSP:</p>
     * <pre><code>${mvc.uri('MyController#myMethod', {'foo': 'bar', 'id': 42})}</code></pre>
     *
     * @param identifier for the controller method.
     * @param params a map of path-, query- and matrix parameters.
     * @return the constructed URI including context- and application path.
     * @throws IllegalArgumentException if there are any URI template parameters without a supplied value, or if a value is {@code null}.
     */
    URI uri(String identifier, Map<String, Object> params);

    /**
     * <p>Returns a {@link UriBuilder} for building URIs to be matched
     * by a controller method. This is aimed primarily for use in Java classes.</p>
     *
     * <p>The controller method can either be identified by the simple name of the controller class
     * and the method name separated by '#' (MyController#myMethod) <em>or</em> by the value
     * of the {@link UriRef} annotation.</p>
     *
     * @param identifier for the controller method.
     * @return a reference to a {@link UriBuilder}.
     */
    UriBuilder uriBuilder(String identifier);

}
