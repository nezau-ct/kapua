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
public class UpdateResponseTest extends Assert {

    UpdateResponse updateResponse;
    UpdateResponse updateResponseDescription;

    @Before
    public void setUp() {
        updateResponse = new UpdateResponse("Id", new TypeDescriptor("Index", "Type"));
        updateResponseDescription = new UpdateResponse("Id", new TypeDescriptor("Index", "Type"), "Description");
    }

    @Test
    public void constructorTest() {
        assertEquals("Expected and actual values should be the same.", "Id", updateResponse.getId());
        assertEquals("Expected and actual values should be the same.", "Index", updateResponse.getTypeDescriptor().getIndex());
        assertEquals("Expected and actual values should be the same.", "Type", updateResponse.getTypeDescriptor().getType());
        assertTrue("True expected.", updateResponse.isResult());
    }

    @Test
    public void constructorDescriptionTest() {
        assertEquals("Expected and actual values should be the same.", "Id", updateResponseDescription.getId());
        assertEquals("Expected and actual values should be the same.", "Index", updateResponseDescription.getTypeDescriptor().getIndex());
        assertEquals("Expected and actual values should be the same.", "Type", updateResponseDescription.getTypeDescriptor().getType());
        assertEquals("Expected and actual values should be the same.", "Description", updateResponseDescription.getDescription());
//        Why is here true not false?
        assertFalse("False expected.", updateResponse.isResult());
    }
    @Test
    public void getDescriptionTest() {
        assertEquals("Expected and actual values should be the same.", "Description", updateResponseDescription.getDescription());
        updateResponseDescription.setDescription("New Description");
        assertEquals("Expected and actual values should be the same.", "New Description", updateResponseDescription.getDescription());
    }
    @Test
    public void getExceptionTest() {
        assertEquals("Expected and actual values should be the same.", null, updateResponse.getException());
        Exception e = new Exception();
        updateResponse.setException(e);
        assertEquals("Expected and actual values should be the same.", e, updateResponse.getException());
    }
}