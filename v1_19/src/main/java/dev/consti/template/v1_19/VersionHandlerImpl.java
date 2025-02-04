package dev.consti.template.v1_19;

import dev.consti.template.VersionHandler;

/**
 * The VersionHandlerImpl class provides the implementation of the VersionHandler interface 
 * for Minecraft version 1.19. This class defines behaviors or functionality specific to 
 * Minecraft 1.19.
 * 
 * How to Use:
 * - This class is loaded dynamically by the main plugin class based on the server's Minecraft version.
 * - When the `hello()` method is called, it prints a message specific to Minecraft 1.19.
 * 
 * Example:
 * VersionHandler handler = new VersionHandlerImpl();
 * handler.hello(); // Outputs: "Hello World from 1.19"
 */
public class VersionHandlerImpl implements VersionHandler {
    @Override
    public void hello() {
        System.out.println("Hello World from 1.19");
    }
}

