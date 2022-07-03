package com.todo1.store.excepciones;

import javax.ejb.ApplicationException;

/**
 * @author holger.morales
 */
@ApplicationException(rollback = true)
public class PersistException extends Exception {

    private static final long serialVersionUID = 1L;
    public static final String FORMATO_MENSAJE = "Se produjo un error al insertar datos en la tabla %s, entidad %s.";

    public PersistException(Object entity) {
        super(GenericException.formatear(FORMATO_MENSAJE, entity));
    }

    public PersistException(Object entity, Throwable throwable) {
        super(GenericException.formatear(FORMATO_MENSAJE, entity), throwable);
    }

}
