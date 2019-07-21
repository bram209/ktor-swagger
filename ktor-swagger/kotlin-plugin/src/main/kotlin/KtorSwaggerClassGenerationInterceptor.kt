import org.jetbrains.kotlin.codegen.ClassBuilder
import org.jetbrains.kotlin.codegen.ClassBuilderFactory
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension
import org.jetbrains.kotlin.diagnostics.DiagnosticSink
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.jvm.diagnostics.JvmDeclarationOrigin

class KtorSwaggerClassGenerationInterceptor : ClassBuilderInterceptorExtension {
    override fun interceptClassBuilderFactory(interceptedFactory: ClassBuilderFactory,
                                              bindingContext: BindingContext,
                                              diagnostics: DiagnosticSink): ClassBuilderFactory =
            object : ClassBuilderFactory by interceptedFactory {
                override fun newClassBuilder(p0: JvmDeclarationOrigin): ClassBuilder =
                        KtorSwaggerClassBuilder(interceptedFactory.newClassBuilder(p0))
            }
}
