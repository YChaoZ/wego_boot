//package com.boot.wego.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.core.serializer.support.DeserializingConverter;
//import org.springframework.core.serializer.support.SerializingConverter;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.SerializationException;
//
//public class RedisObjectSerializer implements RedisSerializer<Object> {
//    // 日志文件
//    private static final Logger logger = LoggerFactory.getLogger(RedisObjectSerializer.class);
//
//    private Converter<Object,byte[]> serializer = new SerializingConverter();
//    private Converter<byte[],Object> deserializer = new DeserializingConverter();
//
//    @Override
//    public byte[] serialize(Object o) throws SerializationException {
//        if (null == o) return new byte[0];
//
//        logger.info("RedisObjectSerializer.serialize() execute.");
//        return serializer.convert(o);
//    }
//
//    @Override
//    public Object deserialize(byte[] bytes) throws SerializationException {
//        if (isEmpty(bytes)) return null;
//
//        logger.info("RedisObjectSerializer.deserialize() execute.");
//        return deserializer.convert(bytes);
//    }
//
//    private boolean isEmpty (byte[] data){
//        return ( null == data ||data.length== 0);
//    }
//}
