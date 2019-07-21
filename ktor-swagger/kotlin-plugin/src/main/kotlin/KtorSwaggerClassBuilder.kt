import org.jetbrains.kotlin.codegen.ClassBuilder
import org.jetbrains.kotlin.codegen.DelegatingClassBuilder
import org.jetbrains.kotlin.resolve.jvm.diagnostics.JvmDeclarationOrigin
import org.jetbrains.org.objectweb.asm.MethodVisitor
import java.lang.RuntimeException

class KtorSwaggerClassBuilder(val delegateBuilder: ClassBuilder): DelegatingClassBuilder() {
    override fun getDelegate(): ClassBuilder = delegateBuilder

    override fun newMethod(origin: JvmDeclarationOrigin, access: Int, name: String, desc: String, signature: String?, exceptions: Array<out String>?): MethodVisitor {
        val original = super.newMethod(origin, access, name, desc, signature, exceptions)
        error("todo")
        return original
    }
}
