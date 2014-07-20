package com.ash.pointers;

import junit.framework.Assert;

import org.junit.Test;

public class ObjectReferencesTest {

	@Test
	public void test() {
		ObjectReferences references = ObjectReferences.getObjects();

		Assert.assertNotNull(references.getRef());
		Assert.assertNotNull(references.getRef().getRef());

	}

}
