package com.adoph.test.translate;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

/**
 * todo 描述
 *
 * @author tangqd
 * @version 1.0
 * @since 2021/9/6
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MultiFieldTranslateData extends HashMap<String, TranslateData> {

    /**
     * i18n
     */
    private String i18n;

    /**
     * 翻译内容
     */
    private String text;

}
