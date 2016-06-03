Formatter

[spring doc](http://docs.spssring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-config-conversion)

```
public class DateFormatter implements Formatter<Date> {

    private String datePattern;
    private SimpleDateFormat dateFormat;

    public DateFormatter(String datePattern) {
        System.out.println("DateFormatter()5b========");
        this.datePattern = datePattern;
        dateFormat = new SimpleDateFormat(datePattern);
        dateFormat.setLenient(false);
    }

    @Override
    public String print(Date date, Locale locale) {
        return dateFormat.format(date);
    }

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        try {
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

Spring config
```
	<bean id="conversionService"
		class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
		<property name="formatters">
			<set>
				<bean class="app20b.formatter.DateFormatter">
					<constructor-arg type="java.lang.String" value="MM-dd-yyyy" />
				</bean>
			</set>
		</property>
	</bean>sss
```