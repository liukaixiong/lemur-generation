package cn.afterturn.gen.convert;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

import cn.afterturn.common.util.TimeUtil;

public class StringToDate implements Converter<String, Date> {

    @Override
    public Date convert(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (str.contains("-") && str.contains(":")) {
                return TimeUtil.DATE_TIME_FORMAT.parse(str);
            }
            if (str.contains("-")) {
                return TimeUtil.DATE_FORMAT.parse(str);
            }
            if (str.contains(":")) {
                return TimeUtil.TIME_FORMAT.parse(str);
            }
            throw new NotImplementedException();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
