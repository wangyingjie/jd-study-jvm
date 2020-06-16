package org.study.gc;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>Desc: </p>
 * <p>Date:2020/6/16 20:29</p>
 *
 * @author wangyingjie1
 */
public class CGLibTest {


    /**
     * -Xmx128m -Xms64m
     * @param args
     */
    public static void main(String[] args) {
        new CGLibTest().testCGLIB();
    }

    public void testCGLIB() {
        int i = 0;
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(EnhancerTest.class);
            enhancer.setCallback(new MethodInterceptorImpl());

            EnhancerTest demo = (EnhancerTest) enhancer.create();
            //demo.test();
            //System.out.println(demo);
            System.out.println("Create " + (i++) + " instance:" + demo.getClass().getSimpleName());
        }
    }

    static class EnhancerTest {

    }

    private static class MethodInterceptorImpl implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args,
                                MethodProxy proxy) throws Throwable {
            //System.err.println("Before invoke " + method);
            Object result = proxy.invokeSuper(obj, args);
            //System.err.println("After invoke" + method);
            return result;
        }
    }

}
