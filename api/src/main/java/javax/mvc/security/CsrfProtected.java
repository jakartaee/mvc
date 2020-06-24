/*
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
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
package javax.mvc.security;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>A controller annotation to validate a CSRF token value received
 * in a request whenever the property {@link javax.mvc.security.Csrf#CSRF_PROTECTION}
 * is set to {@link javax.mvc.security.Csrf.CsrfOptions#EXPLICIT}. If the
 * property {@link javax.mvc.security.Csrf#CSRF_PROTECTION} is set to
 * {@link javax.mvc.security.Csrf.CsrfOptions#IMPLICIT}, then the use of this
 * annotation is redundant. MVC implementations are only REQUIRED to enforce CSRF
 * for POST controllers that consume payloads of type
 * {@link javax.ws.rs.core.MediaType#APPLICATION_FORM_URLENCODED_TYPE}, but
 * other HTTP methods and payloads may be optionally supported by the
 * underlying implementation. If declared at the type level, it applies 
 * to all methods in the type.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @see javax.mvc.security.Csrf
 * @since 1.0
 */
@Target({METHOD, TYPE})
@Retention(RUNTIME)
@Documented
@Inherited
public @interface CsrfProtected {
}
