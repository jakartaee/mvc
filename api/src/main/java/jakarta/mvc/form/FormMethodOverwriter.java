/*
 * Copyright (c) 2022 Contributors to the Eclipse Foundation
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
package jakarta.mvc.form;

/**
 * <p>Form method overwriter is used to overwrite a HTML form's HTTP method to be able to use
 * other verbs such as {@code PATCH} or {@code DELETE}.
 * </p>
 * 
 * @author Tobias Erdle
 * @since 2.1
 */
public final class FormMethodOverwriter {
    
    /**
     * Property that can be used to enable the Form method overwrite mechanism for an application.
     * Values of this property must be of type {@link FormMethodOverwriter.Options}.
     */
    public static final String FORM_METHOD_OVERWRITE = "jakarta.mvc.form.FormMethodOverwrite";

    /**
     * Property that can be used to configure the name of the hidden form input to get the targeted HTTP method.
     */
    public static final String HIDDEN_FIELD_NAME = "jakarta.mvc.form.HiddenFieldName";
    
    /**
     * The default name of the hidden form field used to overwrite the HTTP method.
     */
    public static final String DEFAULT_HIDDEN_FIELD_NAME = "_method";

    /**
     * Options for property {@link FormMethodOverwriter#FORM_METHOD_OVERWRITE}.
     */
    public enum Options {
        /**
         * Form method overwrite is not enabled.
         */
        DISABLED,

        /**
         * Form method overwrite is enabled. Each request will be checked for potential overwrites.
         */
        ENABLED
    }
}
