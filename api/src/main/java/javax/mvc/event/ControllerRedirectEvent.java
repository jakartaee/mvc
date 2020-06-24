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
package javax.mvc.event;

import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * <p>Event fired when a controller triggers a redirect. Only the
 * status codes 301 (moved permanently), 302 (found), 303 (see other) and
 * 307 (temporary redirect) are REQUIRED to be reported. Note that the
 * JAX-RS methods
 * {@link javax.ws.rs.core.Response#seeOther(java.net.URI)}} and
 * {@link javax.ws.rs.core.Response#temporaryRedirect(java.net.URI)}}
 * use the status codes to 303 and 307, respectively. Must be
 * fired after {@link javax.mvc.event.AfterControllerEvent}.</p>
 *
 * <p>For example:
 * <pre><code>    public class EventObserver {
 *         public void onControllerRedirect(&#64;Observes ControllerRedirectEvent e) {
 *            ...
 *        }
 *    }</code></pre>
 *
 * @author Santiago Pericas-Geertsen
 * @see javax.enterprise.event.Observes
 * @since 1.0
 */
public interface ControllerRedirectEvent extends MvcEvent {

    /**
     * Access to the current request URI information.
     *
     * @return URI info.
     * @see javax.ws.rs.core.UriInfo
     */
    UriInfo getUriInfo();

    /**
     * Access to the current request controller information.
     *
     * @return resources info.
     * @see javax.ws.rs.container.ResourceInfo
     */
    ResourceInfo getResourceInfo();

    /**
     * The target of the redirection.
     *
     * @return URI of redirection.
     */
    URI getLocation();
}
