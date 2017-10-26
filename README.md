# Yasson generic collection wrapper bug

When trying to serialize objects:

```
public class CollectionWrapper<T> {

    private Collection<T> data;

    // default constructor, data coustructors, getters, setters ...
}
```

with yasson JSON-B implementation:

```
Jsonb json = Jsonb.create();
CollectionWrapper<String> collectionWrapper = new CollectionWrapper<>(Collections.emptyList());

String json = jsonb.toJson(collectionWrapper);
```

Serialization fails with exception:

```
SEVERE: Generating incomplete JSON

java.lang.IllegalStateException: Generic bound not found for type T declared in class com.stjepano.bugs.yasson.CollectionWrapper.

	at org.eclipse.yasson.internal.ReflectionUtils.resolveTypeArguments(ReflectionUtils.java:166)
	at org.eclipse.yasson.internal.ReflectionUtils.resolveType(ReflectionUtils.java:109)
	at org.eclipse.yasson.internal.serializer.ObjectSerializer.marshallProperty(ObjectSerializer.java:88)
	at org.eclipse.yasson.internal.serializer.ObjectSerializer.serializeInternal(ObjectSerializer.java:59)
	at org.eclipse.yasson.internal.serializer.AbstractContainerSerializer.serialize(AbstractContainerSerializer.java:60)
	at org.eclipse.yasson.internal.Marshaller.serializeRoot(Marshaller.java:118)
	at org.eclipse.yasson.internal.Marshaller.marshall(Marshaller.java:76)
	at org.eclipse.yasson.internal.JsonBinding.toJson(JsonBinding.java:98)
	at com.stjepano.bugs.yasson.JsonbTest.shouldBeAbleToSerializeGenericCollectionWrapperWithSomeItems(JsonbTest.java:41)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	....
```

## Dependencies

```
    // https://mvnrepository.com/artifact/org.eclipse/yasson
    compile group: 'org.eclipse', name: 'yasson', version: '1.0'
    // https://mvnrepository.com/artifact/org.glassfish/javax.json
    compile group: 'org.glassfish', name: 'javax.json', version: '1.1'
```

