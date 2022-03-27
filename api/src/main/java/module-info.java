/**
 * Copyright (c) 2022 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: (secondary) GPL-2.0 with
 * Classpath-exception-2.0 which is available at
 * https://openjdk.java.net/legal/gplv2+ce.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0-only with
 * Classpath-exception-2.0
 */
module jakarta.mvc {

    exports jakarta.mvc.binding;
    exports jakarta.mvc.engine;
    exports jakarta.mvc.event;
    exports jakarta.mvc.form;
    exports jakarta.mvc.locale;
    exports jakarta.mvc.security;

    requires jakarta.annotation;
    requires jakarta.cdi;
    requires jakarta.validation;
    requires jakarta.ws.rs;
}