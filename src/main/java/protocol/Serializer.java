package protocol;

public interface Serializer {

    abstract byte[] serialize(Object object);

    abstract <T> T deSerialize(byte[] bytes, Class<T> clazz);

}
