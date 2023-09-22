package com.frame.demo2.xUtils;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.Reporter;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public class XmlReadUtil {
    /**
     * 读取页面配置文件
     *
     * @param xmlUrl     *
     * 页面配置文件路径     *
     * @param pageName
     * 页面名称
     */
    static logUtil logs = new logUtil(XmlReadUtil.class);

    public static HashMap<String, Position> readXMLDocument(String xmlUrl, String pageName) throws Exception {
//创建一个哈希Map，里面的键值对为（名字，元素）
        HashMap<String, Position> positionMap = new HashMap<>();
//判断XML文件是否存在    
        File file = new File(xmlUrl);
        if (!file.exists()) {
            logs.error("can't find " + xmlUrl);
            Reporter.log("can't find " + xmlUrl);
        } else {
            // 创建SAXReader对象            
            SAXReader sr = new SAXReader();
            // 读取xml文件转换为Document            
            Document document = sr.read(file);
            // 获取所有根节点元素对象            
            Element root = document.getRootElement();
            Iterator<?> rootIte = root.elementIterator();
            Position position = null;
            // 遍历根节点            
            while (rootIte.hasNext()) {
                Element page = (Element) rootIte.next();
                // 节点属性，忽略大小写比较                
                if (page.attribute(0).getValue().equalsIgnoreCase(pageName)) {
                    Iterator<?> pageIte = page.elementIterator();
                    // 找到pageName后遍历该page内各个节点                    
                    while (pageIte.hasNext()) {
                        String type = "";
                        String timeOut = "";
                        String value = "";
                        String positionName = "";
                        Element ele = (Element) pageIte.next();
                        positionName = ele.getText();
                        Iterator<?> positionIte = ele.attributeIterator();
                        // 遍历单个标签内的元素                        
                        while (positionIte.hasNext()) {
                            Attribute attribute = (Attribute) positionIte.next();
                            String attributeName = attribute.getName();
                            if (attributeName.equals("type")) {
                                type = attribute.getValue();
                            } else if (attributeName.equals("value")) {
                                value = attribute.getValue();
                            } else {
                                timeOut = attribute.getValue();
                            }
                        }
//封装页面元素
                        position = new Position(value, Integer.parseInt(timeOut), getType(type), positionName.trim());
//将页面元素加入哈希Map的集合
                        positionMap.put(positionName.trim(), position);
                    }
                    break;
                }
            }
        }
        return positionMap;
    }

    //从读取的type属性的值，来定义寻找元素的方法
    private static Position.ByType getType(String type) {
        Position.ByType byType = Position.ByType.xpath;
        if (type == null || type.equalsIgnoreCase("xpath")) {
            byType = Position.ByType.xpath;
        } else if (type.equalsIgnoreCase("id")) {
            byType = Position.ByType.id;
        } else if (type.equalsIgnoreCase("linkText")) {
            byType = Position.ByType.linkText;
        } else if (type.equalsIgnoreCase("name")) {
            byType = Position.ByType.name;
        } else if (type.equalsIgnoreCase("className")) {
            byType = Position.ByType.className;
        } else if (type.equalsIgnoreCase("cssSelector")) {
            byType = Position.ByType.cssSelector;
        } else if (type.equalsIgnoreCase("partialLinkText")) {
            byType = Position.ByType.partialLinkText;
        } else if (type.equalsIgnoreCase("tagName")) {
            byType = Position.ByType.tagName;
        }
        return byType;
    }
}
