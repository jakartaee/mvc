/*
 * Copyright (c) 2018 JSR 371 expert group and contributors
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
 * Base interface for errors related to parameter data binding
 *
 * @author Christian Kaltepoth
 * @since 1.0
 */
public interface ParamError {

    /**
     * Returns a human-readable error message for this error.
     *
     * @return The human-readable error message
     */
    String getMessage();

    /**
     * The parameter name of the value that caused the error. This is usually
     * the name specified in the binding annotation (i.e. {@link javax.ws.rs.FormParam}).
     *
     * @return The name of the parameter which caused the error
     */
    String getParamName();

}
