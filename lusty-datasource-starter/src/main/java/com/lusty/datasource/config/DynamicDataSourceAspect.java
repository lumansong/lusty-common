package com.lusty.datasource.config;


import com.lusty.datasource.config.anno.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

//@Aspect
@Slf4j
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

//
//
//    //切点表达式，表示加了OperationLog注解的都是切点，路径是自定义注解的全路径
//    @Pointcut("@annotation(com.lusty.datasource.config.anno.DataSource)")
//    public void pointcut()
//    {
//
//    }
//
//
//    @Before("pointcut()")
//    public void changeDataSource(JoinPoint point) throws Throwable {
//        String dsId=getClassAnnoDataSoucreIdByJoinPot(point);
//        if(StringUtils.isEmpty(dsId)){
//            if (DynamicDataSourceContextHolder.dataSourceIds.contains(dsId)) {
//                logger.debug("Use DataSource :{} >", dsId, point.getSignature());
//            } else {
//                logger.info("数据源[{}]不存在，使用默认数据源 >{}", dsId, point.getSignature());
//            }
//        }
//        DynamicDataSourceContextHolder.setDataSourceRouterKey(dsId);
//    }
//
//    @After("pointcut()")
//    public void restoreDataSource(JoinPoint point) {
//        String dsId=getClassAnnoDataSoucreIdByJoinPot(point);
//        logger.debug("Revert DataSource : " +dsId + " > " + point.getSignature());
//        DynamicDataSourceContextHolder.removeDataSourceRouterKey();
//    }

    @Bean
    public Advisor dataSourceAdvisor(){
        Pointcut pointcut = new AnnotationMatchingPointcut(DataSource.class, true);
        Advice advice = new MethodAroundAdvice();

        return new DefaultPointcutAdvisor(pointcut, advice);
    }


    private static class MethodAroundAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

        @Override
        public void before(Method method, Object[] args, Object target) throws Throwable {
         String dsId=getDsId(method);
            if (DynamicDataSourceContextHolder.dataSourceIds.contains(dsId)) {
                logger.debug("Use DataSource :{} >", dsId);
            } else {
                logger.info("数据源[{}]不存在，使用默认数据源 >{}", dsId);
            }
            DynamicDataSourceContextHolder.setDataSourceRouterKey(dsId);
        }

        @Override
        public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        String dsId=getDsId(method);
        logger.debug("Revert DataSource : " +dsId + " ");
        DynamicDataSourceContextHolder.removeDataSourceRouterKey();
        }

        private String getDsId(Method method){
            String dataSourceId=null;
            try {
                Class clazz = method.getDeclaringClass();
                DataSource annotation = (DataSource) clazz.getDeclaredAnnotation(DataSource.class);
                if(annotation!=null&&annotation.value()!=null){
                    dataSourceId=annotation.value();
                    return dataSourceId;
                }
                String methodName = method.getName();
                Method methdo = clazz.getMethod(methodName, String.class);
                annotation = methdo.getAnnotation(DataSource.class);
                if (annotation != null) {
                    dataSourceId=annotation.value();
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
            return dataSourceId;
        }
    }




    private  String getClassAnnoDataSoucreIdByJoinPot(JoinPoint joinPoint) {
        String dataSourceId=null;
        try {
            Class clazz = joinPoint.getTarget().getClass();
            DataSource annotation = (DataSource) clazz.getDeclaredAnnotation(DataSource.class);
            if(annotation!=null&&annotation.value()!=null){
                dataSourceId=annotation.value();
                return dataSourceId;
            }
            String methodName = joinPoint.getSignature().getName();
            Method methdo = clazz.getMethod(methodName, String.class);
             annotation = methdo.getAnnotation(DataSource.class);
            if (annotation != null) {
                dataSourceId=annotation.value();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return dataSourceId;
    }
}
