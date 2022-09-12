package com.adoph.test.translate;

import lombok.Data;

/**
 * todo 描述
 *
 * @author tangqd
 * @version 1.0
 * @since 2021/9/6
 */
@Data
public class TranslateReq {

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 秘钥
     */
    private String appKey;

}
