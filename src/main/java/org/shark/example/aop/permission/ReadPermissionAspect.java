package org.shark.example.aop.permission;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
@Component
@RequiredArgsConstructor
public class ReadPermissionAspect {

    private final PermissionService permissionService;

    @Around("@annotation(org.shark.example.aop.permission.RequiresPermission)")
    public Object checkPermission(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        RequiresPermission permission = signature.getMethod().getAnnotation(RequiresPermission.class);
        String requiredPermission = permission.value();


        if (!permissionService.hasRedPermission(requiredPermission)) {
            throw new SecurityException("User does not have permission");
        }

        return joinPoint.proceed();
    }
}
