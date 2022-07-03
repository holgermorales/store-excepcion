package com.todo1.store.excepciones;

import javax.ejb.ApplicationException;

/**
 * @author holger.morales
 */
@ApplicationException(rollback = true)
public class DeleteException extends Exception {

    private static final long serialVersionUID = 1L;
    public static final String FORMATO_MENSAJE = "Se produjo un error al eliminar un registro de la tabla %s, entidad %s.";

    public DeleteException(Object entity) {
        super(GenericException.formatear(FORMATO_MENSAJE, entity));
    }

    public DeleteException(Object entity, Throwable throwable) {
        super(GenericException.formatear(FORMATO_MENSAJE, entity), throwable);
    }

}
