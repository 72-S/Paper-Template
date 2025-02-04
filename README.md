# Paper-Template

A multi-version compatible Minecraft Paper plugin that dynamically loads the correct implementation based on the server's Minecraft version.

---

### 📂 Project Structure
```
Paper-Template/
│── common/                  # Shared logic for all versions
│── plugin/                  # Main plugin module
│── v1_19/                   # Implementation for Minecraft 1.19
│── v1_20/                   # Implementation for Minecraft 1.20
│── v1_21/                   # Implementation for Minecraft 1.21
│── build.gradle.kts         # Gradle build script
│── settings.gradle.kts      # Gradle settings file
│── plugin.yml               # Bukkit plugin descriptor (auto-generated)
│── README.md                # Project documentation
```

---

### ⚙️ How to Build
1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/Paper-Template.git
   cd Paper-Template
   ```

2. **Build the plugin**
   ```bash
   ./gradlew shadowJar
   ```

3. **Find the built JAR**
   ```
   plugin/build/libs/Paper-Template-1.0.0.jar
   ```

---

### 🚀 How It Works
1. **`Main.java` detects the server version** and loads the correct implementation dynamically.
2. **Each Minecraft version has a corresponding package** (e.g., `v1_19`, `v1_20`, `v1_21`).
3. **Version-specific implementations extend `VersionHandler`** to provide logic unique to each version.

---

### 📝 Example: `VersionHandlerImpl` for Minecraft 1.19
```java
package dev.consti.template.v1_19;

import dev.consti.template.VersionHandler;

/**
 * Implementation of VersionHandler for Minecraft 1.19.
 */
public class VersionHandlerImpl implements VersionHandler {
    @Override
    public void hello() {
        System.out.println("Hello from 1.19");
    }
}
```
