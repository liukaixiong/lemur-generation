package io.lemur.generation.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.formatter.DefaultCodeFormatter;
import org.eclipse.jdt.internal.formatter.DefaultCodeFormatterOptions;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

/**
 * Java 文件格式化
 * @author JueYue
 * @date 2014年12月25日
 */
@SuppressWarnings("unchecked")
public class CodeFromatter {

    public static String format(String fileContent) throws Exception {
        String sourceCode = fileContent;
        Map<String, String> options = DefaultCodeFormatterConstants.getEclipseDefaultSettings();
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
}