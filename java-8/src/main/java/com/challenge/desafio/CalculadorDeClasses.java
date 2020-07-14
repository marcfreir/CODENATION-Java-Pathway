package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object object) {
        return calculateAttrib(object, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object object) {
        return calculateAttrib(object, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object object) {
        return somar(object).subtract(subtrair(object));
    }

    private BigDecimal calculateAttrib(Object object, Class<? extends Annotation> annotation) {

        BigDecimal count = BigDecimal.ZERO;

        for (Field attribute : object.getClass().getDeclaredFields()) {
            if (attribute.isAnnotationPresent(annotation) && attribute.getType() == BigDecimal.class) {
                try {
                    attribute.setAccessible(true);
                    BigDecimal attribValue = new BigDecimal(String.valueOf(attribute.get(object)));
                    count = count.add(attribValue);

                } catch (IllegalAccessException exc) {
                    exc.printStackTrace();
                    throw new RuntimeException();
                }
            }
        }
        return count;
    }
}
