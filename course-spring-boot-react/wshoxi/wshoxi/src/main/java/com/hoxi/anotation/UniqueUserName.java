package com.hoxi.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})//nerde kullanılacağı biz şuanda fieldlarda kullanacağımız için field seçtik
@Retention(RUNTIME)//anatasyonun runtime esnasında çözümlenmesi ile alakalı
@Constraint(validatedBy = {UniqueUserNameValidator.class})//ilgili muhatap lıcig seçilir
public @interface UniqueUserName {
    String message() default "User name must be unique";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
