package dev.consti.template;

/**
 * The VersionHandler interface defines a contract for version-specific implementations 
 * in the plugin. Each Minecraft version should provide its own implementation of this 
 * interface to handle functionality tailored to that version.
 * 
 * How to Use:
 * - Create a class in a version-specific package (e.g., `v1_19`, `v1_20`) that implements this interface.
 * - Implement the `hello()` method to define behavior for the specific version.
 * - Dynamically load the appropriate implementation based on the server's Minecraft version 
 *   in the main plugin class.
 */
public interface VersionHandler {
    void hello();
}

