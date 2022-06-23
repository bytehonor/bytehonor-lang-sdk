package com.bytehonor.sdk.lang.spring.string;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringEmojiUtilsTest {

    private static final Logger LOG = LoggerFactory.getLogger(StringEmojiUtilsTest.class);

    private static String TEXT = "5⚽";
    // "下班途中遇火情，辅警变身“消防员”救火🧯";
    // "1🌹2🍀3🍎4💰5📱6🌙7🍁8🍂9🍃0🌷1💎2🔪3🔫4🏀5⚽6⚡8👄9👍0🔥"

    @Test
    public void testContainsEmoji() {
        boolean has = StringEmojiUtils.containsEmoji(TEXT);

        assertTrue("*testContainsEmoji*", has);
    }

    @Test
    public void testRemoveEmoji() {
        String target = "下班途中遇火情，辅警变身“消防员”救火";
        String clear = StringEmojiUtils.removeEmoji(TEXT);
        LOG.info("clear:{}", clear);
        assertTrue("*testRemoveEmoji*", target.equals(clear));
    }

}
