import com.google.auto.service.AutoService
import org.jetbrains.kotlin.compiler.plugin.AbstractCliOption
import org.jetbrains.kotlin.compiler.plugin.CliOption
import org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.config.CompilerConfigurationKey

object ConfigurationKeys {
    val ENABLED: CompilerConfigurationKey<Boolean> =
            CompilerConfigurationKey.create("plugin enabled")
}

@AutoService(CommandLineProcessor::class)
class KtorSwaggerCommandLineProcessor : CommandLineProcessor {
    companion object {
        val ENABLED_OPTION = CliOption("enabled", "<true|false>", "whether plugin is enabled", required = true, allowMultipleOccurrences = false)
    }


    override val pluginId: String
        get() = "ktor-swagger"
    override val pluginOptions: Collection<AbstractCliOption>
        get() = listOf(ENABLED_OPTION)

    override fun processOption(option: AbstractCliOption, value: String, configuration: CompilerConfiguration) {
        when (option.optionName) {
             ENABLED_OPTION.optionName -> configuration.put(ConfigurationKeys.ENABLED, value.toBoolean())
            else -> error("unexpected option: ${option.optionName}")
        }
    }
}