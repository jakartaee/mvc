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
package jakarta.mvc.engine;

/**
 * <p>View engines are responsible for processing views and are discovered
 * using Jakarta Contexts and Dependency Injection. Implementations must look up all instances of this interface,
 * and process a view as follows:
 * <ol>
 *     <li>Gather the set of candidate view engines by calling {@link #supports(String)}
 *     and discarding engines that return <code>false</code>.</li>
 *     <li>Sort the resulting set of candidates using priorities. View engines
 *     can be decorated with {@link jakarta.annotation.Priority} to indicate
 *     their priority; otherwise the priority is assumed to be {@link ViewEngine#PRIORITY_APPLICATION}.</li>
 *     <li>If more than one candidate is available, choose one in an
 *     implementation-defined manner.</li>
 *     <li>Fire a {@link jakarta.mvc.event.BeforeProcessViewEvent} event.</li>
 *     <li>Call method {@link #processView(ViewEngineContext)} to process view.</li>
 *     <li>Fire a {@link jakarta.mvc.event.AfterProcessViewEvent} event.</li>
 * </ol>
 * <p>The default view engine for Jakarta Server Pages uses file extensions to determine
 * support. Namely, the default Jakarta Server Pages view engine supports views with extensions <code>jsp</code>
 * and <code>jspx</code>.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @author Ivar Grimstad
 * @see jakarta.annotation.Priority
 * @see jakarta.mvc.event.BeforeProcessViewEvent
 * @since 1.0
 */
@SuppressWarnings("unused")
public interface ViewEngine {

    /**
     * Name of property that can be set to override the root location for views in an archive.
     *
     * @see jakarta.ws.rs.core.Application#getProperties()
     */
    String VIEW_FOLDER = "jakarta.mvc.engine.ViewEngine.viewFolder";

    /**
     * The default view file extension that is used to fetch templates. For example, if this setting is set to <code>.jsp</code>,
     * instead of returning <code>index.jsp</code> only <code>index</code> is required.
     *
     * @see jakarta.ws.rs.core.Application#getProperties()
     */
    String VIEW_EXTENSION = "jakarta.mvc.engine.ViewEngine.defaultViewFileExtension";

    /**
     * Default value for property {@link #VIEW_FOLDER}.
     */
    String DEFAULT_VIEW_FOLDER = "/WEB-INF/views/";

    /**
     * Priority for all built-in view engines.
     */
    int PRIORITY_BUILTIN = 1000;

    /**
     * Recommended priority for all view engines provided by frameworks built
     * on top of MVC implementations.
     */
    int PRIORITY_FRAMEWORK = 2000;

    /**
     * Recommended priority for all application-provided view engines (default).
     */
    int PRIORITY_APPLICATION = 3000;

    /**
     * Returns <code>true</code> if this engine can process the view or <code>false</code>
     * otherwise.
     *
     * @param view the view.
     * @return outcome of supports test.
     */
    boolean supports(String view);

    /**
     * <p>Process a view given a {@link jakarta.mvc.engine.ViewEngineContext}. Processing
     * a view involves <i>merging</i> the model and template data and writing
     * the result to an output stream.</p>
     *
     * <p>Following the Jakarta EE threading model, the underlying view engine implementation
     * must support this method being called by different threads. Any resources allocated
     * during view processing must be released before the method returns.</p>
     *
     * @param context the context needed for processing.
     * @throws ViewEngineException if an error occurs during processing.
     */
    void processView(ViewEngineContext context) throws ViewEngineException;
}
