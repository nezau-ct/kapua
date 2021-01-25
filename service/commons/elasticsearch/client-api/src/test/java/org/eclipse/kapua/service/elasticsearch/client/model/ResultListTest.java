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

import java.util.ArrayList;

@Category(JUnitTests.class)
public class ResultListTest extends Assert {

    ResultList resultList;

    @Before
    public void setUp() {
        resultList = new ResultList(2);
    }

    @Test
    public void constructorTest() {
        assertEquals("Expected and actual values should be the same.", new ArrayList<>(), resultList.getResult());
        assertEquals("Expected and actual values should be the same.", 2, resultList.getTotalCount());
    }

    @Test
    public void addTest() {
        String object = "Object";
        int objectInt = 2;
        resultList.add(object);
        assertEquals("Expected and actual values should be the same.", object, resultList.getResult().get(0));
        resultList.add(objectInt);
        assertEquals("Expected and actual values should be the same.", object, resultList.getResult().get(0));
        assertEquals("Expected and actual values should be the same.", objectInt, resultList.getResult().get(1));
        resultList.add(new ArrayList<>());
        assertEquals("Expected and actual values should be the same.", new ArrayList<>(), resultList.getResult().get(2));
    }
}
