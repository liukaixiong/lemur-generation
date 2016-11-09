package cn.afterturn.generation.util;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.formatter.DefaultCodeFormatter;
import org.eclipse.jdt.internal.formatter.DefaultCodeFormatterOptions;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.afterturn.generation.db.exception.GenerationRunTimeException;

/**
 * Java 文件格式化
 * @author JueYue
 * @date 2014年12月25日
 */
@SuppressWarnings("unchecked")
public class CodeFromatter {

    private static final Logger LOGGER             = LoggerFactory.getLogger(CodeFromatter.class);

    /**
     * 配置文件名称
     */
    private static final String FROMAT_CONFIG_FILE = "/EclipseFormatter.xml";

    /**
     * 格式化java文件
     * @param fileContent
     * @return
     * @throws Exception
     */
    public static String format(String fileContent, String fileName) throws Exception {
        if (fileName.endsWith(".java")) {
            fileContent = javaFormat(fileContent);
        } else if (fileName.endsWith(".xml")) {
            //fileContent = xmlFormat(fileContent);
        }
        return fileContent;
    }

    private static String xmlFormat(String fileContent) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        tf.setAttribute("indent-number", new Integer(4));
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter stringWriter = new StringWriter();
        transformer.transform(new DOMSource(DocumentBuilderFactory.newInstance()
            .newDocumentBuilder().parse(new ByteArrayInputStream(fileContent.getBytes()))),
            new StreamResult(stringWriter));
        return stringWriter.toString();
    }

    public static String javaFormat(String fileContent) throws Exception {
        String sourceCode = fileContent;
        Map<String, String> options = DefaultCodeFormatterConstants.getEclipseDefaultSettings();
        hanlderOptionsByUser(options);
        DefaultCodeFormatterOptions preferences = new DefaultCodeFormatterOptions(options);
        Document doc = new Document(sourceCode);
        Map<String, String> compilerOptions = new HashMap<String, String>();
        compilerOptions.put(CompilerOptions.OPTION_Compliance, CompilerOptions.VERSION_1_6);
        compilerOptions.put(CompilerOptions.OPTION_TargetPlatform, CompilerOptions.VERSION_1_6);
        compilerOptions.put(CompilerOptions.OPTION_Source, CompilerOptions.VERSION_1_6);
        DefaultCodeFormatter codeFormatter = new DefaultCodeFormatter(preferences, compilerOptions);
        TextEdit edits = codeFormatter.format(CodeFormatter.K_COMPILATION_UNIT, sourceCode, 0,
            sourceCode.length(), 0, null);
        edits.apply(doc);
        sourceCode = doc.get();
        return sourceCode;
    }

    /**
     * 处理用户自定义属性
     * @param options
     */
    private static void hanlderOptionsByUser(Map<String, String> options) {
        try {
            XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(
                new FileInputStream(CodeFromatter.class.getClassLoader().getResource("").getPath()
                                    + FROMAT_CONFIG_FILE));
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    StartElement start = event.asStartElement();
                    String tag = start.getName().getLocalPart();
                    if (tag.equalsIgnoreCase("setting")) {
                        options.put(start.getAttributeByName(new QName("", "id")).getValue(), start
                            .getAttributeByName(new QName("", "value")).getValue());
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new GenerationRunTimeException("读取格式化文件异常");
        }
    }
}