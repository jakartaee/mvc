/*
 * Copyright (c) 2015 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2016-2018 JSR 371 expert group and contributors
 * Copyright (c) 2020 Contributors to the Eclipse Foundation
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
package jakarta.mvc.event;

import jakarta.mvc.engine.ViewEngine;

/**
 * <p>Event fired after a view engine has been selected but before its
 * {@link jakarta.mvc.engine.ViewEngine#processView(jakarta.mvc.engine.ViewEngineContext)}
 * method is called. Must be fired after {@link jakarta.mvc.event.ControllerRedirectEvent},
 * or if that event is not fired, after {@link jakarta.mvc.event.AfterControllerEvent}.</p>
 *
 * <p>For example:
 * <pre><code>    public class EventObserver {
 *         public void beforeProcessView(&#64;Observes BeforeProcessViewEvent e) {
 *            ...
 *        }
 *    }</code></pre>
 *
 * @author Santiago Pericas-Geertsen
 * @see javax.enterprise.event.Observes
 * @since 1.0
 */
public interface BeforeProcessViewEvent extends MvcEvent {

    /**
     * Returns the view being processed.
     *
     * @return the view.
     */
    String getView();

    /**
    * Returns the {@link jakarta.mvc.engine.ViewEngine} selected by the implementation.
            *
            * @return the view engine selected.
            */
    Class<? extends ViewEngine> getEngine();
}
