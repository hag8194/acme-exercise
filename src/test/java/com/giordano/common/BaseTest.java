package com.giordano.common;

import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public abstract class BaseTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
}
