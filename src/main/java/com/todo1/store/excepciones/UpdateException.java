package com.todo1.store.excepciones;

import javax.ejb.ApplicationException;

/**
 * @author holger.morales
 */
@ApplicationException(rollback = true)
public class UpdateException extends Exception {

    private static final long serialVersionUID = 1L;
    public static final String FORMATO_MENSAJE = "Se produjo un error al actualizar datos de un registro en la tabla %s, entidad %s.";

    public UpdateException(Object entity) {
        super(GenericException.formatear(FORMATO_MENSAJE, entity));
    }

    public UpdateException(Object entity, Throwable throwable) {
        super(GenericException.formatear(FORMATO_MENSAJE, entity), throwable);
    }

}
