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

import java.util.Map;

/**
 * <p>A map of name to model instances used by a {@link javax.mvc.engine.ViewEngine}
 * to process a view. Instances implementing this interface must be injectable using
 * {@link javax.inject.Inject} and are {@link javax.enterprise.context.RequestScoped}.
 *
 * <p>Note that certain view engines, such as engines for JSPs and Facelets, support
 * model binding via {@link javax.inject.Named} in which case the use of Models is
 * optional.
 *
 * @author Santiago Pericas-Geertsen
 * @author Christian Kaltepoth
 * @see javax.inject.Named
 * @see javax.enterprise.context.RequestScoped
 * @since 1.0
 */
public interface Models extends Iterable<String> {

    /**
     * Stores a new model in the map.
     *
     * @param name  name of the model
     * @param model model to store in the map
     * @return the current instance to allow method chaining
     */
    Models put(String name, Object model);

    /**
     * Retrieve a model by name.
     *
     * @param name name of the model
     * @return the model or <code>null</code>
     */
    Object get(String name);

    /**
     * Retrieve a model by name in a type-safe way.
     *
     * @param name  name of the model
     * @param clazz type of the model
     * @param <T>   type of the model
     * @return The model or <code>null</code>
     */
    <T> T get(String name, Class<T> clazz);

    /**
     * Returns a unmodifiable view of the models map.
     *
     * @return unmodifiable map
     */
    Map<String, Object> asMap();

}
