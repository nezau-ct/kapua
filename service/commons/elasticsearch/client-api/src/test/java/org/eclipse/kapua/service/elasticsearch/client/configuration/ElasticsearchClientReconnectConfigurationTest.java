/*******************************************************************************
 * Copyright (c) 2021 Eurotech and/or its affiliates and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.elasticsearch.client.configuration;

import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JUnitTests.class)
public class ElasticsearchClientReconnectConfigurationTest extends Assert {

    ElasticsearchClientReconnectConfiguration elasticsearchClientReconnectConfiguration;

    @Before
    public void setUp() {
        elasticsearchClientReconnectConfiguration = new ElasticsearchClientReconnectConfiguration();
    }

    @Test
    public void getReconnectDelayTest() {
        assertEquals("Expected and actual values should be the same.", 30000, elasticsearchClientReconnectConfiguration.getReconnectDelay());
        elasticsearchClientReconnectConfiguration.setReconnectDelay(0);
        assertEquals("Expected and actual values should be the same.", 0, elasticsearchClientReconnectConfiguration.getReconnectDelay());
    }
}
