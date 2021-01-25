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
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JUnitTests.class)
public class ElasticsearchNodeTest extends Assert {

    ElasticsearchNode elasticsearchNode;

    @Test
    public void constructorGetAddressPortTest() {
        elasticsearchNode = new ElasticsearchNode("Address", 1);
        assertThat("Instance of ElasticsearchNode expected.", elasticsearchNode, IsInstanceOf.instanceOf(ElasticsearchNode.class));
        assertEquals("Expected and actual value should be the same.", "Address", elasticsearchNode.getAddress());
        assertEquals("Expected and actual value should be the same.", 1, elasticsearchNode.getPort());
    }

    @Test
    public void toStringTest() {
        elasticsearchNode = new ElasticsearchNode("Address", 1);
        assertEquals("Expected and actual value should be the same.", "Address:1", elasticsearchNode.toString());
    }
}