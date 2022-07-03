package com.todo1.store.excepciones;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.TreeMap;

import javax.ejb.ApplicationException;
import javax.persistence.Table;

/**
 * @author holger.morales
 */
@ApplicationException(rollback = true)
public class GenericException extends Exception {
    private static final long serialVersionUID = 1L;

    protected Map<String, Object> info = new TreeMap<>();

    public static String formatear(String formato, Object entidad) {
        final Annotation[] anotaciones = entidad.getClass().getDeclaredAnnotations();
        String nameTable = entidad.getClass().getSimpleName().toUpperCase();
        for (Annotation annotation : anotaciones) {
            if (annotation.getClass().getName().equals(Table.class.getName())) {
                final Table table = (Table) annotation;
                nameTable = table.name();
            }
        }
        return String.format(formato, new Object[] { nameTable, entidad.getClass().getCanonicalName() });
    }

    public GenericException(String message) {
        super(message);
        this.info = new TreeMap<>();
    }

    public GenericException(String message, Throwable throwable) {
        super(message, throwable);
        this.info = new TreeMap<>();
    }

    public GenericException(String message, Throwable throwable, Map<String, Object> additionalInfo) {
        super(message, throwable);
        this.info = additionalInfo;
    }

    public GenericException(Throwable throwable) {
        super(throwable);
        this.info = new TreeMap<>();
    }

    public GenericException addInfo(String key, Object value) {
        this.info.put(key, value);
        return this;
    }

    public Map<String, Object> getInfo() {
        return this.info;
    }

}
