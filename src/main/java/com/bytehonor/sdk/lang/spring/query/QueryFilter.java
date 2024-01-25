package com.bytehonor.sdk.lang.spring.query;

import java.util.Collection;

import com.bytehonor.sdk.lang.spring.constant.JavaValueTypes;
import com.bytehonor.sdk.lang.spring.constant.SqlOperator;
import com.bytehonor.sdk.lang.spring.exception.SpringLangException;
import com.bytehonor.sdk.lang.spring.meta.MetaGetter;
import com.bytehonor.sdk.lang.spring.string.SpringString;

/**
 * @author lijianqiang
 *
 */
public class QueryFilter {

    /**
     * 忽略驼峰及下划线风格, 统一转成了下划线
     */
    private final String key;

    /**
     * String Long Integer Boolean Collection
     */
    private final Object value;

    /**
     * java type
     */
    private final String type;

    private final SqlOperator operator;

    private QueryFilter(String key, Object value, String type, SqlOperator operator) {
        this.key = MetaGetter.underline(key);
        this.value = value;
        this.type = type;
        this.operator = operator;
    }

    public static QueryFilter non() {
        return new QueryFilter("", "", JavaValueTypes.STRING, SqlOperator.EQ);
    }

    public static QueryFilter of(String key, Object value, String type, SqlOperator operator) {
        if (SqlOperator.LIKE.equals(operator) && JavaValueTypes.STRING.equals(type) == false) {
            throw new SpringLangException(key + " cannt be like");
        }
        if (SqlOperator.LIKE_LEFT.equals(operator) && JavaValueTypes.STRING.equals(type) == false) {
            throw new SpringLangException(key + " cannt be like");
        }
        if (SqlOperator.LIKE_RIGHT.equals(operator) && JavaValueTypes.STRING.equals(type) == false) {
            throw new SpringLangException(key + " cannt be like");
        }
        return new QueryFilter(key, value, type, operator);
    }

    /**
     * 字符串空值也会被采纳
     * 
     * @param filter
     * @return
     */
    public static boolean accept(QueryFilter filter) {
        if (filter == null) {
            return false;
        }
        if (filter.getOperator() == null) {
            return false;
        }
        if (SpringString.isEmpty(filter.getKey())) {
            return false;
        }
        return filter.getValue() != null;
    }

    /**
     * 
     * <pre>
     * 等于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter eq(String key, String value) {
        return of(key, value, JavaValueTypes.STRING, SqlOperator.EQ);
    }

    /**
     * 
     * <pre>
     * 等于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter eq(String key, Long value) {
        return of(key, value, JavaValueTypes.LONG, SqlOperator.EQ);
    }

    /**
     * 
     * <pre>
     * 等于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter eq(String key, Integer value) {
        return of(key, value, JavaValueTypes.INTEGER, SqlOperator.EQ);
    }

    /**
     * 
     * <pre>
     * 等于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter eq(String key, Boolean value) {
        return of(key, value, JavaValueTypes.BOOLEAN, SqlOperator.EQ);
    }

    /**
     * 
     * <pre>
     * 不等于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter neq(String key, String value) {
        return of(key, value, JavaValueTypes.STRING, SqlOperator.NEQ);
    }

    /**
     * 
     * <pre>
     * 不等于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter neq(String key, Long value) {
        return of(key, value, JavaValueTypes.LONG, SqlOperator.NEQ);
    }

    /**
     * 
     * <pre>
     * 不等于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter neq(String key, Integer value) {
        return of(key, value, JavaValueTypes.INTEGER, SqlOperator.NEQ);
    }

    /**
     * 
     * <pre>
     * 不等于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter neq(String key, Boolean value) {
        return of(key, value, JavaValueTypes.BOOLEAN, SqlOperator.NEQ);
    }

    /**
     * <pre>
     * 大于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter gt(String key, Long value) {
        return of(key, value, JavaValueTypes.LONG, SqlOperator.GT);
    }

    /**
     * <pre>
     * 大于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter gt(String key, Integer value) {
        return of(key, value, JavaValueTypes.INTEGER, SqlOperator.GT);
    }

    /**
     * <pre>
     * 大于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter gt(String key, Double value) {
        return of(key, value, JavaValueTypes.DOUBLE, SqlOperator.GT);
    }

    /**
     * <pre>
     * 大于等于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter egt(String key, Long value) {
        return of(key, value, JavaValueTypes.LONG, SqlOperator.EGT);
    }

    /**
     * <pre>
     * 大于等于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter egt(String key, Integer value) {
        return of(key, value, JavaValueTypes.INTEGER, SqlOperator.EGT);
    }

    /**
     * <pre>
     * 小于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter lt(String key, Long value) {
        return of(key, value, JavaValueTypes.LONG, SqlOperator.LT);
    }

    /**
     * <pre>
     * 小于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter lt(String key, Integer value) {
        return of(key, value, JavaValueTypes.INTEGER, SqlOperator.LT);
    }

    /**
     * <pre>
     * 小于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter lt(String key, Double value) {
        return of(key, value, JavaValueTypes.DOUBLE, SqlOperator.LT);
    }

    /**
     * <pre>
     * 小于等于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter elt(String key, Long value) {
        return of(key, value, JavaValueTypes.LONG, SqlOperator.ELT);
    }

    /**
     * <pre>
     * 小于等于
     * </pre>
     * 
     * @param key
     * @param value
     * @return
     */
    public static QueryFilter elt(String key, Integer value) {
        return of(key, value, JavaValueTypes.INTEGER, SqlOperator.ELT);
    }

    public static QueryFilter like(String key, String value) {
        return of(key, value, JavaValueTypes.STRING, SqlOperator.LIKE);
    }

    public static QueryFilter likeLeft(String key, String value) {
        return of(key, value, JavaValueTypes.STRING, SqlOperator.LIKE_LEFT);
    }

    public static QueryFilter likeRight(String key, String value) {
        return of(key, value, JavaValueTypes.STRING, SqlOperator.LIKE_RIGHT);
    }

    public static <T> QueryFilter in(String key, Collection<T> values, Class<T> type) {
        return of(key, values, type.getName(), SqlOperator.IN);
    }

    public static <T> QueryFilter in(String key, Collection<T> values, String type) {
        return of(key, values, type, SqlOperator.IN);
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public SqlOperator getOperator() {
        return operator;
    }

    public String uuid() {
        return new StringBuilder().append(key).append("-").append(operator.getKey()).toString();
    }

}
