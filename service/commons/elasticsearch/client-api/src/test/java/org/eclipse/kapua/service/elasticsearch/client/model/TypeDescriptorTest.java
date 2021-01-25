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
public class TypeDescriptorTest extends Assert {

    TypeDescriptor typeDescriptorEmpty;
    TypeDescriptor typeDescriptor;

    @Before
    public void setUp() {
        typeDescriptorEmpty = new TypeDescriptor();
        typeDescriptor = new TypeDescriptor("Index", "Type");
    }

    @Test
    public void constructorTest() {
        assertNull("Null expected", typeDescriptorEmpty.getIndex());
        assertNull("Null expected", typeDescriptorEmpty.getType());
        assertEquals("Expected and actual values should be the same.", "Index", typeDescriptor.getIndex());
        assertEquals("Expected and actual values should be the same.", "Type", typeDescriptor.getType());
    }


    @Test
    public void getIndexTest() {
        assertNull("Null expected", typeDescriptorEmpty.getIndex());
        assertEquals("Expected and actual values should be the same.", "Index", typeDescriptor.getIndex());
        typeDescriptorEmpty.setIndex("NotNullIndex");
        typeDescriptor.setIndex("New Index");
        assertEquals("Expected and actual values should be the same.", "NotNullIndex", typeDescriptorEmpty.getIndex());
        assertEquals("Expected and actual values should be the same.", "New Index", typeDescriptor.getIndex());
    }

    @Test
    public void getTypeTest() {
        assertNull("Null expected", typeDescriptorEmpty.getType());
        assertEquals("Expected and actual values should be the same.", "Type", typeDescriptor.getType());
        typeDescriptorEmpty.setType("NotNullType");
        typeDescriptor.setType("New Type");
        assertEquals("Expected and actual values should be the same.", "NotNullType", typeDescriptorEmpty.getType());
        assertEquals("Expected and actual values should be the same.", "New Type", typeDescriptor.getType());
    }
}