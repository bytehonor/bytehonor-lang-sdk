package com.bytehonor.sdk.basic.lang.string;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringCodeUtilsTest {
    
    private static final Logger LOG = LoggerFactory.getLogger(StringCodeUtilsTest.class);


    @Test
    public void testDecode() {
        String src = "bytehonor1234567!@#$%^&*()_+";
        
        String enc = StringCodeUtils.base64Encode(src);
        
        String dec = StringCodeUtils.base64Decode(enc);
        
        LOG.info("src:{}", src);
        LOG.info("enc:{}", enc);
        LOG.info("dec:{}", dec);
        
        assertTrue("testDecode", src.equals(dec));
    }
    
    @Test
    public void testUrlDecode() {
        String src = "https://www.bytehonor.com/index?a=姓名&url=asfasf&^!@#$%^&*()_+{}?><";
        boolean isOk = false;
        try {
            String enc = StringCodeUtils.urlEncode(src);
            String dec = StringCodeUtils.urlDecode(enc);
            LOG.info("src:{}", src);
            LOG.info("enc:{}", enc);
            LOG.info("dec:{}", dec);
            isOk = src.equals(dec);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        assertTrue("testUrlDecode", isOk);
    }

}
