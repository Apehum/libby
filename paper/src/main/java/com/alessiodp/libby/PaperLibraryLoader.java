package com.alessiodp.libby;

import io.papermc.paper.plugin.loader.PluginClasspathBuilder;
import io.papermc.paper.plugin.loader.PluginLoader;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PluginLoader} that uses Libby to download and add libraries to the plugin classpath
 * during the Paper plugin bootstrapping phase.
 */
public class PaperLibraryLoader implements PluginLoader {
    private final String directoryName;

    /**
     * Creates a new Paper library loader.
     *
     * @param directoryName the name of the directory to store downloaded libraries in
     */
    public PaperLibraryLoader(String directoryName) {
        this.directoryName = directoryName;
    }

    @Override
    public void classloader(@NotNull PluginClasspathBuilder classpathBuilder) {
        var libraryManager = new PaperLoaderLibraryManager(classpathBuilder, directoryName);
        libraryManager.configureFromJSON();
    }
}
