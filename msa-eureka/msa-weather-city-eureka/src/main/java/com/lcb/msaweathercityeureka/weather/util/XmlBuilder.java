package com.lcb.msaweathercityeureka.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

public class XmlBuilder {
    /**
     * 将XML转换为POJO
     * @param clazz
     * @param xmlStr
     * @return
     * @throws Exception
     */
    public static Object xmlStrToObject(Class<?> clazz,String xmlStr)throws  Exception{
        Object xmlObject =null;
        Reader reader=null;
        JAXBContext context=JAXBContext.newInstance(clazz);
        //JAXBContext提供了xml转为对象的接口的方法
        Unmarshaller unmarshaller =context.createUnmarshaller();
        reader=new StringReader(xmlStr);
        xmlObject=unmarshaller.unmarshal(reader);
        if(null != reader){
            reader.close();
        }
        return  xmlObject;
    }
}
