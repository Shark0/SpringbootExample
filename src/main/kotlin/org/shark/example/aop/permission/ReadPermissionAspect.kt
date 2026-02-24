package org.shark.example.aop.permission

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.stereotype.Component

@Aspect
@Component
class ReadPermissionAspect(private val permissionService: PermissionService) {

    @Around("@annotation(org.shark.example.aop.permission.RequiresPermission)")
    @Throws(Throwable::class)
    fun checkPermission(joinPoint: ProceedingJoinPoint): Any? {
        val signature = joinPoint.signature as MethodSignature
        val permission = signature.method.getAnnotation(RequiresPermission::class.java)
        val requiredPermission = permission.value

        if (!permissionService.hasRedPermission(requiredPermission)) {
            throw SecurityException("User does not have permission")
        }

        return joinPoint.proceed()
    }
}
