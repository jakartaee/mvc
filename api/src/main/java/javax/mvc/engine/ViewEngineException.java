/*
 * Copyright (c) 2015 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2016-2017 JSR 371 expert group and contributors
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
package javax.mvc.engine;

/**
 * <p>Exception thrown by {@link javax.mvc.engine.ViewEngine#processView(ViewEngineContext)}
 * when unable to process a view.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @see Exception#getMessage()
 * @see Exception#getCause()
 * @since 1.0
 */
public class ViewEngineException extends Exception {

    private static final long serialVersionUID = -429507729780110056L;

    /**
     * Construct an instance using a message.
     *
     * @param message the message.
     */
    public ViewEngineException(String message) {
        super(message);
    }

    /**
     * Construct an instance using a message and a cause.
     *
     * @param message the message.
     * @param cause the underlying cause.
     */
    public ViewEngineException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct an instance using a cause.
     *
     * @param cause the underlying cause.
     */
    public ViewEngineException(Throwable cause) {
        super(cause);
    }
}
