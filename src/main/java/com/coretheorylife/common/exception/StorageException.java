package com.coretheorylife.common.exception;

public class StorageException extends SystemException {

    public StorageException() {
        super(ErrorMapping.getCode(StorageException.class), ErrorMapping.getDefaultMessage(StorageException.class));
    }

    public StorageException(String message) {
        super(ErrorMapping.getCode(StorageException.class), message);
    }
}
