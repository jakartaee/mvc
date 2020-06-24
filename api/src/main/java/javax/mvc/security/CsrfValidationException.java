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
package javax.mvc.security;

/**
 * This exception is thrown by the MVC implementation if the CSRF token validation fails.
 * By default, this will result in a 403 status code sent to the client. The application
 * can provide a custom exception mapper for this exception type to customize this
 * default behavior.
 *
 * @author Christian Kaltepoth
 * @since 1.0
 */
public class CsrfValidationException extends RuntimeException {

    private static final long serialVersionUID = -1083828917314728056L;

    /**
     * Create a new CsrfValidationException
     *
     * @param message the detail message
     */
    public CsrfValidationException(String message) {
        super(message);
    }

}
