package com.quickbank.accounts.application.util;

public enum GenericResponseCodes {

    TRANSACCION_EXITOSA("0001", "Transacción exitosa."),
    ERROR_INTERNO_SERVIDOR("0002", "Error interno del servidor."),
    PERMISO_DENEGADO("0003", "Permiso denegado."),
    YA_EXISTE_RECURSO("0004", "Ya existe el recurso."),
    RECURSO_NO_EXISTE("0005", "Recurso no existente."),
    ERROR_AUTENTICACION("0006", "Error de autenticación."),
    CREDENCIALES_INVALIDAS("0007", "Credenciales de autenticación invalidas."),
    TRANSACCION_FALLIDA("0008", "Transacción fallida.");

    private String value;
    private String description;

    GenericResponseCodes(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }
}
