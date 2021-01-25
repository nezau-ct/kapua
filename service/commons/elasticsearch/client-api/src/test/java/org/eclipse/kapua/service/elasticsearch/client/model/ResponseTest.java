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
public class ResponseTest extends Assert {
    private class ActualResponse extends Response {

        protected ActualResponse(String id, TypeDescriptor typeDescriptor) {
            super(id, typeDescriptor);
        }
    }

    Response response;

    @Before
    public void setUp() {
        response = new ActualResponse("Id", new TypeDescriptor("Index", "Type"));
    }

    @Test
    public void constructorTest() {
        assertEquals("Expected and actual values should be the same.", "Id", response.getId());
        assertEquals("Expected and actual values should be the same.", "Index", response.getTypeDescriptor().getIndex());
        assertEquals("Expected and actual values should be the same.", "Type", response.getTypeDescriptor().getType());
    }

    @Test
    public void getIdTest() {
        assertEquals("Expected and actual values should be the same.", "Id", response.getId());
        response.setId("New ID");
        assertEquals("Expected and actual values should be the same.", "New ID", response.getId());
    }

    @Test
    public void getTypeDescriptorTest() {
        assertEquals("Expected and actual values should be the same.", "Index", response.getTypeDescriptor().getIndex());
        assertEquals("Expected and actual values should be the same.", "Type", response.getTypeDescriptor().getType());
        response.setTypeDescriptor(new TypeDescriptor("New Index", "New Type"));
        assertEquals("Expected and actual values should be the same.", "New Index", response.getTypeDescriptor().getIndex());
        assertEquals("Expected and actual values should be the same.", "New Type", response.getTypeDescriptor().getType());
    }

    @Test
    public void isResultTest() {
        response.setResult(true);
        assertTrue("True expected.", response.isResult());
        response.setResult(false);
        assertFalse("False expected.", response.isResult());
    }
}