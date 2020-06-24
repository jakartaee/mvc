/*
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2016-2019 JSR 371 expert group and contributors
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
 * Cross Site Request Forgery (CSRF) interface with access to the CSRF header name
 * and the CSRF token value. Implementations of this interface are injectable
 * and accessible from EL via the {@link javax.mvc.MvcContext} class as {@code mvc.csrf}.
 *
 * @author Santiago Pericas-Geertsen
 * @author Christian Kaltepoth
 * @see CsrfProtected
 * @since 1.0
 */
public interface Csrf {

    /**
     * Property that can be used to globally enable CSRF protection for an application.
     * Values of this property must be of type {@link Csrf.CsrfOptions}.
     */
    String CSRF_PROTECTION = "javax.mvc.security.CsrfProtection";

    /**
     * Property that can be used to configure the name of the HTTP header used for
     * the CSRF token.
     */
    String CSRF_HEADER_NAME = "javax.mvc.security.CsrfHeaderName";

    /**
     * The default value for {@link #CSRF_HEADER_NAME}.
     */
    String DEFAULT_CSRF_HEADER_NAME = "X-CSRF-TOKEN";
    
    /**
     * Options for property {@link Csrf#CSRF_PROTECTION}.
     */
    enum CsrfOptions {
        /**
         * CSRF protection not enabled.
         */
        OFF,
        /**
         * Enabling CSRF requires use of {@link CsrfProtected} explicitly (default).
         */
        EXPLICIT,
        /**
         * CSRF enabled automatically for all controllers.
         */
        IMPLICIT
    };

    /**
     * Returns the name of the CSRF form field or HTTP request header. This name is typically a constant.
     *
     * @return name of CSRF header.
     */
    String getName();

    /**
     * Returns the value of the CSRF token.
     *
     * @return value of CSRF token.
     */
    String getToken();
}
