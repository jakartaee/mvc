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
 * Interface that provides encoders to <em>escape</em> code in JavaScript, HTML,
 * etc. Encoding data is a way to prevent XSS attacks by ensuring it is not
 * misinterpreted as running code. Implementations of this interface are injectable
 * and accessible from EL via the {@link javax.mvc.MvcContext} class as {@code mvc.encoders}.
 *
 * @author Santiago Pericas-Geertsen
 * @see <a href="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project">OWASP Encoder Project</a>
 * @since 1.0
 */
public interface Encoders {

    /**
     * <p>Encoding for JavaScript code in attributes or script blocks. It MUST support
     * encoding of (at least) the following characters:</p>
     *
     * <table>
     * <caption>Encoding Table</caption>
     * <thead>
     * <tr><th>Input Character</th><th>Encoding</th></tr>
     * </thead>
     * <tbody>
     * <tr><td>U+0008 (BS)</td><td>\b</td></tr>
     * <tr><td>U+0009 (HT)</td><td>\t</td></tr>
     * <tr><td>U+000A (LF)</td><td>\n</td></tr>
     * <tr><td>U+000C (FF)</td><td>\f</td></tr>
     * <tr><td>U+000D (CR)</td><td>\r</td></tr>
     * <tr><td>/</td><td>\/</td></tr>
     * <tr><td>\</td><td>\\</td></tr>
     * <tr><td>"</td><td>\x22</td></tr>
     * <tr><td>&amp;</td><td>\x26</td></tr>
     * <tr><td>'</td><td>\x27</td></tr>
     * <tr><td>U+0000-U001F</td><td>\x##</td></tr>
     * </tbody>
     * </table>
     *
     * @param s string to encode.
     * @return encoded string.
     */
    String js(String s);

    /**
     * <p>Encoding for HTML code in attributes or content. It MUST support encoding of
     * (at least) the following characters:</p>
     *
     * <table>
     * <caption>Encoding Table</caption>
     * <thead>
     * <tr><th>Input Character</th><th>Encoding</th></tr>
     * </thead>
     * <tbody>
     * <tr><td>&amp;</td><td>&amp;amp;</td></tr>
     * <tr><td>&lt;</td><td>&amp;lt;</td></tr>
     * <tr><td>&gt;</td><td>&amp;gt;</td></tr>
     * <tr><td>"</td><td>&amp;#34;</td></tr>
     * <tr><td>'</td><td>&amp;#39;</td></tr>
     * </tbody>
     * </table>
     *
     * @param s string to encode.
     * @return encoded string.
     */
    String html(String s);
}
