Converter
[spring doc](http://docs.spssring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-config-conversion)

Converter Implementation
```
public class StringToDateConverter implements Converter<String, Date> {

    private String datePattern;

    public StringToDateConverter(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public Date convert(String s) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
            dateFormat.setLenient(false);
            return dateFormat.parse(s);
        } catch (ParseException e) {
            // the error message will be displayed when using <form:errors>
            throw new IllegalArgumentException(
                    "invalid date format. Please use this pattern\""
                            + datePattern + "\"");
        }
    }
}
```

Spring Config
```
    <bean id="conversionService"
            class="org.springframework.context.support.ConversionServiceFactoryBean">
        <property name="converters">
            <set>
                <bean class="app20a.converter.StringToDateConverter">
                    <constructor-arg type="java.lang.String" value="MM-dd-yyyy"/>
                </bean>
            </set>
        </property>
    </bean>
```