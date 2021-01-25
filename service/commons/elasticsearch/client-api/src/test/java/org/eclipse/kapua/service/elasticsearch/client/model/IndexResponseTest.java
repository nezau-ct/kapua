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
package org.eclipse.kapua.service.elasticsearch.client.model;

import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JUnitTests.class)
public class IndexResponseTest extends Assert {

    IndexResponse indexRequestBoolean;
    IndexResponse indexRequestStringArray;
    String[] indexes;

    @Before
    public void setUp() {
        indexRequestBoolean = new IndexResponse(true);
        indexes = new String[]{"0", "1"};
        indexRequestStringArray = new IndexResponse(indexes);
    }

    @Test
    public void constructorBooleanParameterTest() {
        assertTrue("True expected.", indexRequestBoolean.isIndexExists());
    }

    @Test
    public void constructorStringArrayParameterTest() {
        assertEquals("Expected and actual values should be the same.", "0", indexRequestStringArray.getIndexes()[0]);
        assertEquals("Expected and actual values should be the same.", "1", indexRequestStringArray.getIndexes()[1]);
    }
}