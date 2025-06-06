package com.handbook.handbookapi.enterprise;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.PathBuilder;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class BooleanBuilderUtil {

    public static BooleanBuilder buildPredicateFromFilter(String filter, Class<?> className) {
        if (filter == null || filter.isEmpty()) {
            return new BooleanBuilder();
        }

        BooleanBuilder predicate = new BooleanBuilder();
        String[] parts = filter.split("\\+");

        if (parts.length == 3) {
            try {
                Field field = getRecursiveField(className, parts[0]);
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                PathBuilder<?> fieldPath = new PathBuilder<>(fieldType, field.getName());

                switch (parts[1].toLowerCase()) {
                    case "equal":
                        predicate.and(Expressions.booleanTemplate("{0} = {1}", fieldPath, getType(fieldType, parts[2])));
                        break;
                    case "notequal":
                        predicate.and(Expressions.booleanTemplate("{0} <> {1}", fieldPath, getType(fieldType, parts[2])));
                        break;
                    case "greater":
                        predicate.and(Expressions.booleanTemplate("{0} > {1}", fieldPath, getType(fieldType, parts[2])));
                        break;
                    case "lesser":
                        predicate.and(Expressions.booleanTemplate("{0} < {1}", fieldPath, getType(fieldType, parts[2])));
                        break;
                    case "greaterequal":
                        predicate.and(Expressions.booleanTemplate("{0} >= {1}", fieldPath, getType(fieldType, parts[2])));
                        break;
                    case "lesserequal":
                        predicate.and(Expressions.booleanTemplate("{0} <= {1}", fieldPath, getType(fieldType, parts[2])));
                        break;
                    case "like":
                        predicate.and(Expressions.booleanTemplate("{0} like '%'||{1}||'%'", fieldPath, getType(fieldType, parts[2])));
                        break;
                    default:
                        throw new RuntimeException("Unable to filter with this operator");
                }
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        if (parts.length == 4) {
            try {
                Field field = getRecursiveField(className, parts[0]);
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                PathBuilder<?> fieldPath = new PathBuilder<>(fieldType, field.getName());

                switch (parts[1].toLowerCase()) {
                    case "between":
                        predicate.and(Expressions.booleanTemplate("{0} >= {1} AND {0} <= {2}", fieldPath, getType(fieldType, parts[2])));
                        break;
                    default:
                        throw new RuntimeException("Unable to filter with this operator");
                }
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return predicate;
    }

    public static Expression getType(Class<?> fieldType, String part) {
        if (fieldType == Integer.class || fieldType == int.class) {
            return Expressions.constant(Integer.parseInt(part));
        } else if (fieldType == Double.class || fieldType == double.class) {
            return Expressions.constant(Double.parseDouble(part));
        } else if (fieldType == LocalDate.class) {
            return Expressions.constant(LocalDate.parse(part));
        } else if (fieldType.isEnum()) {
            return Expressions.constant(Enum.valueOf((Class<Enum>) fieldType, part));
        }
        return Expressions.constant(part);
    }

    private static Field getRecursiveField(Class<?> className, String fieldName) throws NoSuchFieldException {
        try {
            return className.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            if (className.getSuperclass() != null) {
                return getRecursiveField(className.getSuperclass(), fieldName);
            } else {
                throw e;
            }
        }
    }
}
