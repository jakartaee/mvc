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

import java.util.List;
import java.util.Set;

/**
 * <p>Describes the binding result of all controller fields and controller
 * method parameters which are annotated with a binding annotation like
 * {@link javax.ws.rs.FormParam}.</p>
 *
 * <p>A binding can fail because of type conversion issues or in case of validation
 * errors. The former can for example happen if the binding annotation is placed on
 * a numeric type but the value cannot be converted to that type. The latter may be
 * caused by constraint violations detected during validation.
 * </p>
 *
 * <p>Controller methods which declare a parameter of this type will be executed
 * even if the binding for fields and method parameters fails.</p>
 *
 * @author Christian Kaltepoth
 * @since 1.0
 */
public interface BindingResult {

    /**
     * Returns <code>true</code> if there is at least one parameter error.
     *
     * @return <code>true</code> if there is at least one parameter error
     */
    boolean isFailed();

    /**
     * Returns an immutable list of all messages representing both binding and
     * validation errors. This method is a shortcut for:
     *
     * <pre>
     * getAllErrors().stream().map(ParamError::getMessage).collect(Collectors.toList())
     * </pre>
     *
     * @return A list of human-readable messages
     */
    List<String> getAllMessages();

    /**
     * Returns an immutable set of all binding and validation errors.
     *
     * @return All binding and validation errors.
     */
    Set<ParamError> getAllErrors();

    /**
     * Returns an immutable set of all binding and validation errors for
     * a specific parameter.
     *
     * @param param parameter name
     * @return All binding and validation errors for the parameter.
     */
    Set<ParamError> getErrors(String param);

}
