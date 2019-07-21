import org.gradle.api.Plugin
import org.gradle.api.Project

class KtorSwaggerPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create("ktorSwagger", KtorSwaggerGradleExtension::class.java)
    }
}