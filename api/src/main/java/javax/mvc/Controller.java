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

import javax.ws.rs.NameBinding;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

/**
 * <p>Declares a method as a controller. If declared at the type level,
 * it applies to all methods in the type.</p>
 *
 * <p>A controller method that returns void is required to be annotated with
 * {@link View}. A controller method can return a view path
 * as a {@link java.lang.String} or a {@link javax.ws.rs.core.Response}. If a controller
 * returns {@code null} and it is annotated with {@link View},
 * then the value of this annotation is used as a default.</p>
 *
 * <p>Example:
 * <pre><code>
 *     &#64;Controller
 *     public String sayHello() {
 *         return "hello.jsp";
 *     }
 * </code></pre>
 *
 * @author Santiago Pericas-Geertsen
 * @see View
 * @see javax.ws.rs.core.Response
 * @since 1.0
 */
@NameBinding
@Target( { METHOD, TYPE } )
@Retention( RUNTIME )
@Documented
@Inherited
public @interface Controller {
}

