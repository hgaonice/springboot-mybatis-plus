package com.gaoh.mybatisplus.annotation;

import com.alibaba.fastjson.JSONObject;
import com.gaoh.mybatisplus.utils.BaseUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoh
 * @version 1.0
 * @date 2019/7/30 15:41
 *
 * 日志切面
 */
@Aspect
@Component
@Slf4j
public class LogAspect implements Ordered {


    //Controller层切点
    @Pointcut("@annotation(com.gaoh.mybatisplus.annotation.ControllerLog)")
    public void controllerAspect() {
    }

    //Service层切点
    @Pointcut("@annotation(com.gaoh.mybatisplus.annotation.ServiceLog)")
    public void serviceAspect() {
    }

    /**
     * 实现org.springframework.core.Ordered接口来定义order的顺序，order的值越小，越先被执行8
     */
    @Override
    public int getOrder() {
        return 1;
    }

    /**
     * 前置通知 用于拦截管理系统Controller层记录的用户操作
     * @param point
     * @throws Throwable
     */
    @Around("controllerAspect()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
       /* Session session = SecurityUtils.getSubject().getSession();
        String userName = session.getAttribute(SysParameter.USER_NAME).toString();*/
        //方法的签名
        MethodSignature methodSignature = ((MethodSignature) point.getSignature());

       /*
       //切入的方法
        Method method = methodSignature.getMethod();
        //参数类型
        Parameter[] parameters = method.getParameters();*/

        //获取相关描述
        String memo = methodSignature.getMethod().getAnnotation(ControllerLog.class).memo();
        log.info("相关描述:" + memo);
        //操作类型
        OperationType type = methodSignature.getMethod().getAnnotation(ControllerLog.class).type();
        log.info("操作类型:"+type.getDescription());
        //请求的Url
        String[] val = methodSignature.getMethod().getAnnotation(RequestMapping.class).value();
        log.info("请求路径:"+val[0]);

        //************************请求参数打印****************************
        //得到参数名称
        String[] parameterNames = methodSignature.getParameterNames();
        //获取参数
        Object[] args = point.getArgs();
        Map<String, String> paramMap = new HashMap<>();
        for (int i = 0; i < args.length; ++i) {
            Object o = args[i];
            if (o instanceof HttpServletRequest) {
                Enumeration en = request.getParameterNames();
                Map<String, String> map = new HashMap<>();
                while (en.hasMoreElements()) {
                    String name = en.nextElement().toString();
                    String value = request.getParameter(name);
                    map.put(name, value);
                }
                log.info("HttpServletRequest请求参数:" + map);
                continue;
            }
            if (o instanceof Serializable) {
                if (o instanceof String) {
                    paramMap.put(parameterNames[i], JSONObject.toJSONString(o));
                } else if (o instanceof Integer) {
                    paramMap.put(parameterNames[i], JSONObject.toJSONString(o));
                }else {
                    log.info("实体请求参数:" + JSONObject.toJSONString(o));
                }
            }
        }
        if (paramMap.size() > 0) {
            log.info("其他请求参数:" + paramMap.toString());
        }
        //***************************************请求参数打印**********************************


        //TODO  暂时没用
        //获取返回的结果
        Object result = null;
        try {
            result = point.proceed(point.getArgs());
            HashMap resultMap = new HashMap<String, Object>();
            if (result instanceof Map) {
                resultMap = (HashMap) result;
            }

        } catch (Exception e) {
            BaseUtils.loggerError(e);
        }
        return result;
    }

    /**
     * 异常通知 用于拦截service层记录异常日志
     * @param point
     * @param e
     */
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint point, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        Session session = SecurityUtils.getSubject().getSession();

        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
        Object args[] = point.getArgs();
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                params += args[i].toString() + ";";
            }
        }
        String memo = "";
        String exceptionMethod = point.getTarget().getClass().getName() + "." + point.getSignature().getName() + "()";
        try {
            memo = ((MethodSignature) point.getSignature()).getMethod().getAnnotation(ServiceLog.class).memo();
            String[] memos = memo.split("~");
            log.info("==============================异常通知开始==============================");
           /* if(user != null){
                log.info("请求人：{}", new Object[]{user.getUsername()});
            }*/
            log.info("请求IP：{}", new Object[]{BaseUtils.analysisIP(request)}); // 获取请求IP
            log.info("请求方法：{}", new Object[]{exceptionMethod});
            log.info("请求参数：{}", new Object[]{params});
            log.info("请求功能：{}", new Object[]{memos[0]});
            log.info("操作类型：{}", new Object[]{memos[1]});
            StringWriter sw = new StringWriter();
            log.info("异常信息：{}", new Object[]{sw.toString()});
            log.info("==============================异常通知结束==============================");
        } catch (Exception ex) {
            BaseUtils.loggerError(ex);
        }
    }
}
