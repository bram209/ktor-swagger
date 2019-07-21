import com.google.auto.service.AutoService
import org.gradle.api.Project
import org.gradle.api.tasks.compile.AbstractCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinCommonOptions
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinGradleSubplugin
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption


@AutoService(KotlinGradleSubplugin::class)
class KtorSwaggerSubPlugin : KotlinGradleSubplugin<AbstractCompile> {
    override fun apply(project: Project,
                       kotlinCompile: AbstractCompile,
                       javaCompile: AbstractCompile?,
                       variantData: Any?,
                       androidProjectHandler: Any?,
                       kotlinCompilation: KotlinCompilation<KotlinCommonOptions>?
    ): List<SubpluginOption> {
        val extension = project.extensions.findByType(KtorSwaggerGradleExtension::class.java)
                ?: KtorSwaggerGradleExtension()

//         error("reason")

//        val enabledOption = SubpluginOption(key = "enabled", value = extension.enabled.toString())
//        return annotationOptions + enabledOption
        return listOf(SubpluginOption("enabled", "true"))
//        return
    }

    override fun getCompilerPluginId(): String = "ktor-swagger"

    override fun getPluginArtifact(): SubpluginArtifact {
        return SubpluginArtifact(
                groupId = "ktor-swagger",
                artifactId = "kotlin-plugin",
                version = "0.0.3"
        )
    }

    override fun isApplicable(project: Project, task: AbstractCompile): Boolean =
            project.plugins.hasPlugin(KtorSwaggerPlugin::class.java)
}