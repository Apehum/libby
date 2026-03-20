package com.alessiodp.libby;

import com.alessiodp.libby.logging.LogLevel;
import com.alessiodp.libby.logging.adapters.LogAdapter;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static java.util.Objects.requireNonNull;

/**
 * A {@link LogAdapter} implementation that delegates to a {@link ComponentLogger}.
 */
public class ComponentLogAdapter implements LogAdapter {

    private final ComponentLogger logger;

    /**
     * Creates a new component log adapter.
     *
     * @param delegate the component logger to delegate to
     */
    public ComponentLogAdapter(@NotNull ComponentLogger delegate) {
        this.logger = delegate;
    }

    @Override
    public void log(@NotNull LogLevel level, @Nullable String message) {
        switch (requireNonNull(level, "level")) {
            case DEBUG -> logger.debug(message);
            case INFO -> logger.info(message);
            case WARN -> logger.warn(message);
            case ERROR -> logger.error(message);
        }
    }

    @Override
    public void log(@NotNull LogLevel level, @Nullable String message, @Nullable Throwable throwable) {
        switch (requireNonNull(level, "level")) {
            case DEBUG -> logger.debug(message, throwable);
            case INFO -> logger.info(message, throwable);
            case WARN -> logger.warn(message, throwable);
            case ERROR -> logger.error(message, throwable);
        }
    }
}
