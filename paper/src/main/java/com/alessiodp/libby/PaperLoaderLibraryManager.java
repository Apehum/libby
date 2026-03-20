package com.alessiodp.libby;

import io.papermc.paper.plugin.loader.PluginClasspathBuilder;
import io.papermc.paper.plugin.loader.library.impl.JarLibrary;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

/**
 * A {@link LibraryManager} implementation for the Paper plugin loader bootstrapping phase.
 * Adds resolved libraries to the plugin classpath via {@link PluginClasspathBuilder}.
 */
public class PaperLoaderLibraryManager extends LibraryManager {
    private final @NotNull PluginClasspathBuilder classpathBuilder;

    /**
     * Creates a new Paper loader library manager.
     *
     * @param classpathBuilder the classpath builder to add libraries to
     * @param directoryName    the name of the directory to store downloaded libraries in
     */
    public PaperLoaderLibraryManager(@NotNull PluginClasspathBuilder classpathBuilder, @NotNull String directoryName) {
        super(
                new ComponentLogAdapter(classpathBuilder.getContext().getLogger()),
                classpathBuilder.getContext().getDataDirectory(),
                directoryName
        );

        this.classpathBuilder = classpathBuilder;
    }

    @Override
    protected void addToClasspath(@NotNull Path file) {
        classpathBuilder.addLibrary(new JarLibrary(file));
    }
}
