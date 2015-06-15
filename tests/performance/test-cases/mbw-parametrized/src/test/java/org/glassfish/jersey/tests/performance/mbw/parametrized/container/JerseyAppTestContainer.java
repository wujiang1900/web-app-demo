/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package org.glassfish.jersey.tests.performance.mbw.parametrized.container;

import java.net.URI;
import java.util.logging.Logger;

import javax.ws.rs.ProcessingException;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.spi.TestContainer;
import org.glassfish.jersey.tests.performance.mbw.parametrized.JerseyApp;

/**
 * Simple container that executes {@link org.glassfish.jersey.tests.performance.mbw.parametrized.JerseyApp} before
 * the test start and stop it after the test finishes. It is used to test functionality of {@code JerseyApp} and
 * therefore it is initialized from command line arguments (part of the test is to make sure that command line
 * argument parsing works well).
 *
 * @author Miroslav Fuksa
 */
public class JerseyAppTestContainer implements TestContainer {

    private final URI baseUri;
    private final JerseyApp jerseyApp;
    private final String[] args;
    private static final Logger LOGGER = Logger.getLogger(JerseyAppTestContainer.class.getName());

    public JerseyAppTestContainer(URI baseUri, String args[]) {
        jerseyApp = new JerseyApp();
        this.baseUri = baseUri;
        this.args = args;
    }

    @Override
    public ClientConfig getClientConfig() {
        return null;
    }

    @Override
    public URI getBaseUri() {
        return baseUri;
    }

    @Override
    public void start() {
        LOGGER.info("Starting JerseyApp...");
        try {
            jerseyApp.start(args);
        } catch (Exception e) {
            throw new ProcessingException(e);
        }
    }

    @Override
    public void stop() {
        jerseyApp.stop();
        LOGGER.info("JerseyApp stopped.");
    }
}
