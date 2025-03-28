package com.quickbank.accounts.application.usecase;

import com.quickbank.accounts.application.command.Command;

@FunctionalInterface
public interface UseCase<T extends Command, R> {
    R execute(T command);
}
