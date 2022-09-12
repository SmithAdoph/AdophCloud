package com.adoph.test.translate;

import java.util.List;

/**
 * todo 描述
 *
 * @author tangqd
 * @version 1.0
 * @since 2021/9/6
 */
public interface TranslateApi {

    /**
     * 查询单个翻译
     *
     * @param req  应用名称和秘钥
     * @param key  翻译key
     * @param i18n 语言标识
     * @return 翻译的内容
     */
    TranslateData get(TranslateReq req, String key, String i18n);

    /**
     * 查询单个翻译
     *
     * @param req  应用名称和秘钥
     * @param key  翻译key
     * @param i18n 多个语言标识
     * @return 翻译的内容
     */
    MultiTranslateData get(TranslateReq req, String key, String... i18n);

    /**
     * 查询多个翻译
     *
     * @param req  应用名称和秘钥
     * @param keys 多个key
     * @param i18n 语言标识
     * @return 翻译内容
     */
    MultiTranslateData list(TranslateReq req, List<String> keys, String i18n);


    /**
     * 查询单个，多字段翻译
     *
     * @param req    应用名称和秘钥
     * @param key    翻译key
     * @param fields 字段集
     * @param i18n   语言标识
     * @return 翻译内容
     */
    MultiFieldTranslateData listForMultiField(TranslateReq req, String key, String fields, String i18n);
}
