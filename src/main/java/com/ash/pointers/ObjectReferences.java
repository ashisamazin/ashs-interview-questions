package com.ash.pointers;

public class ObjectReferences {

	private ObjectReferences ref;

	public static ObjectReferences getObjects() {
		//a, b and c are all allocated on the heap as they are new objects
		ObjectReferences a = new ObjectReferences();
		ObjectReferences b = new ObjectReferences();
		ObjectReferences c = new ObjectReferences();

		//b now has two references to the object, one from the pointer b, and one from a.ref
		a.setRef(b);
		//c now also has two references to it
		b.setRef(c);

		//b will now just have one reference to it (from a.ref)
		b = null;
		//c will also now just have one reference to it (b.ref)
		c = null;
		
		//all three objects are still referenced, by the path a.ref == b and a.ref.ref == c.
		//therefore none can be garbage collected
		return a;
	}

	public void setRef(ObjectReferences ref) {
		this.ref = ref;
	}

	public ObjectReferences getRef() {
		return ref;
	}

}
