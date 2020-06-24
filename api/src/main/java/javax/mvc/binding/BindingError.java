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
package javax.mvc.binding;

/**
 * <p>Represents a single error that occurred while binding a parameter to a controller
 * method argument or controller field using a binding annotation like 
 * {@link javax.ws.rs.FormParam}.</p>
 *
 * @author Christian Kaltepoth
 * @since 1.0
 */
public interface BindingError extends ParamError {

    /**
     * Provides access to the raw submitted value of the parameter which caused the
     * binding to fail.
     *
     * @return The raw value submitted for the parameter
     */
    String getSubmittedValue();

}
